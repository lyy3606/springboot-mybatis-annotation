package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    void queryArea() {
        List<Area> list = areaDao.queryArea();
        assertEquals(2,list.size());
    }

    @Test
    void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    void insertArea() {
        Area area = new Area("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    void updateArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setAreaId(1);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteArea() {
       int effectNum =  areaDao.deleteArea(3);
       assertEquals(1,effectNum);
    }
}