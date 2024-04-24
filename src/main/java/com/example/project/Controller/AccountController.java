package com.example.project.Controller;

import com.example.project.DTO.AccountDTO;
import com.example.project.DTO.BaseResponse;
import com.example.project.Service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/get/all")
    public ResponseEntity<BaseResponse<List<AccountDTO>>> getAllAccount() {
        BaseResponse<List<AccountDTO>> baseResponse = accountService.getAllAccount();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<AccountDTO>> getAllAccountById(@RequestParam("id") Long accountId) {
        BaseResponse<AccountDTO> baseResponse = accountService.getAllAccountById(accountId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<AccountDTO>> addAccount(
            @Valid @RequestBody AccountDTO accountDTO
    ) {
        BaseResponse<AccountDTO> baseResponse = accountService.addAccount(accountDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<AccountDTO>> updateAccount(
            @RequestParam("id") Long id,
            @Valid @RequestBody AccountDTO accountDTO) {
        BaseResponse<AccountDTO> baseResponse = accountService.updateAccount(id, accountDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<AccountDTO>> deleteAccount(@RequestParam("id") Long id){
        BaseResponse<AccountDTO> baseResponse = accountService.deleteAccountById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
