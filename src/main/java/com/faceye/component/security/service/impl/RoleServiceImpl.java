package com.faceye.component.security.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faceye.component.security.entity.Resource;
import com.faceye.component.security.entity.Role;
import com.faceye.component.security.repository.ResourceRepository;
import com.faceye.component.security.repository.RoleRepository;
import com.faceye.component.security.service.RoleService;
import com.faceye.feature.service.impl.BaseServiceImpl;
/**
 * 角色服务类
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年6月27日
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, Long, RoleRepository> implements RoleService {

	@Autowired
	private ResourceRepository resourceRepository=null;
	@Autowired
	public RoleServiceImpl(RoleRepository dao) {
		super(dao);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		List<Role> allRoles = this.dao.findAll();
		if (null != allRoles && CollectionUtils.isNotEmpty(allRoles)) {
			for (Role role : allRoles) {
				ConfigAttribute ca = new SecurityConfig(role.getRoleAuth());
				allAttributes.add(ca);
			}
		}
		return allAttributes;
	}

	@Override
	public void saveRoleAuthResources(Long roleId, Long[] resourceIds) {
	   Role role=this.dao.findOne(roleId);
	   Set<Resource> resources=role.getResources();
	   resources.clear();
	   if(resourceIds!=null &&resourceIds.length>0){
		   for(Long resourceId:resourceIds){
			   Resource resource=this.resourceRepository.findOne(resourceId);
			   resources.add(resource);
		   }
	   }
	   role.setResources(resources);
	   this.dao.save(role);
	}
	
	
}/**@generate-service-source@**/
