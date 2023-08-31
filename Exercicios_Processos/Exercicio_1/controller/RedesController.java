package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	public String os() {
		return nameSystem();
	}

	public void ip() {
		if (nameSystem().contains("Win")) {
			try {
				readIP("IPCONFIG");
			} catch (Exception erro) {
				System.err.println(erro);
			}
		} else if (nameSystem().contains("Lin")) {
			try {
				readIP("ifconfig");
			} catch (Exception erro) {
				System.err.println(erro);
			}
		} else {
			System.err.println("Sistema Operacional Não Identificado!");
		}
	}

	private void readIP(String IP) throws Exception {
		Process process = Runtime.getRuntime().exec(IP);
		InputStream fluxo = process.getInputStream();
		InputStreamReader stringFlux = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(stringFlux);

		String linha = buffer.readLine();
		while (linha != null) {
			if (linha.contains("IPv4")) {
				String[] ipv4 = linha.split(": ");
				System.out.println(ipv4[1]);

				linha = buffer.readLine();
			} else if (linha.contains("inet ")) {
				String[] inet = linha.split(" ");
				System.out.println(inet[9]);
				linha = buffer.readLine();

			} else {
				linha = buffer.readLine();
			}
		}
		buffer.close();
		stringFlux.close();
		fluxo.close();
	}

	public void ping(String process) {

		try {
			Process processo = Runtime.getRuntime().exec(process);
			InputStream fluxo = processo.getInputStream();// pega os bytes
			InputStreamReader fluxoString = new InputStreamReader(fluxo); // transforma os bytes em charset(String)
			BufferedReader buffer = new BufferedReader(fluxoString);

			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("dia")) {// Windows
					String[] linhaPing = linha.split(" = ");
					String[] tempoPing = linhaPing[3].split("ms");
					System.out.println(tempoPing[0]);

					linha = buffer.readLine();

				} else if (linha.contains("avg")) {//Linux
					String[] rowPing = linha.split("/");
					System.out.println(rowPing[4]);

				} else {
					linha = buffer.readLine();
				}

			}

			buffer.close();
			fluxoString.close();
			fluxo.close();

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private String nameSystem() {

		String os = System.getProperty("os.name");
		return os;
	}

}
