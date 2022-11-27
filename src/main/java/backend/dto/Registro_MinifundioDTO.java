package backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class Registro_MinifundioDTO {
    private String deviceID;
    private String datetime;
    private double ph;
    private double temperature;
    private double humidity;
    //@JsonProperty("P")

    private double P;
    //@JsonProperty("K")
    private double K;
    //@JsonProperty("N")
    private double N;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getK() {
        return K;
    }

    public void setK(double k) {
        K = k;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    @Override
    public String toString() {
        return "Registro_MinifundioDTO{" +
                "deviceID='" + deviceID + '\'' +
                ", datetime='" + datetime + '\'' +
                ", ph=" + ph +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", P=" + P +
                ", K=" + K +
                ", N=" + N +
                '}';
    }

}
