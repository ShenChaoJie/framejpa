package org.frame.persistence.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class SqlRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>{

	public SqlRepositoryFactoryBean() {
		super();
	}
	
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em)
    {
        return new SqlRepositoryFactory(em);
    }

	
}
