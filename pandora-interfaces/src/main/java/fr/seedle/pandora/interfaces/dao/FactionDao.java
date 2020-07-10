package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.FactionDto;

public interface FactionDao {

	public FactionDto getInstance();

	public void insert(FactionDto faction) throws Throwable;

	public void update(FactionDto faction);

	public void delete(FactionDto faction);

	public List<FactionDto> getAll();

}
