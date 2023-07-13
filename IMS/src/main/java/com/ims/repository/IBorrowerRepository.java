package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.Borrower;

public interface IBorrowerRepository extends JpaRepository<Borrower, Long> {

}
