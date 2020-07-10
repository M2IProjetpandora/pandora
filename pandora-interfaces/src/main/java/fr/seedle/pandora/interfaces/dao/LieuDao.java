package fr.seedle.pandora.interfaces.dao;

import java.util.List;

import fr.seedle.pandora.dto.LieuDto;

public interface LieuDao {

	public LieuDto getInstance();

	public void insert(LieuDto lieu) throws Throwable;

	public void update(LieuDto lieu);

	public void delete(LieuDto lieu);

	public List<LieuDto> getAll();

}
