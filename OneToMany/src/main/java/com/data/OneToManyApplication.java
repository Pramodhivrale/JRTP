package com.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.AddressClass;
import com.entity.EmpEntity;
import com.repo.EmpDataRepo;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.repo")
@EntityScan(basePackages = "com.entity")
public class OneToManyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToManyApplication.class, args);

        AddressClass a = new AddressClass();
        a.setCityName("Nanded");
        a.setStateName("Maha");

        AddressClass a1 = new AddressClass();
        a1.setCityName("Basar");
        a1.setStateName("MP");

        EmpEntity e = new EmpEntity();
        e.setEmpName("Pramod");
        e.setEmpDept("Java");

        // Set the employee for each address
//        a.setEmployee(e);
//        a1.setEmployee(e);

        // Add addresses to employee
        List<AddressClass> asList = Arrays.asList(a, a1);
        e.setAddresses(asList);

        EmpDataRepo bean = context.getBean(EmpDataRepo.class);
        bean.save(e);

        System.out.println("Data inserted");
    }
}
