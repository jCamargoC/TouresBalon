package com.touresbalon.common;

public enum ErrorsEnum {
	REFLECTION_ERROR(1, "Error invocando función por reflection"), CLIENT_EXISTS(2,"El email ingresado ya se encuentra asociado a un usuario"), ENCRYPT_ERROR(3,"Error encriptando número de tarjeta"), OBJECT_DOES_NOT_EXISTS(4,"No existe");

	private final int code;
	private final String description;

	private ErrorsEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}
