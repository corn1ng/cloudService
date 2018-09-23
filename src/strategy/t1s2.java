package strategy;


import pojo.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//选择策略
// 租户第一优先级 服务第二优先级
public class t1s2 implements optimiseStrategy {

    @Override
    public void selectStategy(List<Service> services) {
        Collections.sort(services, new Comparator<Service>() {
            @Override
            public int compare(Service o1, Service o2) {
                if(o1.getTenantLevel()>o2.getTenantLevel())
                {
                    return 1;
                }
                else if(o1.getTenantLevel()==o2.getTenantLevel())
                {
                    if(o1.getServiceLevel()>o2.getServiceLevel())
                    {
                        return 1;
                    }
                    else if(o1.getServiceLevel()==o2.getServiceLevel())
                    {
                        if(o1.getApplicationLevel()>o2.getApplicationLevel())
                        {
                            return 1;
                        }
                        else if(o1.getApplicationLevel()==o2.getApplicationLevel())
                        {
                            return 0;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                    else
                    {
                        return -1;
                    }
                }
                else
                {
                    return -1;
                }
            }
        });

        for(Service s:services)
        {
            System.out.println(s.tostring());
        }
    }
}
