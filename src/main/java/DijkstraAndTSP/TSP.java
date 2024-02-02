package DijkstraAndTSP;

public class TSP {
    static String stateWhite = "white";
    static String stateGrey = "grey";
    static String stateBlack = "black";
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