package com.nurani.springbootdemo.customer;

import com.nurani.springbootdemo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfig {

//    @Value(("${app.useFakeCustomerRepo:true}"))
//    private Boolean useFakeCustomerRepo;
    @Autowired
    private Environment enviroment;
    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("Command line runner");
            System.out.println(enviroment.getProperty("info.app.name"));
            System.out.println(infoApp);
        };
    }
    @Bean
    CustomerRepo customerRepo(){
//        System.out.println("useFakeCustomerRepo = "+useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }

}
