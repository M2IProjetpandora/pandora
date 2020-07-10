package fr.seedle.pandora.dto;

import java.time.LocalDateTime;
import java.util.Set;

import fr.seedle.pandora.interfaces.dto.Operation;

public class OperationDto extends PandoraObjectDto implements Operation {

	private String description;
	private LieuDto lieu;
	private LocalDateTime dateHeureDebut;
	private LocalDateTime dateHeureFin;

	private Set<EquipeDto> listEquipeOrganisatrices;

	private Set<FactionDto> listFactions;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LieuDto getLieu() {
		return lieu;
	}

	public void setLieu(LieuDto lieu) {
		this.lieu = lieu;
	}

	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public LocalDateTime getDateHeureFin() {
		return dateHeureFin;
	}

	public void setDateHeureFin(LocalDateTime dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}

	public Set<EquipeDto> getListEquipeOrganisatrices() {
		return listEquipeOrganisatrices;
	}

	public void setListEquipeOrganisatrices(Set<EquipeDto> listEquipeOrganisatrices) {
		this.listEquipeOrganisatrices = listEquipeOrganisatrices;
	}

	public Set<FactionDto> getListFactions() {
		return listFactions;
	}

	public void setListFactions(Set<FactionDto> listFactions) {
		this.listFactions = listFactions;
	}

	@Override
	public String toString() {
		return "OperationDto [description=" + description + ", lieu=" + lieu + ", dateHeureDebut=" + dateHeureDebut
				+ ", dateHeureFin=" + dateHeureFin + ", listEquipeOrganisatrices=" + listEquipeOrganisatrices
				+ ", listFactions=" + listFactions + "]";
	}

}
