package egovframework.com.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AdminService {
	
	public List<HashMap<String, Object>> selectAdminiList(HashMap<String, Object> paramMap);

	public int selectadminListCnt(HashMap<String, Object> paramMap);

}

