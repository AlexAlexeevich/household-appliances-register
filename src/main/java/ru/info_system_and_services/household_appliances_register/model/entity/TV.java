package ru.info_system_and_services.household_appliances_register.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.entity.base.Model;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tv")
public class TV extends Model {

    @Column(name = "category")
    private String category;

    @Column(name = "technology")
    private String technology;

    public TV(String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable,
              String category, String technology) {
        super(name, serialNumber, color, size, price, isAvailable);
        this.category = category;
        this.technology = technology;
    }
}
