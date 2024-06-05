package ru.info_system_and_services.household_appliances_register.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import ru.info_system_and_services.household_appliances_register.model.entity.base.Model;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "householdAppliance")
public class HouseholdAppliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @Enumerated(EnumType.STRING)
    private ProductName productName;

    @Column(name = "country")
    private String country;

    @Column(name = "company")
    private String company;

    @Column(name = "is_order_online")
    private Boolean isOrderOnline;

    @Column(name = "is_possible_installments")
    private Boolean isPossibleInstallments;

    @OneToMany(mappedBy = "householdAppliance", cascade = CascadeType.ALL, orphanRemoval = true)
    @SQLRestriction("is_available = true")
    @JsonIgnoreProperties("householdAppliance")
    private Set<Model> models;
}
