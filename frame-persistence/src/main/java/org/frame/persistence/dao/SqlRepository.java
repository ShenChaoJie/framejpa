package org.frame.persistence.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SqlRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{
	
	//boolean support(String modelType);
	
	public abstract long countBySql(String s);
	
	public abstract long countByJpql(String s);

    public abstract List findBySql(String s);

    public abstract List findByJpql(String s, Map map);

    public abstract List findStrByJpql(String s, Map map);

    public abstract long countByJpql(String s, Map map);

    public abstract Page findByJpql(String s, Map map, Pageable pageable);
    
    public abstract Page findBySql(String s, Map map, Pageable pageable);
    

}