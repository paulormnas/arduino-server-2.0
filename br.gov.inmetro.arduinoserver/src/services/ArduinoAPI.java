package services;
 
import java.io.IOException;

import model.AcessoPortaCOM;
import model.Medicao;

import com.google.gson.*;
import com.google.gson.GsonBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api")
public class ArduinoAPI {
	
	AcessoPortaCOM acesso = new AcessoPortaCOM();
	model.Medicao measures = new Medicao();
	
	//JSONObject
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.setPrettyPrinting().create();
	
	
	//Método de teste para construção do JSON
	@Path("/testeAPI")
	@GET
	@Produces("text/plain")
	public String testeAPI(){	
		measures.setLuminosity("423");
		measures.setTemperature("18 ºC");
		measures.setVoltage("3.33 V");
		String json = gson.toJson(measures);
		return json;
	}

	
	@Path("/readData")
	@GET
	@Produces("text/plain")
	//Os paramentros de entrada só podem ser t, v ou l
	public String lerDados(){
			try {
				acesso.sendDataBySerialPort("v");
				measures.setVoltage(acesso.readDataBySerialPort());
				acesso.sendDataBySerialPort("t");
				measures.setTemperature(acesso.readDataBySerialPort());
				acesso.sendDataBySerialPort("l");
				measures.setLuminosity(acesso.readDataBySerialPort()); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			String json = gson.toJson(measures);
			return json.toString();
	}
		
}