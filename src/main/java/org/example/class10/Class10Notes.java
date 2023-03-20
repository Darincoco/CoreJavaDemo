package org.example.class10;

public class Class10Notes {
/*
1. Exception handling
    @ExceptionHandler -> local
    @ControllerAdvice -> global
    @ResponseStatus -> ResponseStatusExceptionResolver class
    No annotation -> DefaultHandlerExceptionResolver


2. Validation (use jakarta)
    @NotBlank: not empty("")
    @NotNull: not null, but can blank
    @Min() - @Max()
    @Email: in a email format
    @Pattern(reg expression)
    @Validated: based on the annotations asked in the class object


3. Cache:
    Cache miss/ Cache hit
    @EnableCache
    @Cacheable()
    CacheManager

    Eviction Policy
        LRU cache(least recent used) -> LinkedHashMap, LinkedList + HashMap
        LFU cache(least frequent used)
        No-eviction: when fulled, new cache come in and dropped directly
        Random
        Most recently used


4. Relational database(sql database)
    database
    DBMS(database management system): Mysql, PostgreSQL, SQL Server, Oracle, FileMaker
    SQL(Structured Query Language), based language to manipulate database, select.. from .. where.. group by.. order by..

    mysql example: select * from my_table order by name limit 20, 10(select 20 -30)
    Oracle example: select * from my_table order by name offset 20 rows fetch next 10 rows only

    database normalization(has 6, 3 used most)
        1nf(normal form): each table ceil should contain a single value, each record needs to be unique
        2nf: follow 1nf, follow single column primary key(unique identifier)
        3nf: follow 2nf, has no transitive functional dependency

        high nf != better, table will be split to many joined table, join operation will be expensive
        so sometimes according to scenario do de-normalization


5. Non-relational database(no-sql database)
    major categories of no-sql:
        Document data stores(key: id, each key has document: json file, xml file...)
            mongoDB: Collections -> tables, documents -> rows, fields -> columns
            CouchDB
        Columnar(column family) data stores
            Cassandra, HBase
        Key-value stores: (key value pair, values are hashed)
            Redis: stores data entirely in memory
            Riak
        Graph data stores: Neo4j, GraphDB

    CAP principle(for no-sql, distributed system):
        Consistency
        Available
        Partition tolerance (can mostly be archived)

        AP: Dynamo, Cassandra, CouchDB, Riak, SimpleDB
        CP: MongoDB, BigTable, HBase, Redis, Hypertable...


6. Difference between sql and no-sql database
    sql:
        relational database
        predefined schema
        vertical scaling
        ACID

    no-sql:
        non-relational database
        dynamic schema
        horizontal scaling
        CAP

 */
}
