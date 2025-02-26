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

package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import pr2.Graph;

public class GraphTest {

    /**
    * Este test comprueba que el metodo ‘onePath(V v1, V v2)‘
    * encuentra un camino entre ‘v1‘ y ‘v2‘ cuando existe.
    */

    @Test
    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");

        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);

        assertEquals(expectedPath, g.onePath(1, 4));
    }
}
