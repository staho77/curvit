package com.staho.ms.jpa;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;

public class DataBaseProducer {

	@PersistenceContext(unitName = "curvit")// persistence-unit name from persistence.xml
	private EntityManager extendedEntityManager;

	@Produces
	@ConversationScoped
	@Curvit
	public ExtendedEntityManager createExtendedEntityManager() {
		return new ExtendedEntityManager(this.extendedEntityManager);
	}

	public void dispose(@Disposes @Curvit ExtendedEntityManager extendedEntityManager) {
		if (extendedEntityManager.isOpen()) {
			extendedEntityManager.close();
		}
	}
}
