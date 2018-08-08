/**  
 * @Title: CourseDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.CourseDao;
import com.po.ClassName;
import com.po.Course;
import com.po.Teacher;

/**
 * ClassName: CourseDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
@Repository("courseDaoImpl")
public class CourseDaoImpl extends BaseDaoImpl implements CourseDao{

	/* (非 Javadoc)
	* <p>Title: addCourse</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.CourseDao#addCourse(com.po.Course)
	*/
	@Override
	public boolean addCourse(Course obj) {
		return super.add(obj);
	}

	/* (非 Javadoc)
	* <p>Title: updateCourse</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.CourseDao#updateCourse(com.po.Course)
	*/
	@Override
	public boolean updateCourse(Course obj) {
		return super.update(obj);
	}

	/* (非 Javadoc)
	* <p>Title: deleteCourse</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.CourseDao#deleteCourse(com.po.Course)
	*/
	@Override
	public boolean deleteCourse(Course obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByCno</p>
	* <p>Description: </p>
	* @param cno
	* @return
	* @see com.dao.CourseDao#queryCourseByCno(java.lang.String)
	*/
	@Override
	public Course queryCourseByCno(String cno) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByCid</p>
	* <p>Description: </p>
	* @param cid
	* @return
	* @see com.dao.CourseDao#queryCourseByCid(int)
	*/
	@Override
	public Course queryCourseByCid(int cid) {
		return (Course) super.query(Course.class, cid);
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByNameAndYears</p>
	* <p>Description: </p>
	* @param name
	* @param years
	* @return
	* @see com.dao.CourseDao#queryCourseByNameAndYears(java.lang.String, java.lang.String)
	*/
	@Override
	public Course queryCourseByNameAndYears(String name, String years) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByYears</p>
	* <p>Description: </p>
	* @param years
	* @return
	* @see com.dao.CourseDao#queryCourseByYears(java.lang.String)
	*/
	@Override
	public List<Course> queryCourseByYears(String years) {
		String hql = "from Course where years = '"+years+"'";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByTeacher</p>
	* <p>Description: </p>
	* @param teacher
	* @return
	* @see com.dao.CourseDao#queryCourseByTeacher(com.po.Teacher)
	*/
	@Override
	public List<Course> queryCourseByTeacher(Teacher teacher) {
		String hql = "from Course where teachers = '"+teacher.gettId()+"'";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByState</p>
	* <p>Description: </p>
	* @param state
	* @return
	* @see com.dao.CourseDao#queryCourseByState(int)
	*/
	@Override
	public List<Course> queryCourseByState(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByStateAndYears</p>
	* <p>Description: </p>
	* @param years
	* @param state
	* @return
	* @see com.dao.CourseDao#queryCourseByStateAndYears(java.lang.String, int)
	*/
	@Override
	public List<Course> queryCourseByStateAndYears(String years, int state) {
		String hql = "from Course where years = '"+years+"' and checkState = "+state;
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByCreditsAndYears</p>
	* <p>Description: </p>
	* @param credits
	* @param years
	* @return
	* @see com.dao.CourseDao#queryCourseByCreditsAndYears(int, java.lang.String)
	*/
	@Override
	public List<Course> queryCourseByCreditsAndYears(int credits, String years) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByClassNameAndYears</p>
	* <p>Description: </p>
	* @param classname
	* @param years
	* @return
	* @see com.dao.CourseDao#queryCourseByClassNameAndYears(com.po.ClassName, java.lang.String)
	*/
	@Override
	public List<Course> queryCourseByClassNameAndYears(ClassName classname,
			String years) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByCategoryAndYears</p>
	* <p>Description: </p>
	* @param category
	* @param years
	* @return
	* @see com.dao.CourseDao#queryCourseByCategoryAndYears(java.lang.String, java.lang.String)
	*/
	@Override
	public List<Course> queryCourseByCategoryAndYears(String category,
			String years) {
		// TODO Auto-generated method stub
		return null;
	}

}
