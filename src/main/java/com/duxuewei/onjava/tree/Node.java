package com.duxuewei.onjava.tree;

import lombok.Data;

import java.util.List;

/**
 * @author Duxuewei
 * @apiNote 树节点数据
 * @version v1.0.0
 * @since 2021/1/20 20:43
 */
@Data
public class Node {

    private String name;
    private Integer id;
    private Integer parentId;
    private List<Node> children;

    public Node(String name,Integer id,Integer parentId) {
        this.name = name;
        this.id = id;
        this.parentId = parentId;
    }

}
