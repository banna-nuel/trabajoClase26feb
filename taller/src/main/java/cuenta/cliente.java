package cuenta;

import java.util.Scanner;

// Clase Cuenta — encapsula el saldo y las operaciones bancarias
// Decisión de diseño: la lógica de depositar, retirar y consultar
// vive aquí y no en el main, respetando el SRP
class Cuenta {

    // atributo privado — nadie modifica el saldo directamente
    private double saldo;

    // constructor con saldo en 0
    public Cuenta() {
        this.saldo = 0;
    }

    // constructor con monto inicial
    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    // Decisión de diseño: la validación del monto vive dentro
    // de cada método, no en el main
    public void depositar(double monto) {
        if (monto > 0 && monto <= 5000000) {
            this.saldo += monto;
            System.out.println("DEPOSITASTE $" + monto + " PESOS EN TU CUENTA");
        } else {
            System.out.println("monto no válido");
        }
    }

    // Decisión de diseño: retirar valida tanto el rango
    // como que no supere el saldo disponible
    public void retirar(double monto) {
        if (monto <= 0 || monto > 5000000) {
            System.out.println("monto no válido");
        } else if (monto > this.saldo) {
            System.out.println("no puedes retirar $" + monto
                    + " tienes $" + this.saldo + " pesos en tu cuenta");
        } else {
            this.saldo -= monto;
            System.out.println("RETIRASTE $" + monto + " PESOS DE TU CUENTA");
        }
    }

    public void consultarSaldo() {
        System.out.println("EN SU CUENTA HAY UN SALDO TOTAL DE $" + this.saldo + " PESOS");
    }
}

public class cliente {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" ---------------- BANCO AHORROS ----------------- \n" +
                "BIENVENIDO AL BANCO AHORROS \n 1: DESEAS CREAR TU CUENTA CON $0 PESOS \n" +
                " 2: DESEAS CREAR TU CUENTA CON $1 HASTA $5'000.000 DE PESOS");

        System.out.print("DIGITA ENTRE LA OPCIÓN 1 o 2: ");
        int decisionCuenta = sc.nextInt();

        while (decisionCuenta != 1 && decisionCuenta != 2) {
            System.out.println("Opción no válida, digita una opción valida: ");
            decisionCuenta = sc.nextInt();
        }

        // Decisión de diseño: se crea la cuenta según la decisión
        // del usuario, delegando la lógica a la clase Cuenta
        Cuenta cuenta;
        if (decisionCuenta == 1) {
            cuenta = new Cuenta();
            System.out.println("TU CUENTA HA SIDO CREADA CON EXITO CON $0 PESOS");
        } else {
            System.out.print("PARA CREAR TU CUENTA DIGITA EL MONTO ENTRE $1 HASTA $5'000.000 PESOS: ");
            double montoInicial = sc.nextDouble();
            while (montoInicial <= 0 || montoInicial >= 5000001) {
                System.out.print("\nEl monto digitado no es valido, digita un monto valido entre $1 hasta $5'000.000 pesos: ");
                montoInicial = sc.nextDouble();
            }
            cuenta = new Cuenta(montoInicial);
            System.out.println("TU CUENTA SE HA CREADO CON EXITO CON $" + montoInicial + " PESOS");
        }

        // menú de operaciones
        int operacionCuenta = 0;
        while (operacionCuenta != 4) {
            System.out.println(" ---------------- MENU ---------------" +
                    "\n 1: DEPOSITAR DINERO \n 2: RETIRAR DINERO \n 3: OBTENER SALDO ACTUAL \n 4: SALIR" +
                    "\n ---- QUE OPERACION DESEAS HACER -----");
            operacionCuenta = sc.nextInt();

            while (operacionCuenta <= 0 || operacionCuenta > 4) {
                System.out.println("Opción digitada no valida, por favor digite una opción valida");
                operacionCuenta = sc.nextInt();
            }

            if (operacionCuenta == 1) {
                System.out.print("DIGITA EL MONTO DE DINERO A DEPOSITAR EN TU CUENTA (maximo $5'000.000) : $");
                double montoDeposito = sc.nextDouble();
                cuenta.depositar(montoDeposito);

            } else if (operacionCuenta == 2) {
                System.out.print("DIGITA EL MONTO DE DINERO A RETIRAR DE TU CUENTA (maximo $5'000.000) : $");
                double montoRetiro = sc.nextDouble();
                cuenta.retirar(montoRetiro);

            } else if (operacionCuenta == 3) {
                cuenta.consultarSaldo();
            }
        }

        System.out.println("Gracias por usar el Banco Ahorros. Hasta pronto!");
        sc.close();
    }
}
