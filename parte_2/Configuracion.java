package parte_2;

// Singleton basado en Enum: seguro frente a multiples instancias y serializacion
public enum Configuracion {
    INSTANCIA; // Unico objeto que existira

    private String idioma = "es";
    private int volumen = 50;

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        // En Java 21+ Math.clamp permite limitar un valor entre un minimo y maximo
        this.volumen = Math.clamp(volumen, 0, 100);
    }
}
