package com.atec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Equipment> equipmentList;

    @Column(name="noOfEquipment")
    private Long noOfEquipment;

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

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }


    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public Long getNoOfEquipment() {
        return noOfEquipment;
    }

    public void setNoOfEquipment(Long noOfEquipment) {
        this.noOfEquipment = noOfEquipment;
    }
}
