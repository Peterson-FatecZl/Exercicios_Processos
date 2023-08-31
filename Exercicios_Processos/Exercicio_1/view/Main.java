package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesController = new RedesController();

		int opcao = 0;

		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Insira o Número Correspondente ao Método desejado: \n 1 - IP\n 2 - Ping\n 9 - Finalizar Programa",
					"Menu", -1));

			if (opcao == 1) {
				redesController.ip();
			} else if (opcao == 2) {
				if(redesController.os().contains("Win")) {
					redesController.ping("ping -4 -n 10 www.google.com.br");
				}else {
					redesController.ping("ping -4 -c 10 www.google.com.br");
				}
			} else if (opcao == 9) {
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "Por Favor Insira Um Valor Válido", "ERRO", 0);
			}
		}
	}

}
