package dispatch;

import common.Common;
import init.dataInit;

import java.util.Random;

public class ServiceLayer {

    private static Integer totalPV;

    public static Integer getTotalPV()
    {
        Random random =new Random();
        totalPV = dataInit.pvId-Common.randomInteger(2000,8000);
        return totalPV;
    }

    public static Integer printTotalPV()
    {
        //System.out.println("服务层提供PV="+getTotalPV());
        return getTotalPV();
    }

}
