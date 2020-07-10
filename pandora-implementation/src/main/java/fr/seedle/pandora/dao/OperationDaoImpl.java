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

import fr.seedle.pandora.dto.OperationDto;
import fr.seedle.pandora.interfaces.dao.OperationDao;
import fr.seedle.pandora.singleton.HibernateSingleton;

public class OperationDaoImpl implements OperationDao {

	@Override
	public OperationDto getInstance() {
		final OperationDto operation = new OperationDto();
		operation.setNom("veuillez nommer cette nouvelle opération");
		operation.setDescription("Veuillez décrire votre opération de manière claire et concise");
		return operation;
	}

	@Override
	public void insert(OperationDto operation) throws Throwable {
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
	public void update(OperationDto operation) {
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
	public void delete(OperationDto operation) {
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
	public List<OperationDto> getAll() {
		Session session = HibernateSingleton.getInstance().getFactory().openSession();
		try {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<OperationDto> cr = cb.createQuery(OperationDto.class);
			final Root<OperationDto> root = cr.from(OperationDto.class);

			cr.select(root);

			final Query<OperationDto> query = session.createQuery(cr);

			// Permet d'afficher dans le log la requête à exécuter
			// System.out.println("getAll query : " +
			// query.unwrap(org.hibernate.Query.class).getQueryString());

			final List<OperationDto> results = query.getResultList();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
