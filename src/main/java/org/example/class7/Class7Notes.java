package org.example.class7;

public class Class7Notes {
/*
1. OSI model and TCP/IP model
    OSI model: Open System Interconnection model, 7 layer model
        - application layer (Http, FTP(File Transfer Protocol), SMTP, DNS)
        - presentation layer (data encryption/ decryption)
        - session layer (maintain connection between servers) (socket)
        - transport layer (divide data to package and transport (using TCP / UDP protocol))
        - network layer (decide which physical path the data will take. Find device decide path to take)
        - data link layer (define format of data of network)
        - physical layer (transfer raw bit)
    send data: application layer -> ... -> physical layer
    receive data: physical layer -> ... -> application layer

    TCP/IP: current use, simplified model
        - application layer (is application/ presentation/ session layer in OSI model)
        - transport layer (is transport layer in OSI model)
        - Internet layer (network layer in OSI model)
        - network access layer (data link / physical layer in OSI model)

2. HTTP (hypertext transfer protocol, application layer protocol) - A client server model
    Http request
        - header / body
    Http response
        - header / body
    Http method:
        get: read operation                 |safe, idempotent, cacheable|
        post: create operation              |not safe, not idempotent(will create new entry in db), not cacheable|
        put: full update operation          |not safe, idempotent, not cacheable|
        delete: remove operation            |not safe, idempotent, not cacheable|
        patch: partial update operation     |not safe, not idempotent(when update operation into db entry, entry will
                                            change everytime) but can be idempotent, not cacheable|
    Http status:
        1xx information
        2xx success
        3xx redirection
        4xx client error
        5xx server error
    Http advanced
        safe: http method is safe -> the method will not change the state of server
        idempotent: http method is idempotent -> an identical request can be made once or several times in a row with
                    the same effect while leaving the server in the same state
        cacheable: response can be cached or not
        status advanced
            200 OK, send request to server, server send back
            201 created, post method to create successfully
            202 accepted, send request to server, server get but not complete
            204 no content, use with put post, submit info and not update current page
            307 temporary redirect
            301 moved permanently
            400 bad request
            401 unauthorized, use is not valid
            404 not found, requested resource is not found
            403 forbidden, user doesn't permission
            500 internal server error


3. TCP / UDP
    Differences:
        - TCP divides data into sequential packages(e.g. 0 - 100) and sent to server. Server receive the data and will check
        if it receives all 0 - 100 packages. If missing some, TCP will send missing part again. Speed slower
        - UDP doesn't have error detection. Used in some cases when loss are allowed. E.g. Watch stream / play game some
        package loss will occur. Speed faster
    TCP 3 way handshaking (for establishing a connection)
        Step1: SYN. The client send a segment with SYN (synchronized Sequence Number) which inform the server that the client want to set a connection with the SYN
        Step2: SYN + ACK: Server responds to the client request with SYN + ACK(acknowledgement) bits set. ACK signifies the response of the segment it received and SYN signifies what sequence number it is likely to start the segment with
        Step3: ACK: Client acknowledges the response from server and then establishes a connection of data transfer

    TCP 4 way handshaking (for terminating a connection)
        Step1: Firstly, from one side of the connection, either from the client or the server the FIN flag will be sent
        as the request for the termination of the connection.
        Step2: In the second step, whoever receives the FIN flag will then be sending an ACK flag as the acknowledgment
        for the closing request to the other side.
        Step3: And, at the Later step, the server will also send a FIN flag as the closing signal to the other side.
        Step4: In the final step, the TCP, who received the final FIN flag, will be sending an ACK flag as the final
        Acknowledgement for the suggested connection closing.

4. Session and Cookie
    Differences:
        - Sessions are stored in server side/ each client will have session id/ when client send data to server first time
        server will create a session id and send back info in cookies
        - Cookies are piece of info in client side / when client send requests to server, cookie will be sent too, including
        the session id that server created before


5. Java web application
    dispatcher servlet will route the requests to different servlet and get response back to clients
    Tomcat / Jboss / Jetty / Apache TomEE...


6. Three Tier(layer) architecture
    logic: client(HTML file) -> controller -> service -> DAO(data access object) -> database
    controller / service / DAO(repository)


7. Spring IOC
    IOC: inversion of control, with Ioc, the framework or container takes responsibility for object creation and management,
    and the application code is decoupled from these concerns.
    DI: dependency Injection, instead of an object creating its dependencies, the dependencies are passed in from an
    external source, usually by a framework or container, allows for modular and loosely coupled components
    Bean: all java objects controller by ioc container
    ioc container looks like: ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
 */

    public static void main(String[] args) {

    }
}

