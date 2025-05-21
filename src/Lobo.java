import java.util.*;
public class Lobo extends Ciudadano implements CicloVital, Batalla{
    private static int  totalLobos = 0;
    private static int  ulitmoLobo = 0;
    private final static Random ALEATORIO = new Random();
    private static final Vulnerable VULNERABLE = Vulnerable.VAMPIRO;
    private int vidaRestante;
    private  int hijosTotales;

    public Lobo() {
        super();
        setNombre(getClass().getSimpleName() + ulitmoLobo);
        totalLobos++;
        ulitmoLobo++;
        vidaRestante = ALEATORIO.nextInt(VITALIDAD_MAXIMA) +1;
        hijosTotales = 0;
    }
    public int getContadorPoblacion(){
        return  totalLobos;
    }
    public void setContadorPoblacion(int numero){
        totalLobos = numero;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void morir(ArrayList<Ciudadano> ciudadanos) {
        super.morir(ciudadanos);
        totalLobos--;
    }

    @Override
    public Ciudadano combate(Ciudadano oponente) {
        return null;
    }

    @Override
    public String toString() {
        return "Nombre del lobo: " + getNombre() + " vida: " + this.vidaRestante;
    }
}
