package egovframework.com.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("AdminDAO")
public class AdminDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectAdminiList(HashMap<String, Object> paramMap){
		return selectList("selectAdminiList", paramMap);
	}
	
	public int selectadminListCnt(HashMap<String, Object> paramMap) {
		return selectOne("selectadminListCnt", paramMap);
	}

}