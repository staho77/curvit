package com.staho.ms.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.staho.ms.constants.LengthConstants;

@Entity
public class Summary extends Id implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(length = LengthConstants.SUMMARY_DESCRIPTION)
	@Size(max = LengthConstants.SUMMARY_DESCRIPTION)
	private String description1;

	@Column(length = LengthConstants.SUMMARY_DESCRIPTION)
	@Size(max = LengthConstants.SUMMARY_DESCRIPTION)
	private String description2;

	@Column(length = LengthConstants.SUMMARY_DESCRIPTION)
	@Size(max = LengthConstants.SUMMARY_DESCRIPTION)
	private String description3;

	@Column(length = LengthConstants.SUMMARY_DESCRIPTION)
	@Size(max = LengthConstants.SUMMARY_DESCRIPTION)
	private String description4;

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDescription3() {
		return description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	public String getDescription4() {
		return description4;
	}

	public void setDescription4(String description4) {
		this.description4 = description4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description1 == null) ? 0 : description1.hashCode());
		result = prime * result
				+ ((description2 == null) ? 0 : description2.hashCode());
		result = prime * result
				+ ((description3 == null) ? 0 : description3.hashCode());
		result = prime * result
				+ ((description4 == null) ? 0 : description4.hashCode());
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
		Summary other = (Summary) obj;
		if (description1 == null) {
			if (other.description1 != null)
				return false;
		}
		else if (!description1.equals(other.description1))
			return false;
		if (description2 == null) {
			if (other.description2 != null)
				return false;
		}
		else if (!description2.equals(other.description2))
			return false;
		if (description3 == null) {
			if (other.description3 != null)
				return false;
		}
		else if (!description3.equals(other.description3))
			return false;
		if (description4 == null) {
			if (other.description4 != null)
				return false;
		}
		else if (!description4.equals(other.description4))
			return false;
		return true;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("description1", description1);
		builder.append("description2", description2);
		builder.append("description3", description3);
		builder.append("description4", description4);
		return builder.toString();
	}
}