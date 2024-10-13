package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    public static void bfs( ArrayList<Edge> graph[],boolean isVisited[]){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int curr= queue.remove();
            if(!isVisited[curr]){
                System.out.print(curr+", ");
                isVisited[curr]=true;
                for(int i=0;i<graph[curr].size();i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean isVisited[]){
        System.out.print(curr+", ");
        isVisited[curr]=true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]) {
                dfs(graph, e.dest, isVisited);
            }
        }
    }
    public static void main(String args[]){
     int V=7;
     ArrayList<Edge> graph[]=new ArrayList[V];
     createGraph(graph);
//     for(int i=0;i<graph[5].size();i++){
//         Edge e= graph[5].get(i);
//         System.out.print(e.dest+" ,");
//     }
        boolean isVisited[]= new boolean[7];
       // bfs(graph,isVisited);
      //  dfs(graph,0,isVisited);
        findPath(graph,isVisited,0,"0",5);
    }

    public static void findPath(ArrayList<Edge>[] graph,boolean isVisited[], int current, String path, int target) {
        if(current==target){
            System.out.print(path+",");
            return;
        }
        for (int i=0;i<graph[current].size();i++){
            Edge e= graph[current].get(i);
            if(!isVisited[current]){
                isVisited[current]=true;
                findPath(graph,isVisited,e.dest,path+ e.dest,target);
                isVisited[current]=false;
            }
        }
    }


}
