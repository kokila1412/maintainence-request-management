package com.springbootdockermavenjibplugin.dto;

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
public class RequestDto {

    @ApiModelProperty(example = "Complaint/Suggestion")
    @NotEmpty
    @Size(max=50, message = "Request name cannot be greater than 50 characters")
    private String type;

    @ApiModelProperty(example = "Cut in basement")
    @NotEmpty
    @Size(max=100, message = "Request description cannot be greater than 500 characters")
    private String description;

    @ApiModelProperty(example = "userid ")
    private String owner;

    @ApiModelProperty(example = "userid ")
    private String approver;

    @ApiModelProperty(example = "low/high/medium")
    @NotEmpty
    @Size(max=7, message = "Priority name cannot be greater than 50 characters")
    private String priority;
}
