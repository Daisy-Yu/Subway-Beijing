package information;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class subway {
	
	public static void readFile(String filePath){ 
	    try { 
	        String encoding="GBK"; 
	        File file=new File(filePath); 
	        if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ���� 
	          InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ 
	          BufferedReader bufferedReader = new BufferedReader(read); 
	          String lineTxt = null; 
	          while((lineTxt = bufferedReader.readLine()) != null){ 
	            System.out.println(lineTxt); 
	          } 
	          read.close(); 
	    }else{ 
	      System.out.println("�Ҳ������ļ���"); 
	    } 
	    } catch (Exception e) { 
	      System.out.println("��ȡ�ļ����ݳ���"); 
	      e.printStackTrace(); 
	    } 
	    
	  } 
	
	public static void main(String[] args){
		readFile("src/subway");
    }
}
