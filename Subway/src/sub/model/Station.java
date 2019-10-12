package sub.model;

import java.util.ArrayList;
import java.util.List;

public class Station {
	private String sname;
	private String line;
	private List<Station> links = new ArrayList<>();
	
    public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public List<Station> getLinks() {
		return links;
	}
	public void setLinks(List<Station> links) {
		this.links = links;
	}
	public Station (){
		 
    }
	public Station(String name) {
        this.sname = name;
    }
	public Station(String sname, String line) {
        this.sname = sname;
        this.line = line;
    }
	public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getSname().equals(this.getSname())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getSname().hashCode();
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + sname + '\'' +
                ", line='" + line + '\'' +
                ", linkStations=" + links +
                '}';
    }
}
