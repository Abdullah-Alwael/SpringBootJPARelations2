package com.spring.boot.springbootjparelations2.Controller;

import com.spring.boot.springbootjparelations2.Api.ApiResponse;
import com.spring.boot.springbootjparelations2.DTO.AddressDTO;
import com.spring.boot.springbootjparelations2.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address added successfully"));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddresses());

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address updated successfully"));

    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer addressId){
        addressService.deleteAddress(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address deleted successfully"));

    }
}
