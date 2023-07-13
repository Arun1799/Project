package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.model.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {

}
