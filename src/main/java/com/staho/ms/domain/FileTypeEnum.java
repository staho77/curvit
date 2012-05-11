package com.staho.ms.domain;

public enum FileTypeEnum {

	GIF("file_gif.gif", "image/gif"),

	JPG("file_jpg.gif", "image/jpeg");

	private String icon;

	private String contentType;

	private FileTypeEnum(String icon, String contentType) {
		this.icon = icon;
		this.contentType = contentType;
	}

	public String getIcon() {
		return icon;
	}

	public String getContentType() {
		return contentType;
	}

	public String getCode() {
		return this.name();
	}
}
