package models;

public class Range {
	
	private double minimo;
	private double maximo;
	
	public Range(double minimo, double maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public double getMinimo() {
		return minimo;
	}

	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}
	
}