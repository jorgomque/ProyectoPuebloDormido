import java.util.ArrayList;

public interface CicloVital {
    static final int NATALIDAD_MAXIMA = 1;
    static final int VITALIDAD_MAXIMA = 2;

    void reproducir(ArrayList<Ciudadano> ciudadanos, Ciudadano pareja);
    void envejecer(ArrayList<Ciudadano> ciudadanos);

}
