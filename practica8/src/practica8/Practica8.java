package practica8;

/**
 * La clase crea un objeto de caja de cartón con dimensiones específicas y una etiqueta, y calcula el
 * cantidad de cartón utilizado.
 */
public class Practica8 {

	public static void main(String[] args) {
		CajaCarton cajaCarton = new CajaCarton(15, 25, 35);
		cajaCarton.setEtiqueta("de contenido delicado");
		System.out.println(cajaCarton.toString());
		System.out.println("Superficie de cartón utilizada: " + cajaCarton.getSuperficieCarton() + " cm3");
	}

}

/**
 * La clase "Caja" representa una caja con dimensiones y una etiqueta, y puede calcular su volumen en
 * ya sean centímetros o metros.
 */
class Caja {
	enum Unidad {
		CM, M;
	}
	
    int ancho;
    int alto;
    int fondo;
    Unidad unidad;
    String etiqueta;

    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
        this.etiqueta = "";
    }

/**
 * La función calcula el volumen de un objeto y lo convierte a metros cúbicos si la unidad está en
 * centímetros.
 * 
 * @return El método `getVolumen()` devuelve el volumen calculado de un objeto en metros cúbicos. Si el
 * unidad de medida es en centímetros, convierte el volumen a metros cúbicos antes de devolverlo.
 */
    public double getVolumen() {
        double volumen = ancho * alto * fondo;
        if (unidad == Unidad.CM) {
            volumen = volumen / 1000000;
        }
        return volumen;
    }

/**
 * Esta función establece una etiqueta para un objeto, pero si la etiqueta tiene más de 30 caracteres,
 * lo trunca a 30 caracteres.
 * 
 * @param etiqueta un parámetro de cadena que representa la etiqueta que se establecerá para un objeto.
 */
    public void setEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30) {
            this.etiqueta = etiqueta.substring(0, 30);
        } else {
            this.etiqueta = etiqueta;
        }
    }

/**
 * La función devuelve una representación de cadena de un objeto de cuadro con sus dimensiones, unidad y etiqueta.
 * 
 * @return Una representación de cadena de un objeto de caja, incluidas sus dimensiones (ancho, alto, profundidad) en
 * ya sea centímetros o metros, y su etiqueta.
 */
    public String toString() {
        String unidadStr = unidad == Unidad.CM ? "cm" : "m";
        return "Caja de " + ancho + "x" + alto + "x" + fondo + " " + unidadStr + " con etiqueta " + etiqueta;
    }
}

/**
 * La clase CajaCartón extiende Caja y calcula el área de superficie de una caja de cartón a partir de su
 * dimensiones y volumen.
 */
class CajaCarton extends Caja {
    private double superficieCarton;

    public CajaCarton(int ancho, int alto, int fondo) {
        super(ancho, alto, fondo, Unidad.CM);
        double volumen = super.getVolumen();
        double volumenCarton = volumen * 0.8;
        double superficie = (2 * ancho * alto) + (2 * alto * fondo) + (2 * ancho * fondo);
        this.superficieCarton = superficie * volumenCarton;
    }

/**
 * Esta función devuelve el valor de la variable "superficieCarton" de tipo doble.
 * 
 * @return El método `getSuperficieCarton()` devuelve un valor `doble` que representa el
 * superficie de una caja de cartón.
 */
    public double getSuperficieCarton() {
        return superficieCarton;
    }

/**
 * Esta función devuelve una representación de cadena de un objeto de caja de cartón con sus dimensiones y
 * etiqueta.
 * 
 * @return Una representación en cuerda de una caja de cartón con sus dimensiones y etiqueta.
 */
    @Override
    public String toString() {
        return "Caja de cartón de " + super.ancho + "x" + super.alto + "x" + super.fondo + " cm con etiqueta " + super.etiqueta;
    }
}