package com.example.demo3.emp.mapper;

import com.example.demo3.emp.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpMapper {

    List<EmpDTO> selectEmpList();

    EmpDTO selectEmpDetail(int empno);


    void insertEmp(EmpDTO dto);

    void updateEmp(EmpDTO dto);

    void deleteEmp(int empno);
}