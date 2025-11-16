/**
 * A Eulerian path is a path in a graph that passes 
 * through all of its edges exactly once. A Eulerian 
 * cycle is a Eulerian path that is a cycle.
 * 
 * First we can check if there is an Eulerian path. 
 * We can use the following theorem. An Eulerian 
 * cycle exists if and only if the degrees of all 
 * vertices are even. And an Eulerian path exists 
 * if and only if the number of vertices with odd 
 * degrees is two (or zero, in the case of the 
 * existence of a Eulerian cycle). In addition, of 
 * course, the graph must be sufficiently connected 
 * (i.e., if you remove all isolated vertices from 
 * it, you should get a connected graph).
 * 
 * FOR DIRECTED GRAPHS:
 * CONDITIONS:
 * 1. All the vertices are in one stronglt connected
 * component
 * 2. in-degree should be equal to out-degree for every
 * vertex.
 */

public class EulerianPath {
    public boolean isEulerian(DirectedGraph dg) {

    }

    public void printEulerianPath(DirectedGraph dg) {
        // first check if it is possible or not?

    }

    public static void main(String[] args) {
        
    }
}
