package com.staho.ms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = Role.ALL, query = "select r from Role r"),
		@NamedQuery(name = Role.ALL_NOT_DELETED, query = "select r from Role r where r.deleted = false") })
public class Role extends Name implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ALL = "Role.ALL";
	public static final String ALL_NOT_DELETED = "Role.ALL_NOT_DELETED";

	public static final int ADMINISTRATOR = 1;
	public static final int IT_ENGINEER = 2;
	public static final int QA = 3;

	public String toString() {
		return super.toString();
	}
}
