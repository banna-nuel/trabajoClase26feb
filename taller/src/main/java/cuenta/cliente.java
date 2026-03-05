package cuenta;

import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        System.out.println(" ---------------- BANCO EL AHORRADOR ----------------- \n" +
                "BIENVENIDO AL BANCO EL AHORRADOR \n 1: DESEAS CREAR TU CUENTA CON $0 PESOS \n" +
                " 2: DESEAS CREAR TU CUENTA CON $1 HASTA $5'000.000 DE PESOS");

        Scanner sc = new Scanner(System.in);
        System.out.print("DIGITA ENTRE LA OPCIÓN 1 o 2: ");
        int decisionCuenta = sc.nextInt();

        while (decisionCuenta != 1 && decisionCuenta != 2) {
            System.out.println("Opción no válida, digita una opción valida: ");
            decisionCuenta = sc.nextInt();
        }

        double dineroCuenta = 0;
        if (decisionCuenta == 1) {
            System.out.println("TU CUENTA HA SIDO CREADA CON EXITO CON $0 PESOS");
        } else {
            System.out.print("PARA CREAR TU CUENTA DIGITA EL MONTO ENTRE $1 HASTA $5'000.000 PESOS: ");
            dineroCuenta = sc.nextInt();
            while (dineroCuenta <= 0 || dineroCuenta>= 5000001) {
                System.out.print("\nEl monto digitado no es valido, digita un monto valido entre $1 hasta $5'000.000 pesos: ");
                dineroCuenta = sc.nextInt();
            }
            System.out.println("TU CUENTA SE HA CREADO CON EXITO CON $" + dineroCuenta + " PESOS");
        }
        System.out.println(" ---------------- MENU ---------------" +
                "\n 1: DEPOSITAR DINERO \n 2: RETIRARA DINERO \n 3: OBTENER SALDO ACTUAL \n ---- QUE OPERACION DESEAS HACER -----");
        int operacionCuenta = sc.nextInt();
        while (operacionCuenta <= 0 || operacionCuenta >= 4){
            System.out.println("Opción digitada no valida, por favor digite una opción valida");
            operacionCuenta = sc.nextInt();
        }
        if (operacionCuenta == 1) {
            System.out.print("DIGITA EL MONTO DE DINERO A DEPOSITAR EN TU CUENTA (maximo $5'000.000) : $");
            int depositarCuenta = sc.nextInt();
            while (depositarCuenta <=0 || depositarCuenta >= 5000001){
                System.out.print("digita un monto valido: ");
                depositarCuenta = sc.nextInt();
            }
            System.out.println("DEPOSITASTE $" + depositarCuenta + " PESOS EN TU CUENTA");

        } else if (operacionCuenta == 2) {
            System.out.print("DIGITA EL MONTO DE DINERO A RETIRAR DE TU CUENTA (maximo $5'000.000) : $");
            int retirarCuenta = sc.nextInt();
            while (retirarCuenta <=0 || retirarCuenta >= 5000001){
                System.out.print("digita un monto valido: ");
                retirarCuenta = sc.nextInt();
            }
            while (retirarCuenta > dineroCuenta || retirarCuenta <= 0) {
                System.out.println("no puededes retirar $" + retirarCuenta + " tienes $" + dineroCuenta + " pesos en tu cuenta, digita un monto a retirar valido");
                retirarCuenta = sc.nextInt();
            } if (retirarCuenta <= dineroCuenta)
                System.out.println("RETIRASTE $" + retirarCuenta + " PESOS DE TU CUENTA");

        } else if (operacionCuenta == 3) {
            System.out.println("EN SU CUENTA HAY UN SALDO TOTAL DE $" + dineroCuenta + " PESOS");
        }

        sc.close();

    }
}
