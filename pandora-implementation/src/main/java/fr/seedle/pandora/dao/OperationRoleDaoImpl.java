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

import fr.seedle.pandora.dto.OperationRoleDto;
import fr.seedle.pandora.interfaces.dao.OperationRoleDao;
import fr.seedle.pandora.singleton.HibernateSingleton;

public class OperationRoleDaoImpl implements OperationRoleDao {

	@Override
	public OperationRoleDto getInstance() {
		final OperationRoleDto operation = new OperationRoleDto();
		return operation;
	}

	@Override
	public void insert(OperationRoleDto operation) throws Throwable {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(operation);
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
	public void update(OperationRoleDto operation) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(operation);
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
	public void delete(OperationRoleDto operation) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(operation);
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
	public List<OperationRoleDto> getAll() {
		Session session = HibernateSingleton.getInstance().getFactory().openSession();
		try {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<OperationRoleDto> cr = cb.createQuery(OperationRoleDto.class);
			final Root<OperationRoleDto> root = cr.from(OperationRoleDto.class);

			cr.select(root);

			final Query<OperationRoleDto> query = session.createQuery(cr);

			// Permet d'afficher dans le log la requête à exécuter
			// System.out.println("getAll query : " +
			// query.unwrap(org.hibernate.Query.class).getQueryString());

			final List<OperationRoleDto> results = query.getResultList();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
