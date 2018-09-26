package dispatch;

import common.Common;
import init.DataInit;

import java.util.Random;

public class ServiceLayer {

    private static Integer totalPV;

    public static Integer getTotalPV()
    {
        Random random =new Random();
        totalPV = DataInit.pvId-Common.randomInteger(8000,12000);
        if(totalPV<0) totalPV =Common.randomInteger(2000,3000);
        return totalPV;
    }

    public static Integer printTotalPV()
    {
        //System.out.println("服务层提供PV="+getTotalPV());
        return getTotalPV();
    }

}
