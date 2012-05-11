package com.staho.ms.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;
import org.hibernate.exception.ConstraintViolationException;

import com.staho.ms.domain.Career;
import com.staho.ms.domain.Education;
import com.staho.ms.domain.Person;
import com.staho.ms.domain.Summary;
import com.staho.ms.domain.util.DomainUtil;
import com.staho.ms.jpa.CrudService;
import com.staho.ms.jsf.ContextUtil;
import com.staho.ms.jsf.exception.CommonRuntimeException;
import com.staho.ms.service.MasterDataService;
import com.staho.ms.service.UserService;

@Named("personBean")
@WindowScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(PersonBean.class);

	@Inject
	private CrudService crudService;

	@Inject
	private UserService userService;

	@Inject
	private MasterDataService masterDataService;

	private Person person;

	private Education education;

	private Career career;

	public Person getPerson() {
		if (person == null) {
			String idReqParam = ContextUtil.getExternalContext().getRequestParameterMap().get("ID");
			if (idReqParam == null) {
				throw new CommonRuntimeException("error_NoIdSpecifiedMsg1", "error_DefaultMsg2",
						"No ID specified in the URL !");
			}
			Integer id = new Integer(idReqParam);
			person = crudService.find(Person.class, id);
			if (person == null) {
				throw new CommonRuntimeException("error_UserNotFoundMsg1", "error_DefaultMsg2",
						"The user with specified ID doesn't exist!");
			}
		}
		return person;
		// person = crudService.find(Person.class, 1);
		// return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = new Education();
		DomainUtil.copyProperties(this.education, education);
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = new Career();
		DomainUtil.copyProperties(this.career, career);
	}

	public MasterDataService getMasterDataService() {
		return masterDataService;
	}

	public void createPersonEducation() {
		education = new Education();
	}

	public void addPersonEducation() {
		log.debug("addPersonEducation");
		try {
			person = userService.add(education, person);
		} catch (PersistenceException pe) {
			if (pe.getCause() instanceof ConstraintViolationException) {
				log.debug("error_ConstraintViolationException");
			}
		}
		ContextUtil.saveSuccessful();
	}

	public void removePersonEducation() {
		log.debug("removePersonEducation " + education.getId());
		person = userService.remove(education, person);
		ContextUtil.saveSuccessful();
	}

	public void createPersonCareer() {
		career = new Career();
	}

	public void addPersonCareer() {
		log.debug("addPersonCareer");
		try {
			person = userService.add(career, person);
		} catch (PersistenceException pe) {
			if (pe.getCause() instanceof ConstraintViolationException) {
				log.debug("error_ConstraintViolationException");
			}
		}
		ContextUtil.saveSuccessful();
	}

	public void removePersonCareer() {
		log.debug("removePersonCareer " + career.getId());
		person = userService.remove(career, person);
		ContextUtil.saveSuccessful();
	}

	public void createPersonSummary() {
		if (person.getSummary() == null) {
			person.setSummary(new Summary());
		}
	}

	public void savePersonSummary() {
		log.debug("savePersonSummary");
		try {
			person = userService.save(person);
		} catch (PersistenceException pe) {
			if (pe.getCause() instanceof ConstraintViolationException) {
				log.debug("error_ConstraintViolationException");
			}
		}
		ContextUtil.saveSuccessful();
	}

	public void checkPerson() {
		log.debug("Person:" + getPerson());
	}

	public boolean isAdministrator() {
		return person.isAdministrator();
	}

	public List<Person> getPersonToList() {
		List<Person> list = new ArrayList<Person>();
		Person person = getPerson();
		if (person != null) {
			list.add(person);
			return list;
		}
		return null;
	}
}
