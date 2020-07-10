package fr.seedle.pandora.hibernate;

import java.io.File;

import org.hibernate.cfg.Configuration;

import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.dto.RoleDto;

/***
 * 
 * @author eric
 *
 */
public class HibernateConfiguration implements HibernateConfigurationInterface {

	/*
	 * 
	 */
	private Configuration configuration;

	/***
	 * *
	 * 
	 * @author eric
	 * @version fr.actioncom2015.borealecontact.launcher
	 * @date 14 juin 2018
	 *
	 * @param fileHibernateConfig
	 * @return
	 */
	public HibernateConfiguration() {
	}

	/***
	 * *
	 * 
	 * @author eric
	 * @version fr.actioncom2015.borealecontact.launcher
	 * @date 14 juin 2018
	 *
	 * @param fileHibernateConfig
	 * @return
	 */
	public Configuration getConfiguration(File fileHibernateConfig) {
		configuration = new Configuration().configure(fileHibernateConfig).setInterceptor(null);

		configuration.addAnnotatedClass(MembreDto.class);
		configuration.addAnnotatedClass(RoleDto.class);

		return configuration;
	}
}