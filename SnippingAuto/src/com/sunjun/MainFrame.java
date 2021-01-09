package com.sunjun;

import java.awt.EventQueue;
import java.awt.RadialGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.naming.ldap.StartTlsRequest;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyListener;
 
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 5707722022801012830L;
	private JPanel contentPane;
    private JTextField textField;
    private JTextField textSN;
    private JTextField textMachine;
    private JTextField textLine;
    private JButton btnJietu;
    private JList listBox;
    private DefaultListModel dlm;
    private DefaultListModel listModel;
    private String[] strArr1= {"1PL21312312_Q12_V810-3325S2EX"};
    List<String> list2 = new ArrayList<>();
    private JTextField textParthPath;
    
    private JRadioButton btnRad1;
    private JRadioButton btnRad2;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    public MainFrame() {
    	this.setTitle("截图自动V1.0.0 Java版 20201208");
    	this.setAlwaysOnTop(true); 
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100,240, 263);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
 
        JLabel label = new JLabel("监控路径：");
        label.setBounds(8, 310, 65, 15);
        contentPane.add(label);
 
        textField = new JTextField("C:/ClassifiedDefects/data/");
        textField.setBounds(8, 340, 219, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
       
        JLabel lbl1=new JLabel("机编:");
        lbl1.setBounds(2, 2, 30,24);
        contentPane.add(lbl1);
        
        textMachine=new JTextField("V810-3325S2EX");
        textMachine.setBounds(38, 2, 100, 24);
        contentPane.add(textMachine);
        
        
        JLabel lbl2=new JLabel("Line");
        lbl2.setBounds(140, 2, 30,24);
        contentPane.add(lbl2);
        //B92960493028400A
        //QSA104800038K46386-402
        textSN=new JTextField("QSA104800038K46386-402");
        textSN.setBounds(5, 32, 130, 24);
        contentPane.add(textSN);
        
        textLine=new JTextField("R12");
        textLine.setBounds(170, 2, 40, 27);
        contentPane.add(textLine);
 
        btnJietu=new JButton("截图");
        btnJietu.setBounds(140, 32, 70, 55);
        contentPane.add(btnJietu);
        
        
       listModel = new DefaultListModel();
       listBox=new JList<>(listModel);
        JScrollPane jsp=new JScrollPane(listBox);
        jsp.setBounds(5, 100, 210,80);
       // jsp.setAutoscrolls(true);
        contentPane.add(jsp);
        JButton button = new JButton("开始监控");
        button.setEnabled(false);
        JLabel lbl3=new JLabel("站在巨人的肩膀上");
        lbl3.setBounds(8, 185, 170, 26);
        contentPane.add(lbl3);
        JLabel lbl4=new JLabel("存储路径");
        lbl4.setBounds(8, 245, 70, 26);
        contentPane.add(lbl4);
        btnRad1=new JRadioButton("120.75");
        btnRad1.setBounds(80, 245, 70, 26);
        contentPane.add(btnRad1);
        
		btnRad2=new JRadioButton("16");
		btnRad2.setBounds(160, 245, 70, 26);
		contentPane.add(btnRad2);
		textParthPath=new JTextField("\\\\172.26.120.75\\aoiaxi\\AXI\\5DX\\5DX不良");
		textParthPath.setBounds(8, 272, 270, 26);
		contentPane.add(textParthPath);
		JButton btnClearButton=new JButton("重置");
        btnClearButton.setBounds(155,185,60,24);
        contentPane.add(btnClearButton);
        btnRad1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textParthPath.setText("\\\\172.26.120.75\\aoiaxi\\AXI\\5DX\\5DX不良");
				btnRad1.setSelected(true);
				btnRad2.setSelected(false);
			}
		});
        
       btnRad2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textParthPath.setText("\\\\172.26.12.16\\aoi\\5DX\\5DX不良");
				btnRad1.setSelected(false);
				btnRad2.setSelected(true);
			}
		});
        
        btnClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list2.clear();
				String[] newArr1= {};
				listBox.setListData(newArr1);
			}
		});
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addWatch();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        button.setBounds(230, 340, 93, 23);
        contentPane.add(button);
        btnJietu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			     snipping();
			}
		});
        listBox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    String str = list.getSelectedValue().toString();
                    //System.out.println(string);
                    saveImageAndDelay(str.split("_")[0], str.split("_")[1],str.split("_")[2]);
                   
                
                } else if (evt.getClickCount() == 3) {
                    int index = list.locationToIndex(evt.getPoint());
                }
            }
        });
        
        listBox.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String selectedValue = listBox.getSelectedValue().toString();
			    //System.out.println(selectedValue);
				textSN.setText(selectedValue.split("_")[0]);
				textLine.setText(selectedValue.split("_")[1]);
				textMachine.setText(selectedValue.split("_")[2]);
			}
		});
        createFolder();
        try {
            addWatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //ClassifiedDefects
    

	/**
	 * 通用的公共方法截图方法
	 * 
	 * @param parentPath
	 * @param snNum
	 * @param lineStr
	 * @return
	 */

	private void saveImageAndDelay(String snNum, String lineStr,String machineStr) {
		String parentPath = textParthPath.getText();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String formatStr = df.format(new Date());
		Date date1;
		Random random = new Random();
    	int nextInt = random.nextInt(99);
		try {
			date1 = df.parse(formatStr);
			Date date2 = df.parse("20:00:00");
			boolean flag = date1.getTime() >= date2.getTime();
			//System.out.println(flag);
			// false 创建当天的文件夹
			// true 创建第二天的文件夹
			if (flag) {
				try {
					Calendar c = Calendar.getInstance();
					c.setTime(new Date());
					c.add(c.DATE, 1);
					Date tommTime = c.getTime();
					SimpleDateFormat sf3 = new SimpleDateFormat("MMdd");
					String tommTimeformat = sf3.format(tommTime);
					String basePath = parentPath + "\\" + lineStr + "\\" + tommTimeformat;
					File file = new File(basePath);
					if (!file.exists()) {
						file.mkdirs();
					}
				
					this.setVisible(false);
			    	try {
						Thread.sleep(260);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			        CaptionScreenUtil.screenShotAsFile(100, 40, 1820, 975,basePath, snNum+"__" + machineStr +"__" +String.valueOf(nextInt)+"J", "jpg");
			    	this.setVisible(true);
					WriteSnUtil.WriteSnToServer(basePath,snNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					String timePath = new SimpleDateFormat("MMdd").format(new Date());
					String basePath = parentPath + "\\" + lineStr + "\\" + timePath;
					File file = new File(basePath);
					if (!file.exists()) {
						file.mkdirs();
					}
					this.setVisible(false);
			    	try {
						Thread.sleep(260);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					CaptionScreenUtil.screenShotAsFile(100, 40, 1820, 975, basePath, snNum+"__" + machineStr + "__" +String.valueOf(nextInt)+"J", "jpg");
					this.setVisible(true);
					WriteSnUtil.WriteSnToServer(basePath,snNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
    
    
    
    private void snipping() {
    	if(textSN.getText().equals("") || textLine.getText().equals("") || textMachine.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "确保输入框有值", "警告", JOptionPane.ERROR_MESSAGE);
    	  return;
    	}
        saveImageAndDelay(textSN.getText().toUpperCase(),textLine.getText(),textMachine.getText());
    }
    
    private void createFolder() {
    	File f2 =new File("C:\\ClassifiedDefects\\data");
    	if(!f2.exists()) {
    		f2.mkdirs();
    	}
    }
    
    public void addWatch() throws Exception {
        String path = textField.getText();
        int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED
                | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
        boolean watchSubtree = true;
        //添加文件监听
        int watchID = JNotify.addWatch(path, mask, watchSubtree, new Listener());
    }
    class Listener implements JNotifyListener {
        public void fileRenamed(int wd, String rootPath, String oldName,
                String newName) {
        }
        public void fileModified(int wd, String rootPath, String name) {
        }
        public void fileDeleted(int wd, String rootPath, String name) {
        }
        public void fileCreated(int wd, String rootPath, String name) {
          
            if(name.contains("BoardStatus.txt")) 
            {
            	String path = "C:\\ClassifiedDefects\\data\\" + name;
            	String[] strArr = path.split("\\\\");
            	/*for (String string : strArr) {
					System.out.println(string);
				}
            	*/
            	//V810-8085S2[@$@]2020-12-04-21-57-15
            	String t = strArr[3].substring(0,strArr[3].indexOf("["));
            	String mLStr="";
            	if(t.equals("V810-3325S2EX")) {
            		textLine.setText("Q12");
            		mLStr="Q12" +"_" +"V810-3325S2EX";
            	}
            	if(t.equals("V810-3327S2EX")) {
            		textLine.setText("I12");
            		mLStr="I12" +"_" +"V810-3327S2EX";
            	}
            	if(t.equals("V810-3323S2EX")) {
            		textLine.setText("I22");
            		mLStr="I22" +"_" +"V810-3323S2EX";
            	}
            	if(t.equals("V810-3328S2EX")) {
            		textLine.setText("H12");
            		mLStr="H12" +"_" +"V810-3328S2EX";
            	}
            	if(t.equals("V810-8096S2")) {
            		textLine.setText("J12");
            		mLStr="J12" +"_" +"V810-8096S2";
            	}
            	if(t.equals("V810-8085S2")) {
            		textLine.setText("K12");
            		mLStr="K12" +"_" +"V810-8085S2";
            	}
            	if(t.equals("V810-8070S2")) {
            		textLine.setText("K22");
            		mLStr="K22" +"_" +"V810-8070S2";
            	}
            	if(t.equals("V810-8064S2")) {
            		textLine.setText("L12");
            		mLStr="L12" +"_" +"V810-8064S2";
            	}
            	if(t.equals("V810-8057S2")) {
            		textLine.setText("L22");
            		mLStr="L22" +"_" +"V810-8057S2";
            	}
            	if(t.equals("V810-8086S2")) {
            		textLine.setText("P12");
            		mLStr="P12" +"_" +"V810-8086S2";
            	}
            	textMachine.setText(t);
            	File file = new File(path);
            	BufferedReader reader = null;
            	try {
					Thread.sleep(400);
					reader = new BufferedReader(new FileReader(file));
					String tempStr;
					tempStr = reader.readLine();
					String upperCaseSn = tempStr.split(";")[1].toUpperCase().trim();
					textSN.setText(upperCaseSn);
					reader.close();
					List<String> list1=Arrays.asList(strArr1);
					list2.add(upperCaseSn+"_"+mLStr);
					List<String> titleList = new ArrayList<String>();
					 titleList.addAll(list1);
					 titleList.addAll(list2);
					 String[] newArr = titleList.toArray(new String[titleList.size()]);
					 Collections.reverse(Arrays.asList(newArr));
					 listBox.setListData(newArr);
					 WriteSnUtil.writeSn(upperCaseSn+"_"+mLStr);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
