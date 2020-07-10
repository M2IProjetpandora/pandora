package fr.seedle.pandora.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.seedle.pandora.interfaces.dto.Role;

@Entity(name = "RoleDto")
@Table(name = "role")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleDto extends PandoraObjectDto implements Role {

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<MembreDto> listMembres = new HashSet<MembreDto>();

	public Set<MembreDto> getListMembres() {
		return listMembres;
	}

	public void setListMembres(Set<MembreDto> listMembres) {
		this.listMembres = listMembres;
	}

	@Override
	public String toString() {
		return "RoleDto [listMembres=" + listMembres + ", getId()=" + getId() + ", getNom()=" + getNom() + "]";
	}

}