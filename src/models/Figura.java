package models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Figura {

	protected static final String POTENCIA_AREA = "²";
	protected static final String POTENCIA_VOLUME = "³";

	public static final List<String> unidadesDeMedida = new ArrayList<String>(Arrays.asList("cm", "m", "km"));

	// Quantidade máxima de coordenadas para a figura.
	// Exemplo se for um retângulo ou quadrado, serão 4 coordenadas
	// Triângulo 3
	private int maxCoordenadas;

	// Coordenadas da Figura
	private List<Coordenada> coordenadas;

	// Area da Figura
	private double area;

	// Unidade de Medida
	private String unidadeMedida;

	public Figura(int maxCoordenadas, String unidadeMedida) {
		setMaxCoordenadas(maxCoordenadas);
		setUnidadeMedida(unidadeMedida);
	}

	// Método Abstrato, as filhas que irão implementar
	protected abstract double calcularArea();

	public int getMaxCoordenadas() {
		return maxCoordenadas;
	}

	public void setMaxCoordenadas(int maxCoordenadas) {
		this.maxCoordenadas = maxCoordenadas;
	}

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		if (unidadeMedida != null && unidadesDeMedida.contains(unidadeMedida)) {
			this.unidadeMedida = unidadeMedida;
		}
	}

}