package com.rms.rmsapplication.security.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rms.rmsapplication.model.Roles;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {
    //    private Role role;
    private String authority;

    public CustomGrantedAuthority() {}


    public CustomGrantedAuthority(Roles role) {
//        this.role = role;
        this.authority = role.getName();
    }

    @Override
    public String getAuthority() {
//        return role.getName();
        return authority;
    }
}