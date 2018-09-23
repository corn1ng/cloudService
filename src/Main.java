import Comm.Common;
import dispatch.ServiceLayer;
import init.dataInit;
import init.pvInit;
import pojo.Application;
import pojo.SLA;
import pojo.Service;
import pojo.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // 数据初始化
        dataInit.dataInitFunc();
        // 输出SLA统计数据
        dataInit.printTotal();

        // 循环100个时间片
        Integer time =100;
        for(int i=0;i<time;i++)
        {
            // 获取当前时间片服务层提供的访问量。
            ServiceLayer.printTotalPV();

            // 获取当前所有的访问量。
            pvInit.pvPerTime(dataInit.slas,dataInit.services);
        }





    }






}
