package strategy;


import pojo.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//选择策略
// 租户第一优先级 服务第二优先级
public class t1s2 implements optimiseStrategy {

    @Override
    public List<Service> selectStategy(List<Service> services) {
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

//        for(Service s:services)
//        {
//            System.out.println(s.tostring());
//        }
        return  services;
    }

    // 优选分数计算
    public Integer calcuScore(List<Service> services)
    {
        Integer result = 0;
        for(int i=0;i<services.size();i++)
        {
            if(services.get(i).getTenantLevel()==1)
            {
                result=result+1024;
            }
            else if(services.get(i).getTenantLevel()==2)
            {
                result=result+256;
            }
            else
            {
                result=result+64;
            }
            if(services.get(i).getServiceLevel()==1)
            {
                result=result+16;
            }
            else if(services.get(i).getServiceLevel()==2)
            {
                result=result+4;
            }
            else
            {
                result=result+1;
            }
        }
        return result;
    }
}
