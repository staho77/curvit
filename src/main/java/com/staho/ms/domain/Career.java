package com.staho.ms.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.staho.ms.constants.LengthConstants;

@Entity
public class Career extends Name implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	private ImageFile imageFile;

	@Basic(optional = false)
	@Column(length = LengthConstants.CAREER_MONTH)
	@Size(max = LengthConstants.CAREER_MONTH)
	private String monthFrom;

	@Basic(optional = false)
	@Column(length = LengthConstants.CAREER_MONTH)
	@Size(max = LengthConstants.CAREER_MONTH)
	private String monthTo;

	@Column(length = LengthConstants.CAREER_RESPONSIBILITY)
	@Size(max = LengthConstants.CAREER_RESPONSIBILITY)
	private String responsibility;

	@OneToOne
	private Role role;

	@Column(length = LengthConstants.CAREER_WEBSITE)
	@Size(max = LengthConstants.CAREER_WEBSITE)
	private String website;

	@Basic(optional = false)
	@Column(length = LengthConstants.CAREER_YEAR)
	@Size(max = LengthConstants.CAREER_YEAR)
	private String yearFrom;

	@Basic(optional = false)
	@Column(length = LengthConstants.CAREER_YEAR)
	@Size(max = LengthConstants.CAREER_YEAR)
	private String yearTo;

	public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getMonthFrom() {
		return monthFrom;
	}

	public void setMonthFrom(String monthFrom) {
		this.monthFrom = monthFrom;
	}

	public String getMonthTo() {
		return monthTo;
	}

	public void setMonthTo(String monthTo) {
		this.monthTo = monthTo;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + ((monthFrom == null) ? 0 : monthFrom.hashCode());
		result = prime * result + ((monthTo == null) ? 0 : monthTo.hashCode());
		result = prime * result + ((responsibility == null) ? 0 : responsibility.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Career other = (Career) obj;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		}
		else if (!imageFile.equals(other.imageFile))
			return false;
		if (monthFrom == null) {
			if (other.monthFrom != null)
				return false;
		}
		else if (!monthFrom.equals(other.monthFrom))
			return false;
		if (monthTo == null) {
			if (other.monthTo != null)
				return false;
		}
		else if (!monthTo.equals(other.monthTo))
			return false;
		if (responsibility == null) {
			if (other.responsibility != null)
				return false;
		}
		else if (!responsibility.equals(other.responsibility))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		}
		else if (!role.equals(other.role))
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
		builder.append("imageFile", imageFile);
		builder.append("monthFrom", monthFrom);
		builder.append("monthTo", monthTo);
		builder.append("responsibility", responsibility);
		builder.append("website", website);
		builder.append("yearFrom", yearFrom);
		builder.append("yearTo", yearTo);
		return builder.toString();
	}
}