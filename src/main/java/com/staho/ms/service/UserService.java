package com.staho.ms.service;

import java.util.List;

import com.staho.ms.domain.Id;
import com.staho.ms.domain.Person;

public interface UserService {

	Person save(Person person);

	Person add(Id obj, Person person);

	Person delete(Person person);

	Person remove(Id obj, Person person);

	List<Person> findAllPersons();
}
