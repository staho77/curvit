package com.staho.ms.page;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.staho.ms.domain.Person;
import com.staho.ms.service.UserService;

@Named("userAdministrationSearchBean")
@ViewAccessScoped
public class UserAdministrationSearchBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(UserAdministrationSearchBean.class);

	@Inject
	private UserService userService;

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getAllPersons() {
		return userService.findAllPersons();
	}

	public void deletePerson() {
		log.debug("delete person " + person.getName());
		userService.delete(person);
	}
}
