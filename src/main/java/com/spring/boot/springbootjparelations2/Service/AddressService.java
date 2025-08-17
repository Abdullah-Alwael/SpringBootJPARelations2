package com.spring.boot.springbootjparelations2.Service;

import com.spring.boot.springbootjparelations2.Api.ApiException;
import com.spring.boot.springbootjparelations2.DTO.AddressDTO;
import com.spring.boot.springbootjparelations2.Model.Address;
import com.spring.boot.springbootjparelations2.Model.Teacher;
import com.spring.boot.springbootjparelations2.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherService teacherService;

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherService.getTeacher(addressDTO.getTeacherId());

        if (teacher == null){
            throw new ApiException("Error, teacher does not exist");
        }

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet()
                , addressDTO.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddress(Integer addressId){
        return addressRepository.findAddressById(addressId);
    }

    public void updateAddress(AddressDTO address){
        Address oldAddress = addressRepository.findAddressById(address.getTeacherId());

        if (oldAddress == null){
            throw new ApiException("Error, address not found");
        }

        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(address.getBuildingNumber());

        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer addressId){
        Address oldAddress = addressRepository.findAddressById(addressId);

        if (oldAddress == null){
            throw new ApiException("Error, address not found");
        }

        Teacher teacher = oldAddress.getTeacher();

        if (teacher == null){
            throw new ApiException("Error, teacher not found");
        }

        teacher.setAddress(null);

        addressRepository.delete(oldAddress);
    }
}
