/**  
 * @Title: TeachingPlanDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao;

import java.util.List;

import com.po.ClassName;
import com.po.TeachingPlan;

/**
 * ClassName: TeachingPlanDao 
 * @Description: 定义接口
 * @author Victor
 * @date 2017年6月29日
 */
public interface TeachingPlanDao {
	
	//添加教学计划
	public boolean addTeachingPlan(TeachingPlan obj);
	//修改教学计划
	public boolean updateTeachingPlan(TeachingPlan obj);
	//删除教学计划
	public boolean deleteTeachingPlan(TeachingPlan obj);
	//查询全部教学计划
	public List<TeachingPlan> queryAllTeachingPlan();
	//通过id号查询教学计划
	public List<TeachingPlan> queryTeachingPlanById(int id);
	//通过学年学期查询教学计划
	public List<TeachingPlan> queryTeachingPlanByYears(String years);
	//通过班级查询教学计划
	public TeachingPlan queryTeachingPlanByClassName(ClassName classname);
	//通过班级和学期共同查询教学计划
	public TeachingPlan queryTeachingPlanByYearsAndClassName(String years, ClassName classname);
	
}
