package com.ims.service;

import com.ims.model.Vendor;

public interface IVendorService {
	Vendor getVendorById(long id);

	Vendor getVendorByName(String name);

	String validateVendorId(long id);
	
	String validateVendorName(String vendorName);
}
