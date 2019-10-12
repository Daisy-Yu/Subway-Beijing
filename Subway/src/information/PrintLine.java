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
		    if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
		        InputStreamReader read = new InputStreamReader(
		        new FileInputStream(file),encoding);//���ǵ������ʽ
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
		        System.out.println("�Ҳ���ָ�����ļ�");
		    }
		}catch (Exception e) { 
		      System.out.println("��ȡ�ļ����ݳ���"); 
		      e.printStackTrace();
		      } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ���ҵ���·���ƣ�");
		Scanner scanner=new Scanner(System.in);
		String name=scanner.nextLine();
		String path="src/subway";
		System.out.println("��·վ����Ϣ��");
		SearchLine(path,name);

	}

}
