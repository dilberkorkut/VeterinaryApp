package dev.patika.VeterinaryApp.service;

import dev.patika.VeterinaryApp.dto.request.AvailableDateRequest;
import dev.patika.VeterinaryApp.dto.request.CustomerRequest;
import dev.patika.VeterinaryApp.dto.response.AvailableDateResponse;
import dev.patika.VeterinaryApp.dto.response.CustomerResponse;
import dev.patika.VeterinaryApp.entity.AvailableDate;
import dev.patika.VeterinaryApp.entity.Customer;
import dev.patika.VeterinaryApp.mapper.AvailableDateMapper;
import dev.patika.VeterinaryApp.repository.AvailableDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailableDateService {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;


    public List<AvailableDateResponse> findAll() {
        return availableDateMapper.asOutput((availableDateRepository.findAll()));
    }

    public AvailableDateResponse getById(Long id) {
        return availableDateMapper.asOutput(availableDateRepository.findById(id).orElseThrow(() ->
                new RuntimeException("The available date with ID " + id + " could not be found!")));
    } //belirtilen ID'ye sahip veriyi veritabanindan bul,bulamazsa exception  firlat
      //bulunan tarihi AvailableResponse tipine donustur(availableDateMapper ile) ve geri dondur.


    public AvailableDateResponse create (AvailableDateRequest request) {
        Optional<AvailableDate> isAvailableDateExist = availableDateRepository.findByAvailableDate(request.getAvailableDate());
        if (isAvailableDateExist.isEmpty()) {
            AvailableDate availableDateSaved = availableDateRepository.save(availableDateMapper.asEntity(request));
            return availableDateMapper.asOutput(availableDateSaved);
        }
        throw new RuntimeException("The date is not available!");
    }

    public AvailableDateResponse update(Long id, AvailableDateRequest request) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepository.findById(id);
        Optional<AvailableDate> isAvailableDateExist = availableDateRepository.findByAvailableDate(request.getAvailableDate());

        if (availableDateFromDb.isEmpty()) {
            throw new RuntimeException("The date with the ID " + id + " that you are trying to update could not be found in the system!");
        }
        if (isAvailableDateExist.isPresent()) {
            throw new RuntimeException("This date has already been registered in the system!");
        }
        AvailableDate availableDate = availableDateFromDb.get();
        availableDateMapper.update(availableDate, request);
        return availableDateMapper.asOutput((availableDateRepository.save(availableDate)));
    }

    public void deleteById(Long id) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepository.findById(id);
        if (availableDateFromDb.isPresent()) {
            availableDateRepository.delete(availableDateFromDb.get());
        } else {
            throw new RuntimeException("The date with the ID " + id + " could not be found in the system!");
        }
        /*deleteById ile belirli bir id'ye sahip nesne veri tabanindan silinir.
         ozel bir donusume ihtiyac duyulmadigi icin mapper sinifi kullanilmadi. */
    }


    // belirli bir doktorun belirtilen gün ve saat için uygun olup olmadığının kontrolleri yapılır.
    public boolean isDoctorAvailable(Long doctorId, LocalDateTime dateTime) {
        List<AvailableDate> availableDateList = availableDateRepository
        .findByDoctorIdAndAvailableDate(doctorId, dateTime.toLocalDate());
        return !availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId,
                dateTime.toLocalDate());
    }

    public List<AvailableDateResponse> findByDoctorId(Long doctorId) {
        return availableDateMapper.asOutput(availableDateRepository.findByDoctorId(doctorId));
    }
}




