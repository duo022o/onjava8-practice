package com.duxuewei.onjava.collection;

import com.duxuewei.onjava.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class ListModMemory {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Node node = new Node("张三",1,1);
        /// for (int i = 0; i < 10; i++) {
        ///     nodes.add(node);
        /// }
        nodes.add(node);
        System.err.println(nodes.size());
        System.err.println(nodes);
        node.setName("王五");
        System.err.println(nodes);
    }

}
