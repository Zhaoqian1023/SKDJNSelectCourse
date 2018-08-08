/**  
 * @Title: TeachingPlanDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.TeachingPlanDao;
import com.po.ClassName;
import com.po.TeachingPlan;

/**
 * ClassName: TeachingPlanDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
@Repository("teachingPlanDaoImpl")
public class TeachingPlanDaoImpl extends BaseDaoImpl implements TeachingPlanDao {

	/* (非 Javadoc)
	* <p>Title: addTeachingPlan</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeachingPlanDao#addTeachingPlan(com.po.TeachingPlan)
	*/
	@Override
	public boolean addTeachingPlan(TeachingPlan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: updateTeachingPlan</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeachingPlanDao#updateTeachingPlan(com.po.TeachingPlan)
	*/
	@Override
	public boolean updateTeachingPlan(TeachingPlan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: deleteTeachingPlan</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeachingPlanDao#deleteTeachingPlan(com.po.TeachingPlan)
	*/
	@Override
	public boolean deleteTeachingPlan(TeachingPlan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryAllTeachingPlan</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.TeachingPlanDao#queryAllTeachingPlan()
	*/
	@Override
	public List<TeachingPlan> queryAllTeachingPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryTeachingPlanById</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.dao.TeachingPlanDao#queryTeachingPlanById(int)
	*/
	@Override
	public List<TeachingPlan> queryTeachingPlanById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryTeachingPlanByYears</p>
	* <p>Description: </p>
	* @param years
	* @return
	* @see com.dao.TeachingPlanDao#queryTeachingPlanByYears(java.lang.String)
	*/
	@Override
	public List<TeachingPlan> queryTeachingPlanByYears(String years) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryTeachingPlanByClassName</p>
	* <p>Description: </p>
	* @param classname
	* @return
	* @see com.dao.TeachingPlanDao#queryTeachingPlanByClassName(com.po.ClassName)
	*/
	@Override
	public TeachingPlan queryTeachingPlanByClassName(ClassName classname) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryTeachingPlanByYearsAndClassName</p>
	* <p>Description: </p>
	* @param years
	* @param classname
	* @return
	* @see com.dao.TeachingPlanDao#queryTeachingPlanByYearsAndClassName(java.lang.String, com.po.ClassName)
	*/
	@Override
	public TeachingPlan queryTeachingPlanByYearsAndClassName(String years,
			ClassName classname) {
		String hql = "from TeachingPlan where className="+classname.getcId()+"and years='"+years+"'";
		return (TeachingPlan) super.queryListByHQL(hql).get(0);
	}

	
}
