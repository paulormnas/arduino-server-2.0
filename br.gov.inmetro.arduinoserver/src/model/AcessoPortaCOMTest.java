package model;

import java.io.IOException;

import junit.framework.TestCase;
import model.AcessoPortaCOM;

public class AcessoPortaCOMTest extends TestCase{
	
	AcessoPortaCOM acesso;
	
	protected void setUp() {
		acesso = new AcessoPortaCOM();
	}

	public  void testeConectaArduino() {
		assertTrue(acesso.portaEstaAberta());
	}
	
	public void testeRecepcaoDados() {
		String dados= null;
		String resposta = "Teste OK!";
		try {
			acesso.sendDataBySerialPort("u");
			dados = acesso.readDataBySerialPort();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			assertEquals(resposta, dados);
		}	
	}
	
	public void testeDesconectaArduino() {
		acesso.closePort();
		assertFalse(acesso.portaEstaAberta());
	}

}
