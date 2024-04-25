package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.PaymentMethodDTO;

import java.util.List;

public interface PaymentMethodImp {
    BaseResponse<List<PaymentMethodDTO>> getAllPaymentMethod();
    BaseResponse<PaymentMethodDTO> getPaymentMethodById(Long paymentMethodId);
    BaseResponse<PaymentMethodDTO> addPaymentMethod(PaymentMethodDTO paymentMethodDTO);
    BaseResponse<PaymentMethodDTO> updatePaymentMethod(PaymentMethodDTO paymentMethodDTO, Long paymentMethodId);
    BaseResponse<PaymentMethodDTO> deletePaymentMethod(Long paymentMethodId);
}
