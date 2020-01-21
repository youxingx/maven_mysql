package com.itheima.dao;

import com.itheima.domain.Items;

import java.sql.SQLException;
import java.util.List;

/**
 * description: ItemsDao <br>
 * date: 2020/1/21 15:06 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */
public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
