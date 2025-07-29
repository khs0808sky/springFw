package app.labs.ex08.mybatis.hr.service;

import java.util.List;
import java.util.Map;

import app.labs.ex08.mybatis.hr.model.EmpVO;


public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptId);
	
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empId);
	
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	int deleteEmp(int empId, String email);
	
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
