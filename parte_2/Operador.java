package parte_2;

public enum Operador {
    SUMA("+") {
        @Override
        public double aplicar(double a, double b) {
            return a + b;
        }
    },
    RESTA("-") {
        @Override
        public double aplicar(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACION("×") {
        @Override
        public double aplicar(double a, double b) {
            return a * b;
        }
    },
    DIVISION("÷") {
        @Override
        public double aplicar(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("división por cero");
            }
            return a / b;
        }
    };

    private final String simbolo;

    Operador(String simbolo) {
        this.simbolo = simbolo;
    }

    public String simbolo() {
        return simbolo;
    }

    // Cada constante esta obligada a implementar este metodo abstracto
    public abstract double aplicar(double a, double b);
}
