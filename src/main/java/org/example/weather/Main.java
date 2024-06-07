package org.example.weather;

import com.google.gson.Gson;
import org.example.weather._core.dao.WeatherDAO;
import org.example.weather._core.data.WeatherDTO;
import org.example.weather._core.data.WeatherVO;
import org.example.weather._core.db.DBConnection;
import org.example.weather._core.util.MyHttp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 객체 초기화
        Scanner sc = new Scanner(System.in);
        WeatherDAO dao = new WeatherDAO(DBConnection.getInstance());

        System.out.println("원하는 구를 입력하세요");
        System.out.println("ex) [종로구, 수영구, 부산진구]");

        // 구 데이터 입력받기
        String gu = sc.nextLine();
        // 입력받은 정보로 DB 연결
        List<String> dongList = dao.findDong(gu);

        System.out.println("원하는 동을 입력하세요");
        // 입력받기 전 DB로 조회된 동 리스트를 출력
        dongList.forEach(s -> System.out.print(s + " "));
        System.out.println(); // 한칸 띄우기 용

        // 동 데이터 입력받기
        String dong = sc.nextLine();
        // 입력받은 데이터로 DB 연결
        Map<String, String> los = dao.findNxNy(gu, dong);

        // 공공데이터 API 요청
        WeatherVO vo = new WeatherVO("20240607", "1600", los.get("nx"), los.get("ny"));
        try {
            String responseBody = MyHttp.get(
                    vo.uri,
                    vo.serviceKey,
                    vo.baseDate,
                    vo.baseTime,
                    vo.nx,
                    vo.ny
            );
            //GSON 라이브러리를 사용해 JSON 데이터 담기
            Gson gson = new Gson();
            WeatherDTO dto = gson.fromJson(responseBody, WeatherDTO.class);

            System.out.println("현재 온도 : " + dto.response.body.items.item.get(3).obsrValue);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}