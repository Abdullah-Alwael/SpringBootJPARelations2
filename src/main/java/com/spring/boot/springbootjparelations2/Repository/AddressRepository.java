package com.spring.boot.springbootjparelations2.Repository;

import com.spring.boot.springbootjparelations2.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
