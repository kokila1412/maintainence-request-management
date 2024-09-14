package com.springbootdockermavenjibplugin.models;

import com.springbootdockermavenjibplugin.models.abstractions.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Role extends BaseEntity {
//    @Id
//    private int roleId;
    private String roleName;
}
