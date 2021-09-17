package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ListImpl implements List {
  private static class Node {
 
    Node prev;
    Object value;
    Node next;
 
    public Node(Node prev, Object value,
        Node next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
 
    public Node() {
    }
  }
 
  private Node first;
  private Node last;
  private int size;
 
  @Override
  public void clear() {
    size = 0;
 
    first = null;
    last = null;
 
  }
 
  @Override
  public int size() {
    return size;
  }
 
  public Iterator<Object> iterator() {
    return new IteratorImpl();
  }
 
  private class IteratorImpl implements Iterator<Object> {
 
    Node node = first;
 
    @Override
    public boolean hasNext() {
      return node != null;
    }
 
    @Override
    public Object next() {
      Object value = node.value;
      node = node.next;
      return value;
    }
 
  }
 
  @Override
  public void addFirst(Object element) {
    final Node f = first;
    final Node newNode = new Node(null, element, f);
 
    first = newNode;
 
    if (f == null) {
      last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }
 
  @Override
  public void addLast(Object element) {
    final Node l = last;
    final Node newNode = new Node(l, element, null);
 
    last = newNode;
 
    if (l == null) {
      first = newNode;
    } else {
      l.next = newNode;
    }
    size++;
  }
 
  @Override
  public void removeFirst() {
    if (first == null) {
      return;
    }
    first = first.next;
    first.prev = null;
    size--;
  }
 
  @Override
  public void removeLast() {
    if (last == null) {
      return;
    }
    last = last.prev;
    last.next = null;
    size--;
  }
 
  @Override
  public Object getFirst() {
    if (first == null) {
      return null;
    }
    return first.value;
  }
 
  @Override
  public Object getLast() {
    if (last == null) {
      return null;
    }
    return last.value;
  }
 
  @Override
  public Object search(Object element) {
    Node node = first;
    if (element == null) {
      while (node != null) {
        if (node.value == null) {
          return null;
        }
        node = node.next;
      }
    } else {
      while (node != null) {
        if (element.equals(node.value)) {
          return node.value;
        }
        node = node.next;
      }
    }
    return null;
  }
 
  private void unlink(Node node) {
    if (node.prev == null) {
      removeFirst();
    } else if (node.next == null) {
      removeLast();
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }
  }
 
  @Override
  public boolean remove(Object element) {
    Node node = first;
    if (element == null) {
      while (node != null) {
        if (node.value == null) {
          unlink(node);
          return true;
        }
        node = node.next;
      }
    } else {
      while (node != null) {
        if (element.equals(node.value)) {
          unlink(node);
          return true;
        }
        node = node.next;
      }
    }
 
    return false;
  }
 
  @Override
  public String toString() {
    Node node = first;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.value).append(" ");
      node = node.next;
    }
    return "[" + sb
        .toString()
        .trim()
        .replaceAll(" ", ", ") + "]";
  }
 
  public static void main(String[] args) {
 
    ListImpl list = new ListImpl();
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    System.out.println(list.search(null));
    list.addLast(null);
    list.addLast(null);
    list.addFirst(null);
    System.out.println(list.search("D"));
 
    for (Object o : list
    ) {
      System.out.println(o);
    }
    System.out.println(list);
    System.out.println(list.size());
    System.out.println(list.remove(null));
 
    System.out.println(list);
    System.out.println(list.size());
    System.out.println(list.remove(null));
    System.out.println(list);
 
    System.out.println(list.size());
    System.out.println(list.remove(null));
    System.out.println(list);
    System.out.println(list.size());
 
  }   
}
