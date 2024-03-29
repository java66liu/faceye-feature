package com.faceye.component.@component.name@.doc;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @entity.name@ ORM 实体
 * 数据库表:@component.name@_@entity.config.name@
 * @Description @entity.title@ 持久化实体对像
 * @author @haipenge 
 * haipenge@gmail.com
 *  Create Date:2014年5月21日
 */
@Document(collection="@component.name@_@entity.config.name@")
public class @entity.name@ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8926119711730830203L;
	@Id
	private  Long id=null;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}/**@generate-entity-source@**/
