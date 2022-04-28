class LinkedQueue {

    //Node class
    private class Node{
        Question data;
        Node next;

        public Node(Question data){
            this.data = data;
            this.next = null;
        }
    }

    //Fields
    Node front, rear;
    /**
     * Linkedqueue constructor
     */
    public LinkedQueue(){
        this.front = this.rear = null;
    }

    /**
     * endqueue - adds to end of queue
     * @param key
     */
    void enqueue(Question key){
        Node temp = new Node(key);
 
        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
 
        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }
    
    /**
     * dequeue - dequeues front
     */
    void dequeue(){
        if (this.front == null)
            return;
 
        // Store previous front and move front one node ahead
        
        this.front = this.front.next;
 
        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;        
    }

    /**
     * display - displays the queue
     */
    void display(){
        Node temp = front;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /**
     * checks is queue is empty
     * @return
     */
    boolean isEmpty(){
        if(this.rear == null){
            return true;
        }
        return false;
    }
    /**
     * poll - returns front and deques it
     * @return
     */
    Question poll(){
        if(this.front == null){
            System.out.println("No questions!");
            return null;
        }
        Question ret = this.front.data;
        dequeue();
        return ret;
    }
}
