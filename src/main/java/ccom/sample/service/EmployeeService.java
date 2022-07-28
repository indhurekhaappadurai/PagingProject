package ccom.sample.service;

import ccom.sample.entity.EmployeeEntity;
import ccom.sample.entity.EmployeeRecords;
import ccom.sample.repository.EmployeeRecordsRepository;
import ccom.sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeRecordsRepository employeeRecordsRepository;


    public String insert(EmployeeEntity Employee) {
        repository.save(Employee);
        return "Data inserted successfully";

    }

    public List<EmployeeEntity> getAllData() {
        return repository.findAll();
    }

    public List<EmployeeRecords> getAll() {
        return employeeRecordsRepository.findAll();

    }

    @Override
    public List<EmployeeEntity> findpaginated(int pageNo, int pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize);
         Page<EmployeeEntity> pagedResult = repository.findAll(page);
        return pagedResult.toList();
    }

    public List<Object[]> getByColumnName(int pageNo, int pageSize) {
        return employeeRecordsRepository.getByColumn(pageNo,pageSize);


    }

    public List<Object[]> findByColumnName(int pageNo, int pageSize) {
        return employeeRecordsRepository.findByColumn(pageNo,pageSize);


    }

}
