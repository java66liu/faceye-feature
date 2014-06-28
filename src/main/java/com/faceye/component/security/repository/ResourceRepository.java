package com.faceye.component.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.faceye.component.security.entity.Resource;
import com.faceye.feature.repository.BaseRepository;
/**
 * Resource 实体DAO
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月20日
 */
public interface ResourceRepository extends BaseRepository<Resource,Long> {
	
	
}/**@generate-repository-source@**/
