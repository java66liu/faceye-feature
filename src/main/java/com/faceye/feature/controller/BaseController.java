package com.faceye.feature.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import com.faceye.feature.service.BaseService;

/**
 * 基础控制器
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月21日
 * @param <T>
 * @param <ID>
 * @param <S>
 */
public class BaseController<T, ID extends Serializable, S extends BaseService<T, ID>> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected S service = null;

	/**
	 * 默认构造器
	 * 
	 * @param service
	 */
	public BaseController(S service) {
		this.service = service;
	}

	/**
	 * 管理首页
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日
	 * @param <ModelView>
	 */
	protected Page<T> getPage() {
		Page<T> page = null;
        
		return page;
	}

	/**
	 * 转向编辑页面或新增页面，或进行编辑的json页面
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日
	 */
	protected void prepareEdit(ID id) {
		if (id != null) {
			T entity = this.service.get(id);
		} else {
			logger.error(">>ID is Empty.");
		}
	}

	/***
	 * 执行数据保存动作，从/edit页面来
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日
	 */
	protected void prepareSave(T entity) {
		service.save(entity);
	}

	/**
	 * 删除数据
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日
	 */
	protected void prepareRemove(ID id) {
		service.remove(id);
	}

	/**
	 * 查询一个对像
	 * 
	 * @todo
	 * @param id
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2014年5月25日
	 */
	protected T get(ID id) {
		T entity = service.get(id);
		return entity;
	}
}
