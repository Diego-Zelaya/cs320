package edu.sdsu.cs.datastructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.NoSuchElementException;
import java.util.*;
public class DirectedGraph<V> implements IGraph<V> {

    private V vertex;
    private List<V> adjVertices;
    private Map<V,List<V>> vertexMap = new TreeMap<V,List<V>>();
    private int numVertices;




    public DirectedGraph(V vertex, List<V> adjVertices) {
        this.vertex = vertex;
        this.adjVertices = adjVertices;
    }

    public class Vertex<V> {
        private V name;
        private ArrayList<Edge> outgoingEdges;
    }
    public class Edge {
        private Vertex origin;
        private Vertex destination;
        public Edge(Vertex origin, Vertex destination){
            this.origin = origin;
            this.destination = destination;
        }
    }
    @Override
    public void add(V vertexName) {
        if (vertexMap.containsKey(vertexName)) return;
        vertexMap.put(vertexName, new ArrayList<V>());
        numVertices++;
    }

    @Override
    public void connect(V start, V destination) {

    }

    @Override
    public void clear() {
        vertexMap.clear();
    }

    @Override
    public boolean contains(V label) {
        return vertexMap.containsKey(label);
    }

    @Override
    public void disconnect(V start, V destination) {

    }

    @Override
    public boolean isConnected(V start, V destination) {
        return false;
    }

    @Override
    public Iterable<V> neighbors(V vertexName) {
        return null;
    }

    @Override
    public void remove(V vertexName) throws NoSuchElementException {
        if (vertexMap.get(vertexName) == null) {
            throw new NoSuchElementException();
        }
        vertexMap.get(vertexName).getAdj().clear();

        vertexMap.remove(vertexName);
    }
    @Override
    public List<V> shortestPath(V start, V destination) {
        //return null;

        final int INF = Integer.MAX_VALUE; //INF

        start = null;
        destination = null;
        double weight = 0;
        List<V> ListArray = new ArrayList<>();

        //IGraph<V> igraph =new IGraph[];


        if (weight == 0 && start == destination)
            return ListArray = null;

        if (weight == 1 && IGraph[start][destination] != INF)
            return IGraph [start][destination];

        if (weight <= 0)
            return INF;

        V res = INF;

        // Go to all adjacents of u and recur
        for (int i = 0; i < V; i++)
        {
            if (IGraph[start][i] != INF && start != i && destination != i)
            {
                int rec_res = shortestPath(IGraph, i, destination, weight-1);
                if (rec_res != INF)
                    res = Math.min(res, IGraph[start][i] + rec_res);
            }
        }
        return res;
    }


    @Override
    public int size() {
        //return numVertices;
        return (vertexMap.size() & 0x7FFFFFFF);
    }

    @Override
    public Iterable<V> vertices() {
        LinkedList<V> allVertices = new LinkedList<>();
        for (int i = 0; i < vertexMap.size(); i++) {
            if (vertexMap.get(i) != null)
                allVertices.add(vertexMap.get(i).name);
        }
        return allVertices;
    }
    @Override
    public IGraph connectedGraph(V origin) throws NoSuchElementException {

        if (!(vertexMap.containsKey(origin))) {
            throw new NoSuchElementException();
        }

        Vertex v = vertexMap.get(origin);

        LinkedList<V> visited = new LinkedList<V>();
        PriorityQueue<V> toVisit = new PriorityQueue<V>();
        List<V> neigh = (List<V>) neighbors(origin);

        for (int i = 0; i < neigh.size(); i++) {
            toVisit.add(neigh.get(i));
        }

        DirectedGraph<V> newGraph = new DirectedGraph<>();

        newGraph.add(origin);
        for (V temp : neigh) {
            newGraph.add(temp);
            newGraph.connect(origin, temp);
        }

        while (!toVisit.isEmpty()) {
            V aVertex = toVisit.remove();
            newGraph.add(aVertex);
            visited.add(aVertex);

            for (V nbr : neighbors(aVertex)) {
                newGraph.add(nbr);
                newGraph.connect(aVertex, nbr);
                if (!visited.contains(nbr)) {
                    toVisit.add(nbr);
                }
            }
        }

        return newGraph;
    }
}

