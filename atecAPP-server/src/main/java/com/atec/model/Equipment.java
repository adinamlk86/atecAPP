package com.atec.model;

import javax.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "equipment_seq_gen")
    @SequenceGenerator(name = "equipment_seq_gen",
            sequenceName = "equipment_sequence", allocationSize = 1)
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="code")
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
