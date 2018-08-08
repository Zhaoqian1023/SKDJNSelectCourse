/**  
 * @Title: BaseDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dao.BaseDao;


/**
 * ClassName: BaseDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
@Repository("baseDaoImpl")
public class BaseDaoImpl implements BaseDao {
	@Resource(name = "mySessionFactory")
	private SessionFactory mySessionFactory;
	
	protected Session getSession() {
		Session session = null;
		System.out.println("mySessionFactory:"+mySessionFactory);
		try {
			session = mySessionFactory.getCurrentSession();
			System.out.println("CurrentSession-----"+session);
		} catch (Exception e) {
			session = mySessionFactory.openSession();
			System.out.println("openSession-----"+session);
		}
		return session;
	}

	/* (非 Javadoc)
	* <p>Title: save</p>
	* <p>Description: </p>
	* @param o
	* @see com.dao.BaseDao#save(java.lang.Object)
	*/
	@Override
	public boolean add(Object obj) {
		try {
			getSession().save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	/* (非 Javadoc)
	* <p>Title: saveOrUpdate</p>
	* <p>Description: </p>
	* @param oj
	* @return
	* @see com.dao.BaseDao#saveOrUpdate(java.lang.Object)
	*/
	@Override
	public boolean addOrUpdate(Object obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (非 Javadoc)
	* <p>Title: del</p>
	* <p>Description: </p>
	* @param o
	* @see com.dao.BaseDao#del(java.lang.Object)
	*/
	@Override
	public boolean delete(Object obj) {
		try {
			getSession().delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	/* (非 Javadoc)
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param o
	* @see com.dao.BaseDao#update(java.lang.Object)
	*/
	@Override
	public boolean update(Object obj) {
		try {
			getSession().merge(obj);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

	/* (非 Javadoc)
	* <p>Title: get</p>
	* <p>Description: </p>
	* @param po
	* @param id
	* @return
	* @see com.dao.BaseDao#get(java.lang.Class, java.io.Serializable)
	*/
	@Override
	public Object query(Class po, Serializable id) {
		return getSession().get(po, id);
	}

	/* (非 Javadoc)
	* <p>Title: listBySQL</p>
	* <p>Description: </p>
	* @param sql
	* @return
	* @see com.dao.BaseDao#listBySQL(java.lang.String)
	*/
	@Override
	public List queryListBySQL(String sql, Class obj) {
		List result = null;
		if(sql == null){
			sql = "";
		}
		Session session = getSession();
		try {
			Query query = session.createSQLQuery(sql).addEntity(obj);
			result = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return result;
	}

	/* (非 Javadoc)
	* <p>Title: listByHQL</p>
	* <p>Description: </p>
	* @param hql
	* @return
	* @see com.dao.BaseDao#listByHQL(java.lang.String)
	*/
	@Override
	public List queryListByHQL(String hql) {
		List result = null;
		if(hql == null){
			hql = "";
		}
		Session session = getSession();
		try {
			Query query = session.createQuery(hql);
			result = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return result;
	}

	/* (非 Javadoc)
	* <p>Title: listBySQL</p>
	* <p>Description: </p>
	* @param sql
	* @return
	* @see com.dao.BaseDao#listBySQL(java.lang.String)
	*/
	@Override
	public List queryListBySQL(String sql) {
		List result = null;
		if(sql == null){
			sql = "";
		}
		Session session = getSession();
		try {
			Query query = session.createSQLQuery(sql);
			result = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}

	public void setMySessionFactory(SessionFactory mySessionFactory) {
		this.mySessionFactory = mySessionFactory;
	}

	

	
	
}
