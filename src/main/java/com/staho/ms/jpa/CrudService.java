package com.staho.ms.jpa;

import java.util.List;
import java.util.Map;

public interface CrudService {

	<T> T insert(T t);
	
	<T> T update(T t);
	
	<T> T persist(T t);

	<T> T find(Class<T> type, Object id);

	@SuppressWarnings("rawtypes")
	void delete(Class type, Object id);

	<T> T merge(T t);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String name);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String name, Map<String, Object> parameters);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String name, int resultLimit);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String name, Map<String, Object> parameters, int resultLimit);

	<T> List<T> findByNativeQuery(String query, Class<T> type);

	<T> T findObjectByNamedQuery(String name);

	<T> T findObjectByNamedQuery(String name, Map<String, Object> parameters);

	boolean isLoaded(Object obj);

	boolean isLoaded(Object obj, String property);

	void createNativeQuery(String query);

	void beginTransaction();

	void commitTransaction();
}
