package com.upstac.medicineService.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MedicineRepo {

    public static HashMap<String, String> medicineInventory = new HashMap<>();

    private static final String  NOT_AVAILABLE = "NOT_AVAILABLE";

    public String getMedicine(String code){
        if(medicineInventory.containsKey(code)){
            return medicineInventory.get(code);
        }else{
            return NOT_AVAILABLE;
        }
    }

    public String addMedicine(String code, String medicines){
        medicineInventory.put(code, medicines);
        return medicines;
    }

    public void populateMedicines(){
        medicineInventory.put("HBS001", "CAP A 100 MG, SYRUP B");
        medicineInventory.put("HBP001", "TAB Z 2.5MG");
        medicineInventory.put("CCF001", "CALPOL 500MG");
    }
}
