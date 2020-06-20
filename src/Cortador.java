import java.util.ArrayList;
import java.util.List;

public class Cortador {
	
	// Figura Principal
	private FiguraGeometrica figuraPrincipal;
	
	// Lista de Pedaços Menores
	private List<FiguraGeometrica> figurasMenores;
	
	// Guarda a área da figura principal inicialmente
	private double areaPrincipalBackup;
	
	// Construtor que recebe a Figura Principal
	public Cortador(FiguraGeometrica figuraPrincipal) {
		this.figuraPrincipal = figuraPrincipal;
		this.areaPrincipalBackup = figuraPrincipal.getArea();
		this.figurasMenores = new ArrayList<FiguraGeometrica>();
	}
	
	// Verifica se a área não é maior que a área atual da Figura Principal
	public boolean podeCortar(FiguraGeometrica figuraMenor) {
		boolean areaMenorQueAtual = validarArea(figuraMenor);
		boolean sobrePosAlgumaCoordenada = validarSobreposicaoCoordenada(figuraMenor);
		return areaMenorQueAtual && !sobrePosAlgumaCoordenada;
	}
	
	// Verifica se as coordenadas da nova figura não irão sobrepôr as coordenadas já existentes das FigurasMenores
	public boolean validarSobreposicaoCoordenada(FiguraGeometrica figuraMenor) {
		if(figuraMenor != null && figuraMenor.getCoordenadas() != null 
				&& figuraMenor.getCoordenadas().size() > 0) {
			
			boolean sobreposAlgum = false;
			
			// Faz um for na lista de Figuras já existentes na lista figurasMenores
			for(FiguraGeometrica figuraJaExistente : figurasMenores) {
				
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
	public boolean validarArea(FiguraGeometrica figuraMenor) {
		double areaFiguraMenor = figuraMenor.calculaArea();
		double areaFiguraPrincipalAtual = figuraPrincipal.calculaArea();
		if(areaFiguraMenor >= areaFiguraPrincipalAtual) {
			return false;
		}
		return true;
	}
	
	// Se retornar true porque cortou
	// False porque não cortou
	public boolean cortar(FiguraGeometrica figuraMenor) {
		boolean podeCortar = podeCortar(figuraMenor);
		if(podeCortar) {
			figurasMenores.add(figuraMenor);
			double areaFiguraMenor = figuraMenor.calculaArea();
			figuraPrincipal.setArea(figuraPrincipal.getArea() - areaFiguraMenor);
			return true;
		}
		return false;
	}
	
	public FiguraGeometrica getFiguraPrincipal() {
		return figuraPrincipal;
	}
	
	public void setFiguraPrincipal(FiguraGeometrica figuraPrincipal) {
		this.figuraPrincipal = figuraPrincipal;
	}
	
	public List<FiguraGeometrica> getFigurasMenores() {
		return figurasMenores;
	}
	
	public void setFigurasMenores(List<FiguraGeometrica> figurasMenores) {
		this.figurasMenores = figurasMenores;
	}

	public double getAreaPrincipalBackup() {
		return areaPrincipalBackup;
	}

	public void setAreaPrincipalBackup(double areaPrincipalBackup) {
		this.areaPrincipalBackup = areaPrincipalBackup;
	}

}