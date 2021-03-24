package com.duxuewei.onjava.tree;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


/*class Node {

    private String name;
    private Integer id;
    private Integer parentId;
    private List<Node> children;

    // getter and setter
}*/

public class CreateTree {

    public static void main(String[] args) {
        //Create a List of nodes
        Node node1 = new Node("Five", 5, 4);
        Node node2 = new Node("Four", 4, 2);
        Node node3 = new Node("Two",  2, 1);
        Node node4 = new Node("Three", 3, 2);
        Node node5 = new Node("One",   1, null);
        // root as parentId is null

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        //convert to a tree
        CreateTree.createTree(nodes);
    }

    private static void createTree(List<Node> nodes) {
        System.err.println("开始");
        Map<Integer, Node> mapTmp = new HashMap<>(nodes.size());
        // put all node to map
        for (Node node : nodes) {
            mapTmp.put(node.getId(), node);
        }

        //loop and assign parent/child relationships
        for (Node node : nodes) {
            Integer parentId = node.getParentId();
            if (parentId == null) {
                continue;
            }
            Node parentNode = mapTmp.get(parentId);
            if (parentNode == null) {
                continue;
            }
            List<Node> children = parentNode.getChildren();
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(node);
            parentNode.setChildren(children);
            mapTmp.put(parentId, parentNode);
        }

        //extract root node
        List<Node> trees = new ArrayList<>();
        for (Node node :mapTmp.values()) {
            if (node.getParentId() == null) {
                trees.add(node);
            }
        }

        System.err.println(trees);
        System.err.println("结束");
    }

}
