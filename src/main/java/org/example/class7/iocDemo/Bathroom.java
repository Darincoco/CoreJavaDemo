package org.example.class7.iocDemo;

public class Bathroom {
    private Integer size;
    private boolean withTap;

    public Bathroom(Integer size, boolean withTap) {
        this.size = size;
        this.withTap = withTap;
    }

    @Override
    public String toString() {
        return "Bathroom{" +
                "size=" + size +
                ", withTap=" + withTap +
                '}';
    }
}
