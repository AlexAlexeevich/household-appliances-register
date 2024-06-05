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
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.CreateHooverDto;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto;
import ru.info_system_and_services.household_appliances_register.service.HooverService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Hoover APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/household-appliance/hoover")
public class HooverController {

    private final HooverService hooverService;

    @Operation(summary = "Получение по названию всех имеющихся в наличии пылесосов")
    @GetMapping
    public ResponseEntity<List<HooverDto>> getAllByName(
            @RequestParam String name,
            @RequestParam String productName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal startPrice,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal endPrice,
            @RequestParam(required = false) String dustCollectorVolume,
            @RequestParam(required = false) String modeQuantity
    ) {
        return new ResponseEntity<>(
                hooverService.getAllByName(
                        name, productName, color, startPrice, endPrice, dustCollectorVolume, modeQuantity),
                HttpStatus.OK);
    }

    @Operation(summary = "Добавление нового пылесоса")
    @PostMapping
    public ResponseEntity<HooverDto> addNewHoover(@RequestBody CreateHooverDto createHooverDto) throws Exception {
        return new ResponseEntity<>(hooverService.addNewHoover(createHooverDto), HttpStatus.CREATED);
    }
}
