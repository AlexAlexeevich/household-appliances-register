package ru.info_system_and_services.household_appliances_register.model.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_sequence")
    @SequenceGenerator(name = "model_sequence", sequenceName = "model_sequence_name", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_appliance_id")
    private HouseholdAppliance householdAppliance;

    public Model(String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
