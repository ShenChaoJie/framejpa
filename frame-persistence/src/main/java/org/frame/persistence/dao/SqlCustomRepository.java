package org.frame.persistence.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author chaojie.shen
 *
 * @param <T>
 * @param <ID>
 * 
 * SimpleJpaRepository<T,ID> 类,实现了  JpaRepository<T, ID>接口的所有方法
 * 
 */
@NoRepositoryBean
public class SqlCustomRepository<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements SqlRepository<T,ID>  {

	//@Autowired
	private final EntityManager entityManager;
	
	public SqlCustomRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		entityManager = em;
	}
	
	/*public SqlCustomRepository(JpaEntityInformation<T,ID> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}*/
	
	
	@Override
	public long countBySql(String sql) {
		Query q = entityManager.createNativeQuery(sql);
		return q.getResultList().size();
	}
	
	@Override
	public long countByJpql(String jpql) {
		Query q = entityManager.createQuery(jpql);
		return q.getResultList().size();
	}

	@Override
	public List findBySql(String sql) {
		Query q = entityManager.createNativeQuery(sql);
		return q.getResultList();
	}

	@Override
	public List findByJpql(String jpql, Map maps) {
		Query q = entityManager.createQuery(jpql);
		if (maps != null) {
			String key;
			for (Iterator iterator = maps.keySet().iterator(); iterator
					.hasNext(); q.setParameter(key, maps.get(key)))
				key = (String) iterator.next();

		}
		return q.getResultList();
	}

	@Override
	public List findStrByJpql(String jpql, Map maps) {
		Query q = entityManager.createQuery(jpql);
		if (maps != null) {
			String key;
			for (Iterator iterator = maps.keySet().iterator(); iterator
					.hasNext(); q.setParameter(key, maps.get(key)))
				key = (String) iterator.next();

		}
		return q.getResultList();

	}

	@Override
	public long countByJpql(String jpql, Map maps) {
		Query q = entityManager.createQuery(jpql);
		if (maps != null) {
			String key;
			for (Iterator iterator = maps.keySet().iterator(); iterator
					.hasNext(); q.setParameter(key, maps.get(key)))
				key = (String) iterator.next();

		}
		return q.getResultList().size();

	}

	@Override
	public Page findByJpql(String jpql, Map maps, Pageable pageable) {
		Query q = entityManager.createQuery(jpql);
		if (maps != null) {
			String key;
			for (Iterator iterator = maps.keySet().iterator(); iterator
					.hasNext(); q.setParameter(key, maps.get(key)))
				key = (String) iterator.next();

		}
		q.setFirstResult(pageable.getOffset());
		q.setMaxResults(pageable.getPageSize());
		long total = countByJpql2(jpql, maps);
		
		return new PageImpl(q.getResultList(), pageable, total);

	}
	
	
	@Override
	public Page findBySql(String sql, Map maps, Pageable pageable) {
		Query q = entityManager.createNativeQuery(sql);
		if (maps != null) {
			String key;
			for (Iterator iterator = maps.keySet().iterator(); iterator
					.hasNext(); q.setParameter(key, maps.get(key)))
				key = (String) iterator.next();

		}
		q.setFirstResult(pageable.getOffset());
		q.setMaxResults(pageable.getPageSize());
		
		long total = countBySql2(sql, maps);
		return new PageImpl(q.getResultList(), pageable, total);

	}
	

	public long countByJpql2(String jpql, Map maps) {
		StringBuffer sb = new StringBuffer();
		if (jpql.indexOf("select") == 0) {
			sb.append("select count(*) from (");
			sb.append(jpql);
			sb.append(")");
		} else if (jpql.indexOf("from") == 0) {
			sb.append("select count(*) ");
			sb.append(jpql);
		} else {
			return 0L;
		}
		Query q = entityManager.createQuery(sb.toString());
		String key;
		for (Iterator iterator = maps.keySet().iterator(); iterator.hasNext(); q
				.setParameter(key, maps.get(key)))
			key = (String) iterator.next();

		return ((Long) q.getSingleResult()).longValue();
	}
	
	
	public long countBySql2(String sql, Map maps) {
		StringBuffer sb = new StringBuffer();
		if (sql.indexOf("select") == 0) {
			sb.append("select count(*) from (");
			sb.append(sql);
			sb.append(")");
		} else if (sql.indexOf("from") == 0) {
			sb.append("select count(*) ");
			sb.append(sql);
		} else {
			return 0L;
		}
		Query q = entityManager.createNativeQuery(sb.toString());
		String key;
		for (Iterator iterator = maps.keySet().iterator(); iterator.hasNext(); q
				.setParameter(key, maps.get(key)))
			key = (String) iterator.next();

		return ((Long) q.getSingleResult()).longValue();
	}
	
	


}