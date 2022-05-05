package com.nuaa.DAO.impl.Base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    public final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String url= "jdbc:mysql://localhost:3306/managedb?useOldAliasMetadataBehavior=true&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf-8";
    public final String pwd = "160152";
    public final String user = "root";
    protected Connection conn;
    protected PreparedStatement psmt;
    protected ResultSet rs;
    private Class entityClass;
    public BaseDAO(){
        //无参构造方法
        //获取
        Type genericType = getClass().getGenericSuperclass();//获取泛型的类型
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        Type actualType = actualTypeArguments[0];
        try {
            entityClass = Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接公共方法
    public Connection getConn(){
        try {
            Class.forName(Driver);
            return DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    return null;
    }
    //关闭连接公共方法
    public void close(ResultSet rs,Connection conn,PreparedStatement psmt){
            {
                try {
                    if(rs!=null) rs.close();
                    if(conn!=null) conn.close();
                    if(psmt!=null) psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }
    //给占位符赋值公共方法
    public void setParams(PreparedStatement psmt,Object...params) throws SQLException {
        if(params != null && params.length>0){
            for(int i=0;i<params.length;i++){
                psmt.setObject(i+1,params[i]);
            }
        }
    }
    //给OBJ对象的property属性赋值
    private void setValue(Object obj,String property,Object value){
        Class clazz = obj.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(property);
            if(field != null){
                field.setAccessible(true);
                field.set(obj,value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    //查询所有结果
    public List<T> excuteQuery(String sql,Object...params){
        List<T> list = new ArrayList<>();
        try {
            conn = getConn();
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();//拿到结果集的元数据
            int columnCount =  rsmd.getColumnCount();
            while(rs.next()){
                T entity =(T)entityClass.newInstance();//创建实例对象
                for(int i=0;i<columnCount;i++){
                    String columName = rsmd.getColumnName(i+1);//属性名
                    Object value = rs.getObject(i+1);//属性值
                    setValue(entity,columName,value);
                }
                list.add(entity);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            close(rs,conn,psmt);
        }
        return list;
    }
    //执行更新
    public boolean excuteUpdate(String sql,Object...params){
        conn = getConn();
        try {
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            return psmt.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,conn,psmt);
        }
    return false;
    }
    //执行复杂查询
    protected Object[] excuteComplexQuery(String sql,Object...params){
        try {
            conn = getConn();
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            if(rs.next()) {
                for(int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);
                    columnValueArr[i] = columnValue;
                }
                return columnValueArr;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,conn,psmt);
        }
        return null;
    }
    public T load(String sql,Object...params){
        try {
            conn = getConn();
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();//拿到结果集的元数据
            int columnCount =  rsmd.getColumnCount();
            T entity =(T)entityClass.newInstance();
            if(rs.next()){
                for(int i=0;i<columnCount;i++){
                    String columName = rsmd.getColumnName(i+1);//属性名
                    Object value = rs.getObject(i+1);//属性值
                    setValue(entity,columName,value);
                }
                return entity;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            close(rs,conn,psmt);
        }
        return null;
    }
}
