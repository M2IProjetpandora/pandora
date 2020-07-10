package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.OperationRoleDto;

public interface OperationRoleDao {

	public OperationRoleDto getInstance();

	public void insert(OperationRoleDto operationRole) throws Throwable;

	public void update(OperationRoleDto operationRole);

	public void delete(OperationRoleDto operationRole);

	public List<OperationRoleDto> getAll();

}
