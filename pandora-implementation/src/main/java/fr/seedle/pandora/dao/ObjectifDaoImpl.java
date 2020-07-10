package fr.seedle.pandora.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.seedle.pandora.dto.ObjectifDto;
import fr.seedle.pandora.interfaces.dao.ObjectifDao;
import fr.seedle.pandora.singleton.HibernateSingleton;

public class ObjectifDaoImpl implements ObjectifDao {

	@Override
	public ObjectifDto getInstance() {
		final ObjectifDto objectif = new ObjectifDto();
		return objectif;
	}

	@Override
	public void insert(ObjectifDto objectif) throws Throwable {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objectif);
			session.flush();
			tx.commit();

		} catch (PropertyValueException e) {
			if (tx != null) {
				tx.rollback();
			}

			throw e;// System.out.println("il manque une relation");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	@Override
	public void update(ObjectifDto objectif) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(objectif);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(ObjectifDto objectif) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(objectif);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<ObjectifDto> getAll() {
		Session session = HibernateSingleton.getInstance().getFactory().openSession();
		try {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<ObjectifDto> cr = cb.createQuery(ObjectifDto.class);
			final Root<ObjectifDto> root = cr.from(ObjectifDto.class);

			cr.select(root);

			final Query<ObjectifDto> query = session.createQuery(cr);

			// Permet d'afficher dans le log la requête à exécuter
			// System.out.println("getAll query : " +
			// query.unwrap(org.hibernate.Query.class).getQueryString());

			final List<ObjectifDto> results = query.getResultList();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
