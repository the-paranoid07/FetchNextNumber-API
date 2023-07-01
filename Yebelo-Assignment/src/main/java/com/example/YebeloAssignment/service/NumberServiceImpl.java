package com.example.YebeloAssignment.service;

import com.example.YebeloAssignment.dto.NumberRequestDto;
import com.example.YebeloAssignment.dto.NumberResponseDto;
import com.example.YebeloAssignment.model.NumberEntity;
import com.example.YebeloAssignment.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService{
    @Autowired
    NumberRepository numberRepository;
    @Override
    public NumberResponseDto fetchNextNumber(NumberRequestDto numberRequestDto) {

        String categoryCode=numberRequestDto.getCategoryCode();

        NumberEntity number = numberRepository.findByCategoryCode(categoryCode);
        int currentValue = (number != null) ? number.getValue() : 0;
        int nextValue = calculateNextNumber(currentValue);
        saveOrUpdateNumber(categoryCode, nextValue);
        NumberResponseDto numberResponseDto=new NumberResponseDto();
        numberResponseDto.setOldValue(currentValue);
        numberResponseDto.setNewValue(nextValue);
        return numberResponseDto;
    }

    private int calculateNextNumber(int currentValue) {
        int nextValue = currentValue + 1;
        while (sumOfDigits(nextValue) != 1) {
            nextValue++;
        }
        return nextValue;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private void saveOrUpdateNumber(String categoryCode, int value) {
        NumberEntity number = numberRepository.findByCategoryCode(categoryCode);
        if (number == null) {
            number = new NumberEntity();
            number.setCategoryCode(categoryCode);
        }
        number.setValue(value);
        numberRepository.save(number);
    }
}
