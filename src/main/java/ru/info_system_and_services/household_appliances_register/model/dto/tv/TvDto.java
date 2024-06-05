package ru.info_system_and_services.household_appliances_register.model.dto.tv;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.dto.base.ModelDto;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TvDto extends ModelDto {

    @Schema(description = "Категория")
    private String category;

    @Schema(description = "Технология")
    private String technology;

    public TvDto(Long id, ProductName productName, String country, String company, Boolean isOrderOnline, Boolean isPossibleInstallments, String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable, String category, String technology) {
        super(id, productName, country, company, isOrderOnline, isPossibleInstallments, name, serialNumber, color, size, price, isAvailable);
        this.category = category;
        this.technology = technology;
    }
}
