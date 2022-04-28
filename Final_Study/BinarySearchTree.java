public class BinarySearchTree {

    public class Node{
        int data;
        Node left, right;
        Node(int key){
            this.data = key;
            left = right = null;
        }
    }
    Node root;

    public BinarySearchTree(){
        
    }

    public BinarySearchTree(int key){
        root = new Node(key);
    }

    public void insert(int key){
        Node temp = root;
        while(true){
            if(temp.data > key){
                if(temp.left == null){
                    temp.left = new Node(key);
                    return;
                }
                else{
                    temp = temp.left;
                }
            }
            else if (temp.data<key){
                if(temp.right == null){
                    temp.right = new Node(key);
                    return;
                }
                else{
                    temp = temp.right;
                }
            }
        }
    }

    private Node getMin(Node curr){
        while(curr.left!= null){
            curr = curr.left;
        }
        return curr;

    }

    public void delete(int key){
        Node parent = null;
        Node curr = root;
        while(curr != null && curr.data != key){
            parent = curr;
            if(key<curr.data){curr = curr.left;}
            else if(key>curr.data){curr = curr.right;}
        }
        if(curr == null){System.out.println("The node requested to be delted does not exist");}
        //Case 1: leaf Node
        if(curr.left == null && curr.right == null){
            if(curr != root){
                if(parent.left == curr){
                    parent.left = null;
                }
                else if(parent.right == curr){
                    parent.right = null;
                }
            }
            else if (curr == root){
                root = null;
            }
        }
        //Case 2: to be deleted has 2 children
        else if (curr.left != null && curr.right != null){
            Node successor = getMin(curr.right);
            int val = successor.data;
            delete(val);
            curr.data = val;
        }
        //Case 3to be deleted only has one child
        else{
            Node child = (curr.left != null)? curr.left: curr.right;
            if(curr != root){
                if(curr == parent.left){
                    parent.left = child;
                }
                else{
                    parent.right = child;
                }
            }
            else{
                root = child;
            }

        }


    }

    public void display(){
        inOrder(this.root);
    }

    public void inOrder(Node root){
        if(root == null){return;}
        
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
        
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree(2);
        myTree.insert(1);
        myTree.insert(4);
        myTree.insert(3);
        myTree.insert(5);
        myTree.insert(6);
        myTree.delete(4);
        myTree.display();
    }
    
}
