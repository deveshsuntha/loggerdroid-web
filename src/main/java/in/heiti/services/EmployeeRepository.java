package in.heiti.services;

import org.springframework.data.repository.CrudRepository;
import in.heiti.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Employee findOneByFingerprint(String fingerprint);
	
	
}
