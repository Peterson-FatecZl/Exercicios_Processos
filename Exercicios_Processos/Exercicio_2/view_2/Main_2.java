package view_2;

import javax.swing.JOptionPane;
import controller_2.KillController;

public class Main_2 {

	public static void main(String[] args) {
		KillController killcontroller = new KillController();
		int Menu = 0;
		
		while(Menu != 9) {
			Menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a opção desejada \n1 - Listar Porcessos\n2 - Matar Processo Através do ID\n3 - Matar Processo Através do Nome\n9 - Sair","MENU",-1));
			if(Menu == 1) {
				killcontroller.listaProcessos();
				
			}else if(Menu == 2) {
				String entrada = JOptionPane.showInputDialog("Insira o PID do Processo que deseja Matar");
				killcontroller.mataPid(entrada);
			}else if(Menu == 3){
				String entrada = JOptionPane.showInputDialog("Insira o Nome do Processo que deseja Matar");
				killcontroller.mataNome(entrada);
			}else if(Menu == 9) {
				System.exit(0);
			}else {
				JOptionPane.showMessageDialog(null, "Por Favor Insira Um Valor Válido", "ERRO", 0);
			}
		}
//		String entrada = JOptionPane.showInputDialog("entre com o nome do processo");
	}

}
