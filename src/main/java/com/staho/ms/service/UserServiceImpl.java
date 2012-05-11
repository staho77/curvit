package com.staho.ms.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import com.staho.ms.domain.Career;
import com.staho.ms.domain.Education;
import com.staho.ms.domain.Id;
import com.staho.ms.domain.Person;
import com.staho.ms.domain.util.DomainUtil;
import com.staho.ms.jpa.CrudService;
import com.staho.ms.jpa.Curvit;
import com.staho.ms.jsf.exception.CommonRuntimeException;

public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CrudService crudService;

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Transactional(qualifier = Curvit.class)
	public Person save(Person person) {
		log.debug("saving Person: " + person);
		if (person.getId() == null) {
			person = crudService.persist(person);
		}
		else {
			person = crudService.merge(person);
		}
		return person;
	}

	@Override
	@Transactional(qualifier = Curvit.class)
	public Person delete(Person person) {
		log.debug("delete Person: " + person);
		// option 1
		crudService.delete(Person.class, person.getId());
		return null;
		// option 2
		// person.setDeleted(true);
		// person = save(person);
		// return person;

	}

	@Transactional(qualifier = Curvit.class)
	public Person remove(Id obj, Person person) {
		log.debug("removing: " + obj + " from Person: " + person);
		if (obj instanceof Education) {
			Education education = (Education) obj;
			person.deleteEducation(education);
			crudService.delete(Education.class, education.getId());
		}
		else if (obj instanceof Career) {
			Career career = (Career) obj;
			person.deleteCareer(career);
			crudService.delete(Career.class, career.getId());
		}
		else {
			throw new CommonRuntimeException("object: " + obj
					+ " couldn't be deleted from Person: " + person);
		}
		return save(person);
	}

	@Transactional(qualifier = Curvit.class)
	public Person add(Id obj, Person person) {
		if (obj.getId() == null) {
			log.debug("adding new: " + obj + " into Person: " + person);

			if (obj instanceof Education) {
				Education education = (Education) obj;
				person.addEducation(education);
			}
			else if (obj instanceof Career) {
				Career career = (Career) obj;
				person.addCareer(career);
			}
			else {
				// throw new CommonRuntimeException("object: " + obj +
				// " couldn't be added into Person: " + person);
			}
		}
		else {
			log.debug("merging: " + obj + " into Person: " + person);

			if (obj instanceof Education) {
				Education education = (Education) obj;
				Education originalEducation = person.getEducation(education.getId());
				DomainUtil.copyProperties(originalEducation, education);
			}
			else if (obj instanceof Career) {
				Career career = (Career) obj;
				Career originalCareer = person.getCareer(career.getId());
				DomainUtil.copyProperties(originalCareer, career);
			}
			else {
				// throw new CommonRuntimeException("object: " + obj +
				// " couldn't be added into Person: " + person);
			}
		}
		return save(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> findAllPersons() {
		return crudService.findByNamedQuery(Person.ALL);
	}
}
