package egovframework.com.studentMng.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.schoolMng.service.SchoolMngService;
import egovframework.com.studentMng.service.StudentMngService;

@Controller
public class StudentMngController {

	@Resource(name="StudentMngService")
	private StudentMngService studentMngService;
	
	@Resource(name="SchoolMngService")
	private SchoolMngService schoolMngService;

	@RequestMapping("/studentMng/getStudentMngList.do")
	public String getStudentMngList() {
		return "studentMng/studentMngList";
	}
	
	

	@RequestMapping("/studentMng/selectStudentMngList.do")
	public ModelAndView selectStudentMngList() {
		ModelAndView mv = new ModelAndView();

		List<HashMap<String, Object>> list = studentMngService.selectStudentMngList();

		mv.addObject("list", list);
		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/studentMng/detailstudentMngList.do") 
	public ModelAndView detailStudentMngList(@RequestParam(name="studentId") int studentId) {

		ModelAndView mv = new ModelAndView("studentMng/studentMngInfo");
System.out.println(1);
		HashMap<String, Object> studentInfo = studentMngService.detailStudentMngList(studentId);
		System.out.println(2);
		mv.addObject("studentInfo",studentInfo);

		return mv; 
	}
	
	/*
	@RequestMapping("/studentMng/getStudentMngInfo.do")
	public String getStudentMngInfo(
			@RequestParam HashMap<String, Object> paramMap,
			Model model) {
		
		if(!paramMap.isEmpty()) {
			int studentId = Integer.parseInt(paramMap.get("studentId").toString());
			HashMap<String, Object> studentInfo = studentMngService.selectStudentMngInfo(studentId);
			model.addAttribute("studentInfo", studentInfo);
		}
		
		return "studentMng/studentMngDetail";
	}
	
	public ModelAndView getStudentMngInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		if(!paramMap.isEmpty()) {
			int studentId = Integer.parseInt(paramMap.get("studentId").toString());
			HashMap<String, Object> studentInfo = studentMngService.selectStudentMngInfo(studentId);
			mv.addObject("studentInfo", studentInfo);
		}
		
		mv.setViewName("studentMng/studentMngDetail");
		return mv;
	}
	*/

	@RequestMapping("/studentMng/registStudentMng.do")
	public String registStudentMng(Model model) {
		
		List<HashMap<String, Object>> schoolList = schoolMngService.selectSchoolList();
		model.addAttribute("schoolList", schoolList);
		
		return "studentMng/studentMngRegister";
	}

	@RequestMapping("/studentMng/insertStudentMng.do")
	public ModelAndView insertStudentMng(@RequestParam HashMap<String, Object> paramMap ) {
		
		ModelAndView mv = new ModelAndView();
		int resultChk= 0;
		resultChk = studentMngService.insertStudentMng(paramMap);
		
		// System.out.println(paramMap.toString());
		mv.addObject("resultChk",resultChk);
		mv.setViewName("jsonView");
		return mv; 
	}
	
}

