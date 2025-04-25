public class Node {

    public Restaurant data;
    Node next;

    public Node(Restaurant r){
        data = r;
        next = null;
    }

    public Node(Restaurant r, Node n){
        data = r;
        next=  n;
    }

    public void setNode(Restaurant r){
        data = r;
    }

    public Restaurant getNode(){
        return data;
    }
}
