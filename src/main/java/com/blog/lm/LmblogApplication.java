package com.blog.lm;



import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.core.env.Environment;
import org.springframework.jmx.support.RegistrationPolicy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableSwagger2
public class LmblogApplication {

    public static void main(String[] args)throws UnknownHostException {

        ConfigurableApplicationContext run = SpringApplication.run(LmblogApplication.class, args);
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port  + "/\n\t" +
                "External: \thttp://" + ip + ":" + port  + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port  + "/swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
