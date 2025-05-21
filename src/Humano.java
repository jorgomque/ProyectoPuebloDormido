import java.util.*;
public class Humano extends Ciudadano implements CicloVital{
    private static int  totalHumanos = 0;
    private static int ultimoHumano = 0;
    private final static Random ALEATORIO = new Random();
    private static final Vulnerable VULNERABLE = Vulnerable.VAMPIRO;
    private int vidaRestante;
    private  int hijosTotales;

    public Humano() {
        super();
        setNombre(getClass().getSimpleName() + ultimoHumano);
        totalHumanos++;
        ultimoHumano++;
        vidaRestante = ALEATORIO.nextInt(VITALIDAD_MAXIMA) +1;
        hijosTotales = 0;
    }

    public int getHijosTotales() {
        return hijosTotales;
    }

    public int getContadorPoblacion(){
        return  totalHumanos;
    }
    public void setContadorPoblacion(int numero){
        totalHumanos = numero;
    }

    //No se muy bien como hacer este metodo
    @Override
    public Ciudadano combate(ArrayList<Ciudadano> ciudadanos, Ciudadano oponente) {
        if (oponente.getClass().getSimpleName().equalsIgnoreCase(this.getClass().getSimpleName())){
            reproducir(ciudadanos, oponente);
        }
        return null;
    }

    public void reproducir(ArrayList<Ciudadano> ciudadanos, Ciudadano pareja){
            if (pareja instanceof Humano) {
                Humano otroHumano = (Humano) pareja;
                if (this.hijosTotales < NATALIDAD_MAXIMA && otroHumano.hijosTotales < NATALIDAD_MAXIMA) {
                    ciudadanos.add(new Humano());
                    this.hijosTotales++;
                    otroHumano.hijosTotales++;
                } else {
                    System.out.println("No se pueden reproducir");
                }
            }


    }
    @Override
    public void morir(ArrayList<Ciudadano> ciudadanos) {
        super.morir(ciudadanos);
        totalHumanos--;
    }

    public void envejecer(ArrayList<Ciudadano> ciudadanos){
        vidaRestante--;
        if (vidaRestante == 0){
            morir(ciudadanos);
        }
    }

    public Vulnerable getVulnerabilidad(){
        return VULNERABLE;
    }

    @Override
    public String toString() {
        return "Nombre del humano: " + getNombre() + " vida: " + this.vidaRestante;
    }
}
