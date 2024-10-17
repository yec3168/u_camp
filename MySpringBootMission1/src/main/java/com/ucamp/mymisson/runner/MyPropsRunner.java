package com.ucamp.mymisson.runner;

import com.ucamp.mymisson.config.environment.MyEnvironment;
import com.ucamp.mymisson.property.MyPropsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyPropsRunner implements ApplicationRunner {
    @Value("${myprop.username}")
    private String name;

    @Value("${myprop.port}")
    private int port;

    @Autowired
    MyPropsProperties myPropsProperties;

    @Autowired
    MyEnvironment myEnvironment;

    private Logger logger = LoggerFactory.getLogger(MyPropsRunner.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //1-4. @Value 어노테이션을 사용하여 application.properties 파일에 있는 환경변수를 Load 하여 출력하기
        System.out.println("myprop.username     :   " + name);
        System.out.println("myprop.port     :   " + port);

        System.out.println("=============================================");

        //1-5. MyPropsRunner에서 MyPropsProperties 객체를 주입(Injection) 받아서 getter 메서드를 출력하기
        System.out.println("MyPropsProperties username  :" + myPropsProperties.getUsername());
        System.out.println("MyPropsProperties port  :" + myPropsProperties.getPort());

        System.out.println("=============================================");

        //1-6. MyEnviorment 데이터 출력.
        System.out.println("MyEnvironment data      :   " + myEnvironment.toString());

        System.out.println("=============================================");

        //1-7. System.out.println() 를 logger.debug()와 logger.info() 메서드로 변경합니다.

        logger.info("logger test 시작 ");
        logger.info("=============================================");
        logger.info("myprop.username     :   {}", name);
        logger.info("myprop.port     :   {}", port);

        logger.info("=============================================");

        logger.debug("MyPropsProperties username  : {}", myPropsProperties.getUsername());
        logger.debug("MyPropsProperties port  : {}", myPropsProperties.getPort());

        logger.debug("MyEnvironment data      :   {}" , myEnvironment.toString());
    }
}
