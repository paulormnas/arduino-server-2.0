package model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class AcessoPortaCOM {
	
	private static final String PORT = "ttyACM2";  
	private static Scanner scannerIn; 
	private static OutputStream scannerOut;	
	private static SerialPort chosenPort;	
	public String line;
	
	public AcessoPortaCOM(){
		openPort();
	}
	   
	public boolean portaEstaAberta() {
		return chosenPort.isOpen();
	}
	   
	public void leitura(){ 			
		while(scannerIn.hasNext()){ 
			setLine(scannerIn.nextLine());
		}		
	}
	
	public void openPort() {
		chosenPort = SerialPort.getCommPort(PORT);
        chosenPort.setBaudRate(115200);
		chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		chosenPort.openPort();
		scannerIn = new Scanner(chosenPort.getInputStream()); 		//Recebe o fluxo de informações que vem da porta serial
		scannerOut = chosenPort.getOutputStream();		//Envia o fluxo de dados pela porta serial
	}
		
	public void closePort() {
		chosenPort.closePort();
	}

	public String readDataBySerialPort() {
		try{
			return scannerIn.nextLine();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return "Houston, we have a problem!!";		
	}

	public void setLine(String line) {
		this.line = line;
		System.out.println(line);
	}
	
	public void sendDataBySerialPort(String message) throws IOException {
		try{
			scannerOut.write(message.getBytes());			
		}catch(IOException e){
			System.err.println(e);
		}
			
	}

}