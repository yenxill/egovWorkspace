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

import egovframework.com.board.service.BoardService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BoardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{

	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardList(paramMap);
	}

	@Override
	public int selectBoardListCnt(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardListCnt(paramMap);
	}

	@Override
	public int saveBoard(HashMap<String, Object> paramMap, List<MultipartFile> multipartFile) {
		// TODO Auto-generated method stub
		System.out.println(1);
		int resultChk = 0;
		
		String flag = paramMap.get("statusFlag").toString();

		if("I".equals(flag)) {
			resultChk = boardDAO.insertBoard(paramMap);
		}else if("U".equals(flag)) {
			resultChk = boardDAO.updateBoard(paramMap);
		}
	
		String filePath = "/ictsaeil/egovTest";
		
		System.out.println(multipartFile.get(0).getOriginalFilename());
		
		if(multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {	
			for(MultipartFile file : multipartFile) { // = MultipartFile file = multipartFile.get(0); , 0 부터 multipartFile lentgh까지 돌림
				SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHms");
				Calendar cal = Calendar.getInstance();
				String today = date.format(cal.getTime());
				
				try {
					File fileFolder = new File(filePath);
					
					if(!fileFolder.exists()) {
						if(fileFolder.mkdirs()) { //mkdir: 폴더만 만듦
							System.out.println("[file.mkdirs] : Success"); // mkdirs: 상위 폴더까지 만들어줌
						}
					}
					String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
					File saveFile = new File(filePath, "file_"+today+"."+fileExt); //(filePath, "파일명") 파일 생성
					file.transferTo(saveFile);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultChk;
	}

	@Override
	public HashMap<String, Object> selectBoardDetail(int boardIdx) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardDetail(boardIdx);
	}

	@Override
	public int deleteBoard(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(paramMap);
	}

	@Override
	public int insertReply(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.insertReply(paramMap);
	}

	@Override
	public List<HashMap<String, Object>> selectBoardReply(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardReply(paramMap);
	}


	
}
