import java.io.*;
import java.util.*;

public class Main {
    static TreeNode root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");
        String line = br.readLine();

        root = new TreeNode(Integer.parseInt(line), null, null);

        while(true) {
            line = br.readLine();
            if(line == null) break;

            int newVal = Integer.parseInt(line);
            root.putValue(newVal);
        }

        root.printPostTraversal(sj);

        System.out.println(sj);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void putValue(int data) {
        if(data < this.val) {
            if(this.left == null) {
                this.left = new TreeNode(data, null, null);
            }
            else {
                this.left.putValue(data);
            }
        } else {
            if(this.right == null) {
                this.right = new TreeNode(data, null, null);
            }
            else {
                this.right.putValue(data);
            }
        }
    }

    public void printPostTraversal(StringJoiner sj) {
        if(this.left == null && this.right == null) {
            sj.add(String.valueOf(this.val));
            return;
        }
        if(this.left != null)
            this.left.printPostTraversal(sj);
        if(this.right != null)
            this.right.printPostTraversal(sj);
        sj.add(String.valueOf(this.val));
    }
}