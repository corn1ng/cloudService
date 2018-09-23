package init;

import common.Common;
import pojo.Application;
import pojo.SLA;
import pojo.Service;
import pojo.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dataInit {

    // 租户计数器
    public static Integer tenId = 1;

    // 应用计数器
    public static Integer appId = 1;

    // 服务计数器
    public static Integer serId = 1;

    // 总访问量计数器
    public static Integer pvId =0;

    public static List<SLA> slas =new ArrayList<>();

    public static List<Service> services =new ArrayList<>();

    public static void dataInitFunc()
    {
        Random random =new Random();
        //TotalPV 3000-9000
        Integer totlaPV = Common.randomInteger(3000,9000);

        // 租户总数   3-10
        Integer totalTenant = Common.randomInteger(3,10);

        for (tenId = 1; tenId <= totalTenant; tenId++) {
            Integer tenantLevel = Common.randomInteger(1,3);
            Tenant tenant = new Tenant(tenId, tenantLevel);
            Integer applicationPerTenant = Common.randomInteger(1,10);
            List applicationList = new ArrayList(applicationPerTenant);
            for (int j = 1; j <= applicationPerTenant; j++) {
                Integer applicationLevel = Common.randomInteger(1,3);
                Application application = new Application(appId, applicationLevel, tenId);
                Integer pageView = Common.randomInteger(40,100);
                Integer servicePerApplication = Common.randomInteger(4,12);
                List<Service> serviceList = new ArrayList<>(servicePerApplication);
                for (int k = 1; k < servicePerApplication; k++) {
                    Integer serviceLevel = Common.randomInteger(1,3);
                    Service service = Common.toService(serviceLevel, serId);
                    Integer serviceCapacity = Common.randomInteger(1,12);
                    Double cost =serviceCapacity * serviceLevel * pageView * 2 / 5.0;
                    Integer timeRate = Common.randomInteger(1,2);

                    service.setBelongApplication(appId);
                    service.setBelongTenant(tenId);
                    service.setServiceCapacity(serviceCapacity);
                    service.setCost(cost);
                    service.setTimeRate(timeRate);
                    service.setTenantLevel(tenantLevel);
                    service.setApplicationLevel(applicationLevel);

                    pvId =pvId+pageView;
                    Double price = cost+(random.nextFloat() * (5.0-2.0)+2.0)*pageView/10.0;
                    price=Common.hold2(price);
                    SLA sla = new SLA(serId,tenId,appId, service,pageView, price);
                    serId++;
                    serviceList.add(service);
                    slas.add(sla);
                    services.add(service);
                }
                appId++;
                applicationList.add(application);
            }

        }
    }

    public static void printTotal()
    {
        System.out.println("租户总数=" + (tenId-1) + " 应用总数=" + (appId-1) + " 服务总数=" + (serId-1)+"  总PV="+pvId);
    }

    public static void printSLA()
    {
        for(SLA s:slas)
        {
            System.out.println(s.toString());
        }
    }

    public static void printService()
    {
        for(Service s:services)
        {
            System.out.println(s.tostring());
        }
    }
}
