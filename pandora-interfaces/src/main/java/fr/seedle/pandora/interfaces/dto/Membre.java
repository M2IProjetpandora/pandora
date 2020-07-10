package fr.seedle.pandora.interfaces.dto;

import java.util.Date;

import fr.seedle.pandora.dto.RoleDto;

public interface Membre extends PandoraObject {

	public String getAvatar();

	public void setAvatar(String avatar);

	public String getPrenom();

	public void setPrenom(String prenom);

	public String getPseudo();

	public void setPseudo(String membre);

	public String getLogin();

	public void setLogin(String login);

	public String getEmail();

	public void setEmail(String email);

	public String getMobile();

	public void setMobile(String mobile);

	public Date getDateNaissance();

	public void setDateNaissance(Date dateNaissance);

	public boolean isLeader();

	public void setLeader(boolean isLeader);

	public RoleDto getRole();

	public void setRole(RoleDto role);
}
