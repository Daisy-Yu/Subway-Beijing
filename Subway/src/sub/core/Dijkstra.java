package sub.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import sub.model.Data;
import sub.model.Result;
import sub.model.Station;

public class Dijkstra {
	
	private static HashMap<Station, Result> resultMap = new HashMap<>();
	private static List<Station> anaList = new ArrayList<>();
	public static Result value(Station start,Station over) {
        if (!anaList.contains(start)) {
            anaList.add(start);
        }
        if (start.equals(over)){
            Result result = new Result();
            result.setDistance(0);
            result.setOver(start);
            result.setStart(start);
            resultMap.put(start, result);
            return resultMap.get(start);
        }
        if (resultMap.isEmpty()) {
            List<Station> linkStations = getLinkStation(start);
            for (Station station : linkStations) {
                Result result = new Result();
                result.setStart(start);
                result.setOver(station);
                int distance = 1;
                result.setDistance(distance);
                result.getPass().add(station);
                resultMap.put(station, result);
            }
        }
        Station before = getNextStation();
        if (before==null){
            Result result = new Result();
            result.setDistance(0);
            result.setStart(start);
            result.setOver(over);
            return resultMap.put(over, result);
        }
        if (before.equals(over)) {
            return resultMap.get(before);
        }
        List<Station> afterLinks = getLinkStation(before);
        for (Station after : afterLinks) {
            if (anaList.contains(after)) {
                continue;
            }
            int distance =  resultMap.get(before).getDistance()+1;
            if( before.getSname().equals(after.getSname())){
                distance = 0;
            }
            List<Station> beforePass = resultMap.get(before).getPass();
            Result afterResult = resultMap.get(after);
            if (afterResult!=null){
                if (afterResult.getDistance() > distance) {
                	afterResult.setDistance(distance);
                	afterResult.getPass().clear();
                	afterResult.getPass().addAll(beforePass);
                	afterResult.getPass().add(after);
                }
            }
            else {
            	afterResult = new Result();
            	afterResult.setDistance(distance);
            	afterResult.setStart(start);
            	afterResult.setOver(after);
            	afterResult.getPass().addAll(beforePass);
            	afterResult.getPass().add(after);
            }
            resultMap.put(after, afterResult);
        }
        anaList.add(before);
        value(start, over);
        return resultMap.get(over);
    }
	
	private static List<Station> getLinkStation(Station station) {
        List<Station> linkedStaions = new ArrayList<Station>();
        for (List<Station> line : Data.lineSet) {
            for (int i = 0; i < line.size(); i++) {
                if (station.equals(line.get(i))) {
                    if (i == 0) {
                        linkedStaions.add(line.get(i + 1));
                    } else if (i == (line.size() - 1)) {
                        linkedStaions.add(line.get(i - 1));
                    } else {
                        linkedStaions.add(line.get(i + 1));
                        linkedStaions.add(line.get(i - 1));
                    }
                }
            }
        }
        return linkedStaions;
    }
	
	private static Station getNextStation() {
        int min = 100;
        Station dots = null;
        Set<Station> stations = resultMap.keySet();
        for (Station station : stations) {
            if (anaList.contains(station)) {
                continue;
            }
            Result result = resultMap.get(station);
            if (result.getDistance() < min) {
                min = result.getDistance();
                dots = result.getOver();
            }
        }
        return dots;
    }
	
//	public static void getResultToText(String filePath) throws IOException {
//        BufferedWriter writer = null;
//        writer = new BufferedWriter(new FileWriter(filePath, true));
//        Set<List<Station>> lineSet = Data.lineSet;
//        for (List<Station> stations : lineSet) {
//            for (Station station : stations) {
//                for (List<Station> stations2 : lineSet) {
//                    for (Station stationTarget : stations2) {
//                        Dijkstra dijkstra = new Dijkstra();
//
//                        Result result = dijkstra.calculate(station, stationTarget);
//                        resultMap = new HashMap<>();
//                        analysisList = new ArrayList<>();
//                        for (Station s : result.getPass()) {
//                            if (s.getSname().equals(stationTarget.getSname())) {
//                                String text = station.getSname() + "\t" + stationTarget.getSname() + "\t" + result.getPass().size() + "\t" + result.getDistance() + "\t";
//                                for (Station test : result.getPass()) {
//                                    text = text + test.getSname() + ",";
//                                }
//                                writer.write(text);
//                                writer.newLine();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        writer.flush();
//        writer.close();
//
//    }
	
	public static void main(String[] args) {
		
	}

}
