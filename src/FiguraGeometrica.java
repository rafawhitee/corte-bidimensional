public class FiguraGeometrica {
	
	public static final String UNIDADE_MEDIDA = "cm";
	public static final String POTENCIA_AREA = "²";
	public static final String POTENCIA_VOLUME = "³";

	private double comprimento;
	private double largura;
	
	private double area;
	
	private Range rangeComprimento;
	private Range rangeLargura;
	

	public FiguraGeometrica(double comprimento, double largura) {
		this.comprimento = comprimento;
		this.largura = largura;
		this.area = calculaArea();
		this.rangeComprimento = new Range(0, comprimento-1);
		this.rangeLargura = new Range(0, largura-1);
	}
	
	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	public Range getRangeComprimento() {
		return rangeComprimento;
	}

	public void setRangeComprimento(Range rangeComprimento) {
		this.rangeComprimento = rangeComprimento;
	}

	public Range getRangeLargura() {
		return rangeLargura;
	}

	public void setRangeLargura(Range rangeLargura) {
		this.rangeLargura = rangeLargura;
	}
	
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public double calculaArea() {
		if(comprimento > 0.0 && largura > 0.0) {
			return comprimento * largura;
		}
		return 0.0;
	}
	
	public String mostraArea() {
		return getArea() + UNIDADE_MEDIDA + POTENCIA_AREA;
	}

}