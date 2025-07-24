package app.labs.ex05.jdbc01;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpVO {
	
	private int employeeId; // 소문자 변환 : ctrl + shift + 'Y'
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;	
	
}
