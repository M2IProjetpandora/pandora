package fr.seedle.pandora.interfaces.dto;

import java.time.LocalDateTime;
import java.util.Set;

import fr.seedle.pandora.dto.EquipeDto;
import fr.seedle.pandora.dto.FactionDto;
import fr.seedle.pandora.dto.LieuDto;

public interface Operation extends PandoraObject {

	public String getDescription();

	public void setDescription(String description);

	public LieuDto getLieu();

	public void setLieu(LieuDto lieu);

	public LocalDateTime getDateHeureDebut();

	public void setDateHeureDebut(LocalDateTime dateHeureDebut);

	public LocalDateTime getDateHeureFin();

	public void setDateHeureFin(LocalDateTime dateHeureFin);

	public Set<EquipeDto> getListEquipeOrganisatrices();

	public void setListEquipeOrganisatrices(Set<EquipeDto> listEquipeOrganisatrices);

	public Set<FactionDto> getListFactions();

	public void setListFactions(Set<FactionDto> listFactions);

}
