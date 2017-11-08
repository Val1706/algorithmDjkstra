import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices
        View.getFirtsCountry();
        String country1 = View.getCountry();

        View.getNextCountry();
        String country2 = View.getCountry();

        View.getNextCountry();
        String country3 = View.getCountry();

        View.getNextCountry();
        String country4 = View.getCountry();

        View.getNextCountry();
        String country5 = View.getCountry();


        Vertex A = new Vertex(country1);
        Vertex B = new Vertex(country2);
        Vertex D = new Vertex(country3);
        Vertex F = new Vertex(country4);
        Vertex K = new Vertex(country5);
        
        // set the edges and weight

        View.showDistanceMsg(country1, country2);
        Integer distance = View.getFirstDistance();
        A.adjacencies = new Edge[]{ new Edge(B, distance) };

        View.showDistanceMsg(country1, country4);
        Integer distance2 = View.getFirstDistance();
        A.adjacencies = new Edge[]{ new Edge(F, distance2) };

        View.showDistanceMsg(country2, country3);
        Integer distance3 = View.getFirstDistance();
        B.adjacencies = new Edge[]{ new Edge(D, distance3) };

        View.showDistanceMsg(country3, country4);
        Integer distance4 = View.getFirstDistance();
        D.adjacencies = new Edge[]{ new Edge(F, distance4) };

        View.showDistanceMsg(country3, country5);
        Integer distance5 = View.getFirstDistance();
        D.adjacencies = new Edge[]{ new Edge(K, distance5) };

        View.showDistanceMsg(country4, country5);
        Integer distance6 = View.getFirstDistance();
        F.adjacencies = new Edge[]{ new Edge(K, distance6) };

        K.adjacencies = new Edge[]{ new Edge(K, 0) };

        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + K + ": " + K.minDistance);
        List<Vertex> path = getShortestPathTo(K);
        System.out.println("Path: " + path);
    }
}