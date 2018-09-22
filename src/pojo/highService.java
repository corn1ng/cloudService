package pojo;

public class highService extends Service {

    public highService(Integer timeRate,Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(1);
        super.setAvailbilityRate(99.99);
        super.setCompensateRate(0.5);
        super.setSinglePrice(1.5);
        super.setTimeRate(timeRate);

    }
    public highService(Integer serviceId) {
        super.setServiceId(serviceId);
        super.setServiceLevel(1);
        super.setAvailbilityRate(99.99);
        super.setCompensateRate(0.5);
        super.setSinglePrice(1.5);
        //super.setTimeRate(timeRate);

    }


}
