package com.data.provider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public abstract class AbstractProvider<T> {
	@PersistenceContext(name="mewe")
	private static EntityManagerFactory emf;
	EntityManager em;

	public AbstractProvider() {
		if (em != null && em.isOpen()) {
			em.close();
		}
		if (getEmf() == null) {
			emf = Persistence.createEntityManagerFactory("mewe");
		}
		em = emf.createEntityManager();
	}

	protected EntityManagerFactory getEmf() {

		return emf;

	}

	protected abstract Class<T> getEntityClass();

	/**
	 * Save.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	public boolean save(T obj) {

		if (!em.isOpen()) {

			em = getEmf().createEntityManager();

		}

		try {

			em.getTransaction().begin();
			em.persist(obj);
			// em.flush();
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;

		}

	}

	/**
	 * Update.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	public boolean update(T obj) {

		if (!em.isOpen()) {

			em = getEmf().createEntityManager();

		}

		try {

			em.getTransaction().begin();
			em.merge(obj);
			// em.flush();
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;

		}

	}

	/**
	 * Delete.
	 *
	 * @param objId
	 *            the obj id
	 * @return true, if successful
	 */
	public boolean delete(Integer objId) {

		if (!em.isOpen()) {

			em = getEmf().createEntityManager();

		}

		try {

			em.getTransaction().begin();
			T persistedObj = this.find(objId);
			em.remove(persistedObj);
			// em.flush();
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;

		}

	}

	/**
	 * Find.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T find(Integer id) {
		return (T) em.find(getEntityClass(), id);
	}

}
