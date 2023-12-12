package dev.patika.VeterinaryApp.service;

import dev.patika.VeterinaryApp.dto.request.AppointmentRequest;
import dev.patika.VeterinaryApp.dto.response.AnimalResponse;
import dev.patika.VeterinaryApp.dto.response.AppointmentResponse;
import dev.patika.VeterinaryApp.dto.response.AvailableDateResponse;
import dev.patika.VeterinaryApp.entity.Appointment;
import dev.patika.VeterinaryApp.entity.AvailableDate;
import dev.patika.VeterinaryApp.mapper.AppointmentMapper;
import dev.patika.VeterinaryApp.mapper.AvailableDateMapper;
import dev.patika.VeterinaryApp.repository.AppointmentRepository;
import dev.patika.VeterinaryApp.repository.AvailableDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    public List<AppointmentResponse> findAll() {
        return appointmentMapper.asOutput((appointmentRepository.findAll()));
    }

    public AppointmentResponse getById(Long id) {
        return appointmentMapper.asOutput(appointmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("The appointment with ID " + id + " could not be found!")));
    }

    // Degerlendirme formu 14 - 22
    public AppointmentResponse create(AppointmentRequest request) {
        LocalDateTime dateTime = request.getAppointmentDate();
        Long doctorId = request.getDoctor().getId();

        //belirli bir doktorun belirtilen gun ve saat icin uygun olup olmadiginin kontrolleri yapilir.
        if (availableDateService.isDoctorAvailable(doctorId,dateTime)) {
            throw new RuntimeException("The doctor is not available for today. Please choose a new date.");
        }
        if (isAppointmentDateExistOnDate(doctorId,dateTime)) {
            throw new RuntimeException("There is another appointment at the entered time.");
        } else { // randevu olusturulur.
            Appointment appointmentSaved = appointmentRepository.save(appointmentMapper.asEntity(request));
            return appointmentMapper.asOutput(appointmentSaved);
        }
    }

    //belirli bir doktorun belirtilen tarihte ve saatte baska bir randevusu olup olmadigi kontrolu
    private boolean isAppointmentDateExistOnDate (Long doctorId, LocalDateTime appointmentDate) {
        return appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId,appointmentDate);
    }

    public AppointmentResponse update(Long id, AppointmentRequest request) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        Optional<Appointment> isAppointmentExist = appointmentRepository.findByAppointmentDate(request.getAppointmentDate());

        if (appointmentFromDb.isEmpty()) {
            throw new RuntimeException("The appointment with ID " + id + " could not be found for the update!");
        }
        if (isAppointmentExist.isPresent()) {
            throw new RuntimeException("An appointment has already been scheduled for this date!");
        }
        Appointment appointment = appointmentFromDb.get();
        appointmentMapper.update(appointment, request);
        return appointmentMapper.asOutput((appointmentRepository.save(appointment)));
    }

    public void deleteById(Long id) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        if (appointmentFromDb.isPresent()) {
            appointmentRepository.delete(appointmentFromDb.get());
        } else {
            throw new RuntimeException("The appointment with ID " + id + " could not be found in the system!");
        }
    }

    public List<AppointmentResponse> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId) {
        return appointmentMapper.asOutput(appointmentRepository.findByAppointmentDateBetweenAndAnimalId(startDate,endDate, animalId));
    }

    public List<AppointmentResponse> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId) {
        return appointmentMapper.asOutput(appointmentRepository.findByAppointmentDateBetweenAndDoctorId(startDate,endDate, doctorId));
    }
}






