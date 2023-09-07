import java.util.*;

class Solution {
    static List<Integer> res;
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = initTree(nodeinfo);
        
        int[][] answer = new int[2][nodeinfo.length];
        
        res = new ArrayList<>();
        pre(root);
        answer[0] = res.stream().mapToInt(x -> x).toArray();
        res.clear();
        post(root);
        answer[1] = res.stream().mapToInt(x -> x).toArray();
        
        return answer;
    }
    
    public void pre(Node cur) {
        if(cur == null) return;
        
        res.add(cur.idx);
        pre(cur.left);
        pre(cur.right);
    }
    
    public void post(Node cur) {
        if(cur == null) return;
        
        post(cur.left);
        post(cur.right);
        res.add(cur.idx);
    }
    
    public Node initTree(int[][] nodeinfo) {
        Node root;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            if(x[0] == y[0])    return Integer.compare(x[1], y[1]);
            else                return Integer.compare(y[0], x[0]);
        });

        for(int i = 0; i < nodeinfo.length; i++) {
            pq.offer(new int[] {nodeinfo[i][1], nodeinfo[i][0], i + 1}); // {depth,val,idx}
        }
        
        // root node
        int[] info = pq.poll();
        root = new Node(info[0], info[1], info[2]);
        
        while(!pq.isEmpty()) {
            Node cur = root;
            info = pq.poll();

            while(true) {
                // left node
                if(info[1] < cur.val) {
                    if(cur.left == null) {
                        cur.left = new Node(info[0], info[1], info[2]);
                        break;
                    }
                    cur = cur.left;
                } 
                // right node
                else { 
                    if(cur.right == null) {
                        cur.right = new Node(info[0], info[1], info[2]);
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
        
        return root;
    }
}

class Node {
    Node left, right;
    int depth, val, idx;
    
    public Node(int depth, int val, int idx) {
        this.depth = depth;
        this.val = val;
        this.idx = idx;
    }
    public String toString() {
        return idx + "";
    }
}