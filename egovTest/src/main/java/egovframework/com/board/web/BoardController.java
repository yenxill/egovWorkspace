package egovframework.com.board.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.board.service.BoardService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	@RequestMapping("/board/boardList.do")
	public String boardList(HttpSession session, Model model) {
		HashMap<String, Object> loginInfo = null;
		loginInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		if(loginInfo != null) {
			model.addAttribute("loginInfo", loginInfo);
			return "board/boardList";
		}else {
			return "redirect:/login.do";
		}
	}
	
	@RequestMapping("/board/selectBoardList.do")
	public ModelAndView selectBoardList(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		paginationInfo.setRecordCountPerPage(10); 
		paginationInfo.setPageSize(10); //페이지 수 
		
		paramMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
		paramMap.put("lastIndex", paginationInfo.getLastRecordIndex());
		paramMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
		List <HashMap<String, Object>> list = boardService.selectBoardList(paramMap);
		int totCnt = boardService.selectBoardListCnt(paramMap);
		paginationInfo.setTotalRecordCount(totCnt);
		
		mv.addObject("list",list);
		mv.addObject("totCnt",totCnt);
		mv.addObject("paginationInfo", paginationInfo);
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping("/board/boardDetail.do")
	public String boardDetail(@RequestParam(name="boardIdx") int boardIdx, Model model, HttpSession session) {
		HashMap<String, Object> loginInfo = null;
		loginInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		
		if(loginInfo != null) {
			
			HashMap<String, Object> boardInfo = boardService.selectBoardDetail(boardIdx);
			model.addAttribute("boardIdx", boardIdx);
			model.addAttribute("boardInfo", boardInfo);
			model.addAttribute("loginInfo", loginInfo);
			return "board/boardDetail";
		
		
		}else {
			return "redirect:/login.do";
		}

	}
	
	@RequestMapping("/board/getBoardDetail.do")
	public ModelAndView getBoardDetail(@RequestParam(name="boardIdx") int boardIdx) {
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, Object> boardInfo = boardService.selectBoardDetail(boardIdx);
		
		
		mv.addObject("boardInfo", boardInfo);
		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping("/board/registBoard.do")
	public String registBoard(HttpSession session, Model model, @RequestParam HashMap<String, Object> paramMap ) {
		HashMap<String, Object> loginInfo = null;
		loginInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		if(loginInfo != null) {
			String  flag = paramMap.get("flag").toString();
			
			model.addAttribute("flag", flag); // flag : 등록과 수정 구분 값
			
			if("U".equals(flag)) {
				model.addAttribute("boardIdx", paramMap.get("boardIdx").toString());
			}
			
			return "board/registBoard";
			
		} else {
			
			return "redirect:/login.do";
		}
		
	}
	
	@RequestMapping("/board/saveBoard.do")
	public ModelAndView saveBoard(@RequestParam HashMap<String, Object> paramMap
			,@RequestParam(name="fileList") List<MultipartFile> multipartFile
			, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int resultChk = 0;

		//session 정보 가져오기
		HashMap<String, Object> sessionInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		paramMap.put("memberId", sessionInfo.get("id").toString());
		System.out.println(1);
		System.out.println(paramMap.toString());
		resultChk = boardService.saveBoard(paramMap, multipartFile);
		
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");
		return mv;
	}
 
	@RequestMapping("/board/deleteBoard.do")
	public ModelAndView deleteBoard(@RequestParam HashMap<String, Object> paramMap
			, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int resultChk = 0;
		
		HashMap<String, Object> sessionInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		paramMap.put("memberId", sessionInfo.get("id").toString());

		resultChk = boardService.deleteBoard(paramMap);
		
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping("/board/saveBoardReply.do")
	public ModelAndView saveBoardReply(@RequestParam HashMap<String, Object> paramMap, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		
		HashMap<String, Object> sessionInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		paramMap.put("memberId", sessionInfo.get("id").toString());
		
		int resultChk = 0;
		
		resultChk = boardService.insertReply(paramMap);
		
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	@RequestMapping("/board/getBoardReply.do")
	public ModelAndView getBoardReply(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		List<HashMap<String, Object>> replyList = boardService.selectBoardReply(paramMap);
		
		mv.addObject("replyList", replyList);
		mv.setViewName("jsonView");
		return mv;
		
	}
	

}
