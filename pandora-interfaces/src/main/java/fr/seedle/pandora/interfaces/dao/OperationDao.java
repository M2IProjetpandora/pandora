package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.OperationDto;

public interface OperationDao {

	public OperationDto getInstance();

	public void insert(OperationDto Operation) throws Throwable;

	public void update(OperationDto Operation);

	public void delete(OperationDto Operation);

	public List<OperationDto> getAll();

}
