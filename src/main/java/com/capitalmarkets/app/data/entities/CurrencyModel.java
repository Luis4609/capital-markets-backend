package com.capitalmarkets.app.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CURRENCIES")
public class CurrencyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Codigo", nullable = false, unique = true)
    private String code;

    @Column(name = "Nombre", nullable = false)
    private String name;


}
