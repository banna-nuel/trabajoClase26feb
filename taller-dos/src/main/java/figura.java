// superclase abstracta que define la estructura de todas las figuras
abstract class figura {
    // atributos protected para que las subclases puedan acceder
    protected double area;
    protected double perimetro;

    public figura() {
        this.area = 0;
        this.perimetro = 0;
    }

    public double obtenerArea() {
        return area;
    }

    public double obtenerPerimetro() {
        return perimetro;
    }

    // cada subclase debe implementar su propio calculo
    public abstract void calcularArea();
    public abstract void calcularPerimetro();
}

// subclase que representa una circunferencia
class circunferencia extends figura {
    private double radio;

    public circunferencia() {
        this.radio = 0;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    // formula: PI * radio^2
    @Override
    public void calcularArea() {
        this.area = Math.PI * radio * radio;
    }

    // formula: 2 * PI * radio
    @Override
    public void calcularPerimetro() {
        this.perimetro = 2 * Math.PI * radio;
    }
}

// subclase que representa un cuadrado
class cuadrado extends figura {
    private double lado;

    public cuadrado() {
        this.lado = 0;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    // formula: lado * lado
    @Override
    public void calcularArea() {
        this.area = lado * lado;
    }

    // formula: lado * 4
    @Override
    public void calcularPerimetro() {
        this.perimetro = lado * 4;
    }
}

// subclase que representa un rectangulo
class rectangulo extends figura {
    private double base;
    private double altura;

    public rectangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // formula: base * altura
    @Override
    public void calcularArea() {
        this.area = base * altura;
    }

    // formula: (base + altura) * 2
    @Override
    public void calcularPerimetro() {
        this.perimetro = (base + altura) * 2;
    }
}

// subclase que representa un triangulo
class triangulo extends figura {
    private double base;
    private double altura;

    public triangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // formula: (base * altura) / 2
    @Override
    public void calcularArea() {
        this.area = (base * altura) / 2;
    }

    // formula: base * 3 (triangulo equilatero)
    @Override
    public void calcularPerimetro() {
        this.perimetro = base * 3;
    }
}

// clase de prueba que ejecuta los calculos de cada figura
abstract class pruebaSobreEscritura {

    static void obtenerCalculosCircunferencia() {
        circunferencia c = new circunferencia() {
        };
        c.setRadio(5);
        c.calcularArea();
        c.calcularPerimetro();
        System.out.println("--- Circunferencia ---");
        System.out.println("Radio: 5");
        System.out.println("Area: " + c.obtenerArea());
        System.out.println("Perimetro: " + c.obtenerPerimetro());
    }

    static void obtenerCalculosCuadrado() {
        cuadrado c = new cuadrado() {
        };
        c.setLado(4);
        c.calcularArea();
        c.calcularPerimetro();
        System.out.println("--- Cuadrado ---");
        System.out.println("Lado: 4");
        System.out.println("Area: " + c.obtenerArea());
        System.out.println("Perimetro: " + c.obtenerPerimetro());
    }

    static void obtenerCalculosRectangulo() {
        rectangulo r = new rectangulo();
        r.setBase(6);
        r.setAltura(3);
        r.calcularArea();
        r.calcularPerimetro();
        System.out.println("--- Rectangulo ---");
        System.out.println("Base: 6, Altura: 3");
        System.out.println("Area: " + r.obtenerArea());
        System.out.println("Perimetro: " + r.obtenerPerimetro());
    }

    static void obtenerCalculosTriangulo() {
        triangulo t = new triangulo();
        t.setBase(5);
        t.setAltura(8);
        t.calcularArea();
        t.calcularPerimetro();
        System.out.println("--- Triangulo ---");
        System.out.println("Base: 5, Altura: 8");
        System.out.println("Area: " + t.obtenerArea());
        System.out.println("Perimetro: " + t.obtenerPerimetro());
    }

    public static void main(String[] args) {
        obtenerCalculosCircunferencia();
        obtenerCalculosCuadrado();
        obtenerCalculosRectangulo();
        obtenerCalculosTriangulo();
    }
}