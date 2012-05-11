package com.staho.ms.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

public class CrudServiceImpl implements CrudService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Curvit
	private EntityManager entityManager;

	private static final Log log = LogFactory.getLog(CrudServiceImpl.class);

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Log getLog() {
		return log;
	}

	@Transactional(qualifier = Curvit.class)
	public <T> T insert(T t) {
		getEntityManager().persist(t);
		return t;
	}

	@Transactional(qualifier = Curvit.class)
	public <T> T update(T t) {
		return getEntityManager().merge(t);
	}

	public <T> T persist(T t) {
		getEntityManager().persist(t);
		return t;
	}

	public <T> T find(Class<T> type, Object id) {
		return (T) getEntityManager().find(type, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delete(Class type, Object id) {
		Object ref = getEntityManager().getReference(type, id);
		getEntityManager().remove(ref);
	}

	public <T> T merge(T t) {
		T merged = getEntityManager().merge(t);
		return merged;
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String name) {
		return getEntityManager().createNamedQuery(name).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String name, Map<String, Object> parameters) {
		return findByNamedQuery(name, parameters, 0);
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String name, int resultLimit) {
		return getEntityManager().createNamedQuery(name).setMaxResults(resultLimit).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String name, Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(name);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNativeQuery(String query, Class<T> type) {
		return getEntityManager().createNativeQuery(query, type).getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> T findObjectByNamedQuery(String name) {
		return (T) getEntityManager().createNamedQuery(name).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <T> T findObjectByNamedQuery(String name, Map<String, Object> parameters) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(name);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		T obj = null;
		try {
			obj = (T) query.getSingleResult();
		} catch (NoResultException nre) {
		}

		return obj;
	}

	public void createNativeQuery(String query) {
		getEntityManager().createNativeQuery(query).executeUpdate();
	}

	@Override
	public boolean isLoaded(Object obj) {
		return isLoaded(obj, null);
	}

	@Override
	public boolean isLoaded(Object obj, String property) {
		PersistenceUnitUtil unitUtil = getEntityManager().getEntityManagerFactory()
				.getPersistenceUnitUtil();
		if (property == null) {
			getLog().debug("checking if object: " + obj + " is loaded");
			return unitUtil.isLoaded(obj);
		}
		getLog().debug("checking if property" + property + " in object: " + obj + " is loaded");
		return unitUtil.isLoaded(obj, property);
	}

	@Override
	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}
}
