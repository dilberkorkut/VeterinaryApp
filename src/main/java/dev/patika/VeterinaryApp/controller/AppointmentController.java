package dev.patika.VeterinaryApp.controller;

import dev.patika.VeterinaryApp.dto.request.AnimalRequest;
import dev.patika.VeterinaryApp.dto.request.AppointmentRequest;
import dev.patika.VeterinaryApp.dto.response.AnimalResponse;
import dev.patika.VeterinaryApp.dto.response.AppointmentResponse;
import dev.patika.VeterinaryApp.dto.response.VaccineResponse;
import dev.patika.VeterinaryApp.entity.Appointment;
import dev.patika.VeterinaryApp.repository.AppointmentRepository;
import dev.patika.VeterinaryApp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse getById(@PathVariable("id") Long id) {
        return appointmentService.getById(id);
    }

    // Degerlendirme formu 14
    // Degerlendirme formu 22
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@RequestBody AppointmentRequest appointment) {
        return appointmentService.create(appointment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable Long id, @RequestBody AppointmentRequest request) {
        return appointmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        appointmentService.deleteById(id);
    }

    //Degerlendirme Formu 23
    @GetMapping("/animalId") // http://localhost:8080/api/v1/appointments/animalId?startDate=2023-12-06T14:00:00.336&endDate=2023-12-09T14:00:00.336&animalId=1
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findByAppointmentDateBetweenAndAnimalId(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate,
            @RequestParam("animalId") Long animalId
            ) {
        return appointmentService.findByAppointmentDateBetweenAndAnimalId(startDate, endDate, animalId);
    }

    //Degerlendirme Formu 24
    @GetMapping("/doctorId") // http://localhost:8080/api/v1/appointments/doctorId?startDate=2023-12-06T14:00:00.336&endDate=2023-12-09T14:00:00.336&doctorId=1
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findByAppointmentDateBetweenAndDoctorId(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate,
            @RequestParam("doctorId") Long doctorId
    ) {
        return appointmentService.findByAppointmentDateBetweenAndDoctorId(startDate, endDate, doctorId);
    }
}


