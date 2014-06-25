package com.faceye.feature.repository;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{
	/**
	 * 增加通用分页查询
	 * @todo
	 * @param searchParams
	 * @param page
	 * @param size
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年6月24日
	 */
	public Page<T> getPage(Map<String, Object> searchParams, int page, int size) ;
	
	
	/**
	 * 
	 * @todo
	 * @param sql
	 * @param page
	 * @param size
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年6月24日
	 */
	public Page<?> getPage(String sql,String resultSetMapping,int page,int size);
	
	
	public Page<?> getPage(String sql,Class resultClass,int page,int size);
	
}
