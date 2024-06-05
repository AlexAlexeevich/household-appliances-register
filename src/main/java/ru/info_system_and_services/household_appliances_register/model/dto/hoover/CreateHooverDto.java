package ru.info_system_and_services.household_appliances_register.model.dto.hoover;

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
public class CreateHooverDto extends ModelDto {

    @Schema(description = "Объем пылесборника")
    private String dustCollectorVolume;

    @Schema(description = "Количество режимов")
    private String modeQuantity;

    public CreateHooverDto(ProductName productName, String country, String company, Boolean isOrderOnline, Boolean isPossibleInstallments, String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable, String dustCollectorVolume, String modeQuantity) {
        super(productName, country, company, isOrderOnline, isPossibleInstallments, name, serialNumber, color, size, price, isAvailable);
        this.dustCollectorVolume = dustCollectorVolume;
        this.modeQuantity = modeQuantity;
    }
}
