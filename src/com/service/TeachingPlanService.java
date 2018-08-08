/**  
 * @Title: TeachingPlanService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.ClassNameDao;
import com.dao.TeachingPlanDao;
import com.po.ClassName;
import com.po.TeachingPlan;

/**
 * ClassName: TeachingPlanService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
@Service("teachingPlanService")
public class TeachingPlanService {
	@Autowired
	@Qualifier("teachingPlanDaoImpl")
	private TeachingPlanDao teachingPlanDao;
	@Autowired
	@Qualifier("classNameDaoImpl")
	private ClassNameDao classNameDao;
	
	
	public TeachingPlan getPlan(String years,String cName){
		if("".equals(years) || "".equals(cName)){
			return null;
		}
		ClassName classNameTemp = null;
		classNameTemp = classNameDao.queryClassNameByName(cName).get(0);
		return teachingPlanDao.queryTeachingPlanByYearsAndClassName(years, classNameTemp);
	}

	
	
	public TeachingPlanDao getTeachingPlanDao() {
		return teachingPlanDao;
	}

	public void setTeachingPlanDao(TeachingPlanDao teachingPlanDao) {
		this.teachingPlanDao = teachingPlanDao;
	}
	public ClassNameDao getClassNameDao() {
		return classNameDao;
	}



	public void setClassNameDao(ClassNameDao classNameDao) {
		this.classNameDao = classNameDao;
	}
	
	
}
