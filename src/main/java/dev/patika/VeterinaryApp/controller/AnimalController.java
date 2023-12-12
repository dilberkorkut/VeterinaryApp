package dev.patika.VeterinaryApp.controller;

import dev.patika.VeterinaryApp.dto.request.AnimalRequest;
import dev.patika.VeterinaryApp.dto.response.AnimalResponse;
import dev.patika.VeterinaryApp.dto.response.CustomerResponse;
import dev.patika.VeterinaryApp.service.AnimalService;
import dev.patika.VeterinaryApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse getById(@PathVariable("id") Long id) {
        return animalService.getById(id);
    }

    // Degerlendirme formu 11
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse save(@RequestBody AnimalRequest animal) {
        return animalService.create(animal);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@PathVariable Long id, @RequestBody AnimalRequest request) {
        return animalService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        animalService.deleteById(id);
    }

    // Degerlendirme Formu 16
    @GetMapping("/byName") // http://localhost:8080/api/v1/animals/byName?name=Diren
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByName(@RequestParam String name) {
        return animalService.findByName(name);
    }

    // Degerlendirme Formu 18
    @GetMapping("/byCustomerName")  // http://localhost:8080/api/v1/animals/byCustomerName?customerName=Dilber Bilgin
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByCustomerName(@RequestParam String customerName) {
        return animalService.findByCustomerName(customerName);
    }

}
