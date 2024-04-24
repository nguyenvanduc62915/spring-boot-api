package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.DTO.ProductDTO;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;

public interface CategoryImp {
    BaseResponse<List<CategoryDTO>> getAllCategory();
    BaseResponse<CategoryDTO> getCategoryById(Long categoryId);
    BaseResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO, Long productId);
    BaseResponse<CategoryDTO> updateCategory(Long categoryId, CategoryDTO categoryDTO);
    BaseResponse<CategoryDTO> deleteCategoryById(Long categoryId);
}
