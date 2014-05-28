package com.faceye.feature.repository;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{
	public Page<T> getPage(Map<String, Object> searchParams, int page, int size) ;
}
