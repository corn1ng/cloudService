package dispatch;

import init.dataInit;
import org.omg.PortableInterceptor.INACTIVE;
import pojo.SLA;
import pojo.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class YCalgorithm {

    private Random random = null; //随机数生成器

    private static List<Integer> weight=new ArrayList<>();  //物品重量
    private static List<Double> profit=new ArrayList<>(); //物品价值
    private int len; // 染色体长度

    private Integer capacity; //背包容量
    private int scale; //种群规模
    private int maxgen; //最大代数
    private float irate; //交叉率（所有的个体都需要相互交叉的，这里的交叉率指交叉时每位交叉发生交叉的可能性）
    private float arate1; //变异率（某个个体发生变异的可能性）
    private float arate2; //对于确定发生变异的个体每位发生变异的可能性


    private boolean[][] population = null; //上一代种群
    private float[] fitness = null; //种群的适应度

    private float bestFitness; //最优个体的价值
    private boolean[] bestUnit = null; //最优个体的物品取舍策略

    class SortFitness implements Comparable<SortFitness>{
        int index;
        float fitness;
        public int compareTo(SortFitness c) {
            float cfitness = c.fitness;
            if(fitness > cfitness) {
                return -1;
            } else if(fitness < cfitness) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * @param capacity : 背包容量
     * @param scale ： 种群规模
     * @param maxgen ： 最大代数
     * @param irate ： 交叉率（所有的个体都需要相互交叉的，这里的交叉率指交叉时每位交叉发生交叉的可能性）
     * @param arate1 ：变异率（某个个体发生变异的可能性）
     * @param arate2 ：对于确定发生变异的个体每位发生变异的可能性

     */
    public YCalgorithm(Integer capacity, int len ,int scale, int maxgen, float irate, float arate1, float arate2) {
        this.capacity = capacity;
        this.scale = scale;
        this.maxgen = maxgen;
        this.irate = irate;
        this.arate1 = arate1;
        this.arate2 = arate2;
        this.len =len;

        random = new Random(System.currentTimeMillis());
    }

    //读取物品重量和物品价值数据
    private void readDate(List<Service> list, List<SLA> slas) {
        for(int i=0;i<list.size();i++)
        {

            weight.add(list.get(i).getRealPV());
            profit.add(slas.get(i).getPrice()-list.get(i).getCost());
        }
        len = weight.size();
    }

    //初始化初始种群
    private void initPopulation() {
        fitness = new float[scale];
        population = new boolean[scale][len];
        //考虑到随机生成的初始化种群效果有可能不好，这里对于种群的初始化作了一定的优化
        //对于每一个个体，先随机一个容量值（0.5 capacity 至 1.5 capacity）
        //然后随机相应的物品到该个体中，直到超过上面随机的容量
        for(int i = 0; i < scale; i++) {
            // tmp 是随机的容量值。
            float tmp = (float)(0.5 + Math.random()) * capacity;
            int count = 0; //防止初始化耗费太多计算资源
            for(int j = 0; j < tmp;) {
                int k = random.nextInt(len-1);
                if(population[i][k]) {
                    if(count == 3) {
                        break;
                    }
                    count++;
                    continue;
                } else {
                    population[i][k] = true;
                    j += weight.get(k);
                    count = 0;
                }
            }
        }
    }

    //计算一个个体的适应度
    private float evaluate(boolean[] unit) {
        float profitSum = 0;
        float weightSum = 0;
        for (int i = 0; i < unit.length; i++) {
            if (unit[i]) {
                weightSum += weight.get(i);
                profitSum += profit.get(i);
            }
            else
            {   // 如果不满足的话，不仅不计算利润，还要往回扣钱。
                profitSum-= dataInit.slas.get(i).getService().getCompensateRate() * profit.get(i);
            }
        }
        if (weightSum > capacity) {
            //该个体的对应的所有物品的重量超过了背包的容量
            return 0;
        } else {
            return profitSum;
        }
    }

    //计算种群所有个体的适应度
    private void calcFitness() {
        for(int i = 0; i < scale; i++) {
            fitness[i] = evaluate(population[i]);
        }
    }

    //记录最优个体
    private void recBest(int gen) {
        for(int i = 0; i < scale; i++) {
            if(fitness[i] > bestFitness) {
                bestFitness = fitness[i];
                bestUnit = new boolean[len];
                for(int j = 0; j < len; j++) {
                    bestUnit[j] = population[i][j];
                }
            }
        }
    }

    //种群个体选择
    //选择策略：适应度前10%的个体带到下一次循环中，然后在（随机生成10%的个体 + 剩下的90%个体）中随机取90%出来
    private void select() {
        SortFitness[] sortFitness = new SortFitness[scale];
        for(int i = 0; i < scale; i++) {
            sortFitness[i] = new SortFitness();
            sortFitness[i].index = i;
            sortFitness[i].fitness = fitness[i];
        }
        Arrays.sort(sortFitness);

        boolean[][] tmpPopulation = new boolean[scale][len];

        //保留前10%的个体
        int reserve = (int)(scale * 0.1);
        for(int i = 0; i < reserve; i++) {
            for(int j = 0; j < len; j++) {
                tmpPopulation[i][j] = population[sortFitness[i].index][j];
            }
            //将加入后的个体随机化
            for(int j = 0; j < len; j++) {
                population[sortFitness[i].index][j] = false;
            }
            float tmpc = (float)(0.5 + Math.random()) * capacity;
            int count = 0;
            for(int j = 0; j < tmpc;) {
                int k = random.nextInt(len);
                if(population[sortFitness[i].index][k]) {
                    if(count == 3) {
                        break;
                    }
                    count++;
                    continue;
                } else {
                    population[sortFitness[i].index][k] = true;
                    j += weight.get(k);
                    count = 0;
                }
            }//
        }

        //再随机90%的个体出来
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < scale; i++) {
            list.add(i);
        }
        for(int i = reserve; i < scale; i++) {
            int selectid = list.remove((int)(list.size()*Math.random()));
            for(int j = 0; j < len; j++) {
                tmpPopulation[i][j] = population[selectid][j];
            }
        }
        population = tmpPopulation;
    }

    //进行交叉
    private void intersect() {
        for(int i = 0; i < scale-1; i = i + 2)
            for(int j = 0; j < len; j++) {
                if(Math.random() < irate) {
                    boolean tmp = population[i][j];
                    population[i][j] = population[i + 1][j];
                    population[i + 1][j] = tmp;
                }
            }
    }

    //变异
    private void aberra() {
        for(int i = 0; i < scale; i++) {
            if(Math.random() > arate1) {
                continue;
            }
            for(int j = 0; j < len; j++) {
                if(Math.random() < arate2) {
                    population[i][j] = Math.random() > 0.5 ? true : false;
                }
            }
        }
    }

    // 计算前k%的结果用于后续筛选
    private List<List<Integer>> endSelect(Integer k) {
        SortFitness[] sortFitness = new SortFitness[scale];
        for (int i = 0; i < scale; i++) {
            sortFitness[i] = new SortFitness();
            sortFitness[i].index = i;
            sortFitness[i].fitness = fitness[i];
        }
        Arrays.sort(sortFitness);
        List<List<Integer> > endPopulation = new ArrayList<>();


        //boolean[][] tmpPopulation = new boolean[scale][len];

        //保留前k%的个体
        int reserve = (int) (scale * k / 10);

        for (int i = 0; i < reserve; i++) {
            List<Integer> pop =new ArrayList<>(len);
            for (int j = 0; j < len; j++) {
                pop.add(population[sortFitness[i].index][j] ?1:0);
            }
            endPopulation.add(pop);
        }
        return endPopulation;
    }





    //遗传算法
    public List<List<Integer>> solve() {
        readDate(dataInit.services,dataInit.slas);
        initPopulation();
        for(int i = 0; i < maxgen; i++) {
            //计算种群适应度值
            calcFitness();
            //记录最优个体
            recBest(i);
            //进行种群选择
            select();
            //进行交叉
            intersect();
            //发生变异
            aberra();
        }
        List<List<Integer>> population =endSelect(10);

//        int totalWeight = 0;
//        for(int i = 0; i < bestUnit.length; i++) {
//            if(bestUnit[i]){
//                totalWeight += weight.get(i);
//            }
//        }
//        System.out.println("total profit:" + bestFitness);
//        System.out.println("total weight:" + totalWeight);
        return population;
    }

}
