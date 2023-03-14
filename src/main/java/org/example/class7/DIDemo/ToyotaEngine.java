package org.example.class7.DIDemo;

import org.springframework.stereotype.Component;

@Component
public class ToyotaEngine implements IEngine{
    String company;
    double cost;

    public ToyotaEngine(String company, double cost) {
        this.company = company;
        this.cost = cost;
    }

    @Override
    public String importOrigin() {
        return "Japan";
    }

    @Override
    public double cost() {
        return cost;
    }

    @Override
    public String toString() {
        return "ToyotaEngine{" +
                "company='" + company + '\'' +
                ", cost=" + cost +
                '}';
    }
}
