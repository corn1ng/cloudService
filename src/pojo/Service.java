package pojo;

public class Service {
    // 服务序号
    private Integer serviceId;
    // 服务等级
    private Integer serviceLevel;
    // 所属应用
    private Integer belongApplication;
    // 可用率
    private Double availbilityRate;
    // 赔偿标准
    private Double compensateRate;
    //单价比率
    private Double singlePrice;
    // 响应时间
    private Integer timeRate;
    // 所属应用
    private Integer belongTenant;
    // 时间窗口内时间PV
    private Integer realPV;

    public Service(Integer serviceId, Integer serviceLevel,Integer belongApplication, Integer belongTenant,Double availbilityRate, Double compensateRate, Double singlePrice, Integer timeRate) {
        this.serviceId = serviceId;
        this.serviceLevel = serviceLevel;
        this.belongApplication =belongApplication;
        this.belongTenant=belongTenant;
        this.availbilityRate = availbilityRate;
        this.compensateRate = compensateRate;
        this.singlePrice = singlePrice;
        this.timeRate = timeRate;
    }

    public Service() {
    }

    public Integer getRealPV() {
        return realPV;
    }

    public void setRealPV(Integer realPV) {
        this.realPV = realPV;
    }

    public Integer getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(Integer serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public Double getAvailbilityRate() {
        return availbilityRate;
    }

    public void setAvailbilityRate(Double availbilityRate) {
        this.availbilityRate = availbilityRate;
    }

    public Double getCompensateRate() {
        return compensateRate;
    }

    public void setCompensateRate(Double compensateRate) {
        this.compensateRate = compensateRate;
    }

    private Double getSinglePrice() {
        return singlePrice;
    }

    void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    private Integer getTimeRate() {
        return timeRate;
    }

    public void setTimeRate(Integer timeRate) {
        this.timeRate = timeRate;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getBelongApplication() {
        return belongApplication;
    }

    public void setBelongApplication(Integer belongApplication) {
        this.belongApplication = belongApplication;
    }

    public Integer getBelongTenant() {
        return belongTenant;
    }

    public void setBelongTenant(Integer belongTenant) {
        this.belongTenant = belongTenant;
    }

    public String tostring() {
        return ( "服务ID="+getServiceId()
                +"  租户ID="+getBelongTenant()
                +"  应用ID="+getBelongApplication()
                +"  服务等级="+getServiceLevel()
                +"  可用率="+getAvailbilityRate()
                +"  赔偿标准="+getCompensateRate()
                +"  服务单价="+getSinglePrice()
                +"  响应时间="+getTimeRate());

    }
}
