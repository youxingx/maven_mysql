package com.itheima.dao.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description: ItemsDaoImpl <br>
 * date: 2020/1/21 15:08 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

/**
 * 要想从数据库中取出数据
 * 必须有四个属性：数据库驱动，连接数据库的地址，数据库用户名，数据库密码
 */
public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection对象
//        DriverManager.getConnection("jdbc:mysql://localhost:3306/java1?useSSL=false&serverTimezone=UTC");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1?useSSL=false&serverTimezone=UTC", "root", "123qwe");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from user");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库届国际转成java的List集合
            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("username"));
                list.add(items);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
