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