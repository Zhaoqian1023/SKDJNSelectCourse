/**  
 * @Title: TeacherDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dao.TeacherDao;
import com.po.Teacher;

/**
 * ClassName: TeacherDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
@Repository("teacherDaoImpl")
public class TeacherDaoImpl extends BaseDaoImpl implements TeacherDao {

	/* (非 Javadoc)
	* <p>Title: loginValidate</p>
	* <p>Description: </p>
	* @param tId
	* @param pwd
	* @param rank
	* @return
	* @see com.dao.TeacherDao#loginValidate(java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public Teacher loginValidate(String tId, String pwd, int rank) {
		String hql = "from Teacher where tId = "+tId+" and password = '"+pwd+"' and rank = "+rank;
		List data = null;
		data = super.queryListByHQL(hql);
		if(data.size() == 0 ||data == null){
			return null;
		}else{
			return (Teacher) (data.get(0));
		}
	}

	/* (非 Javadoc)
	* <p>Title: addTeacher</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeacherDao#addTeacher(com.po.Teacher)
	*/
	@Override
	public boolean addTeacher(Teacher obj) {
		// TODO Auto-generated method stub
		return super.add(obj);
	}

	/* (非 Javadoc)
	* <p>Title: updateTeacher</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeacherDao#updateTeacher(com.po.Teacher)
	*/
	@Override
	public boolean updateTeacher(Teacher obj) {
		return super.update(obj);
	}

	/* (非 Javadoc)
	* <p>Title: deleteTeacher</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.TeacherDao#deleteTeacher(com.po.Teacher)
	*/
	@Override
	public boolean deleteTeacher(Teacher obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryAllTeacher</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.TeacherDao#queryAllTeacher()
	*/
	@Override
	public List<Teacher> queryAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryTeacherByRank</p>
	* <p>Description: </p>
	* @param rank
	* @return
	* @see com.dao.TeacherDao#queryTeacherByRank(int)
	*/
	@Override
	public List<Teacher> queryTeacherByRank(int rank) {
		String hql = "from Teacher where rank = "+rank;
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryTeacherByTeacherid</p>
	* <p>Description: </p>
	* @param teacherId
	* @return
	* @see com.dao.TeacherDao#queryTeacherByTeacherid(int)
	*/
	@Override
	public Teacher queryTeacherByTeacherid(int teacherId) {
		String hql = "from Teacher where tId="+teacherId;
		List data = null;
		data = super.queryListByHQL(hql);
		if(data.size() == 0 ||data == null){
			return null;
		}else{
			return (Teacher) (data.get(0));
		}
	}

	/* (非 Javadoc)
	* <p>Title: queryTeacherByDept</p>
	* <p>Description: </p>
	* @param dept
	* @return
	* @see com.dao.TeacherDao#queryTeacherByDept(java.lang.String)
	*/
	@Override
	public List<Teacher> queryTeacherByDept(String dept) {
		// TODO Auto-generated method stub
		return null;
	}

}
