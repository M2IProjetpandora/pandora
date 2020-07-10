package fr.seedle.pandora.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

import fr.seedle.pandora.interfaces.dto.PandoraObject;

@MappedSuperclass
public class PandoraObjectDto implements PandoraObject {

	@Id
	@GeneratedValue
	private long id;

	@Column
	@NotNull
	private String nom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Date de création, l'auteur 

}
