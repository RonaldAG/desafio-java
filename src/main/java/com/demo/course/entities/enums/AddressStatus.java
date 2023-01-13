package com.demo.course.entities.enums;

public enum AddressStatus {
	ENDERECO_PRINCIPAL(1),
	ENDERECO_SECUNDARIO(2);
	
	private int code;
	
	private AddressStatus(int i) {
		this.code = i;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static AddressStatus valueOf(int code) {
		for(AddressStatus value : AddressStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code");
	}
	
}
