package fr.seedle.pandora.membre.test;

import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.seedle.pandora.dao.MembreDaoImpl;
import fr.seedle.pandora.dao.RoleDaoImpl;
import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;
import fr.seedle.pandora.interfaces.dao.RoleDao;
import fr.seedle.pandora.interfaces.dto.Membre;
import fr.seedle.pandora.interfaces.dto.Role;

public class MembreToJSONTest {

	@Test
	public void execute() throws JsonProcessingException {

		System.out.println("Before role");

		final RoleDao roleDao = new RoleDaoImpl();
		final Role role = roleDao.getInstance();
		role.setNom("magicien");

		System.out.println("Before membre");

		final MembreDao membreDao = new MembreDaoImpl();
		final Membre membre = membreDao.getInstance();

		System.out.println("Before affectation attribut au membre");

		membre.setAvatar("Avatar");
		membre.setDateNaissance(new Date());
		membre.setEmail("toto@titi.com");
		membre.setLeader(false);
		membre.setLogin("toto");
		membre.setMobile("01 02 03 04 05");
		membre.setNom("Titi");
		membre.setPrenom("toto");

		membre.setRole((RoleDto) role);

		ObjectMapper mapper = new ObjectMapper();
		String resultat = mapper.writeValueAsString(membre);

		System.out.println(resultat);
	}

}
