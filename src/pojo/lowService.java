package pojo;

public class lowService extends Service{
    public lowService(Integer timeRate,Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(3);
        super.setAvailbilityRate(99.0);
        super.setCompensateRate(0.2);
        super.setSinglePrice(1.2);
        super.setTimeRate(timeRate);

    }
    public lowService(Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(3);
        super.setAvailbilityRate(99.0);
        super.setCompensateRate(0.2);
        super.setSinglePrice(1.2);
        //super.setTimeRate(timeRate);

    }


}
