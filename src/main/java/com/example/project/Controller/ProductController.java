package com.example.project.Controller;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.ProductDTO;
import com.example.project.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/get/all")
    public ResponseEntity<BaseResponse<List<ProductDTO>>> getAllProduct(){
        BaseResponse<List<ProductDTO>> baseResponse = productService.getAllProduct();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<ProductDTO>> getProductById(@RequestParam("id") Long productId){
        BaseResponse<ProductDTO> baseResponse = productService.getProductById(productId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ProductDTO>> addProduct(
            @Valid @RequestBody ProductDTO productDTO,
            @RequestParam("id") Long id
    ) {
        BaseResponse<ProductDTO> baseResponse = productService.addProduct(productDTO, id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<ProductDTO>> updateProduct(
            @RequestParam("id") Long id,
            @Valid @RequestBody ProductDTO productDTO
    ) {
        BaseResponse<ProductDTO> baseResponse = productService.addProduct(productDTO,id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
