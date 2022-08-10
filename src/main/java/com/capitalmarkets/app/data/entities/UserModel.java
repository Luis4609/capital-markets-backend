package com.capitalmarkets.app.data.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nombre", nullable = false)
    private String name;

    @Column(name = "Apellido", nullable = false)
    private String surname;

    @Column(name = "Dni", nullable = false,unique=true)
    private String dni;

    @Column(name = "mail", nullable = false,unique=true)
    private String mail;

    @Column(name = "contraseña", nullable = false)
    private String password;



}
