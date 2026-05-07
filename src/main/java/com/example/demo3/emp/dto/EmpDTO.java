package com.example.demo3.emp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmpDTO {
	private String ename;
	private String hiredate;
	private int empno;
    private Integer sal;
	private Integer deptno;
	private String job;
	private Integer mgr;
	private Integer comm;
}