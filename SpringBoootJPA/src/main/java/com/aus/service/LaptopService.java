package com.aus.service;

import com.aus.entity.Laptop;
import com.aus.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public  Laptop save(Laptop laptop){
     return laptopRepository.save(laptop);
    }
    public  Laptop getById(Long id){
        return laptopRepository.getById(id);
    }
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    public  Laptop updatebyId(Long id,Laptop update){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        laptop.get().getBrand().setBrandname(update.getBrand().getBrandname());
       return laptopRepository.save(laptop.get());
    }


    public void deleteByid(Long id) {
         laptopRepository.deleteById(id);
    }
}
