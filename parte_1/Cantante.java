package parte_1;

public interface Cantante {
    default String presentarse() {
        return "canto";
    }
}
