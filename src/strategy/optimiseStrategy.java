package strategy;

import pojo.Service;

import java.util.List;

public interface optimiseStrategy {

    List<Service> selectStategy(List<Service> services);

    public Integer calcuScore(List<Service> services);
}
