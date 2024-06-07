package org.example.weather._core.data;

public class WeatherVO {
    public String uri = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    public String serviceKey = "GwP4SAIbheNGehkwEohRbKiZarjkYCbbT0%2FKzCWnPd7XL0vo97Tvx8b1Q4wwORGuGx47qa34CKrCDe4AL4vCrw%3D%3D";
    public String baseDate;
    public String baseTime;
    public String nx;
    public String ny;


    public WeatherVO(String baseData, String baseTime, String nx, String ny) {
        this.baseDate = baseData;
        this.baseTime = baseTime;
        this.nx = nx;
        this.ny = ny;
    }
}
