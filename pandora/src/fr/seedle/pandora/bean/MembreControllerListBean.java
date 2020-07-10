package fr.seedle.pandora.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.singleton.MembreSingleton;

@ManagedBean(name="membreControllerListBean")
@ViewScoped
public class MembreControllerListBean {

	private List<MembreDto> listMembres;
	private MembreDto membre;
	
	/**
	 * Cette méthode possédant l'annotation 'postConstruct' sera appelée 
	 * automatiquement lors de l'instanciation du bean
	 * 
	 * @param request
	 * @param response
	 */
	@PostConstruct
	public void init() {
		listMembres = MembreSingleton.getInstance().getListMembres();		
	}
	
	
	public List<MembreDto> getListMembres() {
		return listMembres;
	}
	
	public void setListMembres(List<MembreDto> listMembres) {
		this.listMembres = listMembres;
	}
	
	
	public MembreDto getMembre() {
		return membre;
	}
	
	public void setMembre(MembreDto membre) {
		this.membre = membre;
	}
	
	public void onSelect(MembreDto membre) {
		//membre =  RoleSingleton.getInstance().getRoleByNom(nom);
		System.out.println("Sélection d'un membre " + membre);
		this.membre = membre;
	}
	
	
}
