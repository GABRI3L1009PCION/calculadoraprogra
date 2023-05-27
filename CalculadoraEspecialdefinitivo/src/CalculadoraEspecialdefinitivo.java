import java.util.Scanner;

public class CalculadoraEspecialdefinitivo {    
    // Atributos de la clase, pueden ser públicos, privados y protegidos (en herencia)
    public String tipoCalculadora;
    public String color;
    public int dimensionPantalla;
    private String numeroDeSerie;
    private String nombrePropietario;
    
    // Constructor de la clase
    public CalculadoraEspecialdefinitivo(String propietario) {
        this.tipoCalculadora = "Calculadora Básica";
        this.dimensionPantalla = 10;
        this.numeroDeSerie = "12345abc";
        this.color = "Azul";
        this.nombrePropietario = propietario;
    }
    
    // Constructor vacío
    public CalculadoraEspecialdefinitivo() {
    }
    
    // Área de declaración de métodos
    // En POO se llaman métodos en lugar de funciones
    public double sumar(double primerNumero, double segundoNumero) {
        return primerNumero + segundoNumero;
    }
    
    public double restar(double primerNumero, double segundoNumero) {
        return primerNumero - segundoNumero;
    }
    
    public double multiplicar(double primerNumero, double segundoNumero) {
        return primerNumero * segundoNumero;
    }
    
    public double dividir(double primerNumero, double segundoNumero) {
        return primerNumero / segundoNumero;
    }
    
    public double raizCuadrada(double numero) {
        return Math.sqrt(numero);
    }
    
    public boolean esPrimo(int numeroBuscado) {
        boolean primo = false;
        int contador = 0;
        for (int i = numeroBuscado; i > 0; i--) {
            if (numeroBuscado % i == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    // Métodos adicionales
    
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
    
    public double calcularPromedio(double... numeros) {
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        return suma / numeros.length;
    }
    
    public int obtenerFactorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * obtenerFactorial(numero - 1);
        }
    }
    
    public int obtenerMCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    
    public int obtenerMCM(int num1, int num2) {
        return (num1 * num2) / obtenerMCD(num1, num2);
    }
    
    public double calcularInteresSimple(double capital, double tasa, int tiempo) {
        return capital * tasa * tiempo;
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso de la clase CalculadoraEspecialdefinitivo
        CalculadoraEspecialdefinitivo calculadora = new CalculadoraEspecialdefinitivo("John Doe");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        double primerNumero = scanner.nextDouble();
        
        System.out.print("Ingrese el segundo número: ");
        double segundoNumero = scanner.nextDouble();
        
        double resultadoSuma = calculadora.sumar(primerNumero, segundoNumero);
        System.out.println("Suma: " + resultadoSuma);
        
        double resultadoResta = calculadora.restar(primerNumero, segundoNumero);
        System.out.println("Resta: " + resultadoResta);
        
        double resultadoMultiplicacion = calculadora.multiplicar(primerNumero, segundoNumero);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        
        double resultadoDivision = calculadora.dividir(primerNumero, segundoNumero);
        System.out.println("División: " + resultadoDivision);
        
        double resultadoRaizCuadrada = calculadora.raizCuadrada(primerNumero);
        System.out.println("Raíz cuadrada del primer número: " + resultadoRaizCuadrada);
        
        boolean esPrimo = calculadora.esPrimo((int)primerNumero);
        System.out.println("El primer número es primo: " + esPrimo);
        
        double resultadoPotencia = calculadora.potencia(primerNumero, segundoNumero);
        System.out.println("Potencia: " + resultadoPotencia);
        
        double resultadoPromedio = calculadora.calcularPromedio(primerNumero, segundoNumero);
        System.out.println("Promedio: " + resultadoPromedio);
        
        int resultadoFactorial = calculadora.obtenerFactorial((int)primerNumero);
        System.out.println("Factorial del primer número: " + resultadoFactorial);
        
        int resultadoMCD = calculadora.obtenerMCD((int)primerNumero, (int)segundoNumero);
        System.out.println("Máximo Común Divisor: " + resultadoMCD);
        
        int resultadoMCM = calculadora.obtenerMCM((int)primerNumero, (int)segundoNumero);
        System.out.println("Mínimo Común Múltiplo: " + resultadoMCM);
        
        double resultadoInteresSimple = calculadora.calcularInteresSimple(primerNumero, segundoNumero, (int)segundoNumero);
        System.out.println("Interés Simple: " + resultadoInteresSimple);
        
        scanner.close();
    }
}
