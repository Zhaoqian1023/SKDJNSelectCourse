/**  
 * @Title: StudentDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.po.ClassName;
import com.po.Student;

/**
 * ClassName: StudentDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
@Repository("studentDaoImpl")
public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {

	/* (非 Javadoc)
	* <p>Title: addStudent</p>
	* <p>Description: </p>
	* @param student
	* @return
	* @see com.dao.StudentDao#addStudent(com.po.Student)
	*/
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return super.add(student);
	}

	/* (非 Javadoc)
	* <p>Title: updateStudent</p>
	* <p>Description: </p>
	* @param student
	* @return
	* @see com.dao.StudentDao#updateStudent(com.po.Student)
	*/
	@Override
	public boolean updateStudent(Student student) {
		
		return super.update(student);
	}

	/* (非 Javadoc)
	* <p>Title: deleteStudent</p>
	* <p>Description: </p>
	* @param student
	* @return
	* @see com.dao.StudentDao#deleteStudent(com.po.Student)
	*/
	@Override
	public boolean deleteStudent(Student student) {
		return super.delete(student);
	}

	/* (非 Javadoc)
	* <p>Title: loginValidate</p>
	* <p>Description: </p>
	* @param sId
	* @param pwd
	* @return
	* @see com.dao.StudentDao#loginValidate(java.lang.String, java.lang.String)
	*/
	@Override
	public Student loginValidate(String sId, String pwd) {
		String hql = "from Student where sId ='"+sId+"' and password='"+pwd+"'";
		List data = null;
		data = super.queryListByHQL(hql);
		if(data.size() == 0 ||data == null){
			return null;
		}else{
			return (Student) data.get(0);
		}
	}

	/* (非 Javadoc)
	* <p>Title: queryAllStudent</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.StudentDao#queryAllStudent()
	*/
	@Override
	public List<Student> queryAllStudent() {
		String hql = "from Student";
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryStudentBySid</p>
	* <p>Description: </p>
	* @param sid
	* @return
	* @see com.dao.StudentDao#queryStudentBySid(int)
	*/
	@Override
	public Student queryStudentBySid(String sid) {
		String hql = "from Student where sId = '"+sid+"'";
		List data = null;
		data = super.queryListByHQL(hql);
		if(data.size() == 0 || data == null){
			return null;
		}else{
			return (Student) data.get(0);
		}
	}

	/* (非 Javadoc)
	* <p>Title: queryStudentByClassName</p>
	* <p>Description: </p>
	* @param classname
	* @return
	* @see com.dao.StudentDao#queryStudentByClassName(com.po.ClassName)
	*/
	@Override
	public List<Student> queryStudentByClassName(ClassName classname) {
		String hql = "from Student where className="+classname.getcId();
		return super.queryListByHQL(hql);
	}

	/* (非 Javadoc)
	* <p>Title: queryStudentByState</p>
	* <p>Description: </p>
	* @param state
	* @return
	* @see com.dao.StudentDao#queryStudentByState(java.lang.String)
	*/
	@Override
	public List<Student> queryStudentByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
