package com.example.YebeloAssignment.service;

import com.example.YebeloAssignment.dto.NumberRequestDto;
import com.example.YebeloAssignment.dto.NumberResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface NumberService {
    public NumberResponseDto fetchNextNumber(NumberRequestDto numberRequestDto);
}
