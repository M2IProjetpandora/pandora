package fr.seedle.pandora.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.interfaces.dao.RoleDao;
import fr.seedle.pandora.singleton.HibernateSingleton;

public class RoleDaoImpl implements RoleDao {

	@Override
	public RoleDto getInstance() {
		return new RoleDto();
	}

	@Override
	public void insert(RoleDto role) throws Throwable {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(role);
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
	public void update(RoleDto role) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(role);
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
	public void delete(RoleDto role) {
		SessionFactory factory = HibernateSingleton.getInstance().getFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(role);
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
	public List<RoleDto> getAll() {
		Session session = HibernateSingleton.getInstance().getFactory().openSession();
		try {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<RoleDto> cr = cb.createQuery(RoleDto.class);
			final Root<RoleDto> root = cr.from(RoleDto.class);

			cr.select(root);

			final Query<RoleDto> query = session.createQuery(cr);

			// Permet d'afficher dans le log la requête à exécuter
			// System.out.println("getAll query : " +
			// query.unwrap(org.hibernate.Query.class).getQueryString());

			final List<RoleDto> results = query.getResultList();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
