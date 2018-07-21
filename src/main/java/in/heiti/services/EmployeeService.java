package in.heiti.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.heiti.core.GenericResponse;
import in.heiti.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public GenericResponse registerEmployee(Employee employee) {
		
		if(employeeRepo.findOneByFingerprint(employee.getFingerprint())!=null)
			return GenericResponse.status(false, "Employee already registered");
		else {
			employeeRepo.save(employee);
			return GenericResponse.status(true, "Registered successfully");
		}
		
	}
	
	public Employee getEmployeeFromId(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent())
			return emp.get();
		else
			return null;
	}
	
	public Iterable<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

}
