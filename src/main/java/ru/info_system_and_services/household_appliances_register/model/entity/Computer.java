package ru.info_system_and_services.household_appliances_register.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.entity.base.Model;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "computer")
public class Computer extends Model {

    @Column(name = "category")
    private String category;

    @Column(name = "processor_type")
    private String processorType;

    public Computer(String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable,
                    String category, String processorType) {
        super(name, serialNumber, color, size, price, isAvailable);
        this.category = category;
        this.processorType = processorType;
    }
}
