package com.staho.ms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.staho.ms.constants.LengthConstants;

@Entity
@Table(name = "IMAGE_FILE")
@NamedQueries({ @NamedQuery(name = ImageFile.ALL, query = "select i from ImageFile i") })
public class ImageFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ALL = "ImageFile.ALL";

	@Lob
	@Column(length = 10000000)
	private byte[] data;

	@Size(max = LengthConstants.IMAGE_FILENAME)
	@Pattern(regexp = "([a-z]|[A-Z]|[0-9]|[\\.,\\-_ ])*")
	private String fileName;

	private BigDecimal fileSize;

	@Enumerated(EnumType.STRING)
	private FileTypeEnum fileType;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BigDecimal getFileSize() {
		return fileSize;
	}

	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	public FileTypeEnum getFileType() {
		return fileType;
	}

	public void setFileType(FileTypeEnum fileType) {
		this.fileType = fileType;
	}

	@Transient
	public String getContentType() {
		if (fileType != null) {
			return fileType.getContentType();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageFile other = (ImageFile) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		}
		else if (!fileSize.equals(other.fileSize))
			return false;
		if (fileType != other.fileType)
			return false;
		return true;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("fileName", fileName);
		builder.append("fileSize", fileSize);
		builder.append("type", fileType);
		return builder.toString();
	}
}
