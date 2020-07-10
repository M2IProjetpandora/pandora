package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.ObjectifDto;

public interface ObjectifDao {

	public ObjectifDto getInstance();

	public void insert(ObjectifDto objectif) throws Throwable;

	public void update(ObjectifDto objectif);

	public void delete(ObjectifDto objectif);

	public List<ObjectifDto> getAll();

}
