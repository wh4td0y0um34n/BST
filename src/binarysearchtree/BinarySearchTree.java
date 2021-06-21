package binarysearchtree;

import java.io.PrintStream;

class BinarySearchTree {

    class Node {

        String key;
        Node left, right;

        public Node(String item) {
            key = item;
            left = right = null;

        }

    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    BinarySearchTree(String key) {
        root = insertJajan(root, key, "asd");
    }

    void insert(String key, String arah) {
        root = insertJajan(root, key, arah);
    }

    Node insertJajan(Node root, String key, String arah) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (arah.toLowerCase() == "kiri") {
            root.left = insertJajan(root.left, key, arah);
        } else if (arah.toLowerCase() == "kanan") {
            root.right = insertJajan(root.right, key, arah);
        }
        return root;
    }
    
     void inorder() {
        inorderKutil(root);
    }

    void inorderKutil(Node root) {
        if (root != null) {
            inorderKutil(root.left);
            System.out.print(root.key + ",");
            inorderKutil(root.right);
        }
    }

    boolean  isExist(String data) {
         return isExist(root, data);
    }

    boolean isExist(Node root, String data) {
        boolean g = false;
        if (root != null) {
            if(root.key != data){
            return isExist(root.left, data);
            }
            if (root.key == data){
                return true;
            }
            if (root.key != data) {
                return isExist(root.right, data);
            }
        }return false;
        
    }

//    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
//        if (root.right != null) {
//            root.right.key.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
//        }
//        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(root.key.toString()).append("\n");
//        if (root.left != null) {
//            root.left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
//        }
//        return sb;
//    }
//
//    @Override
//    public String toString() {
//        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
//    }
    
    
    public void print() {
        print(" ", root, false);
    }

   public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.key);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
   
   public boolean remove(String s){
        Node ans = remove(root, s);
        if(ans == null){
            return false;
        } else {
            return true;
        }
    }

    private static Node remove(Node root, String s) {

        if (root == null)
            return null;

        if (s.compareTo(root.key) < 0) {
            root.left = remove(root.left, s);
        } else if (s.compareTo(root.key) > 0) {
            root.right = remove(root.right, s);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null)
                return root.left;

            root.key = minimum(root.right);
            root.right = remove(root.right, root.key);
        }

        return root;

    }

    public static String minimum(Node root) {
        String minimum = root.key;
        while (root.left != null) {
            minimum = root.left.key;
            root = root.left;
        }
        return minimum;
    }
    
    

    public static void main(String[] args) {
        BinarySearchTree p = new BinarySearchTree("indonesia");
        p.insert("Jawa Timur", "kiri");
        p.insert("Sumatra", "kanan");
        p.insert("Sulawesi", "kanan");
        p.insert("Kalimantan", "kanan");
        p.insert("Papua", "kiri");
        p.insert("NTT", "kanan");
        p.insert("NTB", "kiri");
        p.insert("Banten", "kanan");
        p.insert("Bengkulu", "kiri");
        p.insert("Bali", "kanan");
        p.insert("Riau", "kiri");
        p.print();
        p.inorder();
        System.out.println();
        System.out.println(p.isExist("sumatra"));
          
        System.out.printf("%.8f", StringScoring.score("Kalimantan", "kaan"));
    }
}

