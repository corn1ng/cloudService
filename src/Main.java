import Comm.Common;
import pojo.Application;
import pojo.SLA;
import pojo.Service;
import pojo.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        //TotalPV 3000-9000
        Integer totlaPV = (random.nextInt(6000) + 3000);

        // 租户总数   3-10
        Integer totalTenant = random.nextInt(8) + 3;

        // 租户计数器
        Integer tenId = 1;

        // 应用计数器
        Integer appId = 1;

        // 服务计数器
        Integer serId = 1;

        List<SLA> slas =new ArrayList<>();

        for (tenId = 1; tenId <= totalTenant; tenId++) {
            Integer tenantLevel = random.nextInt(3) + 1;
            Tenant tenant = new Tenant(tenId, tenantLevel);
            Integer applicationPerTenant = random.nextInt(9) + 1;
            List applicationList = new ArrayList(applicationPerTenant);
            for (int j = 1; j <= applicationPerTenant; j++) {
                Integer applicationLevel = random.nextInt(3) + 1;
                Application application = new Application(appId, applicationLevel, tenId);
                Integer servicePerApplication = random.nextInt(8) + 4;
                List<Service> serviceList = new ArrayList<>(servicePerApplication);
                for (int k = 1; k < servicePerApplication; k++) {
                    Integer serviceLevel = random.nextInt(3) + 1;

                    Service service = Common.toService(serviceLevel, serId);
                    service.setBelongApplication(appId);
                    service.setBelongTenant(tenId);
                    Integer timeRate = random.nextInt(2) + 1;
                    service.setTimeRate(timeRate);
                    Integer serviceCapacity = random.nextInt(11) + 1;
                    Integer pageView = random.nextInt(60) + 40;
                    Double price = serviceCapacity * serviceLevel * pageView * 2 / 5.0;
                    SLA sla = new SLA(serId,tenId,appId,tenantLevel, applicationLevel, service, serviceCapacity, pageView, price);
                    serId++;
                    serviceList.add(service);
                    slas.add(sla);
                }
                appId++;
                applicationList.add(application);
            }

        }
        System.out.println("租户总数=" + (tenId-1) + " 应用总数=" + (appId-1) + " 服务总数=" + (serId-1));
        for(SLA s:slas)
        {
            System.out.println(s.toString());
        }
    }






}
