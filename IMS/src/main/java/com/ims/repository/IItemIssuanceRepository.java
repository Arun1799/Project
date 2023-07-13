package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.Loan;

public interface IItemIssuanceRepository extends JpaRepository<Loan, Long> {

}
