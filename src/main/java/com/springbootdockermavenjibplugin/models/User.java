package com.springbootdockermavenjibplugin.models;

import com.springbootdockermavenjibplugin.models.abstractions.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User extends BaseEntity {
//    @Id
//    private String userId;
    private String name;
    private String password;
   @ManyToOne
    private Role role;

}
