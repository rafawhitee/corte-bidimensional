import java.util.ArrayList;
import java.util.List;

public class FiguraGeometrica {

	public static final Integer MAX_COORDENADAS = 4; // Máximo de 4 coordenadas
	public static final String UNIDADE_MEDIDA = "cm";
	public static final String POTENCIA_AREA = "²";
	public static final String POTENCIA_VOLUME = "³";

	private List<Coordenada> coordenadas;

	private double comprimento;
	private double largura;

	private double area;

	private Range rangeComprimento;
	private Range rangeLargura;

	// Construtor da Figura
	public FiguraGeometrica(Coordenada cod1, Coordenada cod2, Coordenada cod3, Coordenada cod4) {
		coordenadas = new ArrayList<Coordenada>();
		popularCoordenadas(cod1, cod2, cod3, cod4);
		popularComprimentoAndLargura();
		area = calculaArea();
		popularRange();
	}

	/* Outros métodos */

	// Adiciona uma coordenada na lista de coordenadas
	// Somente adiciona se o tamanho da lista atual for menor que 4
	private void adicionarCoordenada(Coordenada cod) {
		if (coordenadas != null && cod != null && coordenadas.size() < MAX_COORDENADAS) {
			coordenadas.add(cod);
		}
	}

	// Recebe coordenada por parâmetro e verifica se sobrepõe alguma já existe
	public boolean coordenadaSobrepoeAlgumaJaExistente(Coordenada codParam) {
		boolean contemCoordenadas = contemCoordenadas();
		if (contemCoordenadas && codParam != null) {

			// Pega os valores mínimos e máximos dos Eixos X e Y
			double minX = getMenorNumeroDoEixoX();
			double maxX = getMaiorNumeroDoEixoX();

			double minY = getMenorNumeroDoEixoY();
			double maxY = getMaiorNumeroDoEixoY();

			// Se o X for maior ou igual ao mínimo X
			// OU o X for menor ou igual ao máximo X
			// OU o Y for maior ou igual ao mínimo Y
			// OU o Y for menor ou igual ao máximo Y
			// então vai sobrepor, então retorna true
			if (codParam.getX() >= minX || codParam.getX() <= maxX || codParam.getY() >= minY
					|| codParam.getY() <= maxY) {
				return true;
			}
		}
		return false;
	}

	// Calcula a Area de acordo com o comprimento e a largura
	public double calculaArea() {
		if (comprimento > 0.0 && largura > 0.0) {
			return comprimento * largura;
		}
		return 0.0;
	}

	private void popularRange() {
		rangeComprimento = new Range(0, getComprimento() - 1);
		rangeLargura = new Range(0, getLargura() - 1);
	}

	public String retornaCoordenadas() {
		String retorno = "";
		boolean contemCoordenadas = contemCoordenadas();
		if (contemCoordenadas) {
			for (Coordenada cod : coordenadas) {

				String coordenadaAtual = "(" + cod.getX() + " , " + cod.getY() + ") \n";
				retorno += coordenadaAtual;
			}
		}
		return retorno;
	}

	// Popula as 2 coordenadas que vem dos parâmetros e cria as 2 restantes
	private void popularCoordenadas(Coordenada cod1, Coordenada cod2, Coordenada cod3, Coordenada cod4) {
		adicionarCoordenada(cod1);
		adicionarCoordenada(cod2);
		adicionarCoordenada(cod3);
		adicionarCoordenada(cod4);
	}

	private void popularComprimento() {
		double minX = getMenorNumeroDoEixoX();
		double maxX = getMaiorNumeroDoEixoX();
		double diferenca = maxX - minX;
		setComprimento(diferenca);
	}

	private void popularLargura() {
		double minY = getMenorNumeroDoEixoY();
		double maxY = getMaiorNumeroDoEixoY();
		double diferenca = maxY - minY;
		setLargura(diferenca);
	}

	private void popularComprimentoAndLargura() {
		popularLargura();
		popularComprimento();
	}

	// Método privado que retorna o maior ou menor número da coordenada do Eixo X
	private double getMaiorOuMenorDoEixoX(boolean maior) {
		boolean contemCoordenadas = contemCoordenadas();
		if (contemCoordenadas) {
			double retorno = (maior) ? 0.0 : 9999.99;
			for (Coordenada cod : coordenadas) {
				if (maior) {
					retorno = Math.max(retorno, cod.getX());
				} else {
					retorno = Math.min(retorno, cod.getX());
				}
			}
			return retorno;
		}
		return 0.0;
	}

	// Método privado que retorna o maior ou menor número da coordenada do Eixo Y
	private double getMaiorOuMenorDoEixoY(boolean maior) {
		boolean contemCoordenadas = contemCoordenadas();
		if (contemCoordenadas) {
			double retorno = (maior) ? 0.0 : 9999.99;
			for (Coordenada cod : coordenadas) {
				if (maior) {
					retorno = Math.max(retorno, cod.getY());
				} else {
					retorno = Math.min(retorno, cod.getY());
				}
			}
			return retorno;
		}
		return 0.0;
	}

	public double getMaiorNumeroDoEixoX() {
		return getMaiorOuMenorDoEixoX(true);
	}

	public double getMenorNumeroDoEixoX() {
		return getMaiorOuMenorDoEixoX(false);
	}

	public double getMaiorNumeroDoEixoY() {
		return getMaiorOuMenorDoEixoY(true);
	}

	public double getMenorNumeroDoEixoY() {
		return getMaiorOuMenorDoEixoY(false);
	}

	// Retorna em String a área concatenada com a Unidade Medida da Área
	public String mostraArea() {
		return getArea() + UNIDADE_MEDIDA + POTENCIA_AREA;
	}

	// Verifica se o tamanho da lista é maior que 0
	public boolean contemCoordenadas() {
		if (coordenadas != null && coordenadas.size() > 0) {
			return true;
		}
		return false;
	}

	/* Getters and Setters */

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

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
}