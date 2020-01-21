package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.dao.impl.ItemsDaoImpl;
import com.itheima.domain.Items;
import org.junit.Test;

import java.util.List;

/**
 * description: ItemsTest <br>
 * date: 2020/1/21 15:28 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */
public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items:list) {
            System.out.println(items.getName());
        }
    }
}
