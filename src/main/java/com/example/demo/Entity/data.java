package com.example.demo.Entity;

public class data {
    private double output;
    private double taktTime;
    private double rateOfStartup;
    private double rateOfUtilization;
    private double current;
    private double vol;
    private double usefulPower;
    private double currentElectricEnergy;
    private double heartbeat;
    private double status;

    public data() {
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getTaktTime() {
        return taktTime;
    }

    public void setTaktTime(double taktTime) {
        this.taktTime = taktTime;
    }

    public double getRateOfStartup() {
        return rateOfStartup;
    }

    public void setRateOfStartup(double rateOfStartup) {
        this.rateOfStartup = rateOfStartup;
    }

    public double getRateOfUtilization() {
        return rateOfUtilization;
    }

    public void setRateOfUtilization(double rateOfUtilization) {
        this.rateOfUtilization = rateOfUtilization;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public double getUsefulPower() {
        return usefulPower;
    }

    public void setUsefulPower(double usefulPower) {
        this.usefulPower = usefulPower;
    }

    public double getCurrentElectricEnergy() {
        return currentElectricEnergy;
    }

    public void setCurrentElectricEnergy(double currentElectricEnergy) {
        this.currentElectricEnergy = currentElectricEnergy;
    }

    public double getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(double heartbeat) {
        this.heartbeat = heartbeat;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }
}
