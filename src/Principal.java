import javax.swing.JOptionPane;

import models.Coordenada;
import models.Cortador;
import models.Retangulo;

public class Principal {
	
	public static void main(String[] args) {			
		try {	
			// Cortador
			Cortador cortador;	
			
			// Cria as 4 Coordenadas da Figura Principal
			Coordenada cod1 = new Coordenada(4.0, 7.0);
			Coordenada cod2 = new Coordenada(9.0, 7.0);
			Coordenada cod3 = new Coordenada(4.0, 3.0);
			Coordenada cod4 = new Coordenada(9.0, 3.0);
			
			// Cria o cortador passando uma nova FiguraGeometrica passando as 4 coordenadas
			cortador = new Cortador(new Retangulo(cod1, cod2, cod3, cod4, "cm"));
			
			String coordenadas = "COORDENADAS: \n" + cortador.getFiguraPrincipal().retornaCoordenadas();
			String areaTotal = "ÁREA: " + cortador.getFiguraPrincipal().mostraArea();
			
			String messagePrincipal = coordenadas + "\n" + areaTotal;
					 		
			// Exibe a mensagem mostrando as coordenadas do principal e a área
			JOptionPane.showMessageDialog(null, messagePrincipal);
			
			// Faz um loop para pegar figuras menores
			while(true) {
				// Pega o comprimento e largura de uma figura menor que a principal
				String strX1 = JOptionPane.showInputDialog("Eixo X 1: ");
				String strY1 = JOptionPane.showInputDialog("Eixo Y 1: ");
				
				String strX2 = JOptionPane.showInputDialog("Eixo X 2: ");
				String strY2 = JOptionPane.showInputDialog("Eixo Y 2: ");
				
				String strX3 = JOptionPane.showInputDialog("Eixo X 3: ");
				String strY3 = JOptionPane.showInputDialog("Eixo Y 3: ");
				
				String strX4 = JOptionPane.showInputDialog("Eixo X 4: ");
				String strY4 = JOptionPane.showInputDialog("Eixo Y 4: ");
				
				double x1 = Double.parseDouble(strX1);
				double y1 = Double.parseDouble(strY1);
				
				double x2 = Double.parseDouble(strX2);
				double y2 = Double.parseDouble(strY2);
				
				double x3 = Double.parseDouble(strX3);
				double y3 = Double.parseDouble(strY3);
				
				double x4 = Double.parseDouble(strX4);
				double y4 = Double.parseDouble(strY4);
				
				// Cria as 4 coordenadas da Figura Menor
				Coordenada cod1Menor = new Coordenada(x1, y1);
				Coordenada cod2Menor = new Coordenada(x2, y2);;
				Coordenada cod3Menor = new Coordenada(x3, y3);
				Coordenada cod4Menor = new Coordenada(x4, y4);
				
				Retangulo figuraMenor = new Retangulo(cod1Menor, cod2Menor, cod3Menor, cod4Menor, "cm");
				boolean cortou = cortador.cortar(figuraMenor);
				String areaAtual = cortador.getFiguraPrincipal().mostraArea();
				String message = (cortou) ? "Cortou !!!" : "Não Cortou !!!";
				message += "\n " + areaAtual;
				
				// Exibe a mensagem, da área que falta pra cortar
				JOptionPane.showMessageDialog(null, message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
