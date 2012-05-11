package com.staho.ms.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.staho.ms.constants.LengthConstants;

@Entity
public class Education extends Name implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Enumerated(EnumType.STRING)
	private EducationDegreeEnum degree;

	@OneToOne(cascade = CascadeType.ALL)
	private ImageFile imageFile;

	@Column(length = LengthConstants.EDUCATION_SPECIALIZATION)
	@Size(max = LengthConstants.EDUCATION_SPECIALIZATION)
	private String specialization;

	@Column(length = LengthConstants.EDUCATION_WEBSITE)
	@Size(max = LengthConstants.EDUCATION_WEBSITE)
	private String website;

	@Basic(optional = false)
	@Column(length = LengthConstants.EDUCATION_YEAR)
	@Size(max = LengthConstants.EDUCATION_YEAR)
	private String yearFrom;

	@Basic(optional = false)
	@Column(length = LengthConstants.EDUCATION_YEAR)
	@Size(max = LengthConstants.EDUCATION_YEAR)
	private String yearTo;

	public EducationDegreeEnum getDegree() {
		return degree;
	}

	public void setDegree(EducationDegreeEnum degree) {
		this.degree = degree;
	}

	public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}

	public String getYearTo() {
		return yearTo;
	}

	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		result = prime * result + ((yearFrom == null) ? 0 : yearFrom.hashCode());
		result = prime * result + ((yearTo == null) ? 0 : yearTo.hashCode());
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
		Education other = (Education) obj;
		if (degree != other.degree)
			return false;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		}
		else if (!imageFile.equals(other.imageFile))
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		}
		else if (!specialization.equals(other.specialization))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		}
		else if (!website.equals(other.website))
			return false;
		if (yearFrom == null) {
			if (other.yearFrom != null)
				return false;
		}
		else if (!yearFrom.equals(other.yearFrom))
			return false;
		if (yearTo == null) {
			if (other.yearTo != null)
				return false;
		}
		else if (!yearTo.equals(other.yearTo))
			return false;
		return true;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("degree", degree);
		builder.append("specialization", specialization);
		builder.append("website", website);
		builder.append("yearFrom", yearFrom);
		builder.append("yearTo", yearTo);
		return builder.toString();
	}
}