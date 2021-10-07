package com.aus.service;

import com.aus.entity.Laptop;
import com.aus.repository.LaptopRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)

@SpringBootTest
class LaptopServiceTest {

    @InjectMocks
    LaptopService laptopService;
    @Mock
   private LaptopRepository laptopRepository;
    Laptop laptop = null;
    @BeforeEach
   public void  setUp()  {
        String path = "src\\test\\java\\com\\aus\\service\\GetByIdResponse.json";
       File file = new File(path);
       log.debug(" Umasankar File path "+file.getAbsolutePath());
        ObjectMapper objectMapper = new ObjectMapper();

        try {
             laptop = objectMapper.readValue(file,Laptop.class);
            log.debug(" Umasankar laptop.getName() "+laptop.getName());
            Mockito.when(laptopRepository.getById(1L)).thenReturn(laptop);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getById() {

        assertEquals(laptopService.getById(1L).getName(),laptop.getName());
    }

}