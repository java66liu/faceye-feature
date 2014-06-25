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
abstract public class BaseController<T, ID extends Serializable, S extends BaseService<T, ID>> {
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

	
}
