package com.example.project.Controller;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.PaymentMethodDTO;
import com.example.project.Service.PaymentMethodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/paymentMethod")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse<List<PaymentMethodDTO>>> getAllPaymentMethod() {
        BaseResponse<List<PaymentMethodDTO>> baseResponse = paymentMethodService.getAllPaymentMethod();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<PaymentMethodDTO>> getPaymentMethodById(@RequestParam("id") Long paymentMethodId){
        BaseResponse<PaymentMethodDTO> baseResponse = paymentMethodService.getPaymentMethodById(paymentMethodId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<PaymentMethodDTO>> addPaymentMethod(
            @Valid @RequestBody PaymentMethodDTO paymentMethodDTO
    ) {
        BaseResponse<PaymentMethodDTO> baseResponse = paymentMethodService.addPaymentMethod(paymentMethodDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<PaymentMethodDTO>> updatePaymentMethod(
            @RequestParam("id") Long paymentMethodId,
            @Valid @RequestBody PaymentMethodDTO paymentMethodDTO
    ) {
        BaseResponse<PaymentMethodDTO> baseResponse = paymentMethodService.updatePaymentMethod(paymentMethodDTO, paymentMethodId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<PaymentMethodDTO>> deletePaymentMethod(@RequestParam("id") Long paymentMethodId){
        BaseResponse<PaymentMethodDTO> baseResponse = paymentMethodService.deletePaymentMethod(paymentMethodId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
