import dispatch.ServiceLayer;
import dispatch.dispatch;
import init.dataInit;
import init.pvInit;
import strategy.t1s2;

public class Main {

    public static void main(String[] args) {

        // 数据初始化
        dataInit.dataInitFunc();
        // 输出SLA统计数据
        dataInit.printTotal();


        // 循环100个时间片
        Integer time =1;
        for(int i=0;i<time;i++)
        {
            // 获取当前时间片服务层提供的访问量。
            Integer totalPV =ServiceLayer.printTotalPV();


            //获取每个时间片内的所有的真实访问量。
            Integer turePV = pvInit.pvPerTime(dataInit.slas,dataInit.services);

            //打印所有服务信息
            //dataInit.printService();
            dispatch.dispatchPV(totalPV,turePV,dataInit.slas,dataInit.services);
            System.out.println("********");

            t1s2 stra =new t1s2();
            stra.selectStategy(dataInit.services);
        }





    }






}
