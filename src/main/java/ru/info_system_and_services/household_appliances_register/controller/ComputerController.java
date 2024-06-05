package ru.info_system_and_services.household_appliances_register.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.CreateComputerDto;
import ru.info_system_and_services.household_appliances_register.service.ComputerService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Computer APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/household-appliance/computer")
public class ComputerController {

    private final ComputerService computerService;

    @Operation(summary = "Получение по названию всех имеющихся в наличии компьютеров")
    @GetMapping
    public ResponseEntity<List<ComputerDto>> getAllByName(
            @RequestParam String name,
            @RequestParam String productName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal startPrice,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal endPrice,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String processorType
    ) {
        return new ResponseEntity<>(computerService.getAllByName(
                name, productName, color, startPrice, endPrice, category, processorType),
                HttpStatus.OK);
    }

    @Operation(summary = "Добавление нового компьютера")
    @PostMapping
    public ResponseEntity<ComputerDto> addNewComputer(@RequestBody CreateComputerDto createComputerDto) throws Exception {
        return new ResponseEntity<>(computerService.addNewComputer(createComputerDto), HttpStatus.CREATED);
    }
}
