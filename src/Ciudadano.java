import java.util.ArrayList;

public abstract class Ciudadano implements Batalla {
    private String nombre;
    private static int poblacionTotal = 0;
    protected Vulnerable vulnerabilidad;

    public Ciudadano() {
        poblacionTotal++;
    }


    public  int getContadorPoblacion() {
        return poblacionTotal;
    }

    public  void setContadorPoblacion(int numero) {
        Ciudadano.poblacionTotal = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public static void censar(ArrayList<Ciudadano> ciudadanos){
        for (Ciudadano ciudadano : ciudadanos) {
            System.out.println(ciudadano.toString());
        }
        System.out.println("Ciudadanos totales: " + Ciudadano.poblacionTotal);
    }



    public static void poblacionesTotales(ArrayList<Ciudadano> ciudadanos){
        int contadorHumanos = 0;
        int contadorVampiros = 0;
        int contadorLobos = 0;
        for (Ciudadano ciudadano : ciudadanos) {
            if (ciudadano.getClass().getSimpleName().equalsIgnoreCase("humano")) {
                contadorHumanos++;
            } else if (ciudadano.getClass().getSimpleName().equalsIgnoreCase("vampiro")) {
                contadorVampiros++;
            } else {
                contadorLobos++;
            }
        }
        System.out.println("Humanos totales: " + contadorHumanos);
        System.out.println("Vampiros totales: " + contadorVampiros);
        System.out.println("Lobos totales: " + contadorLobos);


    }
    //No se muy bien como hacer este metodo
    public void morir(ArrayList<Ciudadano> ciudadanos){
        ciudadanos.remove(this);
        poblacionTotal--;
    }

    @Override
    public  abstract Ciudadano combate(ArrayList<Ciudadano> ciudadanos,  Ciudadano oponente);

    @Override
    public String toString() {
        return "Nombre del ciudadano: " + getNombre();
    }
}
