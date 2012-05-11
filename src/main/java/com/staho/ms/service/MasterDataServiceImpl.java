package com.staho.ms.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.staho.ms.domain.Country;
import com.staho.ms.domain.EducationDegreeEnum;
import com.staho.ms.domain.FileTypeEnum;
import com.staho.ms.domain.ImageFile;
import com.staho.ms.domain.PersonTitleEnum;
import com.staho.ms.domain.Role;
import com.staho.ms.jpa.CrudService;

public class MasterDataServiceImpl implements MasterDataService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CrudService crudService;

	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		return crudService.findByNamedQuery(Role.ALL_NOT_DELETED);
	}

	@SuppressWarnings("unchecked")
	public List<Country> getCountries() {
		return crudService.findByNamedQuery(Country.ALL_NOT_DELETED);
	}

	@SuppressWarnings("unchecked")
	public List<ImageFile> getImageFiles() {
		return crudService.findByNamedQuery(ImageFile.ALL);
	}

	public String getDataTypes() {
		return StringUtils.join(FileTypeEnum.values(), ", ");
	}

	public List<PersonTitleEnum> getPersonTitles() {
		return Arrays.asList(PersonTitleEnum.values());
	}

	public List<EducationDegreeEnum> getEducationDegrees() {
		List<EducationDegreeEnum> l = Arrays.asList(EducationDegreeEnum.values());
		return l;
	}
}
