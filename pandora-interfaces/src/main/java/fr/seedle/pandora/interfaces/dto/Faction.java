package fr.seedle.pandora.interfaces.dto;

import java.time.LocalDateTime;
import java.util.Set;

import fr.seedle.pandora.dto.DressCodeDto;
import fr.seedle.pandora.dto.FactionDto;
import fr.seedle.pandora.dto.LieuDto;
import fr.seedle.pandora.dto.OperationRoleDto;
import fr.seedle.pandora.dto.RelationFactionEquipeDto;

public interface Faction extends PandoraObject {

	public OperationRoleDto getOperationRole();

	public void setOperationRole(OperationRoleDto operationRole);

	public String getBlason();

	public void setBlason(String blason);

	public String getDescription();

	public void setDescription(String description);

	public DressCodeDto getDressCode();

	public void setDessCode(DressCodeDto dressCode);

	public Set<RelationFactionEquipeDto> getListRelationFactionEquipes();

	public void setListRelationFactionEquipes(Set<RelationFactionEquipeDto> listRelationFactionEquipes);

	public Set<FactionDto> getListFactionAmis();

	public void setListFactionAmis(Set<FactionDto> listFactionAmis);

	public LocalDateTime getDateHeureDebut();

	public void setDateHeureDebut(LocalDateTime dateHeureDebut);

	public LocalDateTime getDateHeureFin();

	public void setDateHeureFin(LocalDateTime dateHeureFin);

	public LieuDto getLieuInsertion();

	public void setLieuInsertion(LieuDto lieu);

}
