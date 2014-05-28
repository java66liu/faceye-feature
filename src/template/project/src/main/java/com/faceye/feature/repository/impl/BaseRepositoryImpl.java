package com.faceye.feature.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.faceye.feature.entity.Example;
import com.faceye.feature.repository.BaseRepository;
import com.faceye.feature.repository.DynamicSpecifications;
import com.faceye.feature.repository.SearchFilter;
/**
 * 扩展基础DAO实现
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月25日
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
	
	protected Logger logger=LoggerFactory.getLogger(getClass());
	protected EntityManager entityManager=null;
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
	}
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
	/**
	 * 查询分页数据
	 */
	@Override
	public Page<T> getPage(Map<String, Object> searchParams, int page, int size) {
		Specification<T> specification = null;
		Page<T> result = null;
		Class clazz = this.getDomainClass();
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		specification = DynamicSpecifications.bySearchFilter(filters.values(), clazz);
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size);
			result = findAll(specification, pageable);
		} else {
			List<T> items = findAll(specification);
			result = new PageImpl<T>(items);
		}
		return result;
	}

}
