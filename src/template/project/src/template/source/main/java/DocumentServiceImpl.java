package com.faceye.component.@component.name@.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.faceye.component.@component.name@.doc.@entity.name@;

import com.faceye.component.@component.name@.repository.mongo.@entity.name@Repository;
import com.faceye.component.@component.name@.service.@entity.name@Service;

import com.faceye.component.resource.doc.QQuestion;
import com.faceye.component.resource.doc.Question;
import com.faceye.component.resource.doc.Section;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
import com.faceye.feature.util.ServiceException;
import com.mysema.query.types.Predicate;

/**
 * @entity.name@ ORM 实体
 * @Description @entity.title@ 服务层实现类
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月21日
 */
@Service
public class @entity.name@ServiceImpl extends BaseMongoServiceImpl<@entity.name@, Long, @entity.name@Repository> implements @entity.name@Service {

	@Autowired
	public @entity.name@ServiceImpl(@entity.name@Repository dao) {
		super(dao);
	}
	
	@Override
	public Page<@entity.name@> getPage(Map<String, Object> searchParams, int page, int size) throws ServiceException {
		if (page != 0) {
			page = page - 1;
		}
		Page<@entity.name@> res = null;
		Q@entity.name@ q@entity.name@ = Q@entity.name@.@entity.config.name@;
		Predicate predicate = null;
//		Long sectionId = MapUtils.getLong(searchParams, "sectionId");
		if (null != sectionId) {
//			predicate = q@entity.name@.sectionId.eq(sectionId);
		}
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size);
			res = this.dao.findAll(predicate, pageable);
		} else {
			Iterable<@entity.name@> iQuestions = this.dao.findAll(predicate);
			List<@entity.name@> items = new ArrayList();
			items.addAll((Collection) iQuestions);
			res = new PageImpl(items);
		}
		return res;
	}
	
	
}/**@generate-service-source@**/
