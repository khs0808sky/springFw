package app.labs.ex08.mybatis.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.labs.ex08.mybatis.hr.model.EmpVO;
import app.labs.ex08.mybatis.hr.service.IEmpService;


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
	
	@RequestMapping(value="/hr/update", method=RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		empService.getEmpInfo(empid);		
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		
		return "hr/updateform";
	}	
	
	@RequestMapping(value="/hr/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, RedirectAttributes redirectAttributes) {
		
		try {
			empService.updateEmp(emp);
			String msg = emp.getEmployeeId() + "번 사원정보가 수정되었습니다.";
			redirectAttributes.addFlashAttribute("message", msg);
		} catch (Exception ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		return "redirect:/hr/list";
	}
	
	@RequestMapping(value="/hr/delete", method=RequestMethod.GET)
	public String deleteEmp(int empid, Model model) {		
		model.addAttribute("emp", empService.getEmpInfo(empid));
		
		return "hr/deleteform";
	}
	
	@RequestMapping(value="/hr/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid, String email, RedirectAttributes redirectAttributes, Model model) {
		
		try {
			int cnt = empService.deleteEmp(empid, email);
			
			if (cnt > 0) {
				String msg = empid + "번 사원정보가 삭제되었습니다.";
				redirectAttributes.addFlashAttribute("message", msg);
				return "redirect:/hr/list";
			} else {
				String msg = "사원번호 또는 이메일이 일치하지 않습니다.";
				model.addAttribute("message", msg);
				model.addAttribute("emp", empService.getEmpInfo(empid));
				
				return "hr/deleteform";
			}
		} catch (Exception ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		
		return "redirect:/hr/list";
	}
	
	@RequestMapping(value="/hr/json")
	public @ResponseBody List<EmpVO> getEmpJSONList() {
		return empService.getEmpList();
	}
	
	@RequestMapping(value="/hr/json/{employeeId}")
	public @ResponseBody EmpVO getEmpJSONInfo(@PathVariable int employeeId, Model model) {
		return empService.getEmpInfo(employeeId);
	}
}

