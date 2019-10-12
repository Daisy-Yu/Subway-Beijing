package information;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrintLine {

	public static void SearchLine(String filePath, String key){
		try {
		    String encoding="GBK";
		    File file=new File(filePath);
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		        new FileInputStream(file),encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while((lineTxt = bufferedReader.readLine()) != null){
		        	if(lineTxt.indexOf(key)==0) {
		        		System.out.println(lineTxt);
		        	}
		        }
		    read.close();
		    }
		    else{
		        System.out.println("找不到指定的文件");
		    }
		}catch (Exception e) { 
		      System.out.println("读取文件内容出错"); 
		      e.printStackTrace();
		      } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入要查找的线路名称：");
		Scanner scanner=new Scanner(System.in);
		String name=scanner.nextLine();
		String path="src/subway";
		System.out.println("线路站点信息：");
		SearchLine(path,name);

	}

}
