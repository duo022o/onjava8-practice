package com.duxuewei.onjava.json;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.duxuewei.onjava.tree.Node;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @apiNote 省市区json组装
 * @since 2021/1/23 13:33
 * @author Duxuewei
 * @version v1.0.0
 */
public class JsonToTree {

    public static void main(String[] args) {
        String provincej = JsonUtil.readJsonFile("E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\province.json");
        String cityj = JsonUtil.readJsonFile("E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\city.json");
        String areaj = JsonUtil.readJsonFile("E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\area.json");
        String townj = JsonUtil.readJsonFile("E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\town.json");

        List<JSONObject> provincelist =  (List<JSONObject>) JSONObject.parse(provincej);
        List<JSONObject> citylist =  (List<JSONObject>) JSONObject.parse(cityj);
        List<JSONObject> arealist =  (List<JSONObject>) JSONObject.parse(areaj);
        List<JSONObject> townlist =  (List<JSONObject>) JSONObject.parse(townj);

        List<TransCityEntity> list = new ArrayList<>();
        Map<String,TransCityEntity> map = new HashMap<>();

        provincelist.stream().forEachOrdered(province->{
            CityJsonEntity provinceobj= JSONObject.toJavaObject(province, CityJsonEntity.class);
            TransCityEntity returnobj = new TransCityEntity();
            BeanUtil.copyProperties(provinceobj,returnobj);
            returnobj.setN(provinceobj.getName());
            returnobj.setId(provinceobj.getCode());
            returnobj.setPid("0");
            // list.add(returnobj);
            map.put(returnobj.getProvince(),returnobj);
        });
        // System.err.println(list);

        citylist.stream().forEachOrdered(city->{
            CityJsonEntity cityobj= JSONObject.toJavaObject(city, CityJsonEntity.class);
            TransCityEntity returnobj = new TransCityEntity();
            BeanUtil.copyProperties(cityobj,returnobj);
            returnobj.setN(cityobj.getName());
            returnobj.setId(cityobj.getCode());

            List<TransCityEntity> listTemp = new ArrayList<>();
            TransCityEntity transCityEntity = map.get(returnobj.getProvince());
            returnobj.setPid(transCityEntity.getId());
            map.put(returnobj.getProvince()+returnobj.getCity(),returnobj);
        });

        arealist.stream().forEachOrdered(area->{
            CityJsonEntity areaobj= JSONObject.toJavaObject(area, CityJsonEntity.class);
            TransCityEntity returnobj = new TransCityEntity();
            BeanUtil.copyProperties(areaobj,returnobj);
            returnobj.setN(areaobj.getName());
            returnobj.setId(areaobj.getCode());

            TransCityEntity transCityEntity = map.get(returnobj.getProvince() + returnobj.getCity());

            if (returnobj.getProvince().equals("11")) {
                returnobj.setPid("110000");
            } else
            if (returnobj.getProvince().equals("31")) {
                returnobj.setPid("310000");
            } else
            if (returnobj.getProvince().equals("12")) {
                returnobj.setPid("120000");
            } else
            if (returnobj.getProvince().equals("50")) {
                returnobj.setPid("500000");
            } else {
                if (transCityEntity == null) {
                    System.err.println(returnobj);
                    TransCityEntity transCityEntity1 = map.get(returnobj.getProvince());
                    returnobj.setPid(transCityEntity1.getId());
                } else {
                    returnobj.setPid(transCityEntity.getId());
                }
            }
            String key = returnobj.getProvince() + returnobj.getCity() + returnobj.getArea();

            map.put(key,returnobj);

        });

        townlist.stream().forEachOrdered(town->{
            CityJsonEntity townobj= JSONObject.toJavaObject(town, CityJsonEntity.class);
            TransCityEntity returnobj = new TransCityEntity();
            BeanUtil.copyProperties(townobj,returnobj);
            returnobj.setN(townobj.getName());
            returnobj.setId(townobj.getCode());


            TransCityEntity transCityEntity = map.get(returnobj.getProvince() + returnobj.getCity() + returnobj.getArea());
            returnobj.setPid(transCityEntity.getId());
            String key = returnobj.getProvince() + returnobj.getCity() + returnobj.getArea()+returnobj.getTown();
            map.put(key, returnobj);
        });

        System.err.println("_______________________分割线________________________");
        System.err.println(map.values());
        Collection<TransCityEntity> values = map.values();
        List<TransCityEntity> values2 = new ArrayList<>(values);

        List<Entity2> values3 = new ArrayList<>();
        values2.stream().forEachOrdered(e->{
            Entity2 entity2 = new Entity2();
            BeanUtil.copyProperties(e,entity2);
            values3.add(entity2);
        });
        JsonUtil.writeJsonfile(JSONObject.toJSON(values3).toString(),"E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\data3.json");
        //createTree(values3);
    }

    private static void createTree(List<Entity2> nodes) {

        /// Map<Integer, SysMenuVo> mapTmp = new HashMap<>(nodes.size());
        // put all node to map
        final Map<String, Entity2> mapTmp = nodes.stream()
                .collect(Collectors.toMap(Entity2::getId, menu -> menu, (o, n) -> n));

        //loop and assign parent/child relationships
        nodes.stream().forEachOrdered(node->{
            String parentId = node.getPid();
            if (Objects.isNull(parentId))
                return ;

            Entity2 znode = mapTmp.get(parentId);
            if (Objects.isNull(znode))
                return ;

            List<Entity2> children = znode.getS();
            if (CollectionUtils.isEmpty(children))
                children = new ArrayList<>();
            children.add(node);
            znode.setS(children);
            mapTmp.put(parentId, znode);
        });

        //extract root node
        List<Entity2> trees = new ArrayList<>();
        for (Entity2 node :mapTmp.values()) {
            if (Objects.equals(node.getPid(),"0")) {
                trees.add(node);
            }
        }

        System.err.println("_______________________分割线________________________");
        System.err.println(JSONObject.toJSON(trees));
        JsonUtil.writeJsonfile(JSONObject.toJSON(trees).toString(),"E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\json\\data2.json");
    }


}
