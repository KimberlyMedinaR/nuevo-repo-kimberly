package practica8;

/**
 * Clase para realizar la práctica 8 del curso de Estructura de Datos y Algoritmos
 * Esta clase implementa un programa que recibe por línea de comandos un archivo
 * de texto, lo lee y cuenta el número de palabras diferentes que contiene.
 * 
 * @author Kimberly
 * 
 */
public class Practica8 {
    /**
     * Método principal que se encarga de recibir el archivo, leerlo, 
     * almacenar el número de palabras diferentes que contiene y mostrarlo por pantalla
     * 
     * @param args argumentos de la línea de comandos, se espera que el primer argumento sea
     *             el nombre del archivo a leer
     */
	public static void main(String[] args) {
		CajaCarton cajaCarton = new CajaCarton(15, 25, 35);
		cajaCarton.setEtiqueta("de contenido delicado");
		System.out.println(cajaCarton.toString());
		System.out.println("Superficie de cartón utilizada: " + cajaCarton.getSuperficieCarton() + " cm3");
	}

}

/**
 * La clase Caja representa una caja de cualquier material, con un ancho, alto y fondo dados en una unidad determinada (centímetros o metros).
 */
class Caja {
	
	/**
	 * La enumeración Unidad representa las posibles unidades en que se pueden medir las dimensiones de la caja (centímetros o metros).
	 */
	enum Unidad {
		CM, M;
	}
	
	/**
	 * El ancho de la caja.
	 */
    int ancho;
    
    /**
	 * El alto de la caja.
	 */
    int alto;
    
    /**
	 * El fondo de la caja.
	 */
    int fondo;
    
    /**
	 * La unidad en que se miden las dimensiones de la caja.
	 */
    Unidad unidad;
    
    /**
	 * La etiqueta de la caja, que identifica su contenido.
	 */
    String etiqueta;

    /**
	 * Constructor de la clase Caja.
	 * @param ancho el ancho de la caja
	 * @param alto el alto de la caja
	 * @param fondo el fondo de la caja
	 * @param unidad la unidad en que se miden las dimensiones de la caja
	 */
    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
        this.etiqueta = "";
    }

    /**
	 * Devuelve el volumen de la caja en metros cúbicos.
	 * @return el volumen de la caja en metros cúbicos
	 */
    public double getVolumen() {
        double volumen = ancho * alto * fondo;
        if (unidad == Unidad.CM) {
            volumen = volumen / 1000000;
        }
        return volumen;
    }

    /**
	 * Establece la etiqueta de la caja, limitando su longitud a 30 caracteres.
	 * @param etiqueta la etiqueta a establecer
	 */
    public void setEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30) {
            this.etiqueta = etiqueta.substring(0, 30);
        } else {
            this.etiqueta = etiqueta;
        }
    }

    /**
	 * Devuelve una cadena que representa la información de la caja.
	 * @return una cadena que representa la información de la caja
	 */
    public String toString() {
        String unidadStr = unidad == Unidad.CM ? "cm" : "m";
        return "Caja de " + ancho + "x" + alto + "x" + fondo + " " + unidadStr + " con etiqueta " + etiqueta;
    }
}

/**
 * Clase que representa una caja de cartón.
 */
class CajaCarton extends Caja {
    private double superficieCarton;   // Superficie de cartón utilizada para la caja de cartón.

    /**
     * Constructor de la clase CajaCarton.
     * @param ancho El ancho de la caja de cartón.
     * @param alto El alto de la caja de cartón.
     * @param fondo El fondo de la caja de cartón.
     */
    public CajaCarton(int ancho, int alto, int fondo) {
		super(ancho, alto, fondo, Unidad.CM);
		double volumen = super.getVolumen();
		double volumenCarton = volumen * 0.8;
		double superficie = (2 * ancho * alto) + (2 * alto * fondo) + (2 * ancho * fondo);
		this.superficieCarton = superficie * volumenCarton;
	}
	
		/**
	 * Obtiene la superficie de cartón utilizada para construir la caja.
	 * @return La superficie de cartón utilizada en cm².
	 */
	public double getSuperficieCarton() {
		return superficieCarton;
	}

	/**
	 * Genera una cadena de texto con información detallada sobre la caja de cartón.
	 * @return La cadena de texto generada.
	 */
	@Override
	public String toString() {
		String unidadStr = unidad == Unidad.CM ? "cm" : "m";
		return "Caja de cartón de " + ancho + "x" + alto + "x" + fondo + " " + unidadStr + " con etiqueta " + etiqueta;
	}
}