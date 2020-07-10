package fr.seedle.pandora.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.dto.OperationDto;
import fr.seedle.pandora.dto.RoleDto;

public class PandoraBean {

	public void init(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Je suis instancié " + this.getClass().getName());
	}

	private MembreDto membreConnecter;

	private RoleDto roleCourant;

	private OperationDto operationCourante;

	public MembreDto getMembreConnecter() {
		return membreConnecter;
	}

	public void setMembreConnecter(MembreDto membreConnecter) {
		this.membreConnecter = membreConnecter;
	}

	public RoleDto getRoleCourant() {
		return roleCourant;
	}

	public void setRoleCourant(RoleDto roleCourant) {
		this.roleCourant = roleCourant;
	}

	public OperationDto getOperationCourante() {
		return operationCourante;
	}

	public void setOperationCourante(OperationDto operationCourante) {
		this.operationCourante = operationCourante;
	}

}