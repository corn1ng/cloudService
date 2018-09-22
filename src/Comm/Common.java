package Comm;

import pojo.Service;
import pojo.highService;
import pojo.lowService;
import pojo.midService;

public class Common {

    public static Service toService(Integer integer,Integer serviceId)
    {
        Service service=null;
        if(integer==1)
        {
            service =new highService(serviceId);
        }
        else if(integer==2)
        {
            service =new midService(serviceId);
        }
        else if(integer==3)
        {
            service =new lowService(serviceId);
        }
        return service;
    }
}
