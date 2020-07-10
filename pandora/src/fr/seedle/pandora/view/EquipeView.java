package fr.seedle.pandora.view;

import java.util.List;

import fr.seedle.pandora.dao.EquipeDaoImpl;
import fr.seedle.pandora.dto.EquipeDto;
import fr.seedle.pandora.interfaces.dao.EquipeDao;

public class EquipeView {

	public List<EquipeDto> getListEquipes() {
		final EquipeDao equipeDao = new EquipeDaoImpl();
		return equipeDao.getAll();
	}

}
