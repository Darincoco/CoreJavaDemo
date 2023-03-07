package org.example.class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkCode {
    public static void main(String[] args) {
        Student student1 = new Student("Alexander Hamilton", 18, 85);
        Student student2 = new Student("Aaron Burr", 18, 75);
        Student student3 = new Student("George Washington", 20, 65);
        Student student4 = new Student("Tomas Gates", 21, 55);
        Student student5 = new Student("Benjamin Franklin", 25, 45);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        // use stream api to find all the students’ name starting with ‘A’
        List<Student> res1 =
                studentList.stream().filter(e-> e.getName().charAt(0) == 'A').collect(Collectors.toList());
        System.out.println(res1.toString());

        // use stream api to get the sum of all the students score
        int res2 =
                studentList.stream().mapToInt(e->e.getScore()).sum();
        System.out.println(res2);

        // use stream api to find all the students whose sore >= 60
        List<Student> res3 =
                studentList.stream().filter(e-> e.getScore()>= 60).collect(Collectors.toList());
        System.out.println(res3);

        // use stream api to retrieve all students name
        List<String> res4 =
                studentList.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(res4);

        // use stream api to count the frequency of each age
        Map<Integer, Integer> res5 =
                studentList.stream().collect(Collectors.toMap(c-> c.getAge(), v-> 1, (a,b) -> a + b));
        System.out.println(res5);

    }
}

class Student {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
