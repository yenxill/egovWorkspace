package egovframework.com.board.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.board.service.AdminService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("AdminService")
public class AdminServiceImpl extends EgovAbstractServiceImpl implements AdminService {

	@Resource(name="AdminDAO")
	private AdminDAO adminDAO;

	@Override
	public List<HashMap<String, Object>> selectAdminiList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return adminDAO.selectAdminiList(paramMap);
	}

	@Override
	public int selectadminListCnt(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return adminDAO.selectadminListCnt(paramMap);
	}

}