package in.heiti.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.heiti.core.GenericResponse;
import in.heiti.entity.Employee;
import in.heiti.entity.Register;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public GenericResponse logAttendance(String fingerprint) {
		
		Employee emp = employeeRepo.findOneByFingerprint(fingerprint);
		
		if(emp != null) {
			
			Register register = registerRepo.findBylogDateAndEmployee(new Date(), emp);
			
			if(register == null) {
				
				Register reg = new Register(emp);
				reg.setInTime(new Date());
				reg.setLogDate(new Date());
				registerRepo.save(reg);
				return GenericResponse.status(true, "Swipe in registered");
			} else {
				
				register.setOutTime(new Date());
				registerRepo.save(register);
				return GenericResponse.status(true, "Swipe out registered");
			}
				
			
		} else
		return GenericResponse.status(false, "Employee not registered");
	}

	public List<Register> getTodaysLogs() {
		
		return registerRepo.findAllBylogDate(new Date());
	}

	

}
