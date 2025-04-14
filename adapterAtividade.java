interface FiguraGeoemetrica {
    double getArea();
}

class Quadrado implements FiguraGeoemetrica {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getArea() {
        return lado * lado;
    }
}

class Circulo implements FiguraGeoemetrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getArea() {
        return Math.PI * raio * raio;
    }
}

class AdapterQuadradoCirculo implements FiguraGeoemetrica {
    Quadrado quadrado;

    public AdapterQuadradoCirculo(Quadrado quadrado) {
        this.quadrado = quadrado;
    }

    public double getArea() {
        return Math.PI * 2 * quadrado.getLado();
    }
}
