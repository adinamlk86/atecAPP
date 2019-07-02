package com.atec.dto;

import com.atec.model.Equipment;

import java.util.List;

public class ClientDTO {

	private Long id;

	private String name;

	private String vatCode;

	private String registrationCode;

	private String address;

	private String bank;

	private String iban;

	private List<Equipment> equipmentList;

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
