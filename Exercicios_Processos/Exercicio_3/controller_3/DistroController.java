package controller_3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}

	public void exibeDistro() {
		if (os().contains("Lin")) {
			try {
				Process processo = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader string_fluxo = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(string_fluxo);
				
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.startsWith("NAME=")) {
						System.out.println(linha);
						linha = buffer.readLine();
					}else if(linha.startsWith("VERSION=")) {
						System.out.println(linha);
						linha = buffer.readLine();
					}else {
						linha = buffer.readLine();
					}
				}
			} catch (Exception erro) {
				System.err.println(erro);
			}

		} else {
			System.out.println("Este Sistema Operacional Não é Uma Distribuição Linux");
		}
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

}
