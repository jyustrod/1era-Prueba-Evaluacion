/*
Copyright 2025 Javier Yustres Rodriguez
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific
language governing permissions and limitations under the
License.
*/

package aplicacion;

import aplicacion.mates.Matematicas;
import aplicacion.dominio.Tablero;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1: Generar Numero Pi\n" +
                    "2: Juego de la Vida\n" +
                    "3: Salir\n" +
                    "Escoje una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El número PI es " + Matematicas.generarNumeroPi(Integer.parseInt(args[0])));
                    break;
                case 2:
                    try {
                        Tablero tablero = new Tablero();
                        System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
                        tablero.leerEstadoActual();
                        System.out.println(tablero);

                        for (int i = 0; i <= 5; i++) {
                            TimeUnit.SECONDS.sleep(1);
                            tablero.transitarAlEstadoSiguiente();
                            System.out.println(tablero);
                        }

                        System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
                        tablero.generarEstadoActualPorMontecarlo();
                        System.out.println(tablero);

                        for (int i = 0; i <= 15; i++) {
                            TimeUnit.SECONDS.sleep(1);
                            tablero.transitarAlEstadoSiguiente();
                            System.out.println(tablero);
                        }

                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
            }
        } while (opcion != 3);
    }



}