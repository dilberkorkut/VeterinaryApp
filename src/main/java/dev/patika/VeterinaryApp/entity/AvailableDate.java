package dev.patika.VeterinaryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "available_dates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "available_date")
    private LocalDate availableDate;

    @ManyToOne (fetch = FetchType.EAGER) //LAZY kullaninca veriler yuklenmedi!
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    // iliskili veriler; EAGER ile her seferinde, LAZY ile ihtiyac duyuldugu anda yukleniyor.

}
