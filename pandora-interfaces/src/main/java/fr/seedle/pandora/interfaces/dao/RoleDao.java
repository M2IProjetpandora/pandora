package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.RoleDto;

public interface RoleDao {

	public RoleDto getInstance();

	public void insert(RoleDto role) throws Throwable;

	public void update(RoleDto role);

	public void delete(RoleDto role);

	public List<RoleDto> getAll();

}