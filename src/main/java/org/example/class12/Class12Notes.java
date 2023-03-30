package org.example.class12;

public class Class12Notes {
/*
1. Web Architecture
    Web application and web service
        web app: Amazon.com, GUI
        web service: one component of web app


2. Evolution of web architecture
    Monolithic: backend frontend all in server. Not convenient for modifying
    Front-back separation: separate back end and front end,  client side to front end, front end to backend or vice versa
    Way to communicate:
        front end send request to back end for data
        web-socket: connection between back end front end, back end doesn't need to wait for request,
        push data directly to front end through web-socket
    Service oriented architecture:
        ESB: enterprise service bus
    Microservice:
        each service has its own database
    Mirco-Front:
        webpack


3. Communication
    REST: json, xml, html
    SOAP: xml
    RPC: remote procedure call
    GraphQL: pull data from multiple data resource with single call


4. data store
    sql: Mysql, Oracle, Sql server...
    no-sql: mongoDB, Cassandra
    cache: redis, mem-cache


5. Operating System
    Linux,
    Windows, Mac


6. SOLID Principle
    Single Responsibility Principle
    Open-closed Principle
    Liskov Substitution Principle
    Interface Segregation Principle
    Dependency Inversion Principle


7. Microservice components
    DNS: map domain name to IP address
    LB(load balancer): route different requests to web services
    Database
    Data firehose: used to do some data processing, a data engineer work part
    Cache Service
    job queue/service: do some offline work
    Services
    cloud storage
    full text search:
        traditional schema:
        id  |    title
        1   | I like dogs
        2   | dogs are cute
        3   | I like cats

        inverted index(used in full text search service):
        keyword  | ids
        dog      | 1, 2
        cute     | 2
        like     | 1,3
    Data warehouse: A data warehouse is a system that collects data from many sources and distributes it to an
    organization for analysis and reporting.
        Data warehouse vs database:
            Data warehouse is used for Analytical, database is for Transactional and Operational
            The database is basically a collection of data that is totally application-oriented.
            The data warehouse, in contrast, focuses on a certain type of data.
    CDN (Content Delivery Network): A CDN is a network of servers that distributes content from an “origin” server
    throughout the world by caching content close to where each end user is accessing the internet via a web-enabled device.


8. Spring Cloud
    Config server:
        Config server
        Spring Cloud Config is Spring's client/server approach for storing and serving distributed configurations
        across multiple applications and environments.
    Service discovery:
        Service Discovery is one dedicated server responsible to maintain the registry of all the Microservice that
        has been deployed and removed. This will act like a phone book of all other applications/microservices.
        Eureka, Consoul, Zookeeper
    Zipkin and Sleuth: tracing system(transactions, logs)
    Ribbon: Client side load balancer
    ELK:
        Kibana, Logstash, Elasticsearch
        data manipulation of unstructured data to structured is done by Logstash. Logs will be stored on client side.
        And use Kibana to see the indexed data
    Circuit Breaker: (default tolerance proxy) fall back
        Hystrix -> Resilience4j
        Allows to prevent cascading failures in microservices architecture by invoking remote services through a proxy.
 */
}
