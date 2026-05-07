package com.example.demo3.emp.service;

import com.example.demo3.emp.dto.EmpDTO;
import java.util.List;

public interface EmpService {

    List<EmpDTO> getEmpList();

    EmpDTO getEmpDetail(int empno);

    void insertEmp(EmpDTO dto);

    void updateEmp(EmpDTO dto);

    void deleteEmp(int empno);
}