package estructuras.node.syngly;


public class LinkedNode<E> {
    private E element;
    private LinkedNode<E> next;
    
    public LinkedNode(){
        this.element = null;
        next = null;
    }
    public LinkedNode(E element){
        this.element = element;
        next = null;
    }
    public LinkedNode<E> getNext(){
        return next;
    }
    public void setNext(LinkedNode<E> next){
        this.next = next;
    }
    
    public void set(E element) {
        this.element = element;   
    }

    public E get() {
        return element;  
    }
}
