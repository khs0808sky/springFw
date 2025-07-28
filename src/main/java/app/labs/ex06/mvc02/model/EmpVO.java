package app.labs.ex06.mvc02.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	
	private int employeeId; // 소문자 변환 : ctrl + shift + 'Y'
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // java.util.Date
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;	
	
}
