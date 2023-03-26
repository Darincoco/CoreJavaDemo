package org.example.class11;

public class Class11Notes {
/*
1. JDBC (Java DataBase Connector)
    steps: set up connection -> statement -> sql query -> process sql -> close connection/ statement
    can do select, update, insert(whole, partial), delete
    atomic transaction(commit, rollback)
    transactions: can roll back if exceptions happen, if everything is ok, then commit
    PreparedStatement can prevent sql injection
    Batch processing
    Statement, PreparedStatement, CallableStatement usage:
        Statement: execute normal sql queries
        PreparedStatement: execute parameterized query
        CallableStatement: call stored procedure from java program

    lower level commonly not use, use hibernate


2. Hibernate
    ORM: Object Relational Mapping
    ORM tool: Hibernate, Sequelize, MyBatis, SqlAlchemy, Doctrine2...

    JPA: Java Persistence API one of JAVAEE specification
    Hibernate vs JPA:
        Hibernate: implementation of JPA

    Hibernate Architecture:
        Configuration -> Session Factory -> Session -> query -> database
                                               ^
                                               |
                                           Java Object from Java app

    Entity LifeCycle:
        Transient
        Persistent: object stored/ processed by session
        Detached: call evict method, object then in detached stage
        Removed: object removed from database, will in removed

    Mapping:
        OneToOne: husband <-> wife                      eager default
        ManyToOne: Accounts -> Employee                 eager default
        OneToMany: Employee -> Accounts                 lazy default
        ManyToMany: Reader <-> Subscription             lazy default

    Cascade Type:
        Persist: used to save
        Merge: used to update database with new entity
        Refresh: opposite with merge
        Remove
        Detach
        All

    Fetch type:
        lazy loading: load the single object -> eager!
        eager loading: load the object collections -> lazy!

    First level cache / Second level cache:
        Session level Cache(first level): first come to session to find data, open by default
        Session Factory Cache(second level): if first level cache miss, come to session factory to find data,
        close by default, globally available
        If both cache miss, go to database find data
        default cache: EhCache, can change to OSCache, Redis

    Hibernate Query:
        Criteria Queries:
        HQL: Hibernate Query Language:
        Native query: can use the query from base database

    Usage (from no to yes):
        jdbc -> Hibernate -> spring data JPA / Mongo ...
 */
}
