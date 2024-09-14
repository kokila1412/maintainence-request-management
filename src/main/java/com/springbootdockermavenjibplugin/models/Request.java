package com.springbootdockermavenjibplugin.models;

import com.springbootdockermavenjibplugin.models.abstractions.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Request extends BaseEntity {
//    @Id
//    private int id;
    private String type;
    private String priority;
    private String description;
    private String owner;
    private String approver;
}
