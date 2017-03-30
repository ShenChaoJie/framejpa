package org.frame.persistence.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

public class SqlRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

	private final EntityManager entityManager;  
     
	public SqlRepositoryFactory(EntityManager entityManager) {  
        super(entityManager);  
        this.entityManager = entityManager;  
	}  
	
	/*public SqlRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}*/
	/*protected JpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata,EntityManager em) {
		JpaEntityInformation entityMetadata = (JpaEntityInformation) Mockito.mock(JpaEntityInformation.class);
		Mockito.when(entityMetadata.getJavaType()).thenReturn(metadata.getDomainType());
		return new SqlCustomRepository(entityMetadata, em);
	}

	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return SqlCustomRepository.class;
	}*/
	
	/*@Override  
    protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {  
  
        JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getReturnedDomainClass());  
        return new SqlCustomRepository(entityInformation, entityManager); // custom implementation  
    }*/
	 
	 @Override
     protected Object getTargetRepository(RepositoryMetadata metadata) {
         return new SqlCustomRepository((Class<T>) metadata.getDomainType(), entityManager);
     }
	

   /* @Override  
   	protected JpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {//<T, ID extends Serializable>  
        //JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());  
        
        JpaEntityInformation entityInformation = (JpaEntityInformation)Mockito.mock(JpaEntityInformation.class);
        Mockito.when(entityInformation.getJavaType()).thenReturn(metadata.getDomainType());

        return new SqlCustomRepository(entityInformation, entityManager); 
    }*/
	    
    @Override  
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {  
   
        return SqlCustomRepository.class;  
    }  
	
}
