package com.faceye.test.feature.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import com.faceye.feature.entity.Example;
import com.faceye.feature.repository.SearchFilter;
import com.faceye.feature.service.ExampleService;

/**
 * ExampleEntity 测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class ExampleServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private ExampleService exampleService = null;
	/**
	 * 初始化
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Before
	public void set() throws Exception {
		Assert.isTrue(exampleService != null);
	}

	/**
	 * 清理
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@After
	public void after() throws Exception {
		this.exampleService.removeAllInBatch();
	}

	/**
	 *  保存测试
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Test
	public void testSave() throws Exception {
		Example entity = new Example();
		entity.setName("test-1");
		this.exampleService.save(entity);
		List<Example> entites = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		Example entity = new Example();
		entity.setName("test-1");
		this.exampleService.save(entity);
		List<Example> entites = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			Example entity = new Example();
			entity.setName("test-1");
			this.exampleService.save(entity);
		}
		List<Example> entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		Example entity = new Example();
		entity.setName("test-1");
		this.exampleService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		Example e = this.exampleService.get(entity.getId());
		Assert.isTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		Example entity = new Example();
		entity.setName("test-1");
		this.exampleService.save(entity);
		this.exampleService.remove(entity);
		List<Example> entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			Example entity = new Example();
			entity.setName("test-1");
			this.exampleService.save(entity);
		}
		List<Example> entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.exampleService.removeAllInBatch();
		entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Example entity = new Example();
			entity.setName("test-1");
			this.exampleService.save(entity);
		}
		this.exampleService.removeAll();
		List<Example> entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<Example> entities = new ArrayList<Example>();
		for (int i = 0; i < 5; i++) {
			Example entity = new Example();
			entity.setName("test-1");
			this.exampleService.save(entity);
			entities.add(entity);
		}
		this.exampleService.removeInBatch(entities);
		entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Example entity = new Example();
			entity.setName("test-1");
			this.exampleService.save(entity);
		}
		List<Example> entities = this.exampleService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			Example entity = new Example();
			entity.setName("test-" + i);
			this.exampleService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<Example> page = this.exampleService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.exampleService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.exampleService.getPage(searchParams, 1, 5);

		Assert.isTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			Example entity = new Example();
			entity.setName("test-" + i);
			this.exampleService.save(entity);
			id = entity.getId();
		}
		Example e = this.exampleService.get(id);
		Assert.isTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			Example entity = new Example();
			entity.setName("test-" + i);
			this.exampleService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<Example> entities = this.exampleService.getAll(ids);
		Assert.isTrue(entities != null && entities.size() == 5);
	}
}
