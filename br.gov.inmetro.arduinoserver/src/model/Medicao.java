package model;

public class Medicao {
	private String voltage = "";
	private String temperature = "";
	private String luminosity = "";
	
	public Medicao() {}
	
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getLuminosity() {
		return luminosity;
	}
	public void setLuminosity(String luminosity) {
		this.luminosity = luminosity;
	}
}
