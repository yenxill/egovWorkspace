package egovframework.com.studentMng.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("StudentMngDAO")
public class StudentMngDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectStudentMngList(){
		return selectList("selectStudentMngList");
	}
	
	public HashMap<String, Object> detailStudentMngList(int studentId) {
		
		HashMap<String, Object> resultMap = selectOne("detailstudentMngList", studentId);
		System.out.println(resultMap.toString());
		return resultMap;
	}
	
	public int insertStudentMng(HashMap<String, Object> paramMap) {
		return insert("insertStudentMng", paramMap);
	}
	
 
}