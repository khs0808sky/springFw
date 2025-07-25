package app.labs.ex05.jdbc01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate; // preparedStatement 기반
	
	// table column과 vo seter Mapping class
	// 행마다 실행되는 mapRow 메서드 사용 가능
    private class EmpMapper implements RowMapper<EmpVO> {
        @Override
        public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmpVO emp = new EmpVO();
            emp.setEmployeeId(rs.getInt("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setJobId(rs.getString("job_id"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setCommissionPct(rs.getDouble("commission_pct"));
            emp.setManagerId(rs.getInt("manager_id"));
            emp.setDepartmentId(rs.getInt("department_id"));
            return emp;
        }
    }
	
	@Override
	public int getEmpCount() {
		String sql = "select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptId) {
		String sql = "select count(*) from employees where department_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {
		String sql = "select * from employees";
		return jdbcTemplate.query(sql, new EmpMapper()); // EmpMapper : 행단위로 실행
	}

	@Override
	public EmpVO getEmpInfo(int empId) {
		String sql = "select * from employees where employee_id=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empId);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "insert into employees"
				+ "(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)"
				+ "values "
				+ "(?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql,
				emp.getEmployeeId(),
				emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getPhoneNumber(),
                emp.getJobId(),
                emp.getSalary(),
                emp.getCommissionPct(),
                emp.getManagerId(),
                emp.getDepartmentId()			
				);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		String sql = "update employees "
				+ "set first_name = ?, last_name = ?, email=?, salary=? "
				+ "where employee_id = ?";
		
		jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getSalary(),
				emp.getEmployeeId());

	}

	@Override
	public int deleteEmp(int empId, String email) {
		String sql = "delete from employees "
				+ "where employee_id = ? and email = ?";
		return jdbcTemplate.update(sql, empId, email);
	}

	@Override
	public void deleteJobHistory(int empId) {
		String sql = "delete from job_history "
				+ "where employee_id = ?";
		jdbcTemplate.update(sql, empId);
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "select department_id as departmentId, department_name as departmentName\r\n"
				+ "from departments";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "select job_id as jobId, job_title as jobTitle from jobs";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "select distinct e1.manager_id, e2.first_name as manager_name "
				+ "from employees e1 "
				+ "join employees e2 on e2.employee_id =  e1.manager_id "
				+ "order by e1.manager_id";
		
		return jdbcTemplate.queryForList(sql);
	}

}
