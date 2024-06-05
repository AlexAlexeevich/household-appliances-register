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
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.CreateSmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto;
import ru.info_system_and_services.household_appliances_register.service.SmartphoneService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Smartphone APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/household-appliance/smartphone")
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    @Operation(summary = "Получение по названию всех имеющихся в наличии смартфонов")
    @GetMapping
    public ResponseEntity<List<SmartphoneDto>> getAllByName(
            @RequestParam String name,
            @RequestParam String productName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal startPrice,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal endPrice,
            @RequestParam(required = false) String memory,
            @RequestParam(required = false) String cameraQuantity
    ) {
        return new ResponseEntity<>(
                smartphoneService.getAllByName(name, productName, color, startPrice, endPrice, memory, cameraQuantity),
                HttpStatus.OK);
    }

    @Operation(summary = "Добавление нового смартфона")
    @PostMapping
    public ResponseEntity<SmartphoneDto> addNewSmartphone(@RequestBody CreateSmartphoneDto createSmartphoneDto) throws Exception {
        return new ResponseEntity<>(smartphoneService.addNewSmartphone(createSmartphoneDto), HttpStatus.CREATED);
    }
}
