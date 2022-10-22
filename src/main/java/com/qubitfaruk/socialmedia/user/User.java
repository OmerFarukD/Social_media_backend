package com.qubitfaruk.socialmedia.user;

import com.qubitfaruk.socialmedia.Anotations.uniqueDataAnotation.UniqueData;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull
    @Size(min = 5,max = 255,message = Messages.usernameValidationMesssage)
    @UniqueData
    private String username;

    @Column(name = "displayName")
    @NotNull
    private String displayName;

    @Column(name = "password")
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;
}
