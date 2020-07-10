package fr.seedle.pandora.interfaces.dto;

import fr.seedle.pandora.dto.OperationDto;

public interface OperationRole extends PandoraObject {

	public OperationDto getOperation();

	public void setOperation(OperationDto operation);

	public String getDescription();

	public void setDescription(String description);

}
