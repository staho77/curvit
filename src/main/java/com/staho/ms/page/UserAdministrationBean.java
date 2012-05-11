package com.staho.ms.page;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;
import org.hibernate.exception.ConstraintViolationException;

import com.staho.ms.domain.Person;
import com.staho.ms.domain.util.DomainUtil;
import com.staho.ms.jsf.ContextUtil;
import com.staho.ms.jsf.exception.MessageUtil;
import com.staho.ms.service.MasterDataService;
import com.staho.ms.service.UserService;

@Named("userAdministrationBean")
@WindowScoped
public class UserAdministrationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// private Log log = LogFactory.getLog(UserAdministrationBean.class);

	@Inject
	private MasterDataService masterDataService;

	@Inject
	private UserService userService;

	private Person person;

	public UserAdministrationBean() {
		super();
		person = new Person();
	}

	public MasterDataService getMasterDataService() {
		return masterDataService;
	}

	public UserService getUserService() {
		return userService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = new Person();
		DomainUtil.copyProperties(this.person, person);
	}

	public void refreshView() {
		ContextUtil.refreshView();
	}

	public void save() {
		try {
			person = userService.save(person);
		} catch (PersistenceException pe) {
			if (pe.getCause() instanceof ConstraintViolationException) {
				MessageUtil.getMessage("error_ConstraintViolationException");
			}
		}

		ContextUtil.saveSuccessful();
	}

	public void createPerson() {
		person = new Person();
	}
}
