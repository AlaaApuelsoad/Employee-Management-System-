package com.qnetemployee.qnetdemo.repository;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnetEmployeeRepository extends JpaRepository<QnetEmployee,Integer> {

    //add method to sort by last name
    //public List<QnetEmployee> findAllByOrderByLastNameAsc();
}
