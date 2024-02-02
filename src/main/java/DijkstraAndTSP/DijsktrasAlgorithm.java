package DijkstraAndTSP;

class DijsktrasAlgorithm {
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

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20, 30},
                {10, 0, 35, 25, 40},
                {15, 35, 0, 30, 50},
                {20, 25, 30, 0, 70},
                {30, 40, 50, 70, 0}
        };
        int source = 0;
        int [] distance = dijkstra(graph, source);
        System.out.println("Shortest Distance from: ");
        for (int i = 0; i < distance.length; i++) {
            System.out.println( source + " to " + i + " = " + distance[i]);
        }
    }
}