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

import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;
import fr.seedle.pandora.singleton.HibernateSingleton;

public class MembreDaoImpl implements MembreDao {

	@Override
	public MembreDto getInstance() {
		final MembreDto membre = new MembreDto();
		membre.setLeader(true);
		return membre;
	}

	@Override
	public void insert(MembreDto membre) throws Throwable {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(membre);
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
	public void update(MembreDto membre) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(membre);
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
	public void delete(MembreDto membre) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(membre);
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
	public List<MembreDto> getAll() {
		Session session = HibernateSingleton.getInstance().getFactory().openSession();
		try {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<MembreDto> cr = cb.createQuery(MembreDto.class);
			final Root<MembreDto> root = cr.from(MembreDto.class);

			cr.orderBy(cb.asc(root.get("semaine")));
			cr.select(root);

			final Query<MembreDto> query = session.createQuery(cr);

			// Permet d'afficher dans le log la requête à exécuter
			// System.out.println("getAll query : " +
			// query.unwrap(org.hibernate.Query.class).getQueryString());

			final List<MembreDto> results = query.getResultList();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}