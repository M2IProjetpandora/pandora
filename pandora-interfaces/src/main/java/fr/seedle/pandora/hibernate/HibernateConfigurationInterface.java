package fr.seedle.pandora.hibernate;

import java.io.File;

import org.hibernate.cfg.Configuration;

/***
 * 
 * @author eric
 *
 */
public interface HibernateConfigurationInterface {

	/***
	 * *
	 * 
	 * @author eric
	 * @version fr.actioncom2015.borealecontact.interface
	 * @date 15 juin 2018
	 *
	 * @param dbname
	 * @param fileHibernateConfig
	 * @return
	 */
	public Configuration getConfiguration(File fileHibernateConfig);

}
