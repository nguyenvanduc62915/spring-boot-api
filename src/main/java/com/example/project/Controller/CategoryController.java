package com.example.project.Controller;

import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get/all")
    public ResponseEntity<BaseResponse<List<CategoryDTO>>> getAllCategory() {
        BaseResponse<List<CategoryDTO>> baseResponse = categoryService.getAllCategory();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<CategoryDTO>> getCategoryById(@RequestParam("id") Long productId) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.getCategoryById(productId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<CategoryDTO>> addCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
            @RequestParam Long productId
    ) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.addCategory(categoryDTO, productId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<CategoryDTO>> updateCategory(
            @RequestParam("id") Long id,
            @Valid @RequestBody CategoryDTO categoryDTO) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<CategoryDTO>> deleteAccount(@RequestParam("id") Long id){
        BaseResponse<CategoryDTO> baseResponse = categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
