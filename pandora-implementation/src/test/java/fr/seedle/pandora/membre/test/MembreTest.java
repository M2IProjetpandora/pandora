package fr.seedle.pandora.membre.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import fr.seedle.pandora.dao.MembreDaoImpl;
import fr.seedle.pandora.dao.RoleDaoImpl;
import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;
import fr.seedle.pandora.interfaces.dao.RoleDao;
import fr.seedle.pandora.interfaces.dto.Role;

public class MembreTest {

	@Test
	public void execute() throws SQLException {

		createSequence();
		createTableRole();
		createTableMembre();
		createTableRoleMembre();

		final RoleDao roleDao = new RoleDaoImpl();
		final Role role = roleDao.getInstance();
		role.setNom("magicien");

		final MembreDao membreDao = new MembreDaoImpl();
		final MembreDto membre = membreDao.getInstance();

		membre.setAvatar("Avatar");
		membre.setPseudo("toto");
		membre.setDateNaissance(new Date());
		membre.setEmail("toto@titi.com");
		membre.setLeader(false);
		membre.setLogin("toto");
		membre.setMobile("01 02 03 04 05");
		membre.setNom("Titi");
		membre.setPrenom("toto");

		membre.setRole((RoleDto) role);

		try {
			roleDao.insert((RoleDto) role);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

		try {
			membreDao.insert(membre);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		ResultSet rs = statement.executeQuery("select * from membre");
		while (rs.next()) {
			final MembreDto membreDto = new MembreDto();
			membreDto.setId(rs.getLong("id"));
			membreDto.setLogin(rs.getString("nom"));
			membreDto.setLogin(rs.getString("login"));
			System.out.println("result " + membreDto);
		}
		statement.close();
		rs.close();
		closeConnection(connexion);

		connexion = getConnection();
		statement = connexion.createStatement();
		rs = statement.executeQuery("select * from role");
		while (rs.next()) {
			final RoleDto roleDto = new RoleDto();
			roleDto.setId(rs.getLong("id"));
			roleDto.setNom(rs.getString("nom"));
			System.out.println("result " + roleDto);
		}
		statement.close();
		rs.close();
		closeConnection(connexion);

		connexion = getConnection();
		statement = connexion.createStatement();
		rs = statement.executeQuery("select * from role_membre");
		while (rs.next()) {
			System.out.println("role : " + rs.getLong("roledto_id") + ", membre : " + rs.getLong("listmembres_id"));
		}
		statement.close();
		rs.close();
		closeConnection(connexion);

		List<RoleDto> roles = roleDao.getAll();
		System.out.println("roles : " + roles);
		for (RoleDto roleTemp : roles) {
			System.out.println("résultat recherche par critéria " + roleTemp);
		}
	}

	public Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			// Fonctionnement avec écriture sur disque dur
			// DriverManager.getConnection("jdbc:hsqldb:file:database", "sa", "");

			// Fonctionnement exclusivement en mémoire
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:mem:database", "sa", "");
			return connexion;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createSequence() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableMembre() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate(
				"CREATE TABLE membre(id bigint, role_id bigint, nom varchar(100),avatar varchar(100),prenom varchar(100), pseudo varchar(100), login varchar(100), email varchar(100),\n"
						+ " mobile varchar(100), dateNaissance timestamp, isLeader boolean)");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableRoleMembre() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE TABLE ROLE_MEMBRE(RoleDto_id bigint, listMembres_id bigint)");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableRole() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE TABLE role(id bigint,nom varchar(100))");
		statement.close();
		closeConnection(connexion);
	}

}
