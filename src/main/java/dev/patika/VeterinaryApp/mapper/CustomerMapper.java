package dev.patika.VeterinaryApp.mapper;

import dev.patika.VeterinaryApp.dto.request.CustomerRequest;
import dev.patika.VeterinaryApp.dto.response.CustomerResponse;
import dev.patika.VeterinaryApp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer asEntity(CustomerRequest customerRequest); // asEntity metodu Customer Request sinifindan Customer sinifina donusumu saglar
    CustomerResponse asOutput(Customer customer); // asOutput metodu Customer sinifindan CustomerResponse sinifina donusumu saglar.
    List<CustomerResponse> asOutput(List<Customer> customerList);
    void update(@MappingTarget Customer entity, CustomerRequest request); //sadece gunceller.


}
























/*
MapStruct kutuphanesi kullanildiginda mapper ile nesne donusumleri gerceklestirilir.
Bu metotlar, DTO(Data Transfer Object) ile Entity arasindaki donusumleri saglar.
MapStruck bu metotlarin gercek implementasyonlarini otomatik olarak olusturur.
*/






