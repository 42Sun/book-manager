package com.sundingyi.libmanager.model;

import java.io.Serializable;

import lombok.Data;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {
    private String username;
    
    private String password;
    
    private String roles;
    
    private static final long serialVersionUID = 1L;
}