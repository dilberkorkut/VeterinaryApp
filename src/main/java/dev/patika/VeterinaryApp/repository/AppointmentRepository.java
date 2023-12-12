package dev.patika.VeterinaryApp.repository;

import dev.patika.VeterinaryApp.entity.Animal;
import dev.patika.VeterinaryApp.entity.Appointment;
import dev.patika.VeterinaryApp.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentDate (LocalDateTime appointmentDate);

    //doctor musait oldugu gunde ve o saatte randevusu var mi? sorgusu
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);

    // girilen tarih araligina ve hayvana gore randevu arama
    List<Appointment> findByAppointmentDateBetweenAndAnimalId
    (LocalDateTime startDate, LocalDateTime endDate, Long animalId);

    // girilen tarih araligina ve doctora gore randevu arama
    List<Appointment> findByAppointmentDateBetweenAndDoctorId
    (LocalDateTime startDate, LocalDateTime endDate, Long doctorId);

}

