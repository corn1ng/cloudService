package init;

import common.Common;
import pojo.SLA;
import pojo.Service;

import java.util.List;

public class pvInit {

    
    public static Integer pvPerTime(List<SLA> slaList, List<Service> services)
    {
        Integer truePV =0;

        for(int i=0;i<slaList.size();i++)
        {
            Integer pv =slaList.get(i).getPageView();
            Integer minusRealPV = Common.randomInteger(-10,35);
            services.get(i).setRealPV(pv-minusRealPV);
        }
        for(int i=0;i<services.size();i++)
        {
            truePV =truePV+services.get(i).getRealPV();
        }
        //System.out.println("实际使用PV="+truePV);
        return truePV;
    }
}
