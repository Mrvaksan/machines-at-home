import java.util.Date;

public class WashingMachine {
    private int temperature;
    private int rpm;
    private int timer;
    private int remainingTime;
    private boolean isRunning;
    private boolean isStarted;
    public Date startingMoment;

    public WashingMachine() {
        reset();
    }

    private void reset() {
        this.isRunning = false;
        this.isStarted = false;
        this.temperature = 60;
        this.rpm = 800;
        this.timer = 60;
        this.remainingTime = 60;
    }

    public void start() {
        if (!isStarted) {
            this.startingMoment = new Date();
            remainingTime = timer;
            isStarted = true;
            isRunning = true;
        } else {
            if (!isRunning) {
                timer = remainingTime;
                this.startingMoment = new Date();
                isRunning = true;
            } else {
                timer = remainingTime;
                isRunning = false;
            }
        }
    }

    public void update() {
        if (this.isRunning) {
            Date now = new Date();

            remainingTime = timer - (int) (now.getTime() - startingMoment.getTime()) / (1000);

            if (remainingTime <= 0) {
                reset();
            }
        }
    }

    public void printStatus() {
        String status;

        if (isStarted) {
            if (isRunning) {
                status = "Çalışıyor";
            } else {
                status = "Duraklatıldı";
            }
        } else {
            status = "Çalışmıyor";
        }

        System.out.printf("%s: [Sıcaklık %d °C, Devir: %d rpm, Süre: %d dk]\n", status, temperature, rpm, remainingTime);
    }

    //getter for temperature
    public int getTemperature() {
        return this.temperature;
    }

    //setter for temperature
    public void setTemperature(int newTemperature) {
        if (this.isRunning) {
            System.out.println("Hata! Makine çalışırken sıcaklık değiştirilemez");
        } else {
            this.temperature = newTemperature;
        }
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        if (this.isRunning) {
            System.out.println("Hata! Makine çalışırken devir ayarı değiştirilemez");
        } else {
            this.rpm = rpm;
        }
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        if (this.isRunning) {
            System.out.println("Hata! Makine çalışırken süre değiştirilemez");
        } else {
            this.timer = timer;
            this.remainingTime = timer;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

}
