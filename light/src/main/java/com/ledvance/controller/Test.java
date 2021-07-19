

package com.ledvance.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;


public class Test {

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readJsonFile(File jsonFile) {
        String jsonStr = "";
        try {
            //File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {

        String s = readJsonFile("C:\\Users\\M.xiao-ext\\Desktop\\zuixin.txt");
        //    System.out.println(readJsonFile("C:\\Users\\M.xiao-ext\\Documents\\WeChat Files\\wxid_xlv9p6lwvkum22\\FileStorage\\File\\2021-07\\output1625465122684.txt"));
        //   String s5 = execAutoArrayLampsAlgorithm(s);

        //    System.out.println("dddddddddddddddddddddddddddddd"+s5);
        System.out.println("-------------------------------------------------");

        JSONObject jsonArray = JSONObject.parseObject(s, Feature.OrderedField);

        String layers = jsonArray.getString("layers");
        //   System.out.println("layers-------"+layers);
        JSONObject layer = JSONObject.parseObject(layers, Feature.OrderedField);

        String layer1 = layer.getString("layer-1");
        JSONObject   jsonLayersOne = JSONObject.parseObject(layer1,Feature.OrderedField);
        Object id =   jsonLayersOne.getString("id");
        Object altitude =   jsonLayersOne.getString("altitude");
        Object order =   jsonLayersOne.getString("order");
        Object opacity =   jsonLayersOne.getString("opacity");
        Object name =   jsonLayersOne.getString("name");
        Object visible =   jsonLayersOne.getString("visible");
        Object selected =   jsonLayersOne.getString("selected");
        Object lines =   jsonLayersOne.getString("lines");
        Object holes =   jsonLayersOne.getString("holes");
        Object areas =   jsonLayersOne.getString("areas");
        Object items =   jsonLayersOne.getString("items");
        String vertices =   jsonLayersOne.getString("vertices");
        String areas1 =   jsonLayersOne.getString("areas");
          jsonLayersOne.put("id",id);
          jsonLayersOne.put("altitude",altitude);
          jsonLayersOne.put("order",order);
          jsonLayersOne.put("opacity",opacity);
          jsonLayersOne.put("name",name);
          jsonLayersOne.put("visible",visible);
          jsonLayersOne.put("selected",selected);
          jsonLayersOne.put("lines",lines);
          jsonLayersOne.put("holes",holes);
          jsonLayersOne.put("areas",areas);
          jsonLayersOne.put("items",items);
          jsonLayersOne.put("vertices",vertices);
        JSONObject jsonObject6= JSONObject.parseObject(vertices, Feature.OrderedField);
        System.out.println("6666666666666666666666666666666666666666666666"+jsonObject6);
        Map<String, Object> userMap2 = new HashMap<>();

        //循环转换，获取"layer-1"的vertices坐标
        for (Map.Entry<String, Object> entry : jsonObject6.entrySet()) {
            userMap2.put(entry.getKey(), entry.getValue());

            System.out.println("usermap"+userMap2);
        }

//        List list8=new ArrayList();
//        for (String obj:userMap2.keySet()) {
//            String vertex = jsonObject6.getString(obj);
//            System.out.println("ccccccccccccccccccccc"+vertex);
//            JSONObject jsonObject7= JSONObject.parseObject(vertex,Feature.OrderedField);
//            String x = jsonObject7.getString("x");
//            String y =jsonObject7.getString("y");
//            list8.add(x);
//            list8.add(y);
//
//        }

        //获取区域


        //获取空间灯具家具
        String itemss =   jsonLayersOne.getString("items");

        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+areas1);
        JSONObject jsonObject4 = JSONObject.parseObject(areas1,Feature.OrderedField);



        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"+jsonObject4);
        //获取区域的k-v
        Map<String, Object> area = new TreeMap<>();



        int a=1;
        int b=1000;

        //循环转换
        for (Map.Entry<String, Object> entry : jsonObject4.entrySet()) {
            area.put(entry.getKey(), entry.getValue());
            System.out.println("ddddddddddddd:"+entry.getKey()+"fffff:"+entry.getValue());
        }



        Map map3=new HashMap<>();

        List list4=new ArrayList();

        //暂时为空List
        List list5=new ArrayList();
        //循环获得区域的key
        List  list7=new ArrayList<>();

//        for (String obj:itemss.keySet()){
//            JSONObject obj1 = JSONObject.parseObject(obj, Feature.OrderedField);
//            //获得家具坐标
//            String x = obj1.getString("x");
//            String y = obj1.getString("y");
//            String depth = obj1.getString("depth");
//            JSONObject json1 = JSONObject.parseObject(depth, Feature.OrderedField);
//            String length = json1.getString("length");
//
//            String width = obj1.getString("width");
//            JSONObject json2 = JSONObject.parseObject(depth, Feature.OrderedField);
//            String length1 = json1.getString("length");
//
//            String height = obj1.getString("height");
//            JSONObject json3= JSONObject.parseObject(depth, Feature.OrderedField);
//            String length2 = json1.getString("length");
//
//            //添加家具，暂时自定义
//      //      m.put("furnitures",list5);
//
//        }

        for(String obj:area.keySet()){
            int c=1;
            Map<String,Object> m=new HashMap<>();

            List<Map<String,Object>> list6=new ArrayList();

            Map<String,Object> m2=new HashMap<>();
            List<Map<String,Object>> list2=new ArrayList();
//            //添加空间面积，暂时自定义
//            m.put("area",222222);
//
//            //添加家具，暂时自定义
            m.put("furnitures",list5);
//
//            //添加天花板,暂时自定义
//            m.put("ceilingType","网格天花300x300");
//
//            m.put("type",b++);
//
//            //窗户或者门
            m.put("doorOrWindows",list5);
//
//            //光度，照明度
//            m.put("illuminance",500);
//
//            //添加灯具类型和价格
//            m2.put("price",1);
//            m2.put("type","04.04.90.001.0931");
//            list2.add(m2);
//            m.put("portfolio",list2);
//
//            //一直是false
//            m.put("haschild",false);
//
//            //是否锁定
//            m.put("isLocked",false);
//
//            //维护系数
//            m.put("lightLossFactor",0.8);
//
//            //id从1开始
//            m.put("id",String.valueOf(a++));
//
//            //一直fales
//            m.put("hasParent",false);
//            m.put( "height",300);
//
            Map map4=new HashMap();
//            //灯具所有价格为空
//            map4.put("price","");
//            map4.put("type","");
//            list6.add(map4);
//            m.put("portfolio_all",list6);

            List<Map<String,Double>> list11=new ArrayList();

            String string = jsonObject4.getString(obj);

            JSONObject jsonVertices = JSONObject.parseObject(string, Feature.OrderedField);
            //获得空间有哪些坐标
            String vertices1 = jsonVertices.getString("vertices");
            //获取需要的参数
            String properties = jsonVertices.getString("properties");

            JSONObject blend = JSONObject.parseObject(properties, Feature.OrderedField);
//
            //面积
            JSONObject areaJson = JSONObject.parseObject(blend.getString("area"), Feature.OrderedField);
            String areass  = areaJson.getString("length");
            System.out.println("area:"+areass);
            m.put("area",Double.valueOf(areass)*1000);
//
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
            m.put("ceilingType",ceilingType);

            //类型
            m.put("type",b++);

            //门或者窗户
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
            m.put("illuminance",illuminance);

            //灯具价格
            m2.put("price",1);
            m2.put("type","04.04.90.001.0931");
            list2.add(m2);
            m.put("portfolio",list2);

            //一直是false
            m.put("haschild",false);

            //是否锁定
            m.put("isLocked",false);

            //维护系数
            JSONObject lightLossFactorJson = JSONObject.parseObject(blend.getString("lightLossFactor"), Feature.OrderedField);
            String lightLossFactor  = lightLossFactorJson.getString("length");


            //id从1开始
            m.put("id",a++);

            //一直fales
            m.put("hasParent",false);
            m.put( "height",300);


            //灯具所有价格为空
            map4.put("price","");
            map4.put("type","");
            list6.add(map4);
            m.put("portfolio_all",list6);



            System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrr"+vertices1);

            String substring = vertices1.substring(1, vertices1.length());
            String substring1 = substring.substring(0, substring.length() - 1);
            String str[] = substring1.split(",");

            List<String> strings = Arrays.asList(str);
            System.out.println ("sssssssssssssssssssssssssss"+strings.size ()+"aaaaaaaaaaaaaaaaaaa"+strings);
            Map<String,Double> map6 = new HashMap();

            for (String s1:strings) {

                String s2 = s1.replace ("\"", "");
                String jsonObject7 = jsonObject6.getString (s2);
                JSONObject jsonObject8 = JSONObject.parseObject (jsonObject7);


                for (String obj1 : userMap2.keySet ()) {
                    if (s2.equals (obj1)) {
                        Map<String, Double> mm = new HashMap ();
                        String x = String.format("%.1f", Double.valueOf(jsonObject8.getString("x")));
                        String y = String.format("%.1f", Double.valueOf(jsonObject8.getString("y")));
                        mm.put ("x",Double.valueOf(x));
                        mm.put ("y",Double.valueOf(y));
                        list11.add (mm);

                    }

                }
                Map<String, Double> map5 = new HashMap ();

                String x = String.format("%.2f", Double.valueOf(jsonObject8.getString("x")));
                String y = String.format("%.2f", Double.valueOf(jsonObject8.getString("y")));
                map6.put ("XStart", Double.valueOf(x));
                map6.put ("XEnd", Double.valueOf(y));
                String m6xs = String.format("%.2f", Double.valueOf( map6.get("XStart")));
                String m6xe = String.format("%.2f", Double.valueOf(map6.get("XEnd")));


                String m6ys = String.format("%.2f", Double.valueOf( map6.get("XStart")));
                String m6ye = String.format("%.2f", Double.valueOf(map6.get("XEnd")));

            if (c==1) {


            }else if (c == 2) {
                    map5.put ("XStart",  Double.valueOf (m6xs));
                    map5.put ("XEnd",  Double.valueOf (m6xe));
                    map5.put ("YStart", Double.valueOf (x));
                    map5.put ("YEnd", Double.valueOf (y));

                    map6.put ("YStart", Double.valueOf (x));
                    map6.put  ("YEnd", Double.valueOf (y));
                    list7.add (map5);
                } else  {
                    map5.put ("XStart",  Double.valueOf (m6ys));
                    map5.put ("XEnd",   Double.valueOf (m6ye));
                    map5.put ("YStart", Double.valueOf (x));
                    map5.put ("YEnd", Double.valueOf (y));



                    if (c==strings.size ()) {
                        map6.put ("YStart", Double.valueOf (m6xs));
                        map6.put ("YEnd", Double.valueOf (m6xe));
                        map6.put ("XStart",  Double.valueOf (x));
                        map6.put ("XEnd",  Double.valueOf (y));
                    }
                    list7.add (map5);



                }
                c++;
            }
            list7.add (map6);


            m.put("points",list11);
            list4.add(m);

        }
        //map3.put("walls",list7);
        map3.put("rooms",list4);
        System.out.println("1111111111111111111111111111111111"+map3);
        map3.put("walls",list7);

        JSONObject json = new JSONObject(map3);
        System.out.println("222222222222222222"+json.toString());


        String s1 = execAutoArrayLampsAlgorithm(s);

        System.out.println("dddddddddddddddddddddddddddddd"+s1);
//        Map<String, Object> userMap = new HashMap<>();
//
//        System.out.println("map对象:" + userMap.toString());
//        Object vertices1 = areas.get("vertices");
//        System.out.println(vertices1+"=========================================");
//        List<String> list = castList(vertices1, String.class);
//        System.out.println(list);
//        list.forEach(System.out::println);

//        List<String> purchaseOrders = (List) JSONArray.parseArray(jsonObject4.toString());
//
//        for (String purchaseOrder:purchaseOrders){
//            System.out.println("==========================================++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println("purchaseOrder"+purchaseOrder);
//        }

        String vertices2 =   jsonLayersOne.getString("vertices");
        System.out.println("=======================vertices"+vertices2);
        JSONObject jsonObject2 = JSONObject.parseObject(vertices2);

//        String vertices = jsonObject2.getString("vertices");
//        JSONObject jsonObject2 = JSONObject.parseObject(vertices, Feature.OrderedField);
//        System.out.println("jsonObject2=============="+jsonObject2);
        //     System.out.println("vertices-----======-------"+vertices);




//循环转换
//        for (Map.Entry<String, Object> entry : jsonObject2.entrySet()) {
//            userMap.put(entry.getKey(), entry.getValue());
//        }
//        System.out.println("map对象:" + userMap.toString());
//
//        Map points=new HashMap();



//        for(String key:userMap.keySet()){
//            Object o = userMap.get(key);
//            try {
//                Map<String, Object> objectToMap = getObjectToMap(o);
//                System.out.println("-------------============---"+objectToMap);
//                Object x = objectToMap.get("x");
//                points.put("x",x);
//                points.put("y",objectToMap.get("y"));
//
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//
//        }




//        String Z1NYs5d = jsonObject2.getString("Z1NYs5d-NG");
//     //   System.out.println("Z1NYs5d-NG========="+Z1NYs5d);
//
//        JSONObject jsonObject3 = JSONObject.parseObject(Z1NYs5d);
//
//        String areas2 = jsonObject3.getString("areas");
//    //    System.out.println("areas====================="+areas);
//
//         JSONArray jsonArray1 = JSONArray.parseArray(areas2);
//
//        if (jsonArray1.size()!=0) {
//            for (int i = 0; i < jsonArray1.size(); i++) {
//                System.out.println("name = " + jsonArray1.getJSONObject(i).getString("a"));
//                System.out.println("password = " + jsonArray1.getJSONObject(i).getString("b"));
//
//            }
//        }
//
//        Map map2 =new HashMap();
//        map2.put("depth","100");
//        map2.put("width","100");
//        map2.put("x","236.55281");
//        map2.put("y","288");
//        map2.put("height","100");
//
//
//        Map map1 =new HashMap();
//        map1.put("area","937040");
//        map1.put("furnitures",map2);
//        map1.put("ceilingType","937040");
//        map1.put("type","937040");



//        Map map11 =new HashMap();
//        map.put("room",map);
//        String s1 = map.toString();
//        System.out.println("---------------------------map"+s1);


//        System.out.println("layers = " + jsonArray.getString("layers"));
//            System.out.println("grids = " + jsonArray.getString("grids"));
//            System.out.println("selectedLayer = " + jsonArray.getString("selectedLayer"));
//            System.out.println("groups = " + jsonArray.getString("groups"));
//            System.out.println("width = " + jsonArray.getString("width"));
//            System.out.println("height = " + jsonArray.getString("height"));
//            System.out.println("meta = " + jsonArray.getString("meta"));
//            System.out.println("guides = " + jsonArray.getString("guides"));
        //       for(int i = 0 ;i < jsonArray.size() ; i++) {
//            System.out.println("unit = " + jsonArray.getJSONObject(i).getString("unit"));
//            System.out.println("layers = " + jsonArray.getJSONObject(i).getString("layers"));
//            System.out.println("grids = " + jsonArray.getJSONObject(i).getString("grids"));
//            System.out.println("selectedLayer = " + jsonArray.getJSONObject(i).getString("selectedLayer"));
//            System.out.println("groups = " + jsonArray.getJSONObject(i).getString("groups"));
//            System.out.println("width = " + jsonArray.getJSONObject(i).getString("width"));
//            System.out.println("height = " + jsonArray.getJSONObject(i).getString("height"));
//            System.out.println("meta = " + jsonArray.getJSONObject(i).getString("meta"));
//            System.out.println("guides = " + jsonArray.getJSONObject(i).getString("guides"));
//
//        }
//        String lampsArrangementString = execAutoArrayLampsAlgorithm(s);
//
//        System.out.println("lampsArrangementString"+lampsArrangementString);



//        String path = JsonTest.class.getClassLoader().getResource("Movie.json").getPath();
//        String s = readJsonFile("C:\\Users\\M.xiao-ext\\Desktop\\a.txt");
//        JSONObject jobj = JSON.parseObject(s);
//        JSONArray movies = jobj.getJSONArray("RECORDS");//构建JSONArray数组
//        for (int i = 0 ; i < movies.size();i++){
//            JSONObject key = (JSONObject)movies.get(i);
//            String name = (String)key.get("name");
//            String director = (String)key.get("director");
//            String scenarist=((String)key.get("scenarist"));
//            String actors=((String)key.get("actors"));
//            String type=((String)key.get("type"));
//            String ratingNum=((String)key.get("ratingNum"));
//            String tags=((String)key.get("tags"));
//            System.out.println(name);
//            System.out.println(director);
//            System.out.println(scenarist);
//            System.out.println(actors);
//            System.out.println(type);
//            System.out.println(director);
//            System.out.println(ratingNum);
//            System.out.println(tags);

//        }
    }
    private static String getPath() {
        return System.getProperty("user.dir");
    }
    public static String getRulePath() {
        return new StringBuilder(getPath()).append(File.separator)
                .append("rule").append(File.separator).toString();
    }
    private static String execAutoArrayLampsAlgorithm(String inputString) {

        String directory = getRulePath();
        String fileName = "executionParameter.txt";
        try {
            File fullFileName = new File("C:\\Users\\M.xiao-ext\\AppData\\Local\\Programs\\Light&Space\\rule\\executionParameter.txt");

            BufferedWriter out = new BufferedWriter(new FileWriter(fullFileName));
            out.write(inputString);
            out.flush();
            out.close();
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] commands = {"cmd.exe", "/c", "autolayout.exe",  fileName};

        StringBuilder result = run(commands, directory);
        System.out.println("--------------"+result);
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
            System.out.println("--------"+reader);
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
        System.out.println("--------"+result);
        return result;
    }

    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> cla = obj.getClass();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(obj);
            if (value == null)
                value = "";
            map.put(keyName, value);
        }
        return map;
    }


    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }


    public static String trimFirstAndLastChar(String source, char element) {
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do {
            //判断指定字符是否出现在该字符串的第一位  是--返回下标1   否--返回下标0
            int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
            //判断指定字符是否出现在该字符串的最后一位  是--返回出现的位置   否--返回字符长度
            int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
            //开始截取字符串
            source = source.substring(beginIndex, endIndex);
            //判断新字符串首位是否还存在指定字符
            beginIndexFlag = (source.indexOf(element) == 0);
            //判断新字符串最后一位是否还存在指定字符
            endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
        } while (beginIndexFlag || endIndexFlag);//条件通过再次截取
        return source;
    }


}