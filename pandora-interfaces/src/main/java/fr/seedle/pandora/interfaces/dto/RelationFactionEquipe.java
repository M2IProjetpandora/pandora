package fr.seedle.pandora.interfaces.dto;

import java.util.Set;

import fr.seedle.pandora.dto.EquipeDto;
import fr.seedle.pandora.dto.FactionDto;
import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.dto.OperationRoleDto;

public interface RelationFactionEquipe extends PandoraObject {

	public FactionDto getFaction();

	public void setFaction(FactionDto faction);

	public EquipeDto getEquipe();

	public void setEquipe(EquipeDto equipe);

	public OperationRoleDto getOperationRole();

	public void setOperationRole(OperationRoleDto operationRole);

	public Set<MembreDto> getListMembres();

	public void setListMembres(Set<MembreDto> listMembre);
}
