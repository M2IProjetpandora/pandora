package fr.seedle.pandora.dto;

import fr.seedle.pandora.interfaces.dto.OperationRole;

public class OperationRoleDto extends PandoraObjectDto implements OperationRole {

	private OperationDto operation;
	private String description;

	public OperationDto getOperation() {
		return operation;
	}

	public void setOperation(OperationDto operation) {
		this.operation = operation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
