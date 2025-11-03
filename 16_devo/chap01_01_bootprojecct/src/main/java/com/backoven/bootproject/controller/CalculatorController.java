package com.backoven.bootproject.controller;

import com.backoven.bootproject.dto.CalculatorDTO;
import com.backoven.bootproject.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CalculatorController {
     private final CalculatorService service;

     @Autowired
    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String healthCheck() {
         return "I'm Alive!";
    }

//    @GetMapping("/plus")
//    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO){
//         log.info("calculatorDTO = {}", calculatorDTO);
//         int result = service.plusTwoNumbers(calculatorDTO);
//         calculatorDTO.setSum(result);
//
//         return ResponseEntity.ok().body(calculatorDTO);
//    }

    @PostMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(@RequestBody CalculatorDTO calculatorDTO){
        log.info("calculatorDTO = {}", calculatorDTO);
        int result = service.plusTwoNumbers(calculatorDTO);
        calculatorDTO.setSum(result);

        return ResponseEntity.ok().body(calculatorDTO);
    }
}
