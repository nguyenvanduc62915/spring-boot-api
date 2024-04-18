package com.example.project.Service;

import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.Entity.Account;
import com.example.project.Repository.AccountRepository;
import com.example.project.Service.Imp.AccountImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements AccountImp {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BaseResponse<List<AccountDTO>> getAllAccount() {
        BaseResponse<List<AccountDTO>> baseResponse = new BaseResponse<>();
        List<AccountDTO> accountDTOList = new ArrayList<>();
        try {
            List<Account> accountList = accountRepository.findAll();
            if (accountList.isEmpty() || accountList == null){
                baseResponse.setMessage("Không tồn tại sản phẩm");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for(Account account : accountList){
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setAccountId(account.getAccountId());
                accountDTO.setAddress(account.getAddress());
                accountDTO.setCreatedAt(account.getCreatedAt());
                accountDTO.setUser(account.getUser());
                accountDTO.setImage(account.getImage());
                accountDTO.setEmail(account.getEmail());
                accountDTO.setPassword(account.getPassword());
                accountDTO.setUpdatedAt(account.getUpdatedAt());
                accountDTO.setFirstName(account.getFirstName());
                accountDTO.setFirstName(account.getFirstName());
                accountDTOList.add(accountDTO);
            }
            baseResponse.setData(accountDTOList);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<List<AccountDTO>> getAllAccountById(Long accountId) {
        return null;
    }

    @Override
    public BaseResponse<AccountDTO> addAccount(AccountDTO accountDTO) {
        BaseResponse<AccountDTO> baseResponse = new BaseResponse<>();
        try {
            Account account = new Account();
            account.setAccountId(accountDTO.getAccountId());
            account.setAddress(accountDTO.getAddress());
            account.setImage(accountDTO.getImage());
            account.setEmail(accountDTO.getEmail());
            account.setFirstName(accountDTO.getFirstName());
            account.setPassword(accountDTO.getPassword());
            account.setUpdatedAt(accountDTO.getUpdatedAt());
            account.setCreatedAt(accountDTO.getCreatedAt());
            account.setLastName(accountDTO.getLastName());
            account.setUser(accountDTO.getUser());
            accountRepository.save(account);
            baseResponse.setData(accountDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình thêm Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<AccountDTO> updateAccount(Long accountId, AccountDTO accountDTO) {
        BaseResponse<AccountDTO> baseResponse = new BaseResponse<>();
        try {
            Account account = accountRepository.findAccountByAccountId(accountId);
            if (account == null){
                baseResponse.setMessage("Không tìm thấy Account có id là " + accountId);
                baseResponse.setCode(404);
                return baseResponse;
            }
            account.setAccountId(accountDTO.getAccountId());
            account.setAddress(accountDTO.getAddress());
            account.setImage(accountDTO.getImage());
            account.setEmail(accountDTO.getEmail());
            account.setFirstName(accountDTO.getFirstName());
            account.setPassword(accountDTO.getPassword());
            account.setUpdatedAt(accountDTO.getUpdatedAt());
            account.setCreatedAt(accountDTO.getCreatedAt());
            account.setLastName(accountDTO.getLastName());
            account.setUser(accountDTO.getUser());
            accountRepository.save(account);
            baseResponse.setData(accountDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình thêm Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<AccountDTO> deleteAccountById(Long accountId) {
        return null;
    }
}
