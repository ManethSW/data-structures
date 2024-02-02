package Q5;

public class TSP {
    static String stateWhite = "white";
    static String stateGrey = "grey";
    static String stateBlack = "black";

    public static int[] dijkstra(int[][] graph, int source) {
        int[] distance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        String[] state = new String[graph.length];
        for (int i = 0; i < graph.length; i++) {
            state[i] = stateWhite;
        }

        distance[source] = 0;

        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(source, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.dequeue();
            state[current[0]] = stateGrey;

            for (int i = 0; i < graph.length; i++) {
                if (graph[current[0]][i] != 0 && graph[current[0]][i] != Integer.MAX_VALUE && state[i].equals("white")) {
                    int newDistance = distance[current[0]] + graph[current[0]][i];
                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        pq.enqueue(i, newDistance);
                    }
                }
            }
            state[current[0]] = stateBlack;
        }
        return distance;
    }
    public static int[][] dijkstraTSP(int[][] graph, int source) {
        int[][] path = new int[graph.length + 1][2];
        String[] state = new String[graph.length];
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < graph.length; i++) {
            state[i] = stateWhite;
        }
        int lastVisited = source;
        int index = 0;

        pq.enqueue(source, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.dequeue();
            state[current[0]] = stateGrey;
            path[index][0] = current[0];
            path[index][1] = current[1];
            pq.clear();
            lastVisited = current[0];

            for (int i = 0; i < graph.length; i++) {
                if (state[i].equals("white")) {
                    pq.enqueue(i, graph[current[0]][i]);
                }
            }
            state[current[0]] = stateBlack;
            index++;
        }

        path[graph.length][0] = source;
        path[graph.length][1] = graph[lastVisited][source];

        return path;
    }


    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20, 30},
                {10, 0, 35, 25, 40},
                {15, 35, 0, 30, 50},
                {20, 25, 30, 0, 70},
                {30, 40, 50, 70, 0}
        };

//        // Run the dijkstra's Algorithm
//        int source = 0;
//        int [] distance = dijkstra(graph, source);
//        System.out.println("Shortest Distance from: ");
//        for (int i = 0; i < distance.length; i++) {
//            System.out.println( source + " to " + i + " = " + distance[i]);
//        }

//      // Run the dijkstraTSP Algorithm
        int [][] minPath = new int[graph.length + 1][2];
        int minTotDistance = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int[][] path = dijkstraTSP(graph, i);
            int totalDistance = 0;
            for (int j = 0; j < path.length; j++) {
                totalDistance += path[j][1];
            }
            if (totalDistance < minTotDistance) {
                minTotDistance = totalDistance;
                for (int k = 0; k < path.length; k++) {
                    minPath[k][0] = path[k][0];
                    minPath[k][1] = path[k][1];
                }
            }
        }

        for (int i = 0; i < minPath.length; i++) {
            System.out.print((char) (minPath[i][0] + 'A'));
            if (i < minPath.length - 1 && minPath[i + 1][1] != 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("Total distance: " + minTotDistance + " units");

    }
}