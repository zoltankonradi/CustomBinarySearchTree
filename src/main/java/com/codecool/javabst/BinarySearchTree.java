package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    private Node root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        if (elements.size() == 0) {
            return binarySearchTree;
        }
        Integer middleElement = elements.get((elements.size() / 2) + 1);
        binarySearchTree.root = new Node(middleElement);
        elements.remove(middleElement);
        createNodes(elements, binarySearchTree.root);
        return binarySearchTree;
    }

    private static void createNodes(List<Integer> elements, Node root) {
        for (Integer element : elements) {
            Node currentNode = root;
            while (true) {
                if (element <= currentNode.value) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(element);
                        break;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                } else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(element);
                        break;
                    } else {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }
    }

    public boolean search(Integer toFind) {
        if (this.root == null) return false;
        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value.equals(toFind)) {
                return true;
            } else {
                if (toFind < currentNode.value) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return false;
    }

    public void add(Integer toAdd) throws NodeAlreadyExistsException {
        if (this.root == null) throw new NullPointerException();
        Node currentNode = this.root;
        while (true) {
            if (currentNode.value.equals(toAdd)) {
                throw new NodeAlreadyExistsException();
            } else {
                if (toAdd < currentNode.value) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(toAdd);
                        break;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                } else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(toAdd);
                        break;
                    } else {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }
    }

    public void remove(Integer toRemove) throws NoSuchNodeException {
        if (this.root == null) throw new NullPointerException();
        Node childNode = this.root;
        Node parentNode = this.root;
        while (true) {
            if (childNode == null) {
                throw new NoSuchNodeException();
            }

            if (childNode.value.equals(toRemove)) {
                if (parentNode.leftChild == childNode) {
                    parentNode.leftChild = null;
                } else {
                    parentNode.rightChild = null;
                }
                break;
            } else {
                if (toRemove < childNode.value) {
                    parentNode = childNode;
                    childNode = childNode.leftChild;
                } else {
                    parentNode = childNode;
                    childNode = childNode.rightChild;
                }
            }
        }
    }
}