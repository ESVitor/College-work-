/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converttemperature;

import net.webservicex.TemperatureUnit;
/**
 *
 * @author ThieresLuiz
 */

public class ConvertTemperature {

    private double temperature;
    private TemperatureUnit fromUnit;
    private TemperatureUnit toUnit;
    private double result;

    public ConvertTemperature() {
       
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public TemperatureUnit getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(TemperatureUnit fromUnit) {
        this.fromUnit = fromUnit;
    }

    public TemperatureUnit getToUnit() {
        return toUnit;
    }

    public void setToUnit(TemperatureUnit toUnit) {
        this.toUnit = toUnit;
    }

    public double getResult() {
        result = convertTemp(temperature, fromUnit, toUnit);
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private static double convertTemp(double temperature, net.webservicex.TemperatureUnit fromUnit, net.webservicex.TemperatureUnit toUnit) {
        net.webservicex.ConvertTemperature service = new net.webservicex.ConvertTemperature();
        net.webservicex.ConvertTemperatureSoap port = service.getConvertTemperatureSoap12();
        return port.convertTemp(temperature, fromUnit, toUnit);
    }
    
}
