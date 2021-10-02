package com.aus.controller;

import com.aus.entity.Laptop;
import com.aus.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to SpringBoot";
    }
   @PostMapping("/save")
   public ResponseEntity<Laptop> save(@RequestBody  Laptop laptop){
        Laptop laptop1 = laptopService.save(laptop);
        return new ResponseEntity<Laptop> (laptop1,HttpStatus.CREATED);
    }
@GetMapping("/getByid/{id}")
    public ResponseEntity<Laptop> getByid(@PathVariable  Long id){
       return new ResponseEntity<>(laptopService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Laptop> update(@PathVariable  Long id,@RequestBody  Laptop laptop){
        Laptop laptop1 = laptopService.updatebyId(id,laptop);
        return new ResponseEntity<Laptop> (laptop1,HttpStatus.CREATED);
    }
    @DeleteMapping(produces = "application/json", consumes = "application/json", path = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        laptopService.deleteByid(id);
        return new ResponseEntity<>("Laptop : " + id + " deleted successfully", HttpStatus.OK);
    }

}
