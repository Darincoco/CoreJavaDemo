package org.example.class8;


public class Class8Notes {
/*
1. Types of DI
    Constructor injection
        put @Autowired on constructor
        call constructor order: dogs controller -> dogs service -> dogs repo,
        fields defined in construction back order: dog repo -> service -> controller
        recommended, make unit test easily, inject mock easily

    Setter injection
        put @Autowired on setter method
        call constructor order: dog controller no-arg -> dog service no-arg -> dog repo no-arg
        fields defined by setter populate back, order: dog service -> dog controller
        flexible, can do partially injection, inject certain one arg in a setter method

    Filed injection
        put @Autowired on the field we define
        most convenient, prevent cycle dependency issue, not safe when autowired a private field from other class


2. ApplicationContext, BeanFactory
    ApplicationContext, interface, extends BeanFactory, implementation: ClassPathApplicationContext,
    FileSystemApplicationContext, AnnotationConfigWebApplicationContext
    BeanFactory, interface, only one implementation: XmlBeanFactory(class)
    In Spring framework, ApplicationContext represents the IoC container, that is, ioc container is the implementation
    of ApplicationContext


3. Bean scope
    singleton: each ioc container only has 1 instance, (default setting)
    prototype: everytime do DI, there will be a new bean
    request: each http request, will be a new bean, request ends, bean will be destroyed
    session: one bean for each session, session ends, bean destroyed
    application: whole app, globally one bean


4. Bean lifecycle
    @PostConstruct: method with this annotation will be scanned when bean is initialized, and perform some operations in it.
    @PreDestroy: perform customized destroy method with this annotation


5. AOP (aspect oriented programming)
    Aspect: cut across concern, things to concern, like logging, security, transaction, using @Aspect
    Advice: @Before @After @AfterReturn @AfterThrowing @Around
    JoinPoint: a point during execution of program
    Pointcut: predicate about matches join points, expression matches join points
    Target: place we want to add AOP logic


 */
    public static void main(String[] args) {

    }
}
