package com.epam.lab.payments.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
@Data
public class UserEntity {
    @Id
    @Column(name = "id", insertable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = -1)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;

    @Basic
    @Column(name = "phone", nullable = false, length = -1)
    private String phone;

    @Basic
    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;
}
