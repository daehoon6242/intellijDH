package com.example.demo3.emp.service;

import com.example.demo3.emp.dto.EmpDTO;
import com.example.demo3.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<EmpDTO> getEmpList() {
        return empMapper.selectEmpList();
    }

    @Override
    public EmpDTO getEmpDetail(int empno) {
        return empMapper.selectEmpDetail(empno);
    }

    @Override
    public void insertEmp(EmpDTO dto) {
        empMapper.insertEmp(dto);
    }

    @Override
    public void updateEmp(EmpDTO dto) {
        empMapper.updateEmp(dto);
    }

    @Override
    public void deleteEmp(int empno) {empMapper.deleteEmp(empno);}

}