import java.util.*;

class Node {
    int key;
    Node left, right;

    Node(int data) {
        key = data;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    boolean findPair(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        boolean foundLeft = findPair(root.left, sum, set);
        if (foundLeft) {
            return true;
        }

        if (set.contains(sum - root.key)) {
            System.out.println("Pair found: (" + root.key + ", " + (sum - root.key) + ")");
            return true;
        } else {
            set.add(root.key);
        }

        boolean foundRight = findPair(root.right, sum, set);
        if (foundRight) {
            return true;
        }

        return false;
    }
}

public class PairInBST {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(40);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(30);
        bst.insert(50);
        bst.insert(70);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        HashSet<Integer> set = new HashSet<Integer>();
        if (!bst.findPair(bst.root, sum, set)) {
            System.out.println("Nodes are not found.");
        }
    }
}
