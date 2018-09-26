import dispatch.ServiceLayer;
import dispatch.dispatch;
import init.DataInit;
import init.PvInit;
import pojo.Service;
import strategy.t1s2;
import static init.DataInit.services;
import static init.DataInit.slas;

public class Main {

    public static void main(String[] args) {

        // 数据初始化
        // 初始化 租户 应用 服务 SLA
        DataInit.dataInitFunc();


//        System.out.println("******************");
//        for(int i=0;i<services.size();i++)
//        {
//            System.out.println(services.get(i).tostring());
//        }
//
//
//        System.out.println("******************");

        // 输出初始化数据的基础统计数据
        DataInit.printTotal();

        // 开始调度。
        // 循环100个时间片
        Integer time =1;
        for(int i=0;i<time;i++)
        {
            // 获取当前时间片服务层提供的访问量。
            Integer totalPV =ServiceLayer.getTotalPV();

            //获取每个时间片内的所有的真实访问量。
            Integer turePV = PvInit.pvPerTime(slas,services);


            // 根据提供与实际进行判断与调度。
            dispatch.dispatchPV(totalPV,turePV,slas,services);


            t1s2 stra =new t1s2();
            //stra.selectStategy(services);

//            for(Service s:services)
//            {
//                System.out.println(s.tostring());
//            }
        }
    }
}
