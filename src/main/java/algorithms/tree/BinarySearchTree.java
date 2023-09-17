package algorithms.tree;

import java.util.Comparator;

public class BinarySearchTree<E> {
  static class Node<E> {
    E value;

    Node<E> left;
    Node<E> right;
    Node<E> parent;

    Node(E value) {
      this(value, null);
    }

    Node(E value, Node<E> parent) {
      this.value = value;
      this.parent = parent;
      this.right = null;
      this.left = null;
    }
  }

  private Node<E> root;
  private int size;

  private final Comparator<? super E> comparator;

  public BinarySearchTree() {
    this(null);
  }

  public BinarySearchTree(Comparator<? super E> comparator) {
    this.comparator = comparator;
    this.root = null;
    this.size = 0;
  }

  public boolean add(E value) {
    return addUsingComparable(value) == null;
  }

  private E addUsingComparable(E value) {
    Node<E> current = root;

    if (current == null) {
      root = new Node<E>(value);
      size++;
      return null;
    }

    Node<E> currentParent;

    @SuppressWarnings("unchecked")
    Comparable<? super E> compValue = (Comparable<? super E>) value;

    int compResult;

    do {
      currentParent = current;

      compResult = compValue.compareTo(current.value);

      if (compResult < 0) {
        current = current.left;
      } else if (compResult > 0) {
        current = current.right;
      } else {
         return value;
      }
    } while (current != null);

    Node<E> newNode = new Node<E>(value, currentParent);

    if (compResult < 0) {
      currentParent.left = newNode;
    } else {
      currentParent.right = newNode;
    }

    size++;
    return null;
  }

  private Node<E> getSuccessorAndUnlink(Node<E> node) {
    Node<E> currentParent = node;
    Node<E> current = node.right;

    if (current.left == null) {
      currentParent.right = current.right;
      if (currentParent.right != null) {
        currentParent.right.parent = currentParent;
      }
      current.right = null;
      return current;
    }

    while (current.left != null) {
      currentParent = current;
      current = current.left;
    }

    currentParent.left = current.right;
    if (currentParent.left != null) {
      currentParent.left.parent = currentParent;
    }
    current.right = null;
    return current;
  }

  private Node<E> deleteNode(Node<E> node) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        if (node == root) {
          root = null;
        } else {
          node = null;
        }
        return null;
      }

      if (node.left != null && node.right != null) {
        Node<E> replacement = getSuccessorAndUnlink(node);

        node.value = replacement.value;
      } else if (node.left != null) {
        if (node == root) {
          node = node.left;
          root = node;
          root.parent = null;
        } else {
          node = node.left;
        }
      } else {
        if (node == root) {
          node = node.right;
          root = node;
          root.parent = null;
        } else {
          node = node.right;
        }
      }

    }
    return node;
  }

  public E remove(Object o) {
     if (root == null) return null;

     return removeUsingComparable(o);
  }

  private E removeUsingComparable(Object value) {
    @SuppressWarnings("unchecked")
    E oldVal = (E) value;

    Node<E> parent = null, current = root;
    boolean hasLeft = false;

    if (root == null) {
      return null;
    }

    @SuppressWarnings("unchecked")
    Comparable<? super E> compValue = (Comparable<? super E>) value;

    do {
      int resComp = compValue.compareTo(current.value);

      if (resComp == 0) break;

      parent = current;
      if (resComp < 0) {
        hasLeft = true;
        current = current.left;
      } else {
        hasLeft = false;
        current = current.right;
      }
    } while (current != null);

    if (current == null) return null;

    if (parent == null) {
      deleteNode(current);
      size--;
      return oldVal;
    }

    if (hasLeft) {
      parent.left = deleteNode(current);
      if (parent.left != null) {
        parent.left.parent = parent;
      }
    } else {
      parent.right = deleteNode(current);
      if (parent.right != null) {
        parent.right.parent = parent;
      }
    }
    size--;
    return oldVal;
  }
}
