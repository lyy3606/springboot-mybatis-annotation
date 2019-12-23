package com.imooc.demo.main;

import com.imooc.demo.annotion.Colnum;
import com.imooc.demo.annotion.Table;
import com.imooc.demo.entity.Filter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AonnotationText {

    public static void main(String[] args) {
        Filter filter = new Filter();
        filter.setId(1);//表示查询id为1的
        filter.setGrade("一年级");
        filter.setPrefession("信息与计算科学");

        Filter filter1 = new Filter();
        filter1.setUserName("小明");//模糊查询name为小明的用户
        filter1.setAge(20);
        filter1.setGrade("三年级");

        Filter filter2 = new Filter();
        filter2.setHobby("游泳,插花");//模糊查询
        filter2.setPrefession("通信工程,数据结构,数学与应用数学,信息与计算科学");

        String sql = query(filter);
        String sql1 = query(filter1);
        String sql2 = query(filter2);
        System.out.println(sql);
        System.out.println(sql1);
        System.out.println(sql2);
    }

    //功能：根据filter带进来的信息返回由select组装成的sql语句
    //sql语句结构：select 查询的属性 from 查询的表 where 1=1 and 查询的属性='属性值'
    public static String query(Filter filter) {
        StringBuilder str = new StringBuilder();
        //获取class类型  调用反射
        Class c = filter.getClass();
        //判断类中是否含有Table注解
        Boolean isExist = c.isAnnotationPresent(Table.class);
        //不存在就返回null
        if (!isExist) {
            return null;
        }
        //获取注解的内容
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        //构造sql语句  加入where 1=1是为了防止where后边的条件获取失败，从而造成sql语句错误
        str = str.append("select * from " + tableName + " where 1=1");
        String colunmName = null;
        //获取所有的属性，之后进行遍历属性看是否有Colnum注解，有的话获取注解的值，值对应table中的字段名
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            boolean exist = field.isAnnotationPresent(Colnum.class);
            if (!exist) {
                continue;
            }
            Colnum col = field.getAnnotation(Colnum.class);
            colunmName = col.value();
            //获取到字段名之后还得需要获取字段的值，字段值可以通过反射Method，拼接method名，再反射获取value
            Object filedValue = null;
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method method = c.getMethod(getMethodName);
                filedValue = method.invoke(filter, null);

            } catch (Exception e) {
                e.printStackTrace();
            }
            //如果属性中虽然有Colnum注解，但是值是null或者int类型的，默认值为0，视为没有传进来值，不加入到sql语句中
            if (filedValue == null || (filedValue instanceof Integer && (Integer) filedValue == 0)) {
                continue;
            }
            str.append(" and " + colunmName);
            //若传进来的参数是string类型并且其中函数逗号，注意sql语句跟不含逗号的不同
            if (filedValue instanceof String) {
                if (((String) filedValue).contains(",")) {
                    String[] values = ((String) filedValue).split(",");
                    str.append(" in "+"(");
                    for (String value: values){
                        str.append("'").append(value).append("',");
                    }
                    str.deleteCharAt(str.length()-1);
                    str.append(")");
                } else {
                    //String类型的值在sql语句中是要加单引号的
                    str.append("=" + "'" + filedValue + "'");
                }
            } else {//int类型不用加引号
                str.append("=" + filedValue);
            }
        }
        return str.toString();
    }
}
