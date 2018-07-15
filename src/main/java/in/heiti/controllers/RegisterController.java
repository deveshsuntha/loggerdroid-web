package in.heiti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.heiti.entity.Employee;
import in.heiti.entity.Register;
import in.heiti.services.EmployeeService;
import in.heiti.services.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private RegisterService regService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public boolean registerEmployee(@RequestBody Employee emp) {
		
		empService.registerEmployee(emp);
		return true;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/log/{fingerprint}")
	public boolean logAttendance(@PathVariable String fingerprint) {
		
		return regService.logAttendance(fingerprint);
	}
	
	@CrossOrigin(origins= {"http://localhost:8080"})
	@RequestMapping(method=RequestMethod.GET, value="/getTodaysLogs")
	public List<Register> getTodaysLogs() {
		
		return regService.getTodaysLogs();
	}
	

}
