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

package dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
* Esta clase es responsable de leer el tablero de un
* fichero en forma de ceros y unos, ir transitando de
* estados e ir mostrando dichos estados.
*/

public class Tablero{
    private static int DIMENSION = 30;
    private int[][] estadoActual = new int[DIMENSION][DIMENSION];
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    /********************************************************
     * Lee el estado inicial de un fichero llamado ‘matriz‘.
     ********************************************************/

    public void leerEstadoActual () {
        try (BufferedReader br = new BufferedReader(new FileReader("Codigo/src/main/java/dominio/matriz"))) {
            for (int i = 0; i < DIMENSION; i++) {
                String linea = br.readLine();
                for (int j = 0; j < DIMENSION; j++) {
                    estadoActual[i][j] = linea.charAt(j) - '0';
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /********************************************************
     * Genera un estado inicial aleatorio. Para cada celda
     * genera un número aleatorio en el intervalo [0, 1). Si
     * el número es menor que 0,5, entonces la celda está
     * inicialmente viva. En caso contrario, está muerta.
     *******************************************************/

    public void generarEstadoActualPorMontecarlo () {
        Random rand = new Random();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (rand.nextDouble() < 0.5) {
                    estadoActual[i][j] = 1;
                } else {
                    estadoActual[i][j] = 0;
                }
            }
        }
    }

    /********************************************************
     * Transita al estado siguiente según las reglas del
     * juego de la vida.
     ********************************************************/

    public void transitarAlEstadoSiguiente () {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinosVivos = contarVecinosVivos(i, j);

                if (estadoActual[i][j] == 1) {
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }

                } else {
                    if (vecinosVivos == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }
                }
            }
        }
        int[][] temp = estadoActual;
        estadoActual = estadoSiguiente;
        estadoSiguiente = temp;
    }

    /*******************************************************
     * Devuelve el numero de vecinos vivos de una celda (x, y).
     * @param x la coordenada x de la celda a evaluar.
     * @param y la coordenada y de la celda a evaluar.
     * @return el numero de vecinos vivos..
     *******************************************************/

    private int contarVecinosVivos(int x, int y) {
        int vivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int a = x + i, b = y + j; // (x, y) = celda siendo evaluada, (i, j) = desplazamiento, (a, b) = celda adjunta a la evaluada
                if (a >= 0 && a < DIMENSION && b >= 0 && b < DIMENSION) {
                    vivos += estadoActual[a][b];
                }
            }
        }
        return vivos;
    }

    /*******************************************************
     * Devuelve, en modo texto, el estado actual.
     * @return el estado actual.
     *******************************************************/

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (estadoActual[i][j] == 1) {
                    sb.append("x");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
