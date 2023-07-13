package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.ItemType;

public interface IItemTypeRepository extends JpaRepository<ItemType, Long> {

}