public class LQueue {
    class Node{
        int data;
        Node next;
        Node(int key){
            data = key;
            next = null;
        }
    }

    Node front, back;

    public LQueue(){
        front = null;
        back = null;
    }

    public LQueue(int key){
        front = back = new Node(key);
    }
    
    public void enqueue(int key){
        if(front == null){
            front = back = new Node(key);            
        }
        else if(front == back){
            this.back = new Node(key);
            front.next = back;
        }
        else{
            Node temp = new Node(key);
            back.next = temp;
            back = temp;
        }
    }
    private boolean isEmpty(){
        if(this.front == null){return false;}
        return true;
    }

    public void dequeue(){
        if(isEmpty()){
            this.front = this.front.next;
            return;
        }
        System.out.println("The list was empty!");      

    }

    public void print(){
        Node temp = this.front;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LQueue myQueue = new LQueue();
        myQueue.dequeue();
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        
        myQueue.print();
    }
}
