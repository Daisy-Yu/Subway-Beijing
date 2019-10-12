package sub.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import sub.model.Result;
import sub.model.Station;

public class PrintResult {
	public String getPath(String startAddress,String endAddress) {
		StringBuffer sb = new StringBuffer();
		
		Result result = Dijkstra.value(new Station(startAddress), new Station(endAddress));
		sb.append("����վ������" + result.getPass().size()+"\n");
		sb.append("->����"+result.getPass().get(1).getLine()+"\n");
		for(int i=0;i<result.getPass().size()-1;i++) {
			sb.append(result.getPass().get(i).getSname()+"\n");
        	if(!result.getPass().get(i+1).getLine().equals(result.getPass().get(i).getLine())){
        		sb.append("->����"+result.getPass().get(i+1).getLine()+"\n");
        	}
        }
		return sb.toString();
	}
	
	public String getLine(String key) throws IOException{
		StringBuffer sb = new StringBuffer();
		String encoding="GBK";
		File file=new File("src/subway");
//		if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
		    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ
		    BufferedReader bufferedReader = new BufferedReader(read);
		    String lineTxt = null;
		    while((lineTxt = bufferedReader.readLine()) != null){
		        if(lineTxt.indexOf(key)==0) {
		            sb.append(lineTxt+"\n");
		        }
		    }
		read.close();
//		}
//		else{
//		    System.out.println("�Ҳ���ָ�����ļ�");
//		    }
//		}catch (Exception e) { 
//		      System.out.println("��ȡ�ļ����ݳ���"); 
//		      e.printStackTrace();
//		      } 
		return sb.toString();
	}

}
