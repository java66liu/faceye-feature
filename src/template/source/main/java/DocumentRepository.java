package com.faceye.component.@component.name@.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.faceye.component.@component.name@.doc.@entity.name@;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * @entity.name@ 实体DAO
 * @description：@entity.title@ 持久化
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月20日
 */
public interface @entity.name@Repository extends BaseMongoRepository<@entity.name@,Long> {
	
	
}/**@generate-repository-source@**/
