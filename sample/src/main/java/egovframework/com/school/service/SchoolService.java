package egovframework.com.school.service;

import java.util.HashMap;
import java.util.List;

public interface SchoolService {

	//선언
	public List<HashMap<String, Object>> selectSchoolList();
	
	//호출
	public HashMap<String, Object> selectSchoolInfo(int schoolIdx);

	public int insertSchoolInfo(HashMap<String, Object> paramMap);

	public int deleteSchoolInfo(int schoolIdx);
}
