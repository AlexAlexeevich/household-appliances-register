package ru.info_system_and_services.household_appliances_register.model.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDto {

    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Вид продукта")
    private ProductName productName;

    @Schema(description = "Страна")
    private String country;

    @Schema(description = "Компания")
    private String company;

    @Schema(description = "Возможность заказа онлайн")
    private Boolean isOrderOnline;

    @Schema(description = "Возможность оформления рассрочки")
    private Boolean isPossibleInstallments;

    @Schema(description = "Наименование")
    private String name;

    @Schema(description = "Серийный номер")
    private String serialNumber;

    @Schema(description = "Цвет")
    private String color;

    @Schema(description = "Размер")
    private String size;

    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    private Boolean isAvailable;

    public ModelDto(ProductName productName, String country, String company, Boolean isOrderOnline,
                    Boolean isPossibleInstallments, String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable) {
        this.productName = productName;
        this.country = country;
        this.company = company;
        this.isOrderOnline = isOrderOnline;
        this.isPossibleInstallments = isPossibleInstallments;
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
