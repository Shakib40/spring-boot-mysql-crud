package com.crud.entity;

import com.crud.enm.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    
    private String fullName;

    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role; 
}
