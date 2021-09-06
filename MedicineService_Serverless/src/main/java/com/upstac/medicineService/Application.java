package com.upstac.medicineService;

import com.upstac.medicineService.controller.PingController;
import com.upstac.medicineService.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;


@SpringBootApplication
@Import({ PingController.class })
public class Application {

    @Autowired
    MedicineRepo medicineRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init(){
        medicineRepo.populateMedicines();
    }
}