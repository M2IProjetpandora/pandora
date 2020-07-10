package fr.seedle.pandora.singleton;

import java.io.File;
import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import fr.seedle.pandora.hibernate.HibernateConfiguration;

/***
 * 
 * @author eric
 *
 */
public class HibernateSingleton implements Serializable {

	/*
	 * serialVersionUID - long
	 */
	private static final long serialVersionUID = 5060277755980541156L;

	/*
	 * Le singleton
	 */
	private static HibernateSingleton hibernateSingleton;

	/*
	 * Hibernate session
	 */
	private SessionFactory factory;

	/***
	 * 
	 * @return le singleton
	 */
	public static HibernateSingleton getInstance() {
		if (hibernateSingleton == null) {
			hibernateSingleton = new HibernateSingleton();
		}
		return hibernateSingleton;
	}

	/***
	 * * Constructeur 2 avr. 2020 fr.seedle.insui.singleton insui-implementations 2
	 * avr. 2020
	 */
	public HibernateSingleton() {

		final HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();

		// FIXME il faut définir un répertoire de configuration
		final String theUserDir = "masociete.cfg.xml";

		final Configuration configuration = hibernateConfiguration.getConfiguration(new File(theUserDir));

		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties()).build();
		final ServiceRegistry serviceRegistry = builder.build();

		this.factory = configuration.buildSessionFactory(serviceRegistry);

	}

	/***
	 * 
	 * 9 sept. 2019
	 * 
	 * @return fr.seedle.insui.bean insui-implementations 9 sept. 2019
	 */
	public SessionFactory getFactory() {
		return this.factory;
	}

	/***
	 * factory 10 oct. 2019 fr.seedle.insui.bean insui-implementations 10 oct. 2019
	 * 
	 * @return the factory
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
