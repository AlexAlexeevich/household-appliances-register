package ru.info_system_and_services.household_appliances_register.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.model.entity.base.Model;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
//@Builder
public class HouseholdApplianceDto {

    private Long id;

    private ProductName productName;

    private String country;

    private String company;

    private Boolean isOrderOnline;

    private Boolean isPossibleInstallments;

    private Set<Model> models;

    public HouseholdApplianceDto(Long id, ProductName productName, String country, String company, Boolean isOrderOnline, Boolean isPossibleInstallments, Set<Model> models) {
        this.id = id;
        this.productName = productName;
        this.country = country;
        this.company = company;
        this.isOrderOnline = isOrderOnline;
        this.isPossibleInstallments = isPossibleInstallments;
        this.models = models;
    }
}
