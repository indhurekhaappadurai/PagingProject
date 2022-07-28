package ccom.sample.repository;


import ccom.sample.entity.EmployeeRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRecordsRepository extends JpaRepository<EmployeeRecords, Integer> {

    public static final String FIND_ACCEPTINGCOLUMN = "SELECT accepting_records FROM mock_data LIMIT :pageNo,:pageSize";

    public static  final  String FIND_REJECTINGCOLUMN = "select rejecting_records FROM mock_data LIMIT :pageNo, :pageSize";
    @Query(value = FIND_ACCEPTINGCOLUMN, nativeQuery = true)
    List<Object[]> getByColumn(@Param(value = "pageNo") int pageNo, @Param("pageSize") int pageSize);

   @Query(value = FIND_REJECTINGCOLUMN, nativeQuery = true)
    List<Object[]> findByColumn(@Param(value = "pageNo") int pageNo, @Param("pageSize") int pageSize);



}