package dev.patika.VeterinaryApp.service;

import dev.patika.VeterinaryApp.dto.request.AnimalRequest;
import dev.patika.VeterinaryApp.dto.response.AnimalResponse;
import dev.patika.VeterinaryApp.dto.response.VaccineResponse;
import dev.patika.VeterinaryApp.entity.Animal;
import dev.patika.VeterinaryApp.mapper.AnimalMapper;
import dev.patika.VeterinaryApp.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public List<AnimalResponse> findAll() {
        return animalMapper.asOutput(animalRepository.findAll());
    }

    public AnimalResponse getById(Long id) {
        return animalMapper.asOutput(animalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Animal with id " + id + " not found!")));
    }

    public AnimalResponse create (AnimalRequest request) {
        Optional<Animal> isAnimalExist = animalRepository.findByNameAndSpeciesAndBreed(
                request.getName(), request.getSpecies(), request.getBreed());

        if(isAnimalExist.isEmpty()) {
            Animal animalSaved = animalRepository.save(animalMapper.asEntity(request));
            return animalMapper.asOutput(animalSaved);
        }
        throw new RuntimeException("This animal has already been registered in the system!");
    }

    public AnimalResponse update(Long id, AnimalRequest request) {
        Optional<Animal> animalFromDb = animalRepository.findById(id); //veritabanindan guncellenmek istenen hayvani id ile arama.
        // Yeni bilgilerle ayni customer, name, tur, irk.. sahip baska hayvan var mi kontrolu
        Optional<Animal> isAnimalExist = animalRepository.findByCustomerIdAndNameAndSpeciesAndBreed(request.getCustomer().getId(), request.getName(), request.getSpecies(), request.getBreed());
        if (animalFromDb.isEmpty()) {
            throw new RuntimeException("The animal with the ID " + id + " that you are trying to update could not be found in the system!");
        }
        if (isAnimalExist.isPresent() && !isAnimalExist.get().getId().equals(id))  {
            throw new RuntimeException("This animal has already been registered in the system.");
        }
        Animal animal = animalFromDb.get();
        animalMapper.update(animal, request);
        return animalMapper.asOutput((animalRepository.save(animal)));
    }

    public void deleteById(Long id) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if(animalFromDb.isPresent()) {
            animalRepository.delete(animalFromDb.get());
        } else {
            throw new RuntimeException("The animal with the ID " + id + " could not be found in the system!");
        }
    }

    public List<AnimalResponse> findByName(String name) {
        return animalMapper.asOutput(animalRepository.findByName(name));
    }

    public List<AnimalResponse> findByCustomerName(String customerName) {
        return animalMapper.asOutput(animalRepository.findByCustomerName(customerName));
    }

    public List<AnimalResponse> findByCustomerId(Long customerId) {
        return animalMapper.asOutput(animalRepository.findByCustomerId(customerId));
    }

}
