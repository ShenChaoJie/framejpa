package org.frame.service.api;

import java.util.List;
import java.util.Map;

import org.frame.common.page.PageBar;
import org.frame.persistence.po.TProvince;


public interface ProvinceService {
	public Map<String, String> addProvince(Map<String, String> para) throws Exception;

	public Map<String, String> upProvince(Map<String, String> para) throws Exception;

	public TProvince getProvince(Map<String, String> para) throws Exception;

	public PageBar queryProvince(Map<String, String> para) throws Exception;

	public PageBar queryCity(Map<String, String> para) throws Exception;

	public PageBar queryProvinceDetail(Map<String, String> para) throws Exception;
	
	public PageBar queryProvinceForChoose(Map<String, String> para) throws Exception;

	public Map<String, String> delProvince(Map<String, String> para) throws Exception;

	public List queryProvince() throws Exception;
	
	public TProvince findById(Integer id) throws Exception;

	public List<TProvince> findByPid(Integer pid) throws Exception;
	
	/**
	 * 根据ID查询,例如1,2,3
	 * @param ids
	 * @return
	 */
	public List<TProvince> findByIds(String ids) throws Exception;
	
	public List<TProvince> getProvinceAndCity();

}
