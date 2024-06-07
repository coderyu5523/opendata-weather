package org.example.weather._core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherDAO {
    private final Connection connection;

    public WeatherDAO(Connection connection) {
        this.connection = connection;

    }

    public List<String> findDong(String gu) {

        List<String> dongList = new ArrayList<String>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("select dong from opendata_weather_tb where gu =?");
            pstmt.setString(1, gu);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dongList.add(rs.getString("dong"));
            }
            return dongList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Map<String, String> findNxNy(String gu, String dong) {

        Map<String, String> los = new HashMap<>();

        try {
            PreparedStatement pstmt = connection.prepareStatement("select nx,ny from opendata_weather_tb where gu= ? and dong =?");
            pstmt.setString(1, gu);
            pstmt.setString(2, dong);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                los.put("nx", rs.getString("nx"));
                los.put("ny", rs.getString("ny"));
            }
            return los;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
