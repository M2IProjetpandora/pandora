package fr.seedle.pandora.interfaces.dto;

import java.time.LocalDateTime;

public interface Objectif extends PandoraObject {

	public String getDescription();

	public void setDescription(String description);

	public LocalDateTime getDateHeureDebut();

	public void setDateHeureDebut(LocalDateTime dateHeureDebut);

	public LocalDateTime getDateHeureFin();

	public void setDateHeureFin(LocalDateTime dateHeureFin);

}
