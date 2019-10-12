package sub.jframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sub.model.Data;
import sub.model.Station;

import sub.core.PrintResult;

public class MainWindow extends JFrame {
	
	JTextArea result, jta1, jta2;
	JPanel jp1, jp2;
	JTextField jtf1, jtf2, jtf3;
	JScrollPane jsp1, jsp2;
	JTabbedPane jtp;
	JLabel jl1, jl2, jl3;
	JButton jb1, jb2;
	
	public MainWindow() {
		super("����������ѯϵͳ");
		this.setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		addComponent();
		setVisible(true);
		setLocationRelativeTo(null);// �������ʾ;
	}
	
	public void addComponent() {
		// ���һ
		jp1 = new JPanel(new BorderLayout());
		jl1 = new JLabel("������ʼվ�㣺");
		jtf1 = new JTextField(14);
		jl2 = new JLabel("�������վ�㣺");
		jtf2 = new JTextField(14);
		jb1 = new JButton("��ѯ");
		jta1 = new JTextArea(20, 60);
		jsp1 = new JScrollPane(jta1);
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String startAddress = jtf1.getText().trim();
				String endAddress = jtf2.getText().trim();
				if(startAddress.equals(endAddress)) {
					JOptionPane.showMessageDialog(null, "��ʼվ�������վ����ͬ", "����",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int flag=1;
				for(List<Station> l:Data.lineSet) {
					for(int i=0;i<l.size();i++) {
						if(l.get(i).getSname().equals(startAddress)&&l.get(i).getSname().equals(endAddress)) {
							flag=0;
						}	
					}
				}
				if(flag==1) {
					JOptionPane.showMessageDialog(null, "վ�㲻����", "����",JOptionPane.ERROR_MESSAGE);
			        return;
				}	
				String resultStr = "";
				boolean iscontinue=false;
				if(!iscontinue){
					PrintResult pr = new PrintResult();
					resultStr = pr.getPath(startAddress, endAddress);
				}
				
				jta1.setText(resultStr);
			}
		});
		
		JPanel jp3 = new JPanel(new FlowLayout());

		jp3.add(jl1);
		jp3.add(jtf1);
		jp3.add(jl2);
		jp3.add(jtf2);
		jp3.add(jb1);
		jp1.add(jp3, "North");
		jp1.add(jsp1, "Center");
		
		// ����
		jp2 = new JPanel(new BorderLayout());
		
		jl3 = new JLabel("������·���ƣ�");
		jtf3 = new JTextField(10);
		jb2 = new JButton("��ѯ");
		jta2 = new JTextArea(20, 60);
		jsp2 = new JScrollPane(jta2);
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String line = jtf3.getText().trim();
				for(int i=0;i<Data.lineSet.size();i++) {
					if(!Data.lineSet.contains(line)) {
						JOptionPane.showMessageDialog(null, "��·������", "����",JOptionPane.ERROR_MESSAGE);
						return;
					}			
				}
				String resultStr = "";
				boolean iscontinue=false;
				if(!iscontinue){
					PrintResult pr = new PrintResult();
					try {
						resultStr = pr.getLine(line);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				jta2.setText(resultStr);
			}
		});
		
		JPanel jp4 = new JPanel(new FlowLayout());
		
		jp4.add(jl3);
		jp4.add(jtf3);
		jp4.add(jb2);
		jp2.add(jp4, "North");
		jp2.add(jsp2, "Center");

		result = new JTextArea(20, 60);
		jsp1 = new JScrollPane(result);
		jsp2 = new JScrollPane(result);

		jtp = new JTabbedPane();
		jtp.addTab("���·�߲�ѯ", jp1);
		jtp.addTab("��·վ���ѯ", jp2);

		add(jtp);
	}
	
	public static void main(String[] args) {
		Data.readData("src/subway");
		new MainWindow();
	}

}
