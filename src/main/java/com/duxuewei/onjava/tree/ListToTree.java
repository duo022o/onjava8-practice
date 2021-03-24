package com.duxuewei.onjava.tree;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Duxuewei
 * @apiNote list to tree
 * @version v1.0.0
 * @since 2021/1/20 20:43
 */
public class ListToTree {

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
        createTree(nodes);
    }

    private static void createTree(List<Node> nodes) {

        /// Map<Integer, SysMenuVo> mapTmp = new HashMap<>(nodes.size());
        // put all node to map
        final Map<Integer, Node> mapTmp = nodes.stream()
                .collect(Collectors.toMap(Node::getId, menu -> menu, (o, n) -> n));

        //loop and assign parent/child relationships
        nodes.stream().forEachOrdered(node->{
            Integer parentId = node.getParentId();
            if (Objects.isNull(parentId))
                return ;
            Node znode = mapTmp.get(parentId);
            if (Objects.isNull(znode))
                return ;
            List<Node> children = znode.getChildren();
            if (CollectionUtils.isEmpty(children))
                children = new ArrayList<>();
            children.add(node);
            znode.setChildren(children);
            mapTmp.put(parentId, znode);
        });

        //extract root node
        List<Node> trees = new ArrayList<>();
        for (Node node :mapTmp.values()) {
            if (Objects.equals(node.getParentId(),null)) {
                trees.add(node);
            }
        }

        System.err.println(JSONObject.toJSON(trees));
    }


}
