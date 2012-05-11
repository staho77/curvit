package com.staho.ms.page;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.richfaces.component.SortOrder;

@ViewScoped
@Named("userAdministrationSearchSortingBean")
public class UserAdministrationSearchSortingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private SortOrder surnameOrder = SortOrder.unsorted;
	private SortOrder givennameOrder = SortOrder.unsorted;
	private SortOrder departmentOrder = SortOrder.unsorted;
	private SortOrder countryOrder = SortOrder.unsorted;

	public UserAdministrationSearchSortingBean() {
		this.surnameOrder = SortOrder.ascending; // default sort by surname
	}

	public SortOrder getSurnameOrder() {
		return surnameOrder;
	}

	public void setSurnameOrder(SortOrder surnameOrder) {
		this.surnameOrder = surnameOrder;
	}

	public SortOrder getGivennameOrder() {
		return givennameOrder;
	}

	public void setGivennameOrder(SortOrder givennameOrder) {
		this.givennameOrder = givennameOrder;
	}

	public SortOrder getDepartmentOrder() {
		return departmentOrder;
	}

	public void setDepartmentOrder(SortOrder departmentOrder) {
		this.departmentOrder = departmentOrder;
	}

	public SortOrder getCountryOrder() {
		return countryOrder;
	}

	public void setCountryOrder(SortOrder countryOrder) {
		this.countryOrder = countryOrder;
	}

	public void sortBySurname() {
		givennameOrder = SortOrder.unsorted;
		departmentOrder = SortOrder.unsorted;
		countryOrder = SortOrder.unsorted;

		if (surnameOrder.equals(SortOrder.ascending)) {
			setSurnameOrder(SortOrder.descending);
		} else {
			setSurnameOrder(SortOrder.ascending);
		}
	}

	public void sortByGivenname() {
		surnameOrder = SortOrder.unsorted;
		departmentOrder = SortOrder.unsorted;
		countryOrder = SortOrder.unsorted;

		if (givennameOrder.equals(SortOrder.ascending)) {
			setGivennameOrder(SortOrder.descending);
		} else {
			setGivennameOrder(SortOrder.ascending);
		}
	}

	public void sortByDepartment() {
		surnameOrder = SortOrder.unsorted;
		givennameOrder = SortOrder.unsorted;
		countryOrder = SortOrder.unsorted;

		if (departmentOrder.equals(SortOrder.ascending)) {
			setDepartmentOrder(SortOrder.descending);
		} else {
			setDepartmentOrder(SortOrder.ascending);
		}
	}

	public void sortByCountry() {
		surnameOrder = SortOrder.unsorted;
		givennameOrder = SortOrder.unsorted;
		departmentOrder = SortOrder.unsorted;

		if (countryOrder.equals(SortOrder.ascending)) {
			setCountryOrder(SortOrder.descending);
		} else {
			setCountryOrder(SortOrder.ascending);
		}
	}
}
