package com.atec.model;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "client_seq_gen")
    @SequenceGenerator(name = "client_seq_gen",
                       sequenceName = "client_sequence", allocationSize = 1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="vat_code")
    private String vatCode;

    @Column(name="reg_code")
    private String registrationCode;

    @Column(name="address")
    private String address;

    @Column(name="bank")
    private String bank;

    @Column(name="iban")
    private String iban;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatCode() {
        return vatCode;
    }

    public void setVatCode(String vatCode) {
        this.vatCode = vatCode;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
