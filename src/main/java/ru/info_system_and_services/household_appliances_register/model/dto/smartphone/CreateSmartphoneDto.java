package ru.info_system_and_services.household_appliances_register.model.dto.smartphone;

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
public class CreateSmartphoneDto extends ModelDto {

    @Schema(description = "Память")
    private String memory;

    @Schema(description = "Количество камер")
    private String cameraQuantity;

    public CreateSmartphoneDto(ProductName productName, String country, String company, Boolean isOrderOnline, Boolean isPossibleInstallments, String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable, String memory, String cameraQuantity) {
        super(productName, country, company, isOrderOnline, isPossibleInstallments, name, serialNumber, color, size, price, isAvailable);
        this.memory = memory;
        this.cameraQuantity = cameraQuantity;
    }
}
