package ru.aryukov.telegrambot.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CITYES")
@SequenceGenerator(name="city_id_gen",initialValue = 10, allocationSize = 100)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_gen")
    @Column(name = "city_id")
    private Long id;

    @Column
    @NotNull
    @Size(min = 3,max = 15,message = "City name must be min = 3 and max = 15")
    private String name;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "city")
    private Set<Advice> advices = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId().equals(city.getId()) &&
                getName().equals(city.getName()) &&
                getAdvices().equals(city.getAdvices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
