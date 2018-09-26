package init;

import common.Common;
import pojo.SLA;
import pojo.Service;

import java.util.List;

public class PvInit {

    public static Integer pvPerTime(List<SLA> slaList, List<Service> services)
    {
        Integer truePV =0;

        for(int i=0;i<slaList.size();i++)
        {
            Integer pv =slaList.get(i).getPageView();
            Integer minus = Common.randomInteger(-40,80);
            if(pv-minus<0)
            {
                Integer index =Common.randomInteger(0,10);
                services.get(i).setRealPV(pv- index);
            }
            else {
                services.get(i).setRealPV(pv-minus);
            }

            truePV =truePV+services.get(i).getRealPV();
        }

        // System.out.println("实际使用PV="+truePV);
        return truePV;
    }
}
