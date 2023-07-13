package com.ims.service;

import java.util.List;
import com.ims.model.ItemRepair;

public interface IItemRepairService {
	List<ItemRepair> getAllRepairItems();

	void saveItemRepair(ItemRepair itemRepair);

	void deleteItemRepairById(long id);

	ItemRepair findItemRepairById(long id);
}