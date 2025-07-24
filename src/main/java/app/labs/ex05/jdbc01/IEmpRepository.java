package app.labs.ex05.jdbc01;

import java.util.List;
import java.util.Map;

// service 계층을 위한 기능설계
public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptId);
	
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empId);
	
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	int deleteEmp(int empId, String email);
	
	void deleteJobHistory(int empId);
	
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
