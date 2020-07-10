package fr.seedle.pandora.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.singleton.RoleSingleton;

@ManagedBean(name="roleControllerListBean")
@ViewScoped
public class RoleControllerListBean {

	private List<RoleDto> listRoles;
	private RoleDto role;
	
	@ManagedProperty(value="#{loginBean}") 
	LoginBean loginBean;
	
	/**
	 * Cette méthode possédant l'annotation 'postConstruct' sera appelée 
	 * automatiquement lors de l'instanciation du bean
	 * 
	 * @param request
	 * @param response
	 */
	@PostConstruct
	public void init() {
		listRoles = RoleSingleton.getInstance().getListRoles();		
	}
	
	
	public List<RoleDto> getListRoles() {
		return listRoles;
	}
	
	public void setListRoles(List<RoleDto> listRoles) {
		this.listRoles = listRoles;
	}
	
	public RoleDto getRole() {
		return role;
	}
	
	public void setRole(RoleDto role) {
		this.role = role;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public void onSelect(RoleDto role) {
		System.out.println("Sélection d'un rôle " + role);
		this.role = role;
		
		final FacesContext context = FacesContext.getCurrentInstance();
		final LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);

		loginBean.getMembreCourant().setRole(this.role);
	}
	public void deSelect() {
		this.role = null;
		
		final FacesContext context = FacesContext.getCurrentInstance();
		final LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		loginBean.getMembreCourant().setRole(null);
	}
	
	
}
