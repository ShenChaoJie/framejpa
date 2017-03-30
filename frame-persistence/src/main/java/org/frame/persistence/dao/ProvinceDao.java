package org.frame.persistence.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.frame.persistence.po.TProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * 
 * @author chaojie.shen
 *
 * @param <TProvince>
 * @param <ID>
 * 
 * JpaRepository<T, ID extends Serializable> 接口
 * 这个接口提供了JPA的相关功能 
 * 
 * CrudRepository<T, ID extends Serializable>接口
 * 这个接口提供了最基本的对实体类的添删改查操作 
 * 
 * PagingAndSortingRepository<T, ID extends Serializable> 接口
 * 这个接口提供了分页与排序功能
 * 
 * JpaSpecificationExecutor接口 
 * 特殊的复杂查询
 */
@Repository
public interface ProvinceDao extends SqlRepository<TProvince, Integer>{
	
	public List<TProvince> findByName(String name);
	
	public List<TProvince> findByPid(Integer pid);
	
	//@Query("select t from TProvince t where pname = ?1")
	//public List<TProvince> queryProvince(String pname);
	
	//public List<TProvince> findByIdIn(Collection<Id> ids);
	
	
	
}
