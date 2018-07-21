package in.heiti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.heiti.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public void registerEmployee(Employee employee) {
		employeeRepo.save(employee);
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
