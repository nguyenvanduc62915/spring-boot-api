package com.example.project.Service.Imp;

import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.Entity.Account;

import java.util.List;

public interface AccountImp {
    BaseResponse<List<AccountDTO>> getAllAccount();
    BaseResponse<AccountDTO> getAllAccountById(Long accountId);
    BaseResponse<AccountDTO> addAccount(AccountDTO accountDTO);
    BaseResponse<AccountDTO> updateAccount(Long accountId, AccountDTO accountDTO);
    BaseResponse<AccountDTO> deleteAccountById(Long accountId);
}
