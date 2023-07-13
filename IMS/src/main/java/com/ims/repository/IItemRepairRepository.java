package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.model.ItemRepair;

@Repository
public interface IItemRepairRepository extends JpaRepository<ItemRepair, Long> {

}
