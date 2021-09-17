package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>>{
    
    private Node<E> root;
    private Node<E> parent;
    private Node<E> current;
    
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element, null, null);
            return true;
        }
        return add(root, element);
    }

    private boolean add(Node<E> root, E element) {
        if (element.compareTo(root.value) < 0) {
            if (root.left == null) {
                root.left = new Node<>(element, null, null);
                return true;
            }
            return add(root.left, element);
        }

        if (element.compareTo(root.value) > 0) {
            if (root.right == null) {
                root.right = new Node<>(element, null, null);
                return true;
            }
            return add(root.right, element);
        }
        return false;
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public boolean remove(E element) {
        int left = -1;
        int right = 1;
        int noStep = 0;

        setParent(null);
        setCurrent(root);
        int lastStep = noStep;
        lastStep = removeCurrent(element, left, right, lastStep);

        if (current == null) return false;

        if (current.left == null) {
            removeLeft(left, right, lastStep);
        } else if (current.right == null) {
            removeRight(left, right, lastStep);
        } else {
            Node<E> replaceNode = current.right;
            parent = current;

            while (replaceNode.left != null) {
                parent = replaceNode;
                replaceNode = replaceNode.left;
            }
            current.value = replaceNode.value;
            replaceNode(replaceNode);
        }
        return true;
    }

    private void replaceNode(Node<E> replaceNode) {
        if (parent.equals(current)) {
            parent.right = replaceNode.right;
        } else {
            parent.left = replaceNode.right;
        }
    }

    private void removeLeft(int left, int right, int lastStep) {
        if (lastStep == right) {
            parent.right = current.right;
        } else if (lastStep == left) {
            parent.left = current.right;
        } else {
            root = current.right;
        }
    }

    private void removeRight(int left, int right, int lastStep) {
        if (lastStep == right) {
            parent.right = current.left;
        } else if (lastStep == left) {
            parent.left = current.left;
        } else {
            root = current.left;
        }
    }


    private int removeCurrent(E element, int left, int right, int lastStep) {
        int temp;

        while (current != null && (temp = current.value.compareTo(element)) != 0) {
            parent = current;
            if (temp < 0) {
                lastStep = right;
                current = current.right;
            } else {
                lastStep = left;
                current = current.left;
            }
        }
        return lastStep;
    }

    public void print() {
        print(root, "");
    }

    public void print(Node<E> currentElement, String indent) {
        if (currentElement == null) {
            return;
        }
        print(currentElement.left, indent + "  ");
        System.out.println(indent + currentElement.value);
        print(currentElement.right, indent + "  ");
    }

    public E getRoot() {
        return root.value;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getCurrent() {
        return current;
    }

    public void setCurrent(Node<E> current) {
        this.current = current;
    }
 
    private static final class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
