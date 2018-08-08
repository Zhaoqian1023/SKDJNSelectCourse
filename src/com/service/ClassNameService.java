/**  
 * @Title: ClassNameService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.ClassNameDao;
import com.po.ClassName;

/**
 * ClassName: ClassNameService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
@Service("classNameService")
public class ClassNameService {
	@Autowired
	@Qualifier("classNameDaoImpl")
	private ClassNameDao classNameDao;
	
	public ClassName getClassName(String cName){
		if("".equals(cName) || cName == null){
			return null;
		}
		ClassName className = null;
		List<ClassName> data = classNameDao.queryClassNameByName(cName);
		if(data.size() == 0){
			return null;
		}
		className =data.get(0);
		return className;
	}

}
