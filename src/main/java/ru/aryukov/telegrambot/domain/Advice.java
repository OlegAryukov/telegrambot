package ru.aryukov.telegrambot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ADVICES")
@SequenceGenerator(name="advice_id_gen",initialValue = 10, allocationSize = 100)
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advice_id_gen")
    private Long id;

    @Column
    @NotNull
    @Size(min = 10, max = 30, message = "Advice must be min 10 and max 50 characters")
    private String content;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    private City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advice)) return false;
        Advice advice = (Advice) o;
        return Objects.equals(getId(), advice.getId()) &&
                Objects.equals(getContent(), advice.getContent()) &&
                Objects.equals(getCity(), advice.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getCity());
    }
}
