package org.example.class1;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashCodeDemo {

    public static void main(String[] args) {
        Student s1 = new Student("Alex", 1);
        Student s2 = new Student("Alex", 1);

        Map<Student, String> map = new HashMap<>();
        map.put(s1, "AAA");
        map.put(s2, "BBB");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        for (Map.Entry<Student, String> entry: map.entrySet()) {
            System.out.println(entry.getKey().toString());
            System.out.println(entry.getValue().toString());
        }
    }
}

class Student{
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Student student = (Student) obj;  // type casting
        return (student.name.equals(this.name) && student.id == this.id );
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
