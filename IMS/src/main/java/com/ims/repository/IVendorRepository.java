package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.model.Vendor;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long> {

}
