package com.staho.ms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = Country.ALL, query = "select c from Country c"),
		@NamedQuery(name = Country.ALL_NOT_DELETED, query = "select c from Country c where c.deleted=false"),
		@NamedQuery(name = Country.BY_NAME, query = "select c from Country c where c.name = :name"),
		@NamedQuery(name = Country.BY_CODE, query = "select c from Country c where c.code = :code") })
public class Country extends Code implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ALL = "Country.ALL";
	public static final String ALL_NOT_DELETED = "Country.ALL_NOT_DELETED";
	public static final String BY_NAME = "Country.BY_NAME";
	public static final String BY_CODE = "Country.BY_CODE";

	public String toString() {
		return super.toString();
	}
}
