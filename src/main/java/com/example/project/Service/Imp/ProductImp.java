package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.ProductDTO;

import java.util.List;

public interface ProductImp {
    BaseResponse<List<ProductDTO>> getAllProduct();
    BaseResponse<ProductDTO> getProductById(Long productId);
    BaseResponse<ProductDTO> addProduct(ProductDTO productDTO, Long orderItemId);
    BaseResponse<ProductDTO> updateProduct(ProductDTO productDTO, Long productId);
    BaseResponse<ProductDTO> deleteProduct(Long productId);
}
