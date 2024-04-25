package com.example.project.Service;

import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.DTO.ProductDTO;
import com.example.project.Entity.Account;
import com.example.project.Entity.Category;
import com.example.project.Entity.Product;
import com.example.project.Repository.CategoryRepository;
import com.example.project.Repository.ProductRepository;
import com.example.project.Service.Imp.CategoryImp;
import com.example.project.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryImp {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<CategoryDTO>> getAllCategory() {
        BaseResponse<List<CategoryDTO>> baseResponse = new BaseResponse<>();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        try {
            List<Category> categoryList = categoryRepository.findAll();
            if (categoryList.isEmpty() || categoryList == null){
                baseResponse.setMessage("Không tồn tại danh mục");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (Category category : categoryList){
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryId(category.getCategoryId());
                categoryDTO.setName(category.getName());
                categoryDTO.setCreatedAt(category.getCreatedAt());
                categoryDTO.setUpdatedAt(category.getUpdatedAt());
                List<Product> productList = new ArrayList<>(category.getProducts());
                List<ProductDTO> productDTOList = productList
                        .stream()
                        .map(product -> convertRelationship.convertToProductDTO(product))
                        .collect(Collectors.toList());
                categoryDTO.setProducts(productDTOList);
                categoryDTOList.add(categoryDTO);
            }
            baseResponse.setData(categoryDTOList);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> getCategoryById(Long categoryId) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = categoryRepository.findCategoriesById(categoryId);
            if (category == null){
                baseResponse.setMessage("Id không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setName(category.getName());
            categoryDTO.setCreatedAt(category.getCreatedAt());
            categoryDTO.setUpdatedAt(category.getUpdatedAt());
            List<Product> productList = new ArrayList<>(category.getProducts());
            List<ProductDTO> productDTOList = productList
                    .stream()
                    .map(product -> convertRelationship.convertToProductDTO(product))
                    .collect(Collectors.toList());
            categoryDTO.setProducts(productDTOList);
            baseResponse.setData(categoryDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO, Long productId) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            if (productId == null) {
                baseResponse.setMessage("ProductId không được để trống");
                baseResponse.setCode(400);
                return baseResponse;
            }

            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage("Sản phẩm không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }

            Category category = new Category();
            category.setName(categoryDTO.getName());
            category.setCreatedAt(categoryDTO.getCreatedAt());
            category.setUpdatedAt(categoryDTO.getUpdatedAt());
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            category.setProducts(productList);
            Category saveCategory = categoryRepository.save(category);
            product.setCategory(saveCategory);
            productRepository.save(product);
            CategoryDTO saveCategoryDTO = convertRelationship.convertToCategoryDTO(saveCategory);
            baseResponse.setData(saveCategoryDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình thêm Category");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }


    @Override
    public BaseResponse<CategoryDTO> updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = categoryRepository.findCategoriesById(categoryId);
            if (category == null) {
                baseResponse.setMessage("Không tìm thấy " + categoryId + "nên không thể sửa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            category.setName(categoryDTO.getName());
            category.setCreatedAt(categoryDTO.getCreatedAt());
            category.setUpdatedAt(categoryDTO.getUpdatedAt());
            categoryRepository.save(category);
            baseResponse.setData(categoryDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình update Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> deleteCategoryById(Long categoryId) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = categoryRepository.findCategoriesById(categoryId);
            if (category == null){
                baseResponse.setData(null);
                baseResponse.setMessage("Không tìm thấy " + category + " nên không thể xóa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            categoryRepository.delete(category);
            baseResponse.setMessage("Xóa thành công với danh mục có id là: " + categoryId);
            baseResponse.setCode(202);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi khi xóa " + ex.getMessage());
            baseResponse.setCode(404);
        }
        return baseResponse;
    }
}
