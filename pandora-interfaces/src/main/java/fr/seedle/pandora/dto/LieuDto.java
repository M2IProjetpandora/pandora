package fr.seedle.pandora.dto;

import fr.seedle.pandora.interfaces.dto.Lieu;

public class LieuDto extends PandoraObjectDto implements Lieu {

	private String longitude;
	private String latitude;
	private String utm;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getUtm() {
		return utm;
	}

	public void setUtm(String utm) {
		this.utm = utm;
	}

}
