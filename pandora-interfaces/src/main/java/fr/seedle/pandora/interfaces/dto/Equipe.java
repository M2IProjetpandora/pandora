package fr.seedle.pandora.interfaces.dto;

import java.util.Set;

import fr.seedle.pandora.dto.DressCodeDto;
import fr.seedle.pandora.dto.LieuDto;
import fr.seedle.pandora.dto.MembreDto;

public interface Equipe extends PandoraObject {

	public String getBlason();

	public void setBlason(String blason);

	public LieuDto getLieu();

	public void setLieu(LieuDto lieu);

	public Set<MembreDto> getListMembres();

	public void setListMembres(Set<MembreDto> listMembres);

	public String getDescription();

	public void setDescription(String description);

	public DressCodeDto getDressCode();

	public void setDressCode(DressCodeDto dressCode);

}
