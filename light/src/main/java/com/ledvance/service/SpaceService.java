package com.ledvance.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class SpaceService {
    public String space(String space){
        JSONObject jsonAll = JSONObject.parseObject(space, Feature.OrderedField);
        String layers = jsonAll.getString("layers");
        JSONObject layer = JSONObject.parseObject(layers, Feature.OrderedField);
        //获取grids的参数
        String GridsString = jsonAll.getString("grids");
        JSONObject jsonGrids = JSONObject.parseObject(GridsString, Feature.OrderedField);
        //获取selectedLayer参数
        String selectedLayer = jsonAll.getString("selectedLayer");

        //获取guides参数
        String guides = jsonAll.getString("guides");
        JSONObject jsonGuides = JSONObject.parseObject(guides, Feature.OrderedField);
        //获取width参数
        String width = jsonAll.getString("width");
        //获取height
        String height=jsonAll.getString("height");

        //获取layer-1的参数
        String layersOne = layer.getString("layer-1");
        JSONObject jsonLayersOne = JSONObject.parseObject(layersOne,Feature.OrderedField);
        //获取layer-1下的key-value
        Object id =   jsonLayersOne.getString("id");
        String altitude =   jsonLayersOne.getString("altitude");
        String order =   jsonLayersOne.getString("order");
        String opacity =   jsonLayersOne.getString("opacity");
        Object name =   jsonLayersOne.getString("name");
        String visible =   jsonLayersOne.getString("visible");

        String selected =   jsonLayersOne.getString("selected");
        JSONObject JsonSelected = JSONObject.parseObject(selected, Feature.OrderedField);
        String lines =   jsonLayersOne.getString("lines");
        JSONObject JsonLines = JSONObject.parseObject(lines, Feature.OrderedField);

        //    Object holes =   jsonLayersOne.getString("holes");
        String items =   jsonLayersOne.getString("items");
        JSONObject JsonItems = JSONObject.parseObject(items, Feature.OrderedField);

        String vertices =   jsonLayersOne.getString("vertices");

        //重新装入到JsonVertices中
        JSONObject JsonVertices = JSONObject.parseObject(vertices, Feature.OrderedField);
        jsonLayersOne.put("id",id);
        jsonLayersOne.put("altitude",Integer.valueOf(altitude));
        jsonLayersOne.put("order",Integer.valueOf(order));
        jsonLayersOne.put("opacity",Integer.valueOf(opacity));
        jsonLayersOne.put("name",name);
        jsonLayersOne.put("visible",Boolean.valueOf(visible));
        jsonLayersOne.put("selected",JsonSelected);
        jsonLayersOne.put("lines",JsonLines);
        Map mapNull=new HashMap();

        jsonLayersOne.put("holes",mapNull);
        //  jsonLayersOne.put("items",JsonItems);
        jsonLayersOne.put("vertices",JsonVertices);
        JSONObject jsonVertice= JSONObject.parseObject(vertices, Feature.OrderedField);

        Map<String, Object> layerMap = new HashMap<>();

        //循环转换，获取"layer-1"的vertices坐标
        for (Map.Entry<String, Object> entry : jsonVertice.entrySet()) {
            layerMap.put(entry.getKey(), entry.getValue());
        }

        String areas =  jsonLayersOne.getString("areas");
        JSONObject jsonAreas= JSONObject.parseObject(areas,Feature.OrderedField);

        //获取区域的k-v
        Map<String, Object> areasMap = new TreeMap<>();

        int a=1;
        int b=999;

        //循环转换
        for (Map.Entry<String, Object> entry : jsonAreas.entrySet()) {
            areasMap.put(entry.getKey(), entry.getValue());
        }


        Map arithmeticMap=new HashMap<>();

        List roomsList=new ArrayList();

        //暂时为空List
        List listNull=new ArrayList();
        //添加墙的list
        List  wallsList=new ArrayList<>();

        //添加空间
        JSONObject jsonObjectAreas = new JSONObject();


        for(String obj:areasMap.keySet()){
            int c=1;
            Map<String,Object> m=new HashMap<>();

            List<Map<String,Object>> portfolioAllList=new ArrayList();

            Map<String,Object> lightPriceMap=new HashMap<>();

            m.put("furnitures",listNull);
            m.put("doorOrWindows",listNull);


            Map portfolioMap=new HashMap();

            List<Map<String,Double>> pointsList=new ArrayList();
            String areasString = jsonAreas.getString(obj);
            JSONObject jsonVertices = JSONObject.parseObject(areasString, Feature.OrderedField);
            //获得空间有哪些坐标
            String verticesString = jsonVertices.getString("vertices");
            //获取需要的参数
            String properties = jsonVertices.getString("properties");
            JSONObject blend = JSONObject.parseObject(properties, Feature.OrderedField);
            //面积
            JSONObject areaJson = JSONObject.parseObject(blend.getString("area"), Feature.OrderedField);
            String area  = areaJson.getString("length");
            System.out.println("area:"+area);
            //     m.put("area",Double.valueOf(area)*1000);
            m.put("area",504832);

    //            //获取家具长度
    //            JSONObject furnitureDepth = JSONObject.parseObject(blend.getString("depth"), Feature.OrderedField);
    //            String furnitureDepthLength = furnitureDepth.getString("length");
    //
    //            //获取家具宽度
    //            JSONObject width = JSONObject.parseObject(blend.getString("width"), Feature.OrderedField);
    //            String furnitureDepthWidth = width.getString("length");
    //
    //            //获取家具高度
    //            JSONObject height = JSONObject.parseObject(blend.getString("height"), Feature.OrderedField);
    //            String furnitureHeight  = height.getString("length");

            //天花板
            JSONObject ceilingTypeJson = JSONObject.parseObject(blend.getString("ceilingType"), Feature.OrderedField);

            String ceilingType  = ceilingTypeJson.getString("length");
            m.put("ceilingType","网格天花300x300");

            //类型
            m.put("type",++b);

    //                //门或者窗户
    //            JSONObject doorOrWindowsJson = JSONObject.parseObject(blend.getString("doorOrWindows"), Feature.OrderedField);
    //
    //            System.out.println(doorOrWindowsJson);
    //            List<Map<String,String>> listObjectFir = (List<Map<String,String>>) JSONArray.parse(String.valueOf(doorOrWindowsJson));
    //            for(Map<String,String> mapList : listObjectFir){
    //                for (Map.Entry entry : mapList.entrySet()){
    //                    Object value = entry.getValue();
    //
    //                }
    //            }


            //照明度
            JSONObject  illuminanceJson = JSONObject.parseObject(blend.getString("illuminance"), Feature.OrderedField);
            String illuminance  = illuminanceJson.getString("length");
            System.out.println("illuminance"+illuminance);
            //          m.put("illuminance",Integer.valueOf(illuminance));
            m.put("illuminance",500);
            List lightList=new ArrayList();
            //灯具价格
            lightPriceMap.put("price",Double.valueOf(1));
            lightPriceMap.put("type","04.04.90.001.0931");
            lightList.add(lightPriceMap);
            m.put("portfolio",lightList);
            //一直是false
            m.put("haschild",false);
            //是否锁定
            m.put("isLocked",false);

            //维护系数
            JSONObject lightLossFactorJson = JSONObject.parseObject(blend.getString("lightLossFactor"), Feature.OrderedField);
            System.out.println("lightLossFactorJson"+lightLossFactorJson);
            String lightLossFactor  = lightLossFactorJson.getString("length");

            //    m.put("lightLossFactor",Float.valueOf(lightLossFactor));
            m.put("lightLossFactor",Float.valueOf(0.8f));
            //id从1开始
            m.put("id", String.valueOf(a++));

            //一直fales
            m.put("hasParent",false);
            m.put( "height",300);

            //灯具所有价格为空
            portfolioMap.put("price","");
            portfolioMap.put("type","");
            portfolioAllList.add(portfolioMap);
            m.put("portfolio_all",portfolioAllList);

            String substring = verticesString.substring(1, verticesString.length());
            String substring1 = substring.substring(0, substring.length() - 1);
            String str[] = substring1.split(",");

            List<String> strings = Arrays.asList(str);
            Map<String,Double> wallMap = new HashMap();

            List pointList=new ArrayList();

            String vertice = jsonVertices.getString("vertices");
            String sub = vertice.substring(1,vertice.length()-1);
            String demoArray[] = sub.split(",");
            List list=new ArrayList();
            for(String ss:demoArray){
                String removeStr = "\"";
                String replace = ss.replace(removeStr, "");
                list.add(replace);

            }

            //     String holes1 = jsonVertices.getString("holes");


            for (String s1:strings) {

                String s2 = s1.replace ("\"", "");
                String jsonObject7 = jsonVertice.getString (s2);
                JSONObject jsonObject8 = JSONObject.parseObject (jsonObject7);


                for (String obj1 : layerMap.keySet ()) {
                    if (s2.equals (obj1)) {
                        Map<String, Double> pointsMap = new HashMap ();
                        JSONObject jSonPoints = new JSONObject();

                        String x = String.format("%.1f", Double.valueOf(jsonObject8.getString("x")));
                        String y = String.format("%.1f", Double.valueOf(jsonObject8.getString("y")));
                        pointsMap.put ("x",Double.valueOf(x));
                        pointsMap.put ("y",Double.valueOf(y));
                        jSonPoints.put("x",Double.valueOf(x));
                        jSonPoints.put("y",Double.valueOf(y));
                        pointsList.add (pointsMap);
                        pointList.add(jSonPoints);
                    }

                }
                Map<String, Double>  wallsMap= new HashMap ();

                String x = String.format("%.2f", Double.valueOf(jsonObject8.getString("x")));
                String y = String.format("%.2f", Double.valueOf(jsonObject8.getString("y")));
                wallMap.put ("XStart", Double.valueOf(x));
                wallMap.put ("XEnd", Double.valueOf(y));
                String mxs = String.format("%.2f", Double.valueOf( wallMap.get("XStart")));
                String mxe = String.format("%.2f", Double.valueOf(wallMap.get("XEnd")));

                String mys = String.format("%.2f", Double.valueOf( wallMap.get("XStart")));
                String mye = String.format("%.2f", Double.valueOf(wallMap.get("XEnd")));

                if (c==1) {

                }else if (c == 2) {
                    wallsMap.put ("XStart",  Double.valueOf (mxs));
                    wallsMap.put ("XEnd",  Double.valueOf (mxe));
                    wallsMap.put ("YStart", Double.valueOf (x));
                    wallsMap.put ("YEnd", Double.valueOf (y));

                    wallMap.put ("YStart", Double.valueOf (x));
                    wallMap.put  ("YEnd", Double.valueOf (y));
                    wallsList.add (wallsMap);
                } else  {
                    wallsMap.put ("XStart",  Double.valueOf (mys));
                    wallsMap.put ("XEnd",   Double.valueOf (mye));
                    wallsMap.put ("YStart", Double.valueOf (x));
                    wallsMap.put ("YEnd", Double.valueOf (y));

                    if (c==strings.size ()) {
                        wallMap.put ("YStart", Double.valueOf (mxs));
                        wallMap.put ("YEnd", Double.valueOf (mxe));
                        wallMap.put ("XStart",  Double.valueOf (x));
                        wallMap.put ("XEnd",  Double.valueOf (y));
                    }
                    wallsList.add (wallsMap);
                }
                c++;
            }
            wallsList.add (wallMap);
            m.put("points",pointsList);
            roomsList.add(m);

        }

        arithmeticMap.put("rooms",roomsList);
        arithmeticMap.put("walls",wallsList);

        JSONObject json = new JSONObject(arithmeticMap);


        String ver =   jsonLayersOne.getString("vertices");



        //      String s="{\"rooms\":[{\"area\":82320.0,\"furnitures\":[{\"depth\":100.0,\"width\":100.0,\"x\":348.0,\"y\":408.0,\"height\":100.0},{\"depth\":14.500751,\"width\":91.5,\"x\":532.24994,\"y\":417.75,\"height\":208.5},{\"depth\":45.5,\"width\":45.5,\"x\":468.75,\"y\":504.75,\"height\":98.4}],\"ceilingType\":\"网格天花300x300\",\"type\":1001,\"doorOrWindows\":[{\"depth\":14.500751,\"width\":91.5,\"x\":532.24994,\"y\":417.75,\"height\":208.5}],\"points\":[{\"x\":232.0,\"y\":294.0},{\"x\":526.0,\"y\":294.0},{\"x\":526.0,\"y\":574.0},{\"x\":232.0,\"y\":574.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"1\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":1040704.0,\"furnitures\":[],\"ceilingType\":\"网格天花300x300\",\"type\":1002,\"doorOrWindows\":[],\"points\":[{\"x\":1100.0,\"y\":282.0},{\"x\":2514.0,\"y\":282.0},{\"x\":2514.0,\"y\":1018.0},{\"x\":1100.0,\"y\":1018.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"2\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]}],\"walls\":[{\"XStart\":228.25,\"XEnd\":529.75,\"YEnd\":290.25,\"YStart\":290.25},{\"XStart\":529.75,\"XEnd\":529.75,\"YEnd\":577.75,\"YStart\":290.25},{\"XStart\":529.75,\"XEnd\":228.25,\"YEnd\":577.75,\"YStart\":577.75},{\"XStart\":228.25,\"XEnd\":228.25,\"YEnd\":290.25,\"YStart\":577.75},{\"XStart\":1096.25,\"XEnd\":2517.75,\"YEnd\":278.25,\"YStart\":278.25},{\"XStart\":2517.75,\"XEnd\":2517.75,\"YEnd\":1021.75,\"YStart\":278.25},{\"XStart\":2517.75,\"XEnd\":1096.25,\"YEnd\":1021.75,\"YStart\":1021.75},{\"XStart\":1096.25,\"XEnd\":1096.25,\"YEnd\":278.25,\"YStart\":1021.75}]}";
        //           String ss="{\"rooms\":[{\"area\":90000.0,\"furnitures\":[],\"ceilingType\":\"20\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":298.0,\"y\":1200.0},{\"x\":899.0,\"y\":1200.0},{\"x\":899.0,\"y\":1400.0},{\"x\":298.0,\"y\":1400.0}],\"illuminance\":\"80\",\"portfolio\":[{\"price\":1,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"id\":1,\"hasParent\":false,\"height\":300,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":60000.0,\"furnitures\":[],\"ceilingType\":\"262\",\"type\":1001,\"doorOrWindows\":[],\"points\":[{\"x\":298.0,\"y\":1900.0},{\"x\":298.0,\"y\":1503.0},{\"x\":899.0,\"y\":1503.0},{\"x\":899.0,\"y\":1900.0}],\"illuminance\":\"262\",\"portfolio\":[{\"price\":1,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"id\":2,\"hasParent\":false,\"height\":300,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]}],\"walls\":[{\"XStart\":899.0,\"XEnd\":1200.0,\"YEnd\":1200.0,\"YStart\":899.0},{\"XStart\":899.0,\"XEnd\":1400.0,\"YEnd\":1400.0,\"YStart\":899.0},{\"XStart\":298.0,\"XEnd\":1400.0,\"YEnd\":1400.0,\"YStart\":298.0},{\"XStart\":298.0,\"XEnd\":1400.0,\"YEnd\":1400.0,\"YStart\":298.0},{\"XStart\":298.0,\"XEnd\":1503.0,\"YEnd\":1503.0,\"YStart\":298.0},{\"XStart\":899.0,\"XEnd\":1503.0,\"YEnd\":1503.0,\"YStart\":899.0},{\"XStart\":899.0,\"XEnd\":1900.0,\"YEnd\":1900.0,\"YStart\":899.0},{\"XStart\":899.0,\"XEnd\":1900.0,\"YEnd\":1900.0,\"YStart\":899.0}]}";
    //        String s = readJsonFile("C:\\Users\\M.xiao-ext\\AppData\\Local\\Programs\\Light&Space\\rule\\executionParameter.txt");
        String ss="{\"rooms\":[{\"area\":504832.0,\"furnitures\":[],\"ceilingType\":\"网格天花300x300\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":824.0,\"y\":480.0},{\"x\":1752.0,\"y\":480.0},{\"x\":1752.0,\"y\":1024.0},{\"x\":824.0,\"y\":1024.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"1\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":24780.0,\"furnitures\":[],\"ceilingType\":\"吊顶\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":826.0,\"y\":1136.0},{\"x\":1036.0,\"y\":1136.0},{\"x\":1036.0,\"y\":1254.0},{\"x\":826.0,\"y\":1254.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"2\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]}],\"walls\":[{\"XStart\":820.25,\"XEnd\":1755.75,\"YEnd\":476.25,\"YStart\":476.25},{\"XStart\":1755.75,\"XEnd\":1755.75,\"YEnd\":1027.75,\"YStart\":476.25},{\"XStart\":1755.75,\"XEnd\":820.25,\"YEnd\":1027.75,\"YStart\":1027.75},{\"XStart\":820.25,\"XEnd\":820.25,\"YEnd\":476.25,\"YStart\":1027.75},{\"XStart\":822.25,\"XEnd\":1039.75,\"YEnd\":1132.25,\"YStart\":1132.25},{\"XStart\":1039.75,\"XEnd\":1039.75,\"YEnd\":1257.75,\"YStart\":1132.25},{\"XStart\":1039.75,\"XEnd\":822.25,\"YEnd\":1257.75,\"YStart\":1257.75},{\"XStart\":822.25,\"XEnd\":822.25,\"YEnd\":1132.25,\"YStart\":1257.75}]}";

        String s1 = execAutoArrayLampsAlgorithm(json.toString());
        String s2 = execAutoArrayLampsAlgorithm(ss);


        JSONArray jsons = JSONArray.parseArray(s1);
        JSONObject jsonOne = null;
        System.out.println("json.size()=" + json.size());

        int i=0;
        Map mapItems=new HashMap();
        for(String obj:areasMap.keySet()){
            Map map=new HashMap();
            jsonOne = jsons.getJSONObject(i);
            i++;
            System.out.println("jsonOne=" + jsonOne);
            String schemes = jsonOne.getString("schemes");
            System.out.println("schemes"+schemes);
            JSONArray jsonArraySchemes = JSONArray.parseArray(schemes);
            JSONObject jsonSchemes = null;
            for (int f = 0;f<1;f++){
                System.out.println("json2"+jsonArraySchemes.size());

                jsonSchemes = jsonArraySchemes.getJSONObject(f);
                String x = jsonSchemes.getString("lumps");
                JSONArray xArray = JSONArray.parseArray(x);
                List list=new ArrayList();
                JSONObject blendJson = null;

                for (int g=0;xArray.size()>g;g++){
                    Map mapN=new HashMap();
                    Map blendMap=new HashMap();
                    blendJson = xArray.getJSONObject(g);
                    String angle = blendJson.getString("angle");
                    String price = blendJson.getString("price");
                    String type = blendJson.getString("type");
                    String lightX = blendJson.getString("x");
                    String lightY = blendJson.getString("y");
                    String lightZ = blendJson.getString("z");
                    UUID idOne = UUID.randomUUID();
                    blendMap.put("id",idOne);
                    blendMap.put("type",type);
                    blendMap.put("prototype","items");
                    blendMap.put("name",type);
                    blendMap.put("misc",mapN);
                    blendMap.put("selected",Boolean.valueOf(false));

                    Map mapPro=new HashMap();

                    Map mapAltitude=new HashMap();

                    mapAltitude.put("length",0);
                    mapAltitude.put("unit","cm");
                    mapPro.put("altitude",mapAltitude);
                    mapPro.put("seat",1);
                    mapPro.put("flip",Boolean.valueOf(false));
                    blendMap.put("properties",Boolean.valueOf(false));

                    blendMap.put("visible",Boolean.valueOf(true));
                    blendMap.put("x",Double.valueOf(lightX));
                    blendMap.put("y",Double.valueOf(lightY));
                    blendMap.put("z",Double.valueOf(lightZ));
                    blendMap.put("rotation",0);
                    blendMap.put("angle",angle);
                    blendMap.put("price",price);
                    blendMap.put("depth",50);
                    blendMap.put("width",50);
                    blendMap.put("height",50);
                    blendMap.put("_unit","cm");
                    mapItems.put(idOne,blendMap);
                    list.add(blendMap);

                }

            }
            jsonObjectAreas.put(obj,map);

            jsonLayersOne.put("items",mapItems);

            Map<String,Object> m=new HashMap<>();

            List<Map<String,Object>> portfolioAllList=new ArrayList();

            Map<String,Object> lightPriceMap=new HashMap<>();
            List<Map<String,Object>> lightPriceList=new ArrayList();
    //            //添加空间面积，暂时自定义
    //            m.put("area",222222);
    //
    //            //添加家具，暂时自定义
            m.put("furnitures",listNull);
    //
    //            //添加天花板,暂时自定义
    //            m.put("ceilingType","网格天花300x300");
    //
    //            m.put("type",b++);
    //
    //            //窗户或者门
            m.put("doorOrWindows",listNull);


            Map portfolioMap=new HashMap();


            List<Map<String,Double>> pointsList=new ArrayList();

            String string = jsonAreas.getString(obj);

            JSONObject jsonVertices = JSONObject.parseObject(string, Feature.OrderedField);
            //获得空间有哪些坐标
            String vertices1 = jsonVertices.getString("vertices");
            //获取需要的参数
            String properties = jsonVertices.getString("properties");

            JSONObject blend = JSONObject.parseObject(properties, Feature.OrderedField);

            //面积
            JSONObject areaJson = JSONObject.parseObject(blend.getString("area"), Feature.OrderedField);
            String area  = areaJson.getString("length");
            System.out.println("area:"+area);
            m.put("area",Double.valueOf(area)*1000);


            //天花板
            JSONObject ceilingTypeJson = JSONObject.parseObject(blend.getString("ceilingType"), Feature.OrderedField);

            String ceilingType  = ceilingTypeJson.getString("length");
            m.put("ceilingType",ceilingType);

            //类型
            m.put("type",b++);


            //照明度
            JSONObject  illuminanceJson = JSONObject.parseObject(blend.getString("illuminance"), Feature.OrderedField);
            String illuminance  = illuminanceJson.getString("length");
            m.put("illuminance",Integer.valueOf(illuminance));

            //灯具价格
            lightPriceMap.put("price",1);
            lightPriceMap.put("type","04.04.90.001.0931");
            lightPriceList.add(lightPriceMap);
            m.put("portfolio",lightPriceList);

            //一直是false
            m.put("haschild",false);

            //是否锁定
            m.put("isLocked",false);

            //维护系数
            JSONObject lightLossFactorJson = JSONObject.parseObject(blend.getString("lightLossFactor"), Feature.OrderedField);
            String lightLossFactor  = lightLossFactorJson.getString("length");
            m.put("illuminance",Integer.valueOf(lightLossFactor));

            //id从1开始
            m.put("id",a++);

            //一直fales
            m.put("hasParent",false);
            m.put( "height",300);

            //灯具所有价格为空
            portfolioMap.put("price","");
            portfolioMap.put("type","");portfolioAllList.add(portfolioMap);
            m.put("portfolio_all",portfolioAllList);

            String substring = vertices1.substring(1, vertices1.length());
            String substring1 = substring.substring(0, substring.length() - 1);
            String str[] = substring1.split(",");

            List<String> strings = Arrays.asList(str);
            Map<String,Double> wallMap = new HashMap();

            List pointList=new ArrayList();

            String idString = jsonVertices.getString("id");
            map.put("id",idString);
            String type = jsonVertices.getString("type");
            map.put("type",type);
            String prototype = jsonVertices.getString("prototype");
            map.put("prototype",prototype);
            String name1 = jsonVertices.getString("name");
            map.put("name",name1);
            String JsonMisc = jsonVertices.getString("misc");

            map.put("misc",JSONObject.parseObject(JsonMisc, Feature.OrderedField));
            String selected1 = jsonVertices.getString("selected");
            map.put("selected",Boolean.valueOf(selected1));
            String propertiesString = jsonVertices.getString("properties");
            JSONObject jsonProperties = JSONObject.parseObject(propertiesString, Feature.OrderedField);
            map.put("properties",jsonProperties);
            String visible1 = jsonVertices.getString("visible");
            map.put("visible",Boolean.valueOf(visible1));
            String verticesString = jsonVertices.getString("vertices");

            String sub = verticesString.substring(1,verticesString.length()-1);
            String Array[] = sub.split(",");
            List list=new ArrayList();
            for(String arrayVertices:Array){
                String removeStr = "\"";
                String replace = arrayVertices.replace(removeStr, "");
                list.add(replace);

            }

            map.put("vertices",  list);
            //      String holes1 = jsonVertices.getString("holes");

            map.put("holes",listNull);
            for (String stringS:strings) {
                String sOne = stringS.replace ("\"", "");
                String jsonObject7 = jsonVertice.getString (sOne);
                JSONObject jsonObject8 = JSONObject.parseObject (jsonObject7);
                for (String obj1 : layerMap.keySet ()) {
                    if (sOne.equals (obj1)) {
                        Map<String, Double> pointsMap = new HashMap ();
                        JSONObject jSonPoints = new JSONObject();
                        String x = String.format("%.1f", Double.valueOf(jsonObject8.getString("x")));
                        String y = String.format("%.1f", Double.valueOf(jsonObject8.getString("y")));
                        pointsMap.put ("x",Double.valueOf(x));
                        pointsMap.put ("y",Double.valueOf(y));
                        jSonPoints.put("x",Double.valueOf(x));
                        jSonPoints.put("y",Double.valueOf(y));
                        pointsList.add (pointsMap);
                        pointList.add(jSonPoints);
                    }
                }
            }
            wallsList.add (wallMap);
            map.put("points",pointList);
            jsonObjectAreas.put(obj,map);
            roomsList.add(m);
        }

        jsonLayersOne.put("areas",jsonObjectAreas);

        layer.put("layer-1",  jsonLayersOne);


        jsonAll.put("unit","cm");
        jsonAll.put("layers",layer);
        jsonAll.put("grids",jsonGrids);
        jsonAll.put("selectedLayer",selectedLayer);
        Map groupsMap=new HashMap();
        jsonAll.put("groups",groupsMap);
        jsonAll.put("width",Integer.valueOf(width));
        jsonAll.put("height",Integer.valueOf(height));
        Map metaMap=new HashMap();
        jsonAll.put("meta",metaMap);
    //        Map guidesMap =new HashMap();
    //
    //        guidesMap.put("horizontal",mapNull);
    //        guidesMap.put("vertical",mapNull);
    //        guidesMap.put("circular",mapNull);
        jsonAll.put("guides",jsonGuides);


        return jsonAll.toString();
    }
        public static   String  execAutoArrayLampsAlgorithm(String s)  {
            String directory="C:\\Users\\M.xiao-ext\\AppData\\Local\\Programs\\Light&Space\\rule\\";

            //  String s = readJsonFile("C:\\Users\\M.xiao-ext\\Desktop\\a.txt");
            //String s="{\"rooms\":[{\"area\":937040.0,\"furnitures\":[{\"depth\":100.0,\"width\":100.0,\"x\":236.55281,\"y\":288.0,\"height\":100.0},{\"depth\":52.8,\"width\":66.0,\"x\":969.5528,\"y\":294.4,\"height\":64.4}],\"ceilingType\":\"网格天花300x300\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":60.0,\"y\":76.0},{\"x\":1120.0,\"y\":76.0},{\"x\":1120.0,\"y\":960.0},{\"x\":60.0,\"y\":960.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":true,\"lightLossFactor\":0.8,\"id\":\"1\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":1022400.0,\"furnitures\":[{\"depth\":200.0,\"width\":480.0,\"x\":2014.5529,\"y\":592.0,\"height\":72.1}],\"ceilingType\":\"网格天花300x300\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":1340.0,\"y\":100.0},{\"x\":2618.0,\"y\":100.0},{\"x\":2618.0,\"y\":900.0},{\"x\":1340.0,\"y\":900.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":true,\"lightLossFactor\":0.8,\"id\":\"2\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":268052.0,\"furnitures\":[],\"ceilingType\":\"网格天花300x300\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":1250.0,\"y\":1104.0},{\"x\":14.07,\"y\":1321.93},{\"x\":2474.07,\"y\":1321.93}],\"illuminance\":500,\"portfolio\":[{\"price\":1.0,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"3\",\"hasParent\":false,\"height\":300.0,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]}],\"walls\":[{\"XStart\":56.25,\"XEnd\":1123.75,\"YEnd\":72.25,\"YStart\":72.25},{\"XStart\":1123.75,\"XEnd\":1123.75,\"YEnd\":963.75,\"YStart\":72.25},{\"XStart\":1123.75,\"XEnd\":56.25,\"YEnd\":963.75,\"YStart\":963.75},{\"XStart\":56.25,\"XEnd\":56.25,\"YEnd\":72.25,\"YStart\":963.75},{\"XStart\":1336.25,\"XEnd\":2621.75,\"YEnd\":96.25,\"YStart\":96.25},{\"XStart\":2621.75,\"XEnd\":2621.75,\"YEnd\":903.75,\"YStart\":96.25},{\"XStart\":2621.75,\"XEnd\":1336.25,\"YEnd\":903.75,\"YStart\":903.75},{\"XStart\":1336.25,\"XEnd\":1336.25,\"YEnd\":96.25,\"YStart\":903.75},{\"XStart\":2516.5234,\"XEnd\":-28.796015,\"YEnd\":1325.6785,\"YStart\":1325.6785},{\"XStart\":-28.796015,\"XEnd\":1250.0032,\"YEnd\":1100.1917,\"YStart\":1325.6785},{\"XStart\":1250.0032,\"XEnd\":2516.5234,\"YEnd\":1325.6785,\"YStart\":1100.1917}]}";
            //String s="{\"rooms\":[{\"area\":222222,\"furnitures\":[],\"ceilingType\":\"网格天花300x300\",\"type\":1000,\"doorOrWindows\":[],\"points\":[{\"x\":698.6,\"y\":1202.0},{\"x\":698.6,\"y\":507.3},{\"x\":1903.0,\"y\":501.1},{\"x\":1896.9,\"y\":1202.0}],\"illuminance\":500,\"portfolio\":[{\"price\":1,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"1\",\"hasParent\":false,\"height\":300,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]},{\"area\":222222,\"furnitures\":[],\"ceilingType\":\"网格天花300x300\",\"type\":1001,\"doorOrWindows\":[],\"points\":[{\"x\":601.4,\"y\":1903.5},{\"x\":601.4,\"y\":1303.8},{\"x\":1400.5,\"y\":1303.8},{\"x\":1400.5,\"y\":1903.5}],\"illuminance\":500,\"portfolio\":[{\"price\":1,\"type\":\"04.04.90.001.0931\"}],\"haschild\":false,\"isLocked\":false,\"lightLossFactor\":0.8,\"id\":\"2\",\"hasParent\":false,\"height\":300,\"portfolio_all\":[{\"price\":\"\",\"type\":\"\"}]}],\"walls\":[{\"XStart\":698.59,\"XEnd\":507.3,\"YEnd\":507.3,\"YStart\":698.59},{\"XStart\":1903.03,\"XEnd\":501.13,\"YEnd\":501.13,\"YStart\":1903.03},{\"XStart\":1896.86,\"XEnd\":1202.01,\"YEnd\":1202.01,\"YStart\":1896.86},{\"XStart\":1896.86,\"XEnd\":1202.01,\"YEnd\":1202.01,\"YStart\":1896.86},{\"XStart\":601.37,\"XEnd\":1303.8,\"YEnd\":1303.8,\"YStart\":601.37},{\"XStart\":1400.52,\"XEnd\":1303.8,\"YEnd\":1303.8,\"YStart\":1400.52},{\"XStart\":1400.52,\"XEnd\":1903.48,\"YEnd\":1903.48,\"YStart\":1400.52},{\"XStart\":1400.52,\"XEnd\":1903.48,\"YEnd\":1903.48,\"YStart\":1400.52}]}";
            String fileName = "executionParameter.txt";
            File fullFileName = new File("C:\\Users\\M.xiao-ext\\AppData\\Local\\Programs\\Light&Space\\rule\\executionParameter.txt");
            try {

                System.out.println("2767fileName输出:"+fullFileName);
                if(!fullFileName.exists()){
                    fullFileName.createNewFile();
                }
                BufferedWriter out = new BufferedWriter(new FileWriter(fullFileName));
                out.write(s);
                out.flush();
                out.close();
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String[] commands = {"cmd.exe", "/c", "autolayout.exe", fileName};

            StringBuilder result = run(commands, directory);

            return result == null ? null : result.toString();
        }
        public static StringBuilder run(String[] commands, String directory) {
            StringBuilder result = new StringBuilder();
            try {
                File runDirectory = new File(directory);

                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command(commands);//设置此进程生成器的操作系统程序和参数。
                processBuilder.directory(runDirectory);//方法用于返回此流程生成器的工作目录。 如果返回null指示当前进程的当前工作目录，那么将使用系统属性“ user.dir” assign来分配目录名称
                processBuilder.redirectErrorStream(true);//设置此进程生成器的 redirectErrorStream 属性。默认值为false不合并
                Process process = processBuilder.start();//使用此进程生成器的属性启动一个新进程

                SequenceInputStream sequenceInputStream = new SequenceInputStream(process.getInputStream(),process.getErrorStream());

                final BufferedReader reader = new BufferedReader(new InputStreamReader(sequenceInputStream));


                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                } catch (IOException e) {
                    // Logger.warn("failed to read output from process", e);
                } finally {
                    reader.close();
                    if (reader != null) {
                        reader.close();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return result;
        }
}

