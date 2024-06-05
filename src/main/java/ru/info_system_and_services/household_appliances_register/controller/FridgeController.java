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
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.CreateFridgeDto;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto;
import ru.info_system_and_services.household_appliances_register.service.FridgeService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Fridge APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/household-appliance/fridge")
public class FridgeController {

    private final FridgeService fridgeService;

    @Operation(summary = "Получение по названию всех имеющихся в наличии холодильников")
    @GetMapping
    public ResponseEntity<List<FridgeDto>> getAllByName(
            @RequestParam String name,
            @RequestParam String productName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal startPrice,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal endPrice,
            @RequestParam(required = false) String doorFridgeQuantity,
            @RequestParam(required = false) String compressorType
    ) {
        return new ResponseEntity<>(fridgeService.getAllByName(
                name, productName, color, startPrice, endPrice, doorFridgeQuantity, compressorType),
                HttpStatus.OK);
    }

    @Operation(summary = "Добавление нового холодильника")
    @PostMapping
    public ResponseEntity<FridgeDto> addNewFridge(@RequestBody CreateFridgeDto createFridgeDto) throws Exception {
        return new ResponseEntity<>(fridgeService.addNewFridge(createFridgeDto), HttpStatus.CREATED);
    }
}
