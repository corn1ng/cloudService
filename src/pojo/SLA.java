package pojo;

import pojo.Service;

public class SLA {

    //SLA序号& 服务ID
    private Integer SLAId;
    // 租户序号
    private Integer tenantId;
    // 应用序号
    private Integer appId;
//  租户等级
//    private Integer TenantLevel;
//   应用等级
//    private Integer ApplicationLevel;
    // 服务
    private Service service;
    // 访问量
    private Integer pageView;
    //总价
    private Double price;

    public SLA(Integer SLAId,Integer tenantId,Integer appId, Service service, Integer pageView, Double price) {
        this.SLAId = SLAId;
        this.tenantId=tenantId;
        this.appId=appId;
//        this.TenantLevel = tenantLevel;
//        this.ApplicationLevel = applicationLevel;
        this.service = service;
        this.pageView = pageView;
        this.price = price;
    }

    public Integer getSLAId() {
        return SLAId;
    }

    public void setSLAId(Integer SLAId) {
        this.SLAId = SLAId;
    }

//    public Integer getTenantLevel() {
//        return TenantLevel;
//    }
//
//    public void setTenantLevel(Integer tenantLevel) {
//        TenantLevel = tenantLevel;
//    }
//
//    public Integer getApplicationLevel() {
//        return ApplicationLevel;
//    }
//
//    public void setApplicationLevel(Integer applicationLevel) {
//        ApplicationLevel = applicationLevel;
//    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "SLA{" +
                "SLA& 服务ID=" + SLAId +
                ", 租户ID=" + tenantId +
                ", 应用ID=" + appId +
//                ", 租户等级=" + TenantLevel +
//                ", 应用等级=" + ApplicationLevel +
                ", 服务等级=" + service.getServiceLevel() +
                ", 服务容量=" + service.getServiceCapacity() +
                ", SLA服务PV=" + pageView +
                ", 总价格=" + price +
                '}';
    }
}
