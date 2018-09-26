package pojo;

import java.util.List;

public class Application {

    private Integer applicationId;

    private Integer applicationLevel;

    private Integer belongTenant;

    private List<Service> serviceList;

    public Application()
    {

    }

    public Application(Integer applicationId,Integer applicationLevel,Integer belongTenant)
    {
        this.applicationId=applicationId;
        this.applicationLevel=applicationLevel;
        this.belongTenant=belongTenant;
    }

    public Application(Integer applicationId, Integer applicationLevel,Integer belongTenant ,List<Service> serviceList) {
        this.applicationId = applicationId;
        this.applicationLevel = applicationLevel;
        this.belongTenant =belongTenant;
        this.serviceList = serviceList;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getApplicationLevel() {
        return applicationLevel;
    }

    public void setApplicationLevel(Integer applicationLevel) {
        this.applicationLevel = applicationLevel;
    }


    public Integer getBelongTenant() {
        return belongTenant;
    }

    public void setBelongTenant(Integer belongTenant) {
        this.belongTenant = belongTenant;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }


}
