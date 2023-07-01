package com.example.YebeloAssignment.controller;

import com.example.YebeloAssignment.dto.NumberRequestDto;
import com.example.YebeloAssignment.dto.NumberResponseDto;
import com.example.YebeloAssignment.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FetchNextNumber")
public class FetchNumberController {

    @Autowired
    NumberService numberService;
    @PostMapping
    public ResponseEntity fetchNextNumber(@RequestBody NumberRequestDto numberRequestDto)  {
        NumberResponseDto numberResponseDto = numberService.fetchNextNumber(numberRequestDto);
        return new ResponseEntity(numberResponseDto, HttpStatus.CREATED);
    }
}
