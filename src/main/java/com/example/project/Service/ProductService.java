package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderItemDTO;
import com.example.project.DTO.ProductDTO;
import com.example.project.Entity.OrderItem;
import com.example.project.Entity.Product;
import com.example.project.Repository.OrderItemRepository;
import com.example.project.Repository.ProductRepository;
import com.example.project.Service.Imp.ProductImp;
import com.example.project.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductImp {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<ProductDTO>> getAllProduct() {
        BaseResponse<List<ProductDTO>> baseResponse = new BaseResponse<>();
        List<ProductDTO> productDTOList = new ArrayList<>();
        try {
            List<Product> productList = productRepository.findAll();
            if (productList.isEmpty() || productList == null) {
                baseResponse.setMessage("Không tồn tại sản phẩm!");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (Product product : productList) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(product.getProductId());
                productDTO.setPrice(product.getPrice());
                productDTO.setUpdatedAt(product.getUpdatedAt());
                productDTO.setName(product.getName());
                productDTO.setImage(product.getImage());
                productDTO.setCreatedAt(product.getCreatedAt());
                productDTO.setQuantity(product.getQuantity());
                productDTO.setActive(product.getActive());
                productDTO.setDescription(product.getDescription());
                productDTOList.add(productDTO);
            }
            baseResponse.setData(productDTOList);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> getProductById(Long productId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null) {
                baseResponse.setMessage("Id không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            ProductDTO productDTO = new ProductDTO();
            productDTO.setPrice(product.getPrice());
            productDTO.setUpdatedAt(product.getUpdatedAt());
            productDTO.setName(product.getName());
            productDTO.setImage(product.getImage());
            productDTO.setCreatedAt(product.getCreatedAt());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setActive(product.getActive());
            productDTO.setDescription(product.getDescription());
            List<OrderItem> orderItemList = new ArrayList<>(product.getOrderItems());
            List<OrderItemDTO> orderItemDTOList = orderItemList
                    .stream()
                    .map(orderItem -> convertRelationship.convertToOrderItemDTO(orderItem))
                    .collect(Collectors.toList());
            productDTO.setOrderItems(orderItemDTOList);
            baseResponse.setData(productDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(404);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quà trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> addProduct(ProductDTO productDTO, Long orderItemId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            if (orderItemId == null) {
                baseResponse.setMessage("OrderItemId không được để trống");
                baseResponse.setCode(400);
                return baseResponse;
            }
            OrderItem orderItem = orderItemRepository.findOrderItemById(orderItemId);
            if (orderItem == null) {
                baseResponse.setMessage("Hóa đơn không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            Product product = new Product();
            product.setPrice(productDTO.getPrice());
            product.setUpdatedAt(productDTO.getUpdatedAt());
            product.setName(productDTO.getName());
            product.setImage(productDTO.getImage());
            product.setCreatedAt(productDTO.getCreatedAt());
            product.setQuantity(productDTO.getQuantity());
            product.setActive(productDTO.getActive());
            product.setDescription(productDTO.getDescription());
            List<OrderItem> orderItemList = new ArrayList<>();
            orderItemList.add(orderItem);
            product.setOrderItems(orderItemList);
            Product saveProduct = productRepository.save(product);
            orderItem.setProduct(saveProduct);
            orderItemRepository.save(orderItem);
            ProductDTO saveProductDTO = convertRelationship.convertToProductDTO(saveProduct);
            baseResponse.setData(saveProductDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình thêm Product");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> updateProduct(ProductDTO productDTO, Long productId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null) {
                baseResponse.setMessage("Không tìm thấy " + productId + "nên không thể sửa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            product.setPrice(productDTO.getPrice());
            product.setUpdatedAt(productDTO.getUpdatedAt());
            product.setName(productDTO.getName());
            product.setImage(productDTO.getImage());
            product.setCreatedAt(productDTO.getCreatedAt());
            product.setQuantity(productDTO.getQuantity());
            product.setActive(productDTO.getActive());
            product.setDescription(productDTO.getDescription());
            productRepository.save(product);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình update Product");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> deleteProduct(Long productId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null) {
                baseResponse.setMessage("Không tìm thấy " + productId + "nên không thể xóa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            productRepository.delete(product);
            baseResponse.setMessage("Xóa thành công với sản phâm có id là: " + productId);
            baseResponse.setCode(202);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi khi xóa " + ex.getMessage());
            baseResponse.setCode(404);
        }
        return baseResponse;
    }
}
