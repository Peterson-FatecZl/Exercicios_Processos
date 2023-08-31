package controller_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos() {
		if (os().contains("Win")) {
			try {
				Process processo = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader transformString = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(transformString);

				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
			} catch (Exception e) {
				System.err.println(e);
			}
		} else {
			try {
				Process process = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = process.getInputStream();
				InputStreamReader fluxoString = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(fluxoString);

				String row = buffer.readLine();
				while(row != null) {
					System.out.println(row);
					row = buffer.readLine();
				}
	
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
	
	public void mataPid(String PID) {
		
		if(os().contains("Win")){//Windows
			try {
				Runtime.getRuntime().exec("TASKKILL /PID " + PID);
			} catch (Exception erro) {
				System.err.println(erro);
			}			
		}else {//Linux
			try {
				Runtime.getRuntime().exec("kill -9 " + PID);
			}catch(Exception erro){
				System.err.println(erro);
			}
		}
	}
	
	public void mataNome(String nameProcess) {
		if(os().contains("Win")) {//Windows
			try {
				Runtime.getRuntime().exec("TASKKILL /IM " + nameProcess);
			} catch (IOException erro) {
				System.err.println(erro);
			}
			
		}else {//Linux
			try {
				Runtime.getRuntime().exec("pkill -f " + nameProcess);
			} catch (IOException erro) {
				System.err.println(erro);
			}
		}
		
	}

	
}
