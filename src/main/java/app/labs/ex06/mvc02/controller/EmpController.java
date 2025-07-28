package app.labs.ex06.mvc02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.labs.ex06.mvc02.model.EmpVO;
import app.labs.ex06.mvc02.service.IEmpService;

@Controller
public class EmpController {
	@Autowired
	IEmpService empService;
	
	// 1. 메서드 생성 > 2. url 매핑 > 3. view 생성
	// 4. 결과를 model에 담아서 view에게 전달한다.
	@RequestMapping(value="/hr/count")
	public String empCount(@RequestParam(value="deptid", required=false, defaultValue="0")
							int deptId, Model model) {
		
		if (deptId == 0) {
			model.addAttribute("count", empService.getEmpCount());
		} else {
			model.addAttribute("count", empService.getEmpCount(deptId));
		}
		
		return "hr/count";
	}
	
	@RequestMapping(value="/hr/list")
	public String empAllList(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		
		model.addAttribute("empList", empList);
		
		return "hr/list";
	}
	
	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		
		model.addAttribute("emp", emp);
		
		return "hr/view";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		
		return "hr/insertform";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.POST)
	public String insertEmp(EmpVO emp, RedirectAttributes redirectAttributes) {
		
		try {
			empService.insertEmp(emp);
			String msg = emp.getEmployeeId() + "번 사원정보가 입력되었습니다.";
			redirectAttributes.addFlashAttribute("message", msg);
		} catch (Exception ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		return "redirect:/hr/list";
	}
}
