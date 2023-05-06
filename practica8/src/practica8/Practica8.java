package practica8;

public class Practica8 {

	public static void main(String[] args) {
		CajaCarton cajaCarton = new CajaCarton(15, 25, 35);
		cajaCarton.setEtiqueta("de contenido delicado");
		System.out.println(cajaCarton.toString());
		System.out.println("Superficie de cartón utilizada: " + cajaCarton.getSuperficieCarton() + " cm3");
	}

}

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

    public double getVolumen() {
        double volumen = ancho * alto * fondo;
        if (unidad == Unidad.CM) {
            volumen = volumen / 1000000;
        }
        return volumen;
    }

    public void setEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30) {
            this.etiqueta = etiqueta.substring(0, 30);
        } else {
            this.etiqueta = etiqueta;
        }
    }

    public String toString() {
        String unidadStr = unidad == Unidad.CM ? "cm" : "m";
        return "Caja de " + ancho + "x" + alto + "x" + fondo + " " + unidadStr + " con etiqueta " + etiqueta;
    }
}

class CajaCarton extends Caja {
    private double superficieCarton;

    public CajaCarton(int ancho, int alto, int fondo) {
        super(ancho, alto, fondo, Unidad.CM);
        double volumen = super.getVolumen();
        double volumenCarton = volumen * 0.8;
        double superficie = (2 * ancho * alto) + (2 * alto * fondo) + (2 * ancho * fondo);
        this.superficieCarton = superficie * volumenCarton;
    }

    public double getSuperficieCarton() {
        return superficieCarton;
    }

    @Override
    public String toString() {
        return "Caja de cartón de " + super.ancho + "x" + super.alto + "x" + super.fondo + " cm con etiqueta " + super.etiqueta;
    }
}


