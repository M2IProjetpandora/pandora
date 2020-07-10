package fr.seedle.pandora.dto;

import java.util.Set;

import fr.seedle.pandora.interfaces.dto.RelationFactionEquipe;

public class RelationFactionEquipeDto extends PandoraObjectDto implements RelationFactionEquipe {

	private FactionDto faction;

	private OperationRoleDto operationRole;

	private EquipeDto equipe;

	private Set<MembreDto> listMembres;

	public FactionDto getFaction() {
		return faction;
	}

	public void setFaction(FactionDto faction) {
		this.faction = faction;
	}

	public OperationRoleDto getOperationRole() {
		return operationRole;
	}

	public void setOperationRole(OperationRoleDto operationRole) {
		this.operationRole = operationRole;
	}

	public EquipeDto getEquipe() {
		return equipe;
	}

	public void setEquipe(EquipeDto equipe) {
		this.equipe = equipe;
	}

	public Set<MembreDto> getListMembres() {
		return listMembres;
	}

	public void setListMembres(Set<MembreDto> listMembres) {
		this.listMembres = listMembres;
	}

}
