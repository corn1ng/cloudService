package pojo;

import java.util.List;

public class Tenant {

    private Integer tenantId;

    private Integer tenantLevel;

    private List<Application> applicationList;

    public Tenant()
    {

    }
    public Tenant(Integer tenantId,Integer tenantLevel)
    {
        this.tenantId=tenantId;
        this.tenantLevel=tenantLevel;
    }

    public Tenant(Integer tenantId, Integer tenantLevel, List<Application> applicationList) {
        this.tenantId = tenantId;
        this.tenantLevel = tenantLevel;
        this.applicationList = applicationList;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getTenantLevel() {
        return tenantLevel;
    }

    public void setTenantLevel(Integer tenantLevel) {
        this.tenantLevel = tenantLevel;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }
}
