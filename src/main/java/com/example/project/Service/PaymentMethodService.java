package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.PaymentMethodDTO;
import com.example.project.Entity.PaymentMethod;
import com.example.project.Repository.PaymentMethodRepository;
import com.example.project.Service.Imp.PaymentMethodImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentMethodService implements PaymentMethodImp {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public BaseResponse<List<PaymentMethodDTO>> getAllPaymentMethod() {
        BaseResponse<List<PaymentMethodDTO>> baseResponse = new BaseResponse<>();
        List<PaymentMethodDTO> paymentMethodDTOList = new ArrayList<>();
        try {
            List<PaymentMethod> paymentMethodList = paymentMethodRepository.findAll();
            if (paymentMethodList.isEmpty() || paymentMethodList == null) {
                baseResponse.setMessage("Không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (PaymentMethod paymentMethod : paymentMethodList) {
                PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
                paymentMethodDTO.setPaymentMethodId(paymentMethod.getPaymentMethodId());
                paymentMethodDTO.setName(paymentMethod.getName());
                paymentMethodDTO.setActive(paymentMethod.getActive());
                paymentMethodRepository.save(paymentMethod);
                paymentMethodDTOList.add(paymentMethodDTO);
            }
            baseResponse.setData(paymentMethodDTOList);
            baseResponse.setMessage("Thêm thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> getPaymentMethodById(Long paymentMethodId) {
        return null;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> addPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        return null;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> updatePaymentMethod(PaymentMethodDTO paymentMethodDTO, Long paymentMethodId) {
        return null;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> deletePaymentMethod(Long paymentMethodId) {
        return null;
    }
}
