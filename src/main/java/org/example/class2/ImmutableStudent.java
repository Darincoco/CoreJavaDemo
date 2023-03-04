package org.example.class2;

import java.util.ArrayList;
import java.util.List;

class Course{
    private final String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
final class ImmutableStudent {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final List<Course> courses;

    ImmutableStudent(int id, String firstName, String lastName, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = deepCopy(courses);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Course> getCourses() {
        return deepCopy(this.courses);
    }

    public List<Course> deepCopy(List<Course> list){
        List<Course> newList = new ArrayList<>();
        for (Course course: list) {
            newList.add(course);
        }

        return newList;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "courses=" + courses +
                '}';
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java");
        Course course2 = new Course("Python");
        Course course3 = new Course("Java Script");
        Course course4 = new Course("CPP");
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        ImmutableStudent student = new ImmutableStudent(1, "Jack", "Hilton", courseList);

        System.out.printf("Student id: %d, name: %s %s" ,student.getId(), student.getFirstName(), student.getLastName());
        for (Course course: student.getCourses()) {
            System.out.println("\nStudent courses are: " + course.toString());
        }

        // now to make change to course list
        List<Course>courses = student.getCourses();
        courses.add(course4);
        for (Course course: student.getCourses()) {
            System.out.println("\nStudent courses after changes are: " + course.toString());
        }

    }
}
