package pojo;

public class Service {
    // 服务序号
    private Integer serviceId;
    // 服务等级
    private Integer serviceLevel;
    // 所属应用
    private Integer belongApplication;
    //租户等级
    private Integer TenantLevel;
    // 应用等级
    private Integer ApplicationLevel;
    // 可用率
    private Double availbilityRate;
    // 赔偿标准
    private Double compensateRate;
    // 服务体量
    private Integer serviceCapacity;
    //单价比率
    private Double singlePrice;
    // 响应时间
    private Integer timeRate;

    private Integer belongTenant;
    // 时间窗口内时间PV
    private Integer realPV;
    // 成本
    private Double cost;
    // 准入的PV
    private Integer admitPV;
    // 拒绝的PV
    private Integer rejectPV;



    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    public Integer getServiceCapacity() {
        return serviceCapacity;
    }

    public void setServiceCapacity(Integer serviceCapacity) {
        this.serviceCapacity = serviceCapacity;
    }


    public Integer getTenantLevel() {
        return TenantLevel;
    }

    public void setTenantLevel(Integer tenantLevel) {
        TenantLevel = tenantLevel;
    }

    public Integer getApplicationLevel() {
        return ApplicationLevel;
    }

    public void setApplicationLevel(Integer applicationLevel) {
        ApplicationLevel = applicationLevel;
    }


    public Integer getAdmitPV() {
        return admitPV;
    }

    public void setAdmitPV(Integer admitPV) {
        this.admitPV = admitPV;
    }

    public Integer getRejectPV() {
        return rejectPV;
    }

    public void setRejectPV(Integer rejectPV) {
        this.rejectPV = rejectPV;
    }

    public String tostring() {
        return ( "服务ID="+getServiceId()
                +"  租户ID="+getBelongTenant()
                +"  应用ID="+getBelongApplication()
                +"  租户等级="+getTenantLevel()
                +"  应用等级"+getApplicationLevel()
                +"  服务等级="+getServiceLevel()
                +"  真实PV="+getRealPV()
                +"  准入量"+getAdmitPV()
                +"  拒绝量"+getRejectPV()
                +"  可用率="+getAvailbilityRate()
                +"  赔偿标准="+getCompensateRate()
                +"  服务单价="+getSinglePrice()
                +"  响应时间="+getTimeRate()
                +"  服务体量="+getServiceCapacity()
                +"  成本="+getCost()
                );

    }
}
