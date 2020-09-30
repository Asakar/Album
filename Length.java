public class Length {

    private int minutes;
    private int seconds;

    public Length(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Length add(Length toBeAdded){

        int newMin = 0;
        newMin += toBeAdded.getMinutes();
        newMin += getMinutes();

        Double newSec = 0.0;
        newSec += toBeAdded.getSeconds();
        newSec += getSeconds();
        newSec = newSec/60;

        newMin += Math.floor(newSec);
        toBeAdded.setMinutes(newMin);

        int newSec2 = (int) ((newSec - Math.floor(newSec))*60);
        toBeAdded.setSeconds((newSec2));

        return toBeAdded;
    }

    @Override
    public String toString() {
        return minutes + ":" + seconds;
    }

}

