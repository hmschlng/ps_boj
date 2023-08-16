import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringJoiner sj;
    static StringBuilder sb;
    static Room antHouse;
    static Map<String, Room> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        antHouse = new Room("root");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int depth = Integer.parseInt(st.nextToken());
            map = antHouse.door;

            for (int j = 0; j < depth; j++) {
                String food = st.nextToken();
                Room r = new Room(food);
                if(!map.containsKey(food)) {
                    map.put(food, r);
                }
                map = map.get(food).door;
            }
        }

        sj = new StringJoiner("\n");
        sb = new StringBuilder();
        print(antHouse, 0);
        System.out.println(sj);
    }

    private static void print(Room room, int depth) {
        if(room.door.isEmpty()) {
            return;
        }
        for(String key : room.door.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(key);
            sj.add(sb.toString());
            sb.setLength(0);
            print(room.door.get(key), depth + 1);
        }
    }
}

class Room {
    String name;
    Map<String, Room> door;

    public Room(String name) {
        this.name = name;
        this.door = new TreeMap<>();
    }
}