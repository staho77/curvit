package com.staho.ms.jpa;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

@Typed()
class ExtendedEntityManager implements EntityManager, Serializable {
	private static final long serialVersionUID = 1L;

	private transient EntityManager wrapped;

	protected ExtendedEntityManager() {
	}

	public ExtendedEntityManager(EntityManager wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public void clear() {
		wrapped.clear();
	}

	@Override
	public void close() {
		wrapped.close();
	}

	@Override
	public boolean contains(Object arg0) {
		return wrapped.contains(arg0);
	}

	@Override
	public Query createNamedQuery(String arg0) {
		return wrapped.createNamedQuery(arg0);
	}

	@Override
	public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
		return wrapped.createNamedQuery(arg0, arg1);
	}

	@Override
	public Query createNativeQuery(String arg0) {
		return wrapped.createNativeQuery(arg0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Query createNativeQuery(String arg0, Class arg1) {
		return wrapped.createNativeQuery(arg0, arg1);
	}

	@Override
	public Query createNativeQuery(String arg0, String arg1) {
		return wrapped.createNativeQuery(arg0, arg1);
	}

	@Override
	public Query createQuery(String arg0) {
		return wrapped.createQuery(arg0);
	}

	@Override
	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
		return wrapped.createQuery(arg0);
	}

	@Override
	public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
		return wrapped.createQuery(arg0, arg1);
	}

	@Override
	public void detach(Object arg0) {
		wrapped.detach(arg0);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1) {
		return wrapped.find(arg0, arg1);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		return wrapped.find(arg0, arg1, arg2);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		return wrapped.find(arg0, arg1, arg2);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		return wrapped.find(arg0, arg1, arg2, arg3);
	}

	@Override
	public void flush() {
		wrapped.flush();
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return wrapped.getCriteriaBuilder();
	}

	@Override
	public Object getDelegate() {
		return wrapped.getDelegate();
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return wrapped.getEntityManagerFactory();
	}

	@Override
	public FlushModeType getFlushMode() {
		return wrapped.getFlushMode();
	}

	@Override
	public LockModeType getLockMode(Object arg0) {
		return wrapped.getLockMode(arg0);
	}

	@Override
	public Metamodel getMetamodel() {
		return wrapped.getMetamodel();
	}

	@Override
	public Map<String, Object> getProperties() {
		return wrapped.getProperties();
	}

	@Override
	public <T> T getReference(Class<T> arg0, Object arg1) {
		return wrapped.getReference(arg0, arg1);
	}

	@Override
	public EntityTransaction getTransaction() {
		return wrapped.getTransaction();
	}

	@Override
	public boolean isOpen() {
		return wrapped.isOpen();
	}

	@Override
	public void joinTransaction() {
		wrapped.joinTransaction();
	}

	@Override
	public void lock(Object arg0, LockModeType arg1) {
		wrapped.lock(arg0, arg1);
	}

	@Override
	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		wrapped.lock(arg0, arg1, arg2);
	}

	@Override
	public <T> T merge(T arg0) {
		return wrapped.merge(arg0);
	}

	@Override
	public void persist(Object arg0) {
		wrapped.persist(arg0);
	}

	@Override
	public void refresh(Object arg0) {
		wrapped.refresh(arg0);
	}

	@Override
	public void refresh(Object arg0, Map<String, Object> arg1) {
		wrapped.refresh(arg0, arg1);
	}

	@Override
	public void refresh(Object arg0, LockModeType arg1) {
		wrapped.refresh(arg0, arg1);
	}

	@Override
	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		wrapped.refresh(arg0, arg1, arg2);
	}

	@Override
	public void remove(Object arg0) {
		wrapped.remove(arg0);
	}

	@Override
	public void setFlushMode(FlushModeType arg0) {
		wrapped.setFlushMode(arg0);
	}

	@Override
	public void setProperty(String arg0, Object arg1) {
		wrapped.setProperty(arg0, arg1);
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		return wrapped.unwrap(arg0);
	}
}
