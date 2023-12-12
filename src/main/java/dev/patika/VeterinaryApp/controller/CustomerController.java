package dev.patika.VeterinaryApp.controller;

import dev.patika.VeterinaryApp.dto.request.CustomerRequest;
import dev.patika.VeterinaryApp.dto.response.AnimalResponse;
import dev.patika.VeterinaryApp.dto.response.CustomerResponse;
import dev.patika.VeterinaryApp.entity.Customer;
import dev.patika.VeterinaryApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id")Long id) {
        return customerService.getById(id);
    }

    //Degerlendirme formu 10
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save (@RequestBody CustomerRequest customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable Long id, @RequestBody CustomerRequest request) {
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    // Degerlendirme Formu 17
    @GetMapping("/byName")  // http://localhost:8080/api/v1/customers/byName?name=Dilber Bilgin
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findByName(@RequestParam String name) {
        return customerService.findByName(name);
    }
}
