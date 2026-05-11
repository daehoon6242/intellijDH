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

    // 1. 직원 정보 수정 (PUT)
    @PutMapping("/{empno}")
    public ResponseEntity<ApiResponse<String>> updateEmp(
            @PathVariable("empno") int empno,
            @RequestBody EmpDTO dto) {

        log.info("update empno = [{}], dto = [{}]", empno, dto);

        // URL로 넘어온 사원번호를 DTO에 확실하게 세팅 (데이터 불일치 방지용 안전장치)
        dto.setEmpno(empno);

        // Service 계층의 수정 로직 호출
        empService.updateEmp(dto);

        return ResponseEntity.ok(
                ApiResponse.success("수정 성공")
        );
    }

    // 2. 직원 정보 삭제 (DELETE)
    @DeleteMapping("/{empno}")
    public ResponseEntity<ApiResponse<String>> deleteEmp(
            @PathVariable("empno") int empno) {

        log.info("delete empno = [{}]", empno);

        // Service 계층의 삭제 로직 호출
        empService.deleteEmp(empno);

        return ResponseEntity.ok(
                ApiResponse.success("삭제 성공")
        );
    }


}