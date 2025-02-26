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

package mates;

import java.util.Random;
import static java.lang.Math.pow;

public class Matematicas {

    /**
    * Genera una aproximación al número pi mediante el metodo de Montecarlo.
    * El parámetro ‘pasos‘ indica el número de puntos generados.
    */

    public static double generarNumeroPi(long pasos) {
        Random rand = new Random();
        long aciertos = 0;
        double areaCuadrado = 4.0;

        for (long i = 0; i < pasos; i++) {
            double x = rand.nextDouble() * 2 - 1;
            double y = rand.nextDouble() * 2 - 1;

            if (pow(x, 2) + pow(y, 2) <= 1) {
                aciertos++;
            }
        }

        return areaCuadrado * aciertos / pasos;
    }
}
