package org.example.weather.dao;

import org.example.weather._core.dao.WeatherDAO;
import org.example.weather._core.db.DBConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class WeatherDAOTest {

    @Test
    public void findDong_test() {
        //given
        String gu = "부산진구";

        //when
        WeatherDAO dao = new WeatherDAO(DBConnection.getInstance());
        List<String> dongList = dao.findDong(gu);
        dongList.forEach(System.out::println);
    }

    @Test
    public void findNyNy_test() {
        //given
        String gu = "종로구";
        String dong = "사직동";

        //when
        WeatherDAO dao = new WeatherDAO(DBConnection.getInstance());
        Map<String, String> los = dao.findNxNy(gu, dong);

        System.out.println(los.get("nx"));
        System.out.println(los.get("ny"));

        Assertions.assertEquals("60", los.get("nx"));
        Assertions.assertEquals("127", los.get("ny"));
    }
}
