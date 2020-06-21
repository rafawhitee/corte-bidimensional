package models;
import java.util.ArrayList;
import java.util.List;

public class Cortador {
	
	// Figura Principal
	private Retangulo figuraPrincipal;
	
	// Lista de Pedaços Menores
	private List<Retangulo> figurasMenores;
	
	// Guarda a área da figura principal inicialmente
	private double areaPrincipalBackup;
	
	// Construtor que recebe a Figura Principal
	public Cortador(Retangulo figuraPrincipal) {
		this.figuraPrincipal = figuraPrincipal;
		this.areaPrincipalBackup = figuraPrincipal.getArea();
		this.figurasMenores = new ArrayList<Retangulo>();
	}
	
	// Verifica se a área não é maior que a área atual da Figura Principal
	public boolean podeCortar(Retangulo figuraMenor) {
		boolean areaMenorQueAtual = validarArea(figuraMenor);
		boolean sobrePosAlgumaCoordenada = validarSobreposicaoCoordenada(figuraMenor);
		return areaMenorQueAtual && !sobrePosAlgumaCoordenada;
	}
	
	// Verifica se as coordenadas da nova figura não irão sobrepôr as coordenadas já existentes das FigurasMenores
	public boolean validarSobreposicaoCoordenada(Retangulo figuraMenor) {
		if(figuraMenor != null && figuraMenor.getCoordenadas() != null 
				&& figuraMenor.getCoordenadas().size() > 0) {
			
			boolean sobreposAlgum = false;
			
			// Faz um for na lista de Figuras já existentes na lista figurasMenores
			for(Retangulo figuraJaExistente : figurasMenores) {
				
				// Faz um outro for na lista de coordenadas da figuraMenor, que é a nova figura a ser inserida
				for(Coordenada coordenadaFiguraMenor : figuraMenor.getCoordenadas()) {
					// Para cada coordenada da figuraMenor que vai ser inserida, verifica se não vai sobrepôr as coordenadas da figurasJaExistente
					sobreposAlgum = figuraJaExistente.coordenadaSobrepoeAlgumaJaExistente(coordenadaFiguraMenor);
					// Se sobrepos da um break pra sair do for 2
					if(sobreposAlgum) {
						break;
					}
				}
				
				// Se sobrepos da um break pra sair do for 1
				if(sobreposAlgum) {
					break;
				}
				
			}
			
			// Retorna se sobrepos
			return sobreposAlgum;
		}
		return false;
	}
	
	// Verifica se a área da figura menor é menor do que a área da figura principal restante
	public boolean validarArea(Retangulo figuraMenor) {
		double areaFiguraMenor = figuraMenor.calcularArea();
		double areaFiguraPrincipalAtual = figuraPrincipal.calcularArea();
		if(areaFiguraMenor >= areaFiguraPrincipalAtual) {
			return false;
		}
		return true;
	}
	
	// Se retornar true porque cortou
	// False porque não cortou
	public boolean cortar(Retangulo figuraMenor) {
		boolean podeCortar = podeCortar(figuraMenor);
		if(podeCortar) {
			figurasMenores.add(figuraMenor);
			double areaFiguraMenor = figuraMenor.calcularArea();
			figuraPrincipal.setArea(figuraPrincipal.getArea() - areaFiguraMenor);
			return true;
		}
		return false;
	}
	
	public Retangulo getFiguraPrincipal() {
		return figuraPrincipal;
	}
	
	public void setFiguraPrincipal(Retangulo figuraPrincipal) {
		this.figuraPrincipal = figuraPrincipal;
	}
	
	public List<Retangulo> getFigurasMenores() {
		return figurasMenores;
	}
	
	public void setFigurasMenores(List<Retangulo> figurasMenores) {
		this.figurasMenores = figurasMenores;
	}

	public double getAreaPrincipalBackup() {
		return areaPrincipalBackup;
	}

	public void setAreaPrincipalBackup(double areaPrincipalBackup) {
		this.areaPrincipalBackup = areaPrincipalBackup;
	}

}