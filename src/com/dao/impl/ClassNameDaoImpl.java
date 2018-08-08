/**  
 * @Title: ClassNameDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.ClassNameDao;
import com.po.ClassName;

/**
 * ClassName: ClassNameDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
@Repository("classNameDaoImpl")
public class ClassNameDaoImpl extends BaseDaoImpl implements ClassNameDao  {

	/* (非 Javadoc)
	* <p>Title: addClassName</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.ClassNameDao#addClassName(com.po.ClassName)
	*/
	@Override
	public boolean addClassName(ClassName obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: updateClassName</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.ClassNameDao#updateClassName(com.po.ClassName)
	*/
	@Override
	public boolean updateClassName(ClassName obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: deleteClassName</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.ClassNameDao#deleteClassName(com.po.ClassName)
	*/
	@Override
	public boolean deleteClassName(ClassName obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryAllClassName</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.ClassNameDao#queryAllClassName()
	*/
	@Override
	public List<ClassName> queryAllClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryClassNameByName</p>
	* <p>Description: </p>
	* @param name
	* @return
	* @see com.dao.ClassNameDao#queryClassNameByName(java.lang.String)
	*/
	@Override
	public List<ClassName> queryClassNameByName(String name) {
		String hql = "from ClassName where cName like '%"+name+"%'";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryClassNameByCid</p>
	* <p>Description: </p>
	* @param cid
	* @return
	* @see com.dao.ClassNameDao#queryClassNameByCid(int)
	*/
	@Override
	public ClassName queryClassNameByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
