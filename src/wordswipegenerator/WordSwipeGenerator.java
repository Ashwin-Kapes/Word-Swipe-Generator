/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordswipegenerator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.Keymap;

/**
 *
 * @author Ashwin Kain
 */
public class WordSwipeGenerator {
    static final int N = 16;
    static int[][] KeyMat =  {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
    static int ListMinSize = 3;
    static int ListMaxSize = 7;
    static int count = 0;
    static class Graph{
		int V;
		Map<Integer, List<Integer>> adj; // Adjacency list                
		
		Graph(int v){
			V = v;
			adj = new HashMap<Integer, List<Integer>>();
		}
		
		void addEdge(int u, int v){
			if(!adj.containsKey(u)){
				adj.put(u, new ArrayList<Integer>());
			}
			adj.get(u).add(v);
		}
		
		List<List<Integer>> getAllPaths(int u, int v){
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if(u == v){
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(u);
				result.add(temp);
				return result;
			}
			boolean[] visited = new boolean[V];
			Deque<Integer> path = new ArrayDeque<Integer>();
			getAllPathsDFS(u, v, visited, path, result);
			return result;
		}
		
		void getAllPathsDFS(int u, int v, boolean[] visited, Deque<Integer> path, List<List<Integer>> result){
			visited[u] = true; // Mark visited
			path.add(u); // Add to the end
			if(u == v){
                            if(path.size() >= ListMinSize && path.size() <= ListMaxSize){
				result.add(new ArrayList<Integer>(path));
                                //System.out.println(path);
                            }
			}
			else{
				if(adj.containsKey(u)){
					for(Integer i : adj.get(u)){
						if(!visited[i]){
							getAllPathsDFS(i, v, visited, path, result);
						}
					}
				}
			}
			path.removeLast();
			visited[u] = false;
		}
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph(N);
        //System.out.println(Arrays.deepToString(KeyMat));
        for(int i = 0; i < KeyMat.length;i++){
            for(int j = 0; j < KeyMat.length;j++){
                //g.addEdge(i,j);
                int currentIndex = KeyMat[i][j];
                System.out.print("Adjacent for " + KeyMat[i][j] + "##");
                try {
                     System.out.print(KeyMat[i-1][j] + "-");
                     g.addEdge(currentIndex, KeyMat[i-1][j]);
                } catch (Exception e) {
                }
                try {
                     System.out.print(KeyMat[i+1][j] + "-");
                     g.addEdge(currentIndex, KeyMat[i+1][j]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i][j-1] + "-");
                     g.addEdge(currentIndex, KeyMat[i][j-1]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i][j+1] + "-");
                     g.addEdge(currentIndex, KeyMat[i][j+1]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i+1][j+1] + "-");
                     g.addEdge(currentIndex, KeyMat[i+1][j+1]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i-1][j-1] + "-");
                     g.addEdge(currentIndex, KeyMat[i-1][j-1]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i+1][j-1] + "-");
                     g.addEdge(currentIndex, KeyMat[i+1][j-1]);
                } catch (Exception e) {
                }
                try {                    
                     System.out.print(KeyMat[i-1][j+1] + "-");
                     g.addEdge(currentIndex, KeyMat[i-1][j+1]);
                } catch (Exception e) {
                }
                System.out.println();
        }            
        }
               for(int k = 0; k < N;k++){
                    for(int l = 0; l < N;l++){
                        if(k != l){
                        System.out.println("Showing all paths from (" + k + ", " + l + ")");
                        List<List<Integer>> results = g.getAllPaths(k,l);
                        new keyToValueConverter(results);                            
                        System.out.println("Size of List:" + results.size());
                        count = count + results.size();
                        }
                    }
                    System.out.println("Total combinations: " + count);
               }		
    }
    
}
