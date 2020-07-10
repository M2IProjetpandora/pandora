package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.MembreDto;

public interface MembreDao {

	public MembreDto getInstance();

	public void insert(MembreDto membre) throws Throwable;

	public void update(MembreDto membre);

	public void delete(MembreDto membre);

	public List<MembreDto> getAll();
}
