/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Serg
 */

class Node<T extends Comparable<T>> {
    T data;
    Node<T> parent;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }
    
    
    
}
public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    Node<T> root;
    int size;
    int height;

    public BinaryTree() {
    }
    
    public BinaryTree(T[] array) {
        for (T t : array) {
            add(t);
        }
    }
    
    private void add(Node<T> node){
        
        if (root == null) {
            root = node;
            return;
        }
        
        Node<T> top = root;
        while(true) {
            node.parent = top;
            
            if (node.data.compareTo(top.data) <= 0){
                if (top.leftChild == null){
                    top.leftChild = node;
                    break;
                }
                top = top.leftChild;
            }
            else {
                if (top.rightChild == null){
                    top.rightChild = node;
                    break;
                }
                top = top.rightChild;
            }
        }
    }

    public void add(T data) {
        add(new Node<>(data));
    }
    
    public boolean contains(T el){
        Node<T> top = root;
        
        while (top != null){
            int comp = el.compareTo(top.data);
            
            if (comp > 0)
                top = top.rightChild;
            else if (comp < 0)
                top = top.leftChild;
            else
                return true;
        }
        
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        
        return new Iterator<>(){
            Node<T> top = root;
            final Stack<Node<T>> stack = new Stack<>();
        
            @Override
            public boolean hasNext() {
                if (top != null && top.data != null)
                    stack.push(top.rightChild);
                
                return !stack.empty() || top != null;
            }

            @Override
            public T next() {
                T send = top.data;
                if (top.leftChild != null)
                    top = top.leftChild;
                else if (!stack.empty())
                    top = stack.pop();
                
                else
                    top = null;
                
                return send;
            }
            
        };
    }
    
    
}
