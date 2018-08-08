/**  
 * @Title: SelectDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.SelectDao;
import com.po.Course;
import com.po.Select;
import com.po.Student;

/**
 * ClassName: SelectDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
@Repository("selectDaoImpl")
public class SelectDaoImpl extends BaseDaoImpl implements SelectDao {

	/* (非 Javadoc)
	* <p>Title: addSelect</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.SelectDao#addSelect(com.po.Select)
	*/
	@Override
	public boolean addSelect(Select obj) {
		
		return super.add(obj);
	}

	/* (非 Javadoc)
	* <p>Title: deleteSelect</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.SelectDao#deleteSelect(com.po.Select)
	*/
	@Override
	public boolean deleteSelect(Select obj) {
		return super.delete(obj);
	}

	/* (非 Javadoc)
	* <p>Title: queryCourseByStudent</p>
	* <p>Description: </p>
	* @param student
	* @return
	* @see com.dao.SelectDao#queryCourseByStudent(com.po.Student)
	*/
	@Override
	public List<Course> queryCourseByStudent(Student student) {
		
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryStudentByCourse</p>
	* <p>Description: </p>
	* @param course
	* @return
	* @see com.dao.SelectDao#queryStudentByCourse(com.po.Course)
	*/
	@Override
	public List<Student> queryStudentByCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryCountByCourse</p>
	* <p>Description: </p>
	* @param course
	* @return
	* @see com.dao.SelectDao#queryCountByCourse(com.po.Course)
	*/
	@Override
	public long queryCountByCourse(Course course) {
		String hql = "select count(*) from Select where course="+course.getcId();
		return (long) super.queryListByHQL(hql).get(0);
	}

	/* (非 Javadoc)
	* <p>Title: querySelectByStudent</p>
	* <p>Description: </p>
	* @param student
	* @return
	* @see com.dao.SelectDao#querySelectByStudent(com.po.Student)
	*/
	@Override
	public List<Select> querySelectByStudent(Student student) {
		String hql = "from Select  where student = '"+student.getsId()+"'";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queerySelectByCourse</p>
	* <p>Description: </p>
	* @param course
	* @return
	* @see com.dao.SelectDao#queerySelectByCourse(com.po.Course)
	*/
	@Override
	public List<Select> querySelectByCourse(Course course) {
		String hql = "from Select where course = '"+course.getcId()+"'";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: querySelectByCourseAndStudent</p>
	* <p>Description: </p>
	* @param course
	* @param student
	* @return
	* @see com.dao.SelectDao#querySelectByCourseAndStudent(com.po.Course, com.po.Student)
	*/
	@Override
	public Select querySelectByCourseAndStudent(Course course,
			Student student) {
		String hql = "from Select where course = '"+course.getcId()+"' and student='"+student.getsId()+"'";
		return (Select) super.queryListByHQL(hql).get(0);
	}

}
