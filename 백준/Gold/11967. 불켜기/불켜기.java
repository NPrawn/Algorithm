import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	
	static int N;
	static ArrayList<Room> shed[][];
	static boolean light[][];
	static boolean visit[][];
	static int result = 1;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        shed = new ArrayList[N + 1][N + 1];
        light = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
        		shed[i][j] = new ArrayList<>();
        	}
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	shed[x][y].add(new Room(a, b));
        }
        
        bfs();
        System.out.println(result);
    }
    
    static void bfs() {
    	Queue<Room> q = new LinkedList<>();
    	q.offer(new Room(1, 1));
    	light[1][1] = true;
    	visit[1][1] = true;
    	
    	while(!q.isEmpty()) {
    		Room temp = q.poll();
    		
    		if (!shed[temp.x][temp.y].isEmpty()) {
    			visit = new boolean[N + 1][N + 1];
    			visit[temp.x][temp.y] = true;
    			for (Room room : shed[temp.x][temp.y]) {
    				if (!light[room.x][room.y]) {
    					light[room.x][room.y] = true;
        				result++;
    				}
    			}
    			shed[temp.x][temp.y].clear();
    		}
    		
    		for (int i = 0; i < 4; i++) {
    			int newX = temp.x + dx[i];
    			int newY = temp.y + dy[i];
    			
    			if (newX <= 0 || newY <= 0 || newX > N || newY > N) continue;
    			
    			if (light[newX][newY] == true && !visit[newX][newY]) {
    				q.offer(new Room(newX, newY));
    				visit[newX][newY] = true;
    			}
    		}
    	}
    }
}

class Room {
	int x;
	int y;
	
	Room (int x, int y) {
		this.x = x;
		this.y = y;
	}
}