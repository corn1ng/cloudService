package dispatch;

import Comm.Common;
import init.dataInit;

import java.util.Random;

public class ServiceLayer {

    private static Integer totalPV;

    public static Integer getTotalPV()
    {
        Random random =new Random();
        totalPV = dataInit.pvId-Common.randomInteger(6000,11000);
        return totalPV;
    }

    public static void printTotalPV()
    {
        System.out.println("服务层提供PV="+getTotalPV());
    }

}
