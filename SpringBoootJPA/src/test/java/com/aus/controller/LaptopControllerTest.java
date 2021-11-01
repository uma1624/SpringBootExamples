package com.aus.controller;

import com.aus.entity.Brand;
import com.aus.entity.Laptop;
import com.aus.service.LaptopService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest
class LaptopControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    LaptopService laptopService;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void save() throws Exception {
        Laptop laptop = new Laptop();
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setBrandname("uma");
        laptop.setId(1L);
        laptop.setName("laptop");
        laptop.setBrand(brand);
        Mockito.when(laptopService.save(ArgumentMatchers.any())).thenReturn(laptop);
        String json = mapper.writeValueAsString(laptop);
        mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("laptop")));
    }

    @Test
    void getByid() throws Exception {
        Laptop laptop = new Laptop();
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setBrandname("uma");
        laptop.setId(1L);
        laptop.setName("laptop");
        laptop.setBrand(brand);
        Mockito.when(laptopService.getById(1L)).thenReturn(laptop);
        mockMvc.perform(get("/getByid/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo("laptop")));
    }
}