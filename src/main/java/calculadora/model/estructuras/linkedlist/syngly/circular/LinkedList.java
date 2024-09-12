package calculadora.model.estructuras.linkedlist.syngly.circular;

import calculadora.model.estructuras.node.syngly.LinkedNode;
import calculadora.util.iterator.Iterator;


public class LinkedList<E> {
    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private LinkedNode<E> inode;
    private int size;
    
    public LinkedList(){
        size = 0;
        head = null;
        tail = null;
        inode = null;
    }
    
    public LinkedList(E element){
    size = 0;
    head = null;
    tail = null;
    inode = null;
    add(element);
    }
    
    public boolean add(E element) {
        try{
            LinkedNode<E> node = new LinkedNode(element);
            if(isEmpty()){    
                head = node;
            }else{
                tail.setNext(node);
            }
            tail = node;
            tail.setNext(head);
            size++;
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false; 
    }
    
    public boolean addFirst(E element) {
    try{
    LinkedNode<E> node = new LinkedNode(element);
    if(isEmpty()){    
     tail = node;
    }else{
     node.setNext(head);
    }
    
    head = node;
    tail.setNext(head);
    size++;
    return true;
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
     return false; 
    }
     
    public E peek() {
        return head.get();
    }
    public E peekLast() {
        return tail.get();
    }
    public E pollLast() {
    E element = tail.get(); 
    if (size() == 1) {
        head = null;
        tail = null;
        inode = null;
    } else {
        LinkedNode<E> prevNode = head;
        while (prevNode.getNext() != tail) {
            prevNode = prevNode.getNext();
        }
        
        prevNode.setNext(head);
        tail = prevNode;
    }
    size--; 
    return element;
    }
    public boolean remove(E element) {
    LinkedNode<E> current = head;
    LinkedNode<E> prev = null;

    do{
        if (current.get().equals(element)) {
            if(size==1){
                
                head = null;
                tail = null;
                inode = null;
            }
            else if (prev == null) {
                
                head = current.getNext();
                tail.setNext(head);
            }else if(current == tail){
                
                prev.setNext(current.getNext());
                tail = prev;
            }else {
                
                prev.setNext(current.getNext());
            }
            
            size--;
            return true; 
        }
        prev = current;
        current = current.getNext();
     }while(current != head);
    return false; 
}
    public boolean isEmpty() {
        return head == null && tail == null && inode == null && size == 0;   
    }
    
    public boolean clear() {
    head = null;
    tail = null;
    inode = null;
    size = 0;
    return true;
    }
    
    public int size(){
        return size;
    }
    
    public E poll() {
        E element = head.get();
        if(size == 1){
            head = null;
            tail = null;
            inode = null;
        }else{
        tail.setNext(head.getNext());
        head = head.getNext();
        }
        size--;
        return element;
    }
    
    public Iterator<E> iterator() {
    inode = head; 
    return new Iterator<E>() {
        private boolean llegoCola = false;
        @Override
        public boolean hasNext() {
            if (llegoCola && inode == head) {
                llegoCola = false;
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            if(llegoCola && inode == head){
                llegoCola = false;
            }
            E element = inode.get();
            inode = inode.getNext();
            if (inode == tail) {
                llegoCola = true;
            }
            return element;
        }
    };
} 
}
