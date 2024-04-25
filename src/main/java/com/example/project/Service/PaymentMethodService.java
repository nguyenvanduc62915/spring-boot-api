package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.PaymentMethodDTO;
import com.example.project.Entity.PaymentMethod;
import com.example.project.Repository.PaymentMethodRepository;
import com.example.project.Service.Imp.PaymentMethodImp;
import jakarta.transaction.Transactional;
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
        BaseResponse<PaymentMethodDTO> baseResponse = new BaseResponse<>();
        try{
            PaymentMethod paymentMethod = paymentMethodRepository.findPaymentMethodById(paymentMethodId);
            if (paymentMethodId == null){
                baseResponse.setMessage(paymentMethodId + " no exist");
                baseResponse.setCode(404);
            }
            PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
            paymentMethodDTO.setPaymentMethodId(paymentMethod.getPaymentMethodId());
            paymentMethodDTO.setActive(paymentMethod.getActive());
            paymentMethodDTO.setName(paymentMethod.getName());
            baseResponse.setData(paymentMethodDTO);
            baseResponse.setMessage("Success");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Error in search");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> addPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        BaseResponse<PaymentMethodDTO> baseResponse = new BaseResponse<>();
        try{
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setName(paymentMethodDTO.getName());
            paymentMethod.setActive(paymentMethodDTO.getActive());
            paymentMethodRepository.save(paymentMethod);
            baseResponse.setData(paymentMethodDTO);
            baseResponse.setMessage("Success");
            baseResponse.setCode(404);
        } catch (Exception ex){
            baseResponse.setMessage("Error in search");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> updatePaymentMethod(PaymentMethodDTO paymentMethodDTO, Long paymentMethodId) {
        BaseResponse<PaymentMethodDTO> baseResponse = new BaseResponse<>();
        try{
            PaymentMethod paymentMethod = paymentMethodRepository.findPaymentMethodById(paymentMethodId);
            if (paymentMethod == null){
                baseResponse.setMessage("No exist PaymentMethod");
                baseResponse.setCode(404);
                return baseResponse;
            }
            paymentMethod.setName(paymentMethodDTO.getName());
            paymentMethod.setActive(paymentMethod.getActive());
            paymentMethodRepository.save(paymentMethod);
            baseResponse.setData(paymentMethodDTO);
            baseResponse.setMessage("Success");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Error in search");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<PaymentMethodDTO> deletePaymentMethod(Long paymentMethodId) {
        BaseResponse<PaymentMethodDTO> baseResponse = new BaseResponse<>();
        try {
            PaymentMethod paymentMethod = paymentMethodRepository.findPaymentMethodById(paymentMethodId);
            if (paymentMethod == null){
                baseResponse.setMessage("PaymentMethodId exist");
                baseResponse.setCode(404);
                return baseResponse;
            }
            paymentMethodRepository.delete(paymentMethod);
            baseResponse.setMessage("Delete success PaymentMethod Id = " + paymentMethodId);
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Error in search");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }
}
