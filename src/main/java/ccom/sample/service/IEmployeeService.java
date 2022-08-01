package ccom.sample.service;

import ccom.sample.entity.EmployeeEntity;
import ccom.sample.entity.EmployeeRecords;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeEntity> findpaginated(Integer pageNo, Integer pageSize , String sortBy);
}
