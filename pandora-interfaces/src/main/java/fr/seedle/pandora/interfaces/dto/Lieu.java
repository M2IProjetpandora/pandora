package fr.seedle.pandora.interfaces.dto;

public interface Lieu extends PandoraObject {

	public String getLongitude();

	public void setLongitude(String longitude);

	public String getLatitude();

	public void setLatitude(String latitude);

	public String getUtm();

	public void setUtm(String utm);

}
