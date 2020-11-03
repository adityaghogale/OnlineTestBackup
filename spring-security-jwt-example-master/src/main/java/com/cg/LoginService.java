package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Aditya Ghogale
 *
 */

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class LoginService {
    /*@Autowired
    private UserRepository repository;

    //will get call as soon as application starts and insert data in database
    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "adi", "adi", "adi@gmail.com",0,true),
                new User(102, "luffy", "luffy", "luffy@gmail.com",111,false),
                new User(103, "sanji", "sanji", "sanji@gmail.com",111,false),
                new User(104, "zoro", "zoro", "zoro@gmail.com",222,false)
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(LoginService.class, args);
    }
    
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                   .select()
                   .paths(PathSelectors.any())
                   .apis(RequestHandlerSelectors.basePackage("com.cg"))
                   .build()
                   .apiInfo(myApiInfo());
    }
	private ApiInfo myApiInfo() {
        // for version 2.9.1
        ApiInfo apiInfo=new ApiInfo(
                "SPRING WITH SWAGGER API",
                 "API CREATION",
                 "1.0",
                 "Free to Use",
                 new Contact("Aditya-san","/testapp" ,"reaper@nomail.com"),
                 "API licence",
                 "/testapp",
                 java.util.Collections.emptyList());
        return apiInfo;  
     }

}
