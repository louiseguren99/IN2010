import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearchTree{

    private Node root;
    private int size;

    class Node {
        int element;
        Node left;
        Node right;

        Node(int x) {
            element = x;
        }
    }

    public boolean contains(Node node, int x){
        if (node == null){
            return false;
        }
        else if (x < node.element){
            return contains(node.left, x);
        }
        else if (x > node.element){
            return contains(node.right, x);
        }
        return true;
    }

    //metode for at første innsetting skal fungere og oppdatere roten
    void insert(int x) {
        root = insert(root, x);
    }

    public Node insert(Node node, int x){
        if (node == null){
            size += 1;
            node = new Node(x);
            return node;  
        }
        else if (x < node.element){
            node.left = insert(node.left, x);
        }
        else if (x > node.element){
            node.right = insert(node.right, x);
        }
        return node;
    }

    //hjelpemetode
    public Node findMin(Node node){
        Node min = node;
        while(min.left != null){
            min = min.left;
        }
        return min;
    }

    public Node remove(Node node, int x){
        if (node == null){
            return null;
        }
        if (x < node.element){
            node.left = remove(node.left, x);
        }
        else if (x > node.element){
            node.right = remove(node.right, x);
        }
        else{//fant noden: x == node.element  
            //node med kun ett eller null barn
            if (node.left == null){ 
                size --;
                return node.right;
            }
            if (node.right == null){
                size --;
                return node.left;
            }
            //node med to barn
            node.element = findMin(node.right).element;
            node.right = remove(node.right, node.element);
        }
        return node;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args)throws Exception{

        BinarySearchTree bst = new BinarySearchTree();
            
        Scanner input;
        if (args.length > 0) {
            input = new Scanner(new File(args[0]));
        } 
        else {
            input = new Scanner(System.in);
        }

        int antall = Integer.parseInt(input.nextLine());

        for (int i=1; i<= antall; i++){
            String linje = input.nextLine();
            String[] ord = linje.split(" ");
        
            if (ord[0].equals("insert")){
                bst.insert(Integer.parseInt(ord[1]));
            }

            if (ord[0].equals("contains")){
                System.out.println(bst.contains(bst.root, Integer.parseInt(ord[1])));
            }

            if (ord[0].equals("remove")){
                bst.remove(bst.root, Integer.parseInt(ord[1]));
            }
            if (ord[0].equals("size")){
                System.out.println(bst.size());
            }
        }
        input.close();
    }
}


