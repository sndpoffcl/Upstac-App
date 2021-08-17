package com.upstac.medicineService.controller;

import com.upstac.medicineService.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicineController {

    @Autowired
    MedicineRepo medicineRepo;

    @GetMapping("/{code}")
    public ResponseEntity getMedicineList(@PathVariable("code") String code){
        String medicine = medicineRepo.getMedicine(code);
        return ResponseEntity.ok(medicine);
    }
}
