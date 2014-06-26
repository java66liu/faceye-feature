package com.faceye.feature.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 构造动态查询SQL
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年6月25日
 */
public class DynamicSQLBuilder {
	/**
	 * 构建SQL语句
	 * @todo
	 * @param filters
	 * @param sql
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年6月25日
	 */
	public static SQLBuilderEntity builder(Map<String, SearchFilter> filters, String sql) {
		StringBuilder res = new StringBuilder(sql);
		SQLBuilderEntity entity=new SQLBuilderEntity();
		List<Object> paramValues=new ArrayList<Object>();
		res=addWhere2SQL(res);
		if (MapUtils.isNotEmpty(filters)) {
			Iterator<SearchFilter> it = filters.values().iterator();
			while (it.hasNext()) {
				SearchFilter filter = it.next();
				String key=filter.fieldName;
				Object value=filter.value;
			
				switch (filter.operator) {
				case EQ:
					res.append(" and ");
					res.append(key);
					res.append("=");
//					res.append("'");
					res.append("?");
//					res.append("'");
					paramValues.add(value);
					break;
				case LIKE:
					res.append(" and ");
					res.append(key);
					res.append(" like ");
//					res.append("'%");
					res.append("?");
//					res.append("%'");
					paramValues.add("%"+value+"%");
					break;
				case GT:
					res.append(" and ");
					res.append(key);
					res.append(">");
//					res.append("'");
					res.append("?");
//					res.append("'");
					paramValues.add(value);
					break;
				case LT:
					res.append(" and ");
					res.append(key);
					res.append("<");
//					res.append("'");
					res.append("?");
//					res.append("'");
					paramValues.add(value);
					break;
				case GTE:
					res.append(" and ");
					res.append(key);
					res.append(">=");
//					res.append("'");
					res.append("?");
//					res.append("'");
					paramValues.add(value);
					break;
				case LTE:
					res.append(" and ");
					res.append(key);
					res.append("<=");
//					res.append("'");
					res.append("?");
					paramValues.add(value);
//					res.append("'");
				default:
				}
			}
		}
		entity.setSql(res.toString());
		entity.setParamValues(paramValues);
		return entity;
	}
	/**
	 * 判断SQL中是否有where语句
	 * @todo
	 * @param sql
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年6月25日
	 */
	private static boolean isHaveWhereInSQL(StringBuilder sql){
	   boolean isHave=Boolean.FALSE;
	   if(StringUtils.isNotEmpty(sql)){
		   isHave=sql.toString().toLowerCase().indexOf("where")!=-1;
	   }
	   return isHave;
	}
	/**
	 * 向SQL中添加where语句
	 * @todo
	 * @param sql
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年6月25日
	 */
	private static StringBuilder addWhere2SQL(StringBuilder sql){
		StringBuilder res=sql;
		boolean isHaveWhereInSQL=isHaveWhereInSQL(sql);
		if(!isHaveWhereInSQL){
			res.append(" where 1=1 ");
		}
		return res;
	}
}
