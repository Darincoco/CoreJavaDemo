package org.example.class1;

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
     * (b)Test file: for java test cases
     * (c)POM(Project Object Model).xml:
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
     *
     */
}
