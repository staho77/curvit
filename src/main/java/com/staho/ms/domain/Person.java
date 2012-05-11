package com.staho.ms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.staho.ms.constants.LengthConstants;
import com.staho.ms.jsf.exception.CommonRuntimeException;

@Entity
@NamedQueries({ @NamedQuery(name = Person.ALL, query = "select p from Person p") })
public class Person extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ALL = "Person.ALL";

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@OrderBy("yearFrom DESC, monthFrom DESC")
	private List<Career> careers;

	@OneToOne
	private Country country;

	@Column(length = LengthConstants.PERSON_DEPARTMENT)
	@Size(max = LengthConstants.PERSON_DEPARTMENT)
	private String department;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@OrderBy("yearFrom DESC")
	private List<Education> educations;

	@Basic(optional = false)
	@Column(length = LengthConstants.PERSON_EMAIL, unique = true)
	@Size(max = LengthConstants.PERSON_EMAIL)
	private String email;

	@Column(length = LengthConstants.PERSON_FAX)
	@Size(max = LengthConstants.PERSON_FAX)
	private String fax;

	@Basic(optional = false)
	@Column(length = LengthConstants.PERSON_GIVENNAME)
	@Size(max = LengthConstants.PERSON_GIVENNAME)
	private String givenname;

	@OneToOne(cascade = CascadeType.ALL)
	private ImageFile imageFile;

	@Column(length = LengthConstants.PERSON_LINK)
	@Size(max = LengthConstants.PERSON_LINK)
	private String linkFacebook;
	
	@Column(length = LengthConstants.PERSON_LINK)
	@Size(max = LengthConstants.PERSON_LINK)
	private String linkGithub;
	
	@Column(length = LengthConstants.PERSON_LINK)
	@Size(max = LengthConstants.PERSON_LINK)
	private String linkLinkedIn;
	
	@Column(length = LengthConstants.PERSON_MOBILE)
	@Size(max = LengthConstants.PERSON_MOBILE)
	private String mobile;

	@Column(length = LengthConstants.PERSON_PHONE)
	@Size(max = LengthConstants.PERSON_PHONE)
	private String phone;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Role> roles;

	@Column(length = LengthConstants.PERSON_LINK)
	@Size(max = LengthConstants.PERSON_LINK)
	private String skypeName;

	@OneToOne(cascade = CascadeType.ALL)
	private Summary summary;

	@Basic(optional = false)
	@Column(length = LengthConstants.PERSON_SURNAME)
	@Size(max = LengthConstants.PERSON_SURNAME)
	private String surname;

	@Enumerated(EnumType.STRING)
	private PersonTitleEnum title;

	@Column(length = LengthConstants.PERSON_WEBSITE)
	@Size(max = LengthConstants.PERSON_WEBSITE)
	private String website;

	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	public void addCareer(Career career) {
		if (this.careers == null) {
			this.careers = new ArrayList<Career>();
		}
		this.careers.add(career);
	}

	public void deleteCareer(Career career) {
		if (this.careers != null) {
			for (Career e : this.careers) {
				if (e.getId() == career.getId()) {
					this.careers.remove(e);
					break;
				}
			}
		}
	}

	public Career getCareer(Integer id) {
		if (this.careers != null) {
			for (Career e : this.careers) {
				if (id == e.getId()) {
					return e;
				}
			}
		}
		return null;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public void addEducation(Education education) {
		if (this.educations == null) {
			this.educations = new ArrayList<Education>();
		}
		this.educations.add(education);
	}

	public void deleteEducation(Education education) {
		if (this.educations != null) {
			for (Education e : this.educations) {
				if (e.getId() == education.getId()) {
					this.educations.remove(e);
					break;
				}
			}
		}
	}

	public Education getEducation(Integer id) {
		if (this.educations != null) {
			for (Education e : this.educations) {
				if (id == e.getId()) {
					return e;
				}
			}
		}
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGivenname() {
		return givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(String linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	public String getLinkGithub() {
		return linkGithub;
	}

	public void setLinkGithub(String linkGithub) {
		this.linkGithub = linkGithub;
	}

	public String getLinkLinkedIn() {
		return linkLinkedIn;
	}

	public void setLinkLinkedIn(String linkLinkedIn) {
		this.linkLinkedIn = linkLinkedIn;
	}

	public String getSkypeName() {
		return skypeName;
	}

	public void setSkypeName(String skypeName) {
		this.skypeName = skypeName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Transient
	public String getName() {
		return getGivenname() + " " + getSurname();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Transient
	public Role getRole() {
		List<Role> list = getRoles();
		if (list == null || list.isEmpty()) {
			return null;
		}
		if (list.size() != 1) {
			throw new CommonRuntimeException("exact one role allowed for person " + this);
		}
		return getRoles().get(0);
	}

	@Transient
	public void setRole(Role role) {
		List<Role> list = getRoles();
		if (list == null) {
			list = new ArrayList<Role>(1);
			setRoles(list);
		}
		else {
			list.clear();
		}
		list.add(role);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Transient
	public String getRolesAsString() {
		boolean initial = true;
		StringBuffer sb = new StringBuffer();
		if (getRoles() != null) {
			for (Role role : getRoles()) {
				if (!initial) {
					sb.append(", ");
				}
				else {
					initial = false;
				}
				sb.append(role.getName());
			}
		}
		return sb.toString();
	}

	@Transient
	public List<String> getRolesAsStringList() {
		List<String> roles = new ArrayList<String>();
		if (getRoles() != null) {
			for (Role role : getRoles()) {
				roles.add(role.getName());
			}
		}
		return roles;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public PersonTitleEnum getTitle() {
		return title;
	}

	public void setTitle(PersonTitleEnum title) {
		this.title = title;
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
		result = prime * result + ((careers == null) ? 0 : careers.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((educations == null) ? 0 : educations.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((givenname == null) ? 0 : givenname.hashCode());
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + ((linkFacebook == null) ? 0 : linkFacebook.hashCode());
		result = prime * result + ((linkGithub == null) ? 0 : linkGithub.hashCode());
		result = prime * result + ((linkLinkedIn == null) ? 0 : linkLinkedIn.hashCode());
		result = prime * result + ((skypeName == null) ? 0 : skypeName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		Person other = (Person) obj;
		if (careers == null) {
			if (other.careers != null)
				return false;
		}
		else if (!careers.equals(other.careers))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		}
		else if (!country.equals(other.country))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		}
		else if (!department.equals(other.department))
			return false;
		if (educations == null) {
			if (other.educations != null)
				return false;
		}
		else if (!educations.equals(other.educations))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		}
		else if (!fax.equals(other.fax))
			return false;
		if (givenname == null) {
			if (other.givenname != null)
				return false;
		}
		else if (!givenname.equals(other.givenname))
			return false;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		}
		else if (!imageFile.equals(other.imageFile))
			return false;
		if (linkFacebook == null) {
			if (other.linkFacebook != null)
				return false;
		}
		else if (!linkFacebook.equals(other.linkFacebook))
			return false;
		if (linkGithub == null) {
			if (other.linkGithub != null)
				return false;
		}
		else if (!linkGithub.equals(other.linkGithub))
			return false;
		if (linkLinkedIn == null) {
			if (other.linkLinkedIn != null)
				return false;
		}
		else if (!linkLinkedIn.equals(other.linkLinkedIn))
			return false;
		if (skypeName == null) {
			if (other.skypeName != null)
				return false;
		}
		else if (!skypeName.equals(other.skypeName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		}
		else if (!mobile.equals(other.mobile))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		}
		else if (!phone.equals(other.phone))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		}
		else if (!roles.equals(other.roles))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		}
		else if (!summary.equals(other.summary))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		}
		else if (!surname.equals(other.surname))
			return false;
		if (title != other.title)
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		}
		else if (!website.equals(other.website))
			return false;
		return true;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("country", country);
		builder.append("department", department);
		builder.append("educations", educations);
		builder.append("email", email);
		builder.append("careers", careers);
		builder.append("fax", fax);
		builder.append("givenname", givenname);
		builder.append("linkFacebook", linkFacebook);
		builder.append("linkGithub", linkGithub);
		builder.append("linkLinkedIn", linkLinkedIn);
		builder.append("skypeName", skypeName);
		builder.append("mobile", mobile);
		builder.append("phone", phone);
		builder.append("roles", roles);
		builder.append("surname", surname);
		builder.append("title", title);
		return builder.toString();
	}

	@Transient
	public boolean isAdministrator() {
		if (getRole() == null) {
			return false;
		}
		Integer roleId = getRole().getId();
		return roleId == Role.ADMINISTRATOR;
	}
}