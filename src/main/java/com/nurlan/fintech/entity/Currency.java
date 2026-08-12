package com.nurlan.fintech.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 3)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(name = "decimal_places", nullable = false)
    private Short decimalPlaces;

    protected Currency() {}

    public Currency(String code, String name, Short decimalPlaces) {
        this.code = code;
        this.name = name;
        this.decimalPlaces = decimalPlaces;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public Short getDecimalPlaces() { return decimalPlaces; }
}