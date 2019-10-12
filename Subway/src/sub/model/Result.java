package sub.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private Station start;
	private Station over;
	private int distance = 0;
	private List<Station> pass = new ArrayList<>();
	public Station getStart() {
		return start;
	}
	public void setStart(Station start) {
		this.start = start;
	}
	public Station getOver() {
		return over;
	}
	public void setOver(Station over) {
		this.over = over;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<Station> getPass() {
		return pass;
	}
	public void setPass(List<Station> pass) {
		this.pass = pass;
	}
	public Result(){

	}
	public Result(Station start, Station over, int distance) {
        this.start = start;
        this.over = over;
        this.distance = distance;
    }
	public String toString() {
        return "Result{" +
                "start=" + start +
                ", over=" + over +
                ", distance=" + distance +
                ", passStations=" + pass +
                '}';
    }

}

