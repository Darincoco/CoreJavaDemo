package org.example.class1;

import java.util.*;

public class Class1Notes {
    /**
     * 1. Maven
     * Maven: Maven is a Project Management tool. Most popular use of Maven is for build management and dependencies
     *
     * Maven solution: Tell Maven the projects you are working with (dependencies), like Spring, Hibernate etc. ....
     *                 Maven will go out and download the JAR files for those projects for you
     *                 And Maven will make those JAR files available during compile/run
     *
     * Inside a maven project
     * (a) Main file: for java developing code
     *      Resources file: static resources(web page, pics, xml file)
     * (b) Test file: for java test cases
     * (c) POM(Project Object Model).xml:
     *             structure:  project meta data -- Project name, version etcOutput file type: JAR, WAR, ...
     *                         dependencies -- List of projects we depend on Spring, Hibernate, etc...
     *                         plug ins -- Additional custom tasks to run:generate JUnit test reports etc...
     *             1. every maven project will have
     *             2. artifact id: project id
     *             3. properties: Java version, coding type, etc.
     *             4. dependencies: inside a <dependencies> has every <dependency>.
     *                              Dependency Coordinates: (GroupID, ArtifactID, Version or GAV)
     *                              How to Find Dependency Coordinates:
     * 		                        Option 1: Visit the project page (spring.io, hibernate.org etc)
     * 		                        Option 2: Visit http://search .maven.org (easiest approach)
     *                              e.g.<groupId>junit</groupId>
     *                                  <artifactId>junit</artifactId>
     *                                  <version>3.8.1</version>
     *                                  <scope>test</scope>
     *
     * Type of repository: local(stored on PC, in .m2 folder),
     *                     central(public repository, found on website, can be downloaded),
     *                     remote(company developed for specific uses, need authentication)
     *
     * maven build lifecycle: clean, validate, compile, test, package(as jar or war), verify,
     *                        install(put jar into local repository for future use), site, deploy
     * maven command line: mvn clean, mvn test, ...
     *
     *
     * 2. git: distribution control tool
     * common command: git add . / git commit -m xxx.xxx(file name) / git push / git branch /
     *                 git checkout xxx(branch name) --- switch to new branch
     *
     *
     * 3. eight basic data type:
     *      primitive type: byte(8 bits), short(16 bits), int(32 bits), long(64 bits),
     *                      float(32 bits), double(64 bits), char(16 bits), boolean(1 bit)
     *      wrapper type(Object): Byte, Short, Integer, Long, Float, Double, Character, Boolean
     *      autoboxing: primitive -> wrapper
     *      unboxing: wrapper -> primitive
     *
     *
     * 4. String/ StringBuilder/ StringBuffer
     *      String: String immutable class, can not change
     *
     *      StringBuilder: mutable class, can append, change certain character /
     *                     not thread safe, but better processing speed because of no lock in it
     *
     *      StringBuffer: mutable class, same as SB, but thread safe, poor performance
     *
     *      String a = new String("abc");
     *      String b = new String("abc");
     *      String c = "abc";
     *      String d = "abc";
     *      System.out.println(a == b);   F
     *      System.out.println(a == c);   F
     *      System.out.println(c == d);   T
     *      System.out.println(a.equals(b));   T
     *      new String Object stored in a heap, every Object's address is different
     *      String c, d stored in a String Intern Pool, String Intern Pool is in the heap, same address
     *      String Intern Pool: save some memory space for jvm
     *      b.intern() can put a String object into String Pool
     *      double equals compare the reference address, so a != b, c == d
     *
     * 5. Integer Pool
     *      Integer a = 10;
     *      Integer b = 10;
     *      Integer c = New Integer(10);
     *      Integer d = Integer.valueOf(10)；
     *      System.out.println(a == b);   T
     *      System.out.println(a == c);   F, a is in the Integer Pool
     *      System.out.println(a == d);   T, d is put to the Integer Pool
     *
     *      Integer e = 200;
     *      Integer f = 200;
     *      System.out.println(e == f);   F, Integer Pool only stores -127 ~ 127(see in origin source)
     *
     *
     * 6. Equals and hashCode
     * After override equals(), need to override hashCode(), if only overrides equals, hashCode() will still hash two
     * keys to different bucket
     * If there is no equals() in a class, java will call Object.equals(), which compares the object address
     *
     *
     * 7. Data Structures
     * Collection vs Collections
     * Collection is an interface, contains Queue, Set, List
     *      Queue: Priority Queue, ArrayDeque, LinkedList...
     *
     *      Set(element is unique): HashSet(no insertion order), TreeSet, LinkedHashSet(has insertion order)
     *
     *      List: LinkedList(Separate address, connected by node),
     *            ArrayList(object in consecutive address)
     *
     *      Map:
     *          TreeMap,
     *          HashMap(not thread safe, allow a null value as a key(bucket 0)),
     *               key  ---> hashCode ---> index = hashCode % size of Map(16)
     *               "abc"       33          33%16 = 1
     *               "def"       49          49%16 = 1
     *               above is called hash collision
     *               |0|node 1|2|3|... |15|
     *                     |
     *                     v
     *                  node 2
     *               HashMap use arrayList to save 16 buckets,
     *               each buckets use linkedList to save values when hash collision
     *               (if len of LinkedList > 8 in a bucket, will convert to RedBlackTree)  new feature in Java 8
     *           HashTable(thread safe, does not allow null value key, object level lock),
     *           ConcurrentHashMap(thread safe, bucket level lock)
     *
     *      Stack(thread safe, FILO) vs Queue(FIFO)
     *
     * Collections is a class
     *
     *
     * 8. Comparator and Comparable:
     * Comparable is an interface used to define orders, but only one chance compare. The class itself must implement
     *            the Comparable interface to compare its instances.
     * Comparator is an interface used to define orders, but can override Comparable defined in the class
     *            can also use lambda expression, much faster and convenient
     *            we can set up different comparator to compare with different aspects
     *
     */

    public static void main(String[] args) {
//        int a = 1;
//        Integer b = 1;
//
//        List<Integer> list = new ArrayList<>();
//        list.add(a);
//        list.add(b);
//
//        Integer i1 = 20;
//        Integer i2 = 20;
//        Integer i3 = 200;
//        Integer i4 = 200;
//
//        System.out.println(i1==i2);
//        System.out.println(i3==i4);
//        System.out.println(i3.equals(i4));

//        String s = "abc";
//        StringBuilder sb = new StringBuilder("abc");
//
//        Class1Notes class1Notes = new Class1Notes();
//
//        class1Notes.appendStr(s);
//        System.out.println("String append result: " + s);     // "abc"
//
//        class1Notes.appendStrSB(sb);
//        System.out.println("StringBuilder append result: " + sb);   //"abccde"

//        String a = new String("abc");
//        String b = new String("abc");
//        String c = "abc";
//        String d = "abc";
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(c == d);
//        System.out.println(a.equals(b));

//        Node n1 = new Node(1, 1);
//        Node n2 = new Node(1, 1);
//        System.out.println(n1 == n2);       // F
//        System.out.println(n1.equals(n2));  // F, equals method is Object's method
//                                            // return (this == obj); compare the object address

//        Set<Node> set = new TreeSet<>(new MyComparator());
        Set<Node> set = new TreeSet<>((a,b) -> Integer.compare(b.x,a.x));
        set.add(new Node(1, 1));
        set.add(new Node(2, 2));
        set.add(new Node(3, 3));
        set.add(new Node(4, 4));
        System.out.println(set.stream().findFirst().get().x);  // error, because no order in class Node
    }

    public void appendStr(String str) {
        str = str + "cde";
    }

    public void appendStrSB(StringBuilder str) {
        str.append("cde");
    }

}

class Node implements Comparable<Node>{
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.x, o.x);
    }
}

class MyComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o2.x, o1.x);
    }
}


