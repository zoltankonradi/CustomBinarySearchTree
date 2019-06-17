package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException, NodeAlreadyExistsException, NoSuchNodeException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }

        BinarySearchTree myTree = BinarySearchTree.build(numbers);
        // write some test code here
        System.out.println("SEARCH: ");
        System.out.println("7 " + myTree.search(7)); // should be true
        System.out.println("55 " + myTree.search(55)); // should be true
        System.out.println("34535 " + myTree.search(34535)); // should be false

        System.out.println("ADD: ");
        myTree.add(34535);
        System.out.println("34535 " + myTree.search(34535));

        System.out.println("REMOVE: ");
        myTree.remove(7);
        System.out.println("7 " + myTree.search(7));

        System.out.println("done");
    }
}