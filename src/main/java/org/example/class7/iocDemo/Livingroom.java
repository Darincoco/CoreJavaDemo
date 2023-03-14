package org.example.class7.iocDemo;

public class Livingroom {
    private Integer size;
    private String type;

    public Livingroom(Integer size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Livingroom{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
