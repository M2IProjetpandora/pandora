package fr.seedle.pandora.dto;

import java.time.LocalDateTime;

import fr.seedle.pandora.interfaces.dto.Objectif;

public class ObjectifDto extends PandoraObjectDto implements Objectif {

	private String description;
	private LocalDateTime dateHeureDebut;
	private LocalDateTime dateHeureFin;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
