package fr.seedle.pandora.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.seedle.pandora.interfaces.dto.Membre;

@Entity(name = "MembreDto")
@Table(name = "membre")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MembreDto extends PandoraObjectDto implements Membre {

	@Column
	private String avatar;

	@Column
	private String prenom;

	@Column(nullable = false)
	private String pseudo;

	@Column
	private String login;

	@Column
	private String email;

	@Column
	private String mobile;

	@Column
	private Date dateNaissance;

	@Column
	private boolean isLeader;

	@ManyToOne(optional = false)
	@JoinColumn(updatable = true, insertable = true)
	private RoleDto role;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MembreDto [avatar=" + avatar + ", prenom=" + prenom + ", pseudo=" + pseudo + ", login=" + login
				+ ", email=" + email + ", mobile=" + mobile + ", dateNaissance=" + dateNaissance + ", isLeader="
				+ isLeader + ", getId()=" + getId() + ", getNom()=" + getNom() + "]";
	}

}
