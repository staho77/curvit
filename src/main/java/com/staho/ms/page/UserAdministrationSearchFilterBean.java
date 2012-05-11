package com.staho.ms.page;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("userAdministrationSearchFilterBean")
public class UserAdministrationSearchFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String surnameFilter;

	private String givennameFilter;

	private String departmentFilter;

	private String countryFilter;

	public UserAdministrationSearchFilterBean() {
	}

	public String getSurnameFilter() {
		return surnameFilter;
	}

	public void setSurnameFilter(String surnameFilter) {
		this.surnameFilter = surnameFilter;
	}

	public String getGivennameFilter() {
		return givennameFilter;
	}

	public void setGivennameFilter(String givennameFilter) {
		this.givennameFilter = givennameFilter;
	}

	public String getDepartmentFilter() {
		return departmentFilter;
	}

	public void setDepartmentFilter(String departmentFilter) {
		this.departmentFilter = departmentFilter;
	}

	public String getCountryFilter() {
		return countryFilter;
	}

	public void setCountryFilter(String countryFilter) {
		this.countryFilter = countryFilter;
	}

	public boolean isFilterOn() {
		return surnameFilter != null || givennameFilter != null || departmentFilter != null
				|| countryFilter != null;
	}
}