package sub.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Data {
	
	public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<>();
	
//	private static void getLine(String lineStr,List<Station> line,String lineName){
//        String[] lineArr = lineStr.split(" ");
//        for (String s : lineArr) {
//            line.add(new Station(s,lineName));
//        }
//    }
	
	public static void readData(String filePath){ 
	    try { 
	    	int count=0;
	        String encoding="GBK"; 
	        File file=new File(filePath); 
	        if(file.isFile() && file.exists()){ //判断文件是否存在 
	          InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式 
	          BufferedReader bufferedReader = new BufferedReader(read); 
	          String lineTxt = null; 
	          while((lineTxt = bufferedReader.readLine()) != null){ 
	        	  List<Station> line = new ArrayList<Station>();
	        	  String[] lineArr = lineTxt.split(" ");
	        	  String lineName=lineArr[0];
	        	  for(int j=1;j<lineArr.length;j++) {
	        		  line.add(new Station(lineArr[j],lineName));
	        	  }
	        	  lineSet.add(line);
	          } 
	          read.close(); 
	    }else{ 
	      System.out.println("找不到该文件！"); 
	    } 
	    } catch (Exception e) { 
	      System.out.println("读取文件内容出错"); 
	      e.printStackTrace(); 
	    } 
	    
	  } 

}