package common;

import pojo.Service;
import pojo.highService;
import pojo.lowService;
import pojo.midService;

import java.text.DecimalFormat;
import java.util.Random;

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

    // 产生a-b之间的随机数
    public static Integer randomInteger(Integer a,Integer b)
    {
        Random random =new Random();
        Integer ran =random.nextInt(b-a+1)+a;
        return ran;
    }


    // 保留两位小数
    public static Double hold2(Double d)
    {
        DecimalFormat df =new DecimalFormat("#.00");
        d =Double.parseDouble(df.format(d));
        return d;
    }
}
