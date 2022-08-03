package com.capitalmarkets.app.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CURRENCIES")
public class CurrencyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Codigo", nullable = false, unique = true)
    private String code;

    @Column(name = "Nombre", nullable = false)
    private String name;

    public CurrencyModel(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
