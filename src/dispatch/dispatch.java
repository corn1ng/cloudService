package dispatch;

import init.DataInit;
import pojo.SLA;
import pojo.Service;
import strategy.optimiseStrategy;
import strategy.t1s2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dispatch {
    public static void dispatchPV(Integer servicePV, Integer realPV, List<SLA> slaList, List<Service> services)
    {
        //List<Service> selectService=new ArrayList<>();

        // 如果提供的多余实际需要的，低负载状态，准入。
        // 默认非严格模式
        if(realPV<servicePV*0.95)
        {
            Integer surpuls = servicePV-realPV;
            System.out.println("低负载状态，准入请求。当前时间片剩余容量"+surpuls);

            // 选择 t1s2 策略；
            optimiseStrategy strategy =new t1s2();
            services =strategy.selectStategy(services);
            int i =0;

            /*
            * 价格计算start
            */
            for(int c=0;c<slaList.size();c++)
            {
                DataInit.priceId =slaList.get(c).getPrice()+DataInit.priceId;
                DataInit.costId =services.get(c).getCost()+DataInit.costId;
            }
            /*价格计算结束*/
            for(i=0;surpuls>=0 && i<services.size();i++)
            {
                if((services.get(i).getRealPV()-slaList.get(i).getPageView())>0)
                {
                    // 超出SLA规定的使用
                    surpuls=surpuls-(services.get(i).getRealPV()-slaList.get(i).getPageView());

                    //双倍价格计算
                    DataInit.priceId =DataInit.priceId+slaList.get(i).getPrice();

                    services.get(i).setAdmitPV(services.get(i).getRealPV());
                    services.get(i).setRejectPV(0);
                }
                else
                {
                    services.get(i).setAdmitPV(services.get(i).getRealPV());
                    services.get(i).setRejectPV(0);
                }
            }
            for(;i<services.size();i++)
            {
                if(services.get(i).getRealPV()-slaList.get(i).getPageView()>0)
                {
                    services.get(i).setAdmitPV(slaList.get(i).getPageView());
                    services.get(i).setRejectPV(services.get(i).getRealPV()-slaList.get(i).getPageView());
                }
                else
                {
                    services.get(i).setAdmitPV(services.get(i).getRealPV());
                    services.get(i).setRejectPV(0);
                }

            }
            //System.out.println("当前");
        }
        else
        {
            System.out.println("已超过95%，满载预警");
            // 警报状态
            if(realPV<=servicePV)
            {
                for(int i=0;i<services.size();i++)
                {
                    services.get(i).setAdmitPV(services.get(i).getRealPV());
                    services.get(i).setRejectPV(0);
                }
                System.out.println("未达到100%，已准入");
            }
            // 超载情况
            else
            {
                System.out.println("已超载！"+" 服务层提供"+servicePV+" 实际使用"+realPV);
                Random random =new Random();
                List<List<Integer>> result  =null;
                // 遗传算法start
//
//                for(int i=0;i<20;i++)
//                {
//                    List<Integer> list =new ArrayList<>();
//                    for(int j=0;j<services.size();j++)
//                    {
//                        Integer index =random.nextInt(3)+1;
//                        if(index!=1)
//                            index=0;
//                        list.add(index);
//                    }
////                    for(int k=0;k<list.size();k++)
////                    {
////                        System.out.print(list.get(k)+" ");
////                    }
////                    System.out.println(" ");
//                    result.add(list);
//                }

                YCalgorithm alg = new YCalgorithm(servicePV, services.size(),services.size()/2, 200, 0.5f, 0.05f, 0.1f);
                result =alg.solve();

                // end
                // 选20的结果

                List<Integer> bag = null;
                Integer max =0;
                // 选择 t1s2 策略；
                optimiseStrategy strategy =new t1s2();
                for(int j=0;j<20;j++)
                {
                    List<Integer> integers =result.get(j);
                    List<Service> serviceList = new ArrayList<>();
                    for(int i=0;i<integers.size();i++)
                    {
                        if(integers.get(i)==1)
                        {
                            serviceList.add(services.get(i));
                        }
                    }
                    Integer res =t1s2.calcuScore(serviceList);
                    // 从20种情况中选择此背包。
                    if(res>max)
                    {
                        max= res;
                        bag =integers;
                    }
                }

                for(int i=0;i<services.size();i++)
                {
                    // System.out.print(bag.get(i)+" ");
                    if(bag.get(i)==1)
                    {
                        services.get(i).setAdmitPV(services.get(i).getRealPV());
                        services.get(i).setRejectPV(0);
                    }
                    else
                    {
                        services.get(i).setAdmitPV(0);
                        services.get(i).setRejectPV(services.get(i).getRealPV());
                    }
                }
                System.out.println(" ");
            }
        }
    }
}
