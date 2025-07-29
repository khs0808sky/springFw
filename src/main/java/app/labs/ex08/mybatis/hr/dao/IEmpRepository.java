package app.labs.ex08.mybatis.hr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import app.labs.ex08.mybatis.hr.model.EmpVO;


// service 계층을 위한 기능설계
public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(@Param("deptId") int deptId);
	
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empId);
	
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	int deleteEmp(@Param("empId") int empId, @Param("email") String email);
	
	void deleteJobHistory(int empId);
	
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
