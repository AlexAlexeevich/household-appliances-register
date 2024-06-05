package ru.info_system_and_services.household_appliances_register.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
import ru.info_system_and_services.household_appliances_register.model.dto.tv.CreateTvDto;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto;
import ru.info_system_and_services.household_appliances_register.service.TvService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Tv APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/household-appliance/tv")
public class TvController {

    private final TvService tvService;

    @Operation(summary = "Получение по названию всех имеющихся в наличии телевизоров")
    @GetMapping
    public ResponseEntity<List<TvDto>> getAllByName(
            @RequestParam String name,
            @RequestParam String productName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal startPrice,
            @RequestParam(required = false) @NumberFormat(pattern = "#0,00") BigDecimal endPrice,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String technology
    ) {
        return new ResponseEntity<>(
                tvService.getAllByName(name, productName, color, startPrice, endPrice, category, technology),
                HttpStatus.OK);
    }

    @Operation(summary = "Добавление нового телевизора")
    @PostMapping
    public ResponseEntity<TvDto> addNewTv(@RequestBody CreateTvDto createTvDto) throws Exception {
        return new ResponseEntity<>(tvService.addNewTv(createTvDto), HttpStatus.CREATED);
    }
}
