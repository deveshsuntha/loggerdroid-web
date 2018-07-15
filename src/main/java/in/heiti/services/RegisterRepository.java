package in.heiti.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.heiti.entity.Employee;
import in.heiti.entity.Register;

public interface RegisterRepository extends CrudRepository<Register, Integer> {

	Register findBylogDateAndEmployee(Date logDate, Employee emp);

	List<Register> findAllBylogDate(Date date);

	
}
