package laboratorio_1;

// Clase Cancion que modela una pista musical e implementa Comparable
// para definir su orden natural por titulo alfabetico.
public class Cancion implements Comparable<Cancion> {
    private final String titulo;
    private final String artista;
    private final int duracionSeg;

    public Cancion(String titulo, String artista, int duracionSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }

    // Devuelve la duracion formateada en minutos y segundos ("m:ss")
    public String duracion() {
        return String.format("%d:%02d", duracionSeg / 60, duracionSeg % 60);
    }

    // Orden natural: orden alfabetico por el titulo de la cancion
    @Override
    public int compareTo(Cancion otra) {
        return this.titulo.compareTo(otra.titulo);
    }
}
