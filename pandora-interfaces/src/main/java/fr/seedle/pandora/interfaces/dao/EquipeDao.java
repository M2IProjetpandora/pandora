package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.EquipeDto;

public interface EquipeDao {

	public EquipeDto getInstance();

	public void insert(EquipeDto equipe) throws Throwable;

	public void update(EquipeDto equipe);

	public void delete(EquipeDto equipe);

	public List<EquipeDto> getAll();

}
