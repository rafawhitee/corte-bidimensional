import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		
		// Cortador que tem as funções de cortar
		Cortador cortador;

		String strComprimento = JOptionPane.showInputDialog("Digite o Comprimento: ");
		String strLargura = JOptionPane.showInputDialog("Digite a Largura: ");
			
		try {
			double comprimento = Double.parseDouble(strComprimento);
			double largura = Double.parseDouble(strLargura);
			// Cria o cortador passando uma nova FiguraGeometrica com o comprimento e as larguras escolhidas
			cortador = new Cortador(new FiguraGeometrica(comprimento, largura));
			
			// Mostra a área da figura principal atual
			JOptionPane.showMessageDialog(null, "Área da Figura Principal: " + cortador.getFiguraPrincipal().mostraArea() );
			
			// Faz um loop para pegar figuras menores
			while(true) {
				// Pega o comprimento e largura de uma figura menor que a principal
				String strComprimentoMenor = JOptionPane.showInputDialog("Digite o Comprimento de uma Figura Menor: ");
				String strLarguraMenor = JOptionPane.showInputDialog("Digite a Largura de uma Figura Menor: ");
				double comprimentoMenor = Double.parseDouble(strComprimentoMenor);
				double larguraMenor = Double.parseDouble(strLarguraMenor);
				
				// Chama o método cortar que recebe uma FiguraGeometrica
				boolean cortou = cortador.cortar(new FiguraGeometrica(comprimentoMenor, larguraMenor));
				
				String titleMessage = (cortou) ? "Corte efetuado com sucesso" : "Figura maior que a principal";
				String bodyMessage = "Restando: " + cortador.getFiguraPrincipal().mostraArea();
				String message = titleMessage + "\n" + bodyMessage;
				
				// Exibe a mensagem, da área que falta pra cortar
				JOptionPane.showMessageDialog(null, message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
