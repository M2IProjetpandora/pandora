package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.RelationFactionEquipeDto;

public interface RelationFactionEquipeDao {

	public RelationFactionEquipeDto getInstance();

	public void insert(RelationFactionEquipeDto relationFactionEquipe) throws Throwable;

	public void update(RelationFactionEquipeDto relationFactionEquipe);

	public void delete(RelationFactionEquipeDto relationFactionEquipe);

	public List<RelationFactionEquipeDto> getAll();

}
