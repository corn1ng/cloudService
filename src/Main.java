import dispatch.ServiceLayer;
import dispatch.dispatch;
import init.dataInit;
import init.pvInit;
import pojo.Service;
import strategy.t1s2;

import static init.dataInit.services;

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
            Integer totalPV =ServiceLayer.getTotalPV();


            //获取每个时间片内的所有的真实访问量。
            Integer turePV = pvInit.pvPerTime(dataInit.slas,services);

            //打印所有服务信息
            //dataInit.printService();

            // 根据提供与实际进行判断与调度。
            dispatch.dispatchPV(totalPV,turePV,dataInit.slas,services);


            t1s2 stra =new t1s2();
            stra.selectStategy(services);

            for(Service s:services)
            {
                System.out.println(s.tostring());
            }
        }
    }
}
