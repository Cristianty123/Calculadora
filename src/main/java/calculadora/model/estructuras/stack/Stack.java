package calculadora.model.estructuras.stack;

import calculadora.model.estructuras.linkedlist.syngly.circular.LinkedList;
import calculadora.util.iterator.Iterator;

public class Stack<E> {
    
    private LinkedList<E> stack;
    
    public Stack(){
        stack = new LinkedList<>();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int size() {
        return stack.size();
    }
    public Iterator<E> iterator() {
        return stack.iterator();
    }
    public E peek() {
        return stack.peekLast(); 
    }
    public E pop() {
        return stack.pollLast(); 
    }
    public boolean push(E element) {
        stack.add(element); 
        return true;
    }

    
}
