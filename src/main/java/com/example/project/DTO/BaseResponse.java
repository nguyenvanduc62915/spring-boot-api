package com.example.project.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@JsonInclude()
public class BaseResponse {
}
