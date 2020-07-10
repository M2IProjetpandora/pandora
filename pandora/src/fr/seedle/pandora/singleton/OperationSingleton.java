package fr.seedle.pandora.singleton;

import java.util.ArrayList;
import java.util.List;

import fr.seedle.pandora.dao.OperationDaoImpl;
import fr.seedle.pandora.dto.OperationDto;
import fr.seedle.pandora.interfaces.dao.OperationDao;

public class OperationSingleton {

	private static OperationSingleton operationSingleton;

	private List<OperationDto> listOperations = new ArrayList<>();

	public static OperationSingleton getInstance() {
		if (operationSingleton == null) {
			operationSingleton = new OperationSingleton();
		}
		return operationSingleton;
	}

	public OperationSingleton() {
		final OperationDao operationDao = new OperationDaoImpl();
		final OperationDto m1 = operationDao.getInstance();
		m1.setNom("FADEL");
		listOperations.add(m1);

		final OperationDto m2 = operationDao.getInstance();
		m2.setNom("TCHICAYA");
		listOperations.add(m2);
	}

	public OperationDto getOperationByNom(String nom) {
		for (OperationDto operation : listOperations) {
			if (operation.getNom().equals(nom)) {
				return operation;
			}
		}
		return null;
	}

	public List<OperationDto> getListOperations() {
		return listOperations;
	}

	public void setListOperations(List<OperationDto> listOperations) {
		this.listOperations = listOperations;
	}
}