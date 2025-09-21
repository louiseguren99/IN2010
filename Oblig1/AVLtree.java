import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AVLtree{
    Node root;
    int size;

    class Node{
        int element;
        Node left;
        Node right;
        int height;

        Node(int element){
            this.element = element;
            left = right = null;
            height = 1;
        }
    }

    public int height(Node node){
        if (node == null){
            return -1;
        }
        return node.height;
    }

    public void setHeight(Node node){
        if (node == null){
            return;
        }
        node.height = 1 + Math.max(height(node.left),height(node.right));
    }

    public int balanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public Node rightRotate(Node node){
        Node leftChild = node.left;
        //lcRight er høyre barn av leftChild
        Node lcRight = leftChild.right;
        leftChild.right = node;
        node.left = lcRight;

        setHeight(node);
        setHeight(leftChild);
        return leftChild;
    }

    public Node leftRotate(Node node){
        Node rightChild = node.right;
        Node rcLeft = rightChild.left;
        rightChild.left = node;
        node.right = rcLeft;
        setHeight(node);
        setHeight(rightChild);
        return rightChild;
    }

    public Node balance(Node node){
        if (balanceFactor(node.right) < -1){
            if (balanceFactor(node.right) > 0){
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        else if (balanceFactor(node) > 1){
            if (balanceFactor(node.left) < 0){
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        return node;
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
        setHeight(node);
        return balance(node);
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

    public static void main(String[] args) throws Exception{

        AVLtree avl = new AVLtree();
            
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
                avl.insert(Integer.parseInt(ord[1]));
            }

            if (ord[0].equals("contains")){
                System.out.println(avl.contains(avl.root, Integer.parseInt(ord[1])));
            }

            if (ord[0].equals("remove")){
                avl.remove(avl.root, Integer.parseInt(ord[1]));
            }
            if (ord[0].equals("size")){
                System.out.println(avl.size());
            }
        }
        input.close();   
    }
}








    
    