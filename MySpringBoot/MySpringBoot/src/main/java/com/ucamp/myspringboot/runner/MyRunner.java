package com.ucamp.myspringboot.runner;

import com.ucamp.myspringboot.config.vo.CustomVO;
import com.ucamp.myspringboot.property.MyBootProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// springbean으로 설정
@Component
/**
 * Runner가 여러 개일 때, 우선순위를 정해주는 어노테이션.
 * 순서가 적을수록 우선순위가 높음
 */
@Order(1)                        //@FunctionalInterface
public class MyRunner implements ApplicationRunner {

    @Value("${myboot.name}")
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Autowired
    MyBootProperties myBootProperties;

    @Autowired
    CustomVO customVO;

    private Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    // ApplicationArguments에는 Main메소드안에 있는 String []args에 값들이 들어있다.
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("VM arguments    :   " + args.containsOption("foo")); // false  : vm argument라서 getOptionsName에 들어 있지 않아서 false가 나옴.
        System.out.println("program arguments   :   "+  args.containsOption("bar")); // true
        System.out.println("program arguments(server.port)   :   "+  args.containsOption("server.port") + "\n"); // true

        args.getOptionNames().forEach(System.out::println);
        System.out.println();

        if(args.containsOption("server.port")){
            System.out.println("server.port = " + args.getOptionValues("server.port"));
        }

        //=============================================================================================


        System.out.println("myboot.name : " +name);
        System.out.println("myboot.age : " +age);


        //==============================================================================================


        System.out.println("property age : "  + myBootProperties.getAge());
        System.out.println("property fullname : "  + myBootProperties.getFullName());

        //==============================================================================================


        System.out.println("CustomVO : " + customVO.toString());


        //==============================================================================================


        logger.debug("------------------------");
        logger.info("logger 구현채 클래스명 = {}", logger.getClass().getName());
        logger.debug(myBootProperties.getName());
        logger.info("myboot.name : {}", name);
        logger.info("myboot.age : {} ", age);
        logger.info("property age : {}"  , myBootProperties.getAge());
        logger.info("property fullname : {}"  , myBootProperties.getFullName());
        logger.info("CustomVO : {}",  customVO.toString());

        logger.debug("VM arguments    :  {}" , args.containsOption("foo")); // false  : vm argument라서 getOptionsName에 들어 있지 않아서 false가 나옴.
        logger.debug("program arguments   :   {}" ,  args.containsOption("bar")); // true
        logger.debug("program arguments(server.port)   :   {}x",  args.containsOption("server.port") + "\n"); // true

        args.getOptionNames().forEach(System.out::println);
        System.out.println();

        if(args.containsOption("server.port")){
            System.out.println("server.port = " + args.getOptionValues("server.port"));
        }

    }


    /**
     *  -실행버튼 왼쪽에 MySpringBootApplication에서 edit Configuration을 클릭하여 program argurments와 ADD vm argument 을 클릭하여 값을 추가.
     *  -bar --server.port=8088 을 program argurmnet에 추가하고
     *  -Dfoo 를 vm argument에 추가한다.
     *
     *   1. program arguemnt에 값을 넣은 상태로 시작하면 application.prorperty에 설정된 port보다 우선순위가 높아 8088로 바뀌게 된다.
     *
     *
     *   2. VM argument에는 server port를 넣고 싶다면  -Dfoo -Dserver.port =8085 식으로 값을 넣는다.
     *    - 마찬가지로 application.prorperty보다 우선순위가 높아 tomcat의 port가 8085로 바뀐다.
     */
}
