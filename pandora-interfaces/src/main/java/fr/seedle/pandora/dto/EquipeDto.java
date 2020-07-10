package fr.seedle.pandora.dto;

import java.util.Set;

import fr.seedle.pandora.interfaces.dto.Equipe;

public class EquipeDto extends PandoraObjectDto implements Equipe {

	private String blason;
	private LieuDto lieu;
	private Set<MembreDto> listMembres;
	private String description;
	private DressCodeDto dressCode;

	public String getBlason() {
		return blason;
	}

	public void setBlason(String blason) {
		this.blason = blason;
	}

	public LieuDto getLieu() {
		return lieu;
	}

	public void setLieu(LieuDto lieu) {
		this.lieu = lieu;
	}

	public Set<MembreDto> getListMembres() {
		return listMembres;
	}

	public void setListMembres(Set<MembreDto> listMembres) {
		this.listMembres = listMembres;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DressCodeDto getDressCode() {
		return dressCode;
	}

	public void setDressCode(DressCodeDto dressCode) {
		this.dressCode = dressCode;
	}

}
