package com.algorithm.dfs;
import java.util.*;
public class DFS {
	private static int v = 7;
	private static String str = "1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7";
	private static List<Integer>[] graph;
	private static boolean visited[] = new boolean[v+1];
	private static List<Integer>dpath = new ArrayList<>();
	private static List<Integer>qpath = new ArrayList<>();
	private static Queue<Integer> q = new LinkedList<>();
	// graph를 만들고 -> dfs 방법으로 방문함.
	
	// 1. makeGraph
	public static void makeGraph(String str) {
		String splited[] = str.split(",");
		graph = new List[v+1];
		for(int i = 0; i<graph.length; i++) {
			graph[i] = new ArrayList<>(); //각 정점마다 ArrayList를 만들어둠. 
		}
		
		for(int i = 0; i<splited.length;i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			
			graph[a].add(b);
			graph[b].add(a);
		}
	}
	
	public static void dfs(int start) {
		visited[start] = true; 
		dpath.add(start);
		List<Integer> childs = graph[start]; //딸린 애들 리스트 만들기
		for(int i = 0; i<childs.size();i++) {
			int child = childs.get(i);
			if(visited[child]==false)
				dfs(child);
		}
		
	}
	
	public static void bfs(int start) {
		visited = new boolean[v+1];
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int front = q.poll(); // 맨 앞것 뽑기
			qpath.add(front);
			List<Integer> childs = graph[front];
			for(int i = 0; i<childs.size();i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					q.offer(child);
					visited[child] = true;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		makeGraph(str);
		dfs(1);
		System.out.println("DFS : "+dpath);
		bfs(1);
		System.out.println("BFS : "+qpath);
	}

}
