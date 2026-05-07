package com.example.demo3.emp.controller;

import com.example.demo3.common.ApiResponse;
import com.example.demo3.emp.dto.EmpDTO;
import com.example.demo3.emp.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @GetMapping("/detail/{empno}")
    public ResponseEntity<ApiResponse<EmpDTO>> detail(
            @PathVariable("empno") int empno){

        log.info("empno = [{}]", empno);

        EmpDTO dto = empService.getEmpDetail(empno);

        if(dto == null){
            throw new RuntimeException("데이터 없음");
        }

        return ResponseEntity.ok(
                ApiResponse.success(dto)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmpDTO>>> getList() {

        List<EmpDTO> list = empService.getEmpList();

        return ResponseEntity.ok(
                ApiResponse.success(list)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> insertEmp(
            @RequestBody EmpDTO dto){

        log.info("dto = [{}]", dto);

        empService.insertEmp(dto);

        return ResponseEntity.ok(
                ApiResponse.success("등록 성공")
        );
    }
}