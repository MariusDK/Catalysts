/**
 * Created by MariusDK on 30.03.2017.
 */
public class Bank {
    public double xPosition;
    public double yPosition;
    public double bankOpeningTime;
    public double bankClosingTime;
    public double timeRobbery;

    public double getBankOpeningTime() {
        return bankOpeningTime;
    }

    public void setBankOpeningTime(double bankOpeningTime) {
        this.bankOpeningTime = bankOpeningTime;
    }

    public double getBankClosingTime() {
        return bankClosingTime;
    }

    public void setBankClosingTime(double bankClosingTime) {
        this.bankClosingTime = bankClosingTime;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getTimeRobbery() {
        return timeRobbery;
    }

    public void setTimeRobbery(double timeRobbery) {
        this.timeRobbery = timeRobbery;
    }
}
