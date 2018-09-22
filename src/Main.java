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


        dataInit.dataInitFunc();
        dataInit.printTotal();
        ServiceLayer.printTotalPV();
        //dataInit.printService();
        pvInit.pvPerTime(dataInit.slas,dataInit.services);



    }






}
