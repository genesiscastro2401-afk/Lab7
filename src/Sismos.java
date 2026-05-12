import java.util.ArrayList;

class SismoInvalidoException extends Exception {

    public SismoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class Sismo {

    private String region;
    private String epicentro;
    private float magnitud;

    // Constructor
    public Sismo(String region, String epicentro, float magnitud)
            throws SismoInvalidoException {

        if (region == null || epicentro == null) {
            throw new SismoInvalidoException(
                    "La región y el epicentro deben ser String válidos."
            );
        }

        this.region = region;
        this.epicentro = epicentro;
        this.magnitud = magnitud;
    }

    // Método toString
    @Override
    public String toString() {
        return "Región: " + region +
                " | Epicentro: " + epicentro +
                " | Magnitud: " + magnitud;
    }
}

public class Sismos {

    public static void main(String[] args) {

        // ArrayList para almacenar sismos
        ArrayList<Sismo> listaSismos = new ArrayList<>();

        try {

            Sismo s1 = new Sismo("Ñuble", "Chillán", 5.8f);
            Sismo s2 = new Sismo("Biobío", "Concepción", 6.2f);

            listaSismos.add(s1);
            listaSismos.add(s2);

            System.out.println("Sismos registrados correctamente:\n");

            for (Sismo s : listaSismos) {
                System.out.println(s);
            }

        } catch (SismoInvalidoException e) {

            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Prueba de excepción ---");

        try {
            Sismo s3 = new Sismo(null, "Talca", 4.5f);

            listaSismos.add(s3);

        } catch (SismoInvalidoException e) {

            System.out.println("Excepción capturada:");
            System.out.println(e.getMessage());
        }
    }
}