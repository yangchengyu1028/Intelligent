package com.novo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.novo.util.ReflectUtils;



/**
 * 通用DAO
 * @author Administrator
 *
 */

public class BasicDao<T> {
	
	protected Class<T> entityClass;

	/**
	 * 通过构造函数获得泛型T的类型
	 */
	public BasicDao() {
		entityClass = ReflectUtils.getClassGenricType(getClass());
	}
	
	//sessionfactory注入
	@Autowired
	private LocalSessionFactoryBean localSessionFactoryBean;
	
	/**
	 * 获得当前连接
	 * @return 当前连接
	 */
	protected Session getSession(){
		//获得当前连接
		return localSessionFactoryBean.getObject().getCurrentSession();
	}
	/**
	 * 添加t
	 * @param t
	 */
	public void sava(T t){
		this.getSession().save(t);
	}
	/**
	 * 添加t或者更新t
	 * @param t
	 */
	public void saveOrUpdate(T t){
		this.getSession().saveOrUpdate(t);
	}
	/**
	 *根据t删除(实际是修改对象状态为不可用,状态为0)
	 * @param t
	 */
	public void delObject(T t){
		this.getSession().update(t);
	}
	/**
	 * 根据t删除
	 * @param t
	 */
	public void delete(T t) {
		this.getSession().delete(t);
	}
/*	*//**
	 * 根据id删除（实际是修改目标对象状态）
	 * @param id
	 *//*
	public void delByIdObject(String id){
		this.getSession()
		.update(this.getSession().load(entityClass, id));
	
	}*/
	/**
	 * 更新对象t
	 * @param t
	 */
	public void updateObject(T t){
		this.getSession().update(t);
	}
	/**
	 * 根据ID获得t（急加载）
	 * @param id
	 */
	public T getByIdObject(int id){
	return	this.getSession().get(entityClass, id);
	}
	
	/**
	 * 根据Id获得t（懒加载）
	 * @param id
	 */
	public T loadByIdObject(int id){
	   return	this.getSession().load(entityClass, id);
	}
	 /**
	    * 根据传入的hql语句查询单一对象
	    * @param hql
	    * @param objs
	    * @return
	    */
		public T findObject(String hql){
			 Query query=	this.getSession().createQuery(hql);
			
			return (T)query.uniqueResult();
		}
	
   /**
    * 根据传入的hql语句和查询条件集合查询单一对象
    * @param hql
    * @param objs
    * @return
    */
	public T findObject(String hql,List<String> objs){
		 Query query=	this.getSession().createQuery(hql);
		  for(int i=0;i<objs.size();i++){
			query.setParameter(i,objs.get(i));
		  }
		return (T)query.uniqueResult();
	}
	/**
	 * 获取实体的所有对象
	 */
	public List<T> getListObject(){
		String hql="from "+entityClass.getSimpleName();
	return	this.getSession().createQuery(hql)
		.list();
	}
	/**
	 * 分页
	 * 获取调用的实体的所有对象
	 * @param start 开始位置
	 * @param max  查询行数
	 */
	public List<T> getListObject(int start,int  max){
		String hql="from "+entityClass.getSimpleName();
		 Query query=	this.getSession().createQuery(hql);
		  query.setFirstResult(start);
		  query.setMaxResults(max);
	     return	query.list();
	}
	/**
	 *根据hql查询对象集合
	 * @param hql
	 * @return
	 */
	public List<T> getListObject(String hql){
	return	this.getSession().createQuery(hql)
		.list();
	}
	/**
	 * 根据传入的hql语句和查询条件集合查询对象集合
	 * @param hql
	 * @return
	 */
	public List<T> getListObject(String hql,List<String> obj){
	 Query query=	this.getSession().createQuery(hql);
	  for(int i=0;i<obj.size();i++){
		query.setParameter(i,obj.get(i));
	  }
     return	query.list();
	}
	/**
	 * 根据查询条件查询不同实体，返回hql中要查询的集合
	 * @param hql 查询不同实体和属于不同实体的字段
	 * @param obj 查询条件
	 * @return 不同对象的字段的数组的集合
	 */
	public List<Object[]> getListObjectArray(String hql,List<String> obj){
		 Query query=	this.getSession().createQuery(hql);
		  for(int i=0;i<obj.size();i++){
			query.setParameter(i,obj.get(i));
		  }
	     return	query.list();
		}
	/**
	 * 分页
	 * @param hql 查询语句
	 * @param obj 查询条件集合
	 * @param start 开始位置
	 * @param max  查询行数
	 * @return 查询对象的集合
	 */
	public List<T> getListPageObject(String hql,List<String> obj,int start,int  max){
	 Query query=	this.getSession().createQuery(hql);
	  for(int i=0;i<obj.size();i++){
		query.setParameter(i,obj.get(i));
	  }
	  query.setFirstResult(start);
	  query.setMaxResults(max);
     return	query.list();
	}
	/**
	 * 获取查询对象的总条数
	 * @param hql	查询语句
	 * @param obj	查询条件
	 * @return	总条数
	 */
	public Long getListAllNums(String hql,List<String> obj){
		 Query query=this.getSession().createQuery(hql);
		  for(int i=0;i<obj.size();i++){
			query.setParameter(i,obj.get(i));
		  }
	     return	(Long)query.uniqueResult();
		}
	
	public void UpdateStatus(String hql,List<String> obj){
		 Query query	=	this.getSession().createQuery(hql);
		  for(int i=0;i<obj.size();i++){
			query.setParameter(i,obj.get(i));
		  }
	}
	/**
	 * 获得所有的条数
	 * @param hql hql语句
	 * @param obj 参数数组
	 * @return 所有条数数量
	 */
	public int getTotalNum(String hql,Object[]obj) {
		
		Query query=this.getSession().createQuery(hql);
		  for(int i=0;i<obj.length;i++){
				query.setParameter(i,obj[i]);
			  }
		int count=Integer.parseInt(query.uniqueResult().toString());
		
		return count;
	}
	/**

	 * 自定义HQL查询,条件拼接
	 * @param hql
	 * @return
	 */
	public List<T> getListObject(String hql,Object[] obj){
		
	 Query query=	this.getSession().createQuery(hql);
	  for(int i=0;i<obj.length;i++){
		query.setParameter(i,obj[i]);
	  }
     return	query.list();
	}
	/**
	 * 分页
	 * @param hql 分页的hql
	 * @param obj 分页的条件
	 * @param start 起始位置
	 * @param max  每页显示的行数
	 * @return返回分页的结果
	 */
	public List<T> getListPageObject(String hql,Object[] obj,int start,int  max){
		
	 Query query=	this.getSession().createQuery(hql);
	  for(int i=0;i<obj.length;i++){
		query.setParameter(i,obj[i]);
	  }
	  query.setFirstResult(start);
	  query.setMaxResults(max);
     return	query.list();
	}
	/**
	 * 修改用户状态
	 * @param hql 修改的hql语句
	 * @param obj 传入的条件
	 */
	public void updateState(String hql,Object[]obj) {
		Query query=this.getSession().createQuery(hql);
		  for(int i=0;i<obj.length;i++){
				query.setParameter(i,obj[i]);
			  }
		query.executeUpdate();
	}	
	/**
	 * 根据ID删除对象
	 * @param id
	 */
	public void delByIdObject(int id){
		this.getSession()
		.delete(this.getSession().load(entityClass, id));
	
	}
	/**
	 * 获得所有条数
	 * @param hql
	 * @return
	 */
	public int getTotalNum2(String hql) {
		Query query = this.getSession().createQuery(hql);
		return ((Number) query.uniqueResult()).intValue();	
	}
	/**qj
	 * 分页
	 * @param hql 分页的hql
	 * @param start 起始位置
	 * @param max  每页显示的行数
	 * @return 返回分页的结果
	 */
	public List<T> getListPageObject(String hql,int start,int max){
	 Query query=	this.getSession().createQuery(hql);
	  query.setFirstResult(start);
	  query.setMaxResults(max);
     return	query.list();
	}
	
	public Object getMax(String hql){
		Query query= this.getSession().createQuery(hql);
		return  query.uniqueResult();
	}
	

	

}
