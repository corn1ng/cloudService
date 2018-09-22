package pojo;

public class midService extends Service{
    public midService(Integer timeRate,Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(2);
        super.setAvailbilityRate(99.9);
        super.setCompensateRate(0.35);
        super.setSinglePrice(1.35);
        super.setTimeRate(timeRate);

    }
    public midService(Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(2);
        super.setAvailbilityRate(99.9);
        super.setCompensateRate(0.35);
        super.setSinglePrice(1.35);
        //super.setTimeRate(timeRate);

    }


}
