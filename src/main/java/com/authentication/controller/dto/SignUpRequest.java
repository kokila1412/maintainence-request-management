package com.authentication.controller.dto;


import com.springbootdockermavenjibplugin.models.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {

    @ApiModelProperty(example = "kokila")
    @NotEmpty
    @Size(max=10, message = "USer name cannot be greater than 10 characters")
    private String name;

    @ApiModelProperty(example = "*****")
    @NotEmpty
    @Size(max=10, message = "Password cannot be greater than 10 characters")
    private String password;

//    @ApiModelProperty(example = "userid ")
//    private String role;
}
