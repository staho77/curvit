package com.staho.ms.service;

import java.util.List;

import com.staho.ms.domain.Country;
import com.staho.ms.domain.EducationDegreeEnum;
import com.staho.ms.domain.ImageFile;
import com.staho.ms.domain.PersonTitleEnum;
import com.staho.ms.domain.Role;

public interface MasterDataService {

	public List<Role> getRoles();

	public List<Country> getCountries();

	public List<ImageFile> getImageFiles();

	public String getDataTypes();

	public List<PersonTitleEnum> getPersonTitles();

	public List<EducationDegreeEnum> getEducationDegrees();
}
