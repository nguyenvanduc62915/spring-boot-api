package com.example.project.Service;

import Utils.ConvertRelationship;
import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.Entity.Account;
import com.example.project.Entity.User;
import com.example.project.Repository.AccountRepository;
import com.example.project.Repository.UserRepository;
import com.example.project.Service.Imp.AccountImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements AccountImp {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ConvertRelationship convertRelationship;

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
                accountDTO.setImage(account.getImage());
                accountDTO.setEmail(account.getEmail());
                accountDTO.setPassword(account.getPassword());
                accountDTO.setUpdatedAt(account.getUpdatedAt());
                accountDTO.setFirstName(account.getFirstName());
                accountDTO.setFirstName(account.getLastName());
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
    public BaseResponse<AccountDTO> getAllAccountById(Long accountId) {
        BaseResponse<AccountDTO> baseResponse = new BaseResponse<>();
        try {
            Account account = accountRepository.findAccountById(accountId);
            if (account == null){
                baseResponse.setMessage("Id không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setAccountId(account.getAccountId());
            accountDTO.setEmail(account.getEmail());
            accountDTO.setImage(account.getImage());
            accountDTO.setAddress(account.getAddress());
            accountDTO.setPassword(account.getPassword());
            accountDTO.setUpdatedAt(account.getUpdatedAt());
            accountDTO.setCreatedAt(account.getCreatedAt());
            accountDTO.setFirstName(account.getFirstName());
            accountDTO.setLastName(account.getLastName());
            baseResponse.setData(accountDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<AccountDTO> addAccount(AccountDTO accountDTO, Long userId) {
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
    public BaseResponse<AccountDTO> updateAccount(Long accountId, AccountDTO accountDTO, Long userId) {
        BaseResponse<AccountDTO> baseResponse = new BaseResponse<>();
        try {
            Account account = accountRepository.findAccountById(accountId);
            if (account == null){
                baseResponse.setMessage("Không tìm thấy " + accountId + "nên không thể sửa");
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
        BaseResponse<AccountDTO> baseResponse = new BaseResponse<>();
        try {
            Account account = accountRepository.findAccountById(accountId);
            if (account == null){
                baseResponse.setData(null);
                baseResponse.setMessage("Không tìm thấy " + account + " nên không thể xóa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            accountRepository.delete(account);
            baseResponse.setMessage("Xóa thành công với danh mục có id là: " + accountId);
            baseResponse.setCode(202);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi khi xóa " + ex.getMessage());
            baseResponse.setCode(404);
        }
        return baseResponse;
    }
}
