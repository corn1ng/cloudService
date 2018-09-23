package dispatch;

import pojo.SLA;
import pojo.Service;

import java.util.List;

public class dispatch {
    public static void dispatchPV(Integer servicePV, Integer realPV, List<SLA> slaList, List<Service> services)
    {
        // 如果提供的多余实际需要的，低负载状态，准入。
        if(realPV<servicePV*0.95)
        {
            Integer surpuls = servicePV-realPV;
            System.out.println("低负载状态，准入请求。当前时间片剩余容量"+surpuls);

        }
        else
        {
            System.out.println("已超过95%，满载预警");
            if(realPV>servicePV)
            {
                System.out.println("警告！已超载"+"购买"+servicePV+"实际"+realPV);

            }
        }
    }
}
