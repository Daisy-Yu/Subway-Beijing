package information;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import sub.core.Dijkstra;
import sub.model.Data;
import sub.model.Result;
import sub.model.Station;

public class Test {
	
	public static void test() {
		
		System.out.println("请输入起始站点：");
		Scanner sc=new Scanner(System.in);
		String start=sc.nextLine();
		System.out.println("请输入结束站点：");
		String over=sc.nextLine();
		System.out.println("最短路线：");
        Result result = Dijkstra.value(new Station(start), new Station(over));

//        for (Station station : result.getPass()) {
//            System.out.print(station.getSname() + "\n");
//        }
        System.out.println("->乘坐"+result.getPass().get(1).getLine());
        for(int i=0;i<result.getPass().size()-1;i++) {
        	System.out.println(result.getPass().get(i).getSname());
        	if(!result.getPass().get(i+1).getLine().equals(result.getPass().get(i).getLine())){
        		System.out.println("->换乘"+result.getPass().get(i+1).getLine());
        	}
        }
//        System.out.println("\n总共经过距离" + result.getDistance());
        System.out.println("\n经过站点数：" + result.getPass().size());
    }
	
	public static void main(String[] args) throws IOException {
		Data.readData("src/subway");
		test();
//        Dijkstra.getResultToText("src/result");
        
    }

}
