package parte_1;

// Problema del diamante: ambas interfaces tienen un default con el mismo nombre.
// Java exige que Artista sobrescriba el metodo para resolver la ambigüedad.
public class Artista implements Cantante, Bailarin {
    @Override
    public String presentarse() {
        return "Yo " + Cantante.super.presentarse() + " y " + Bailarin.super.presentarse();
    }
}
