package org.frame.service;


import org.frame.persistence.dao.ProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

	@Autowired
	private ProvinceDao provinceDao;

	public ProvinceDao getProvinceDao() {
		return provinceDao;
	}

	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	
	
}
