package fr.seedle.pandora.singleton;

import java.util.ArrayList;
import java.util.List;

import fr.seedle.pandora.dao.RoleDaoImpl;
import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.interfaces.dao.RoleDao;

public class RoleSingleton {

	private static RoleSingleton roleSingleton;

	private List<RoleDto> listRoles = new ArrayList<>();

	public static RoleSingleton getInstance() {
		if (roleSingleton == null) {
			roleSingleton = new RoleSingleton();
		}
		return roleSingleton;
	}

	public RoleSingleton() {
		final RoleDao rolDao = new RoleDaoImpl();
		
		final RoleDto r1 = rolDao.getInstance();
		r1.setNom("Assasin");
		listRoles.add(r1);

		final RoleDto r2 = rolDao.getInstance();
		r2.setNom("Knight");
		listRoles.add(r2);
	}

	public RoleDto getRoleByNom(String nom) {
		for (RoleDto role : listRoles) {
			if (role.getNom().equals(nom)) {
				return role;
			}
		}
		return null;
	}

	public List<RoleDto> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<RoleDto> listRoles) {
		this.listRoles = listRoles;
	}
}