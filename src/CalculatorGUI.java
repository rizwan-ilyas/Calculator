
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI {

    JFrame frame;
    Image icon;
    JPanel txtPanel,btnPanel,cls;
    JTextField upperTxt,lowerTxt;
    JButton[] btns;
    JButton backbtn,clearbtn,signbtn;
    String[] symbols={"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"};
    CalculatorHandler cal_handle;
    public CalculatorGUI() {
        init();
    }
    
    
    @SuppressWarnings("empty-statement")
    public void init(){
        frame=new JFrame("Calculator");
        icon=Toolkit.getDefaultToolkit().getImage(getClass().getResource("abcuss.png"));
        frame.setIconImage(icon);
        
        frame.setLayout(new BorderLayout());
        txtPanel =new JPanel();
        txtPanel.setLayout(new GridLayout(2,1,0,0));
        btnPanel=new JPanel();
        btnPanel.setLayout(new GridLayout(4, 5));
        upperTxt=new JTextField(15);
        upperTxt.setEditable(false);
        upperTxt.setBorder(null);
        upperTxt.setMargin(new Insets(20, 20, 20, 20));
        lowerTxt=new JTextField(15);
        lowerTxt.setPreferredSize(new Dimension(50, 20));
        //System.out.println(Toolkit.getDefaultToolkit().getFontList());
        Font font1 = new Font("Monospaced", Font.BOLD, 20);
        lowerTxt.setFont(font1);
        lowerTxt.setEditable(false);
        lowerTxt.setBorder(null);
        //lowerTxt.setFont(Font.getFont("Verdana"));
        
        btns=new JButton[16];
        cal_handle =new CalculatorHandler(this);
        
      
        
       
        
        for (int i = 0; i < 16; i++) {
            btns[i]=new JButton(symbols[i]);
            btns[i].setSize(30,30);
            btns[i].setBackground(Color.white);
            btns[i].addActionListener(cal_handle);
            btns[i].setMargin(new Insets(7, 7, 7, 7));
            btnPanel.add(btns[i]);
            
        }
        cls=new JPanel();
        cls.setLayout(new GridLayout(3, 1));
        backbtn=new JButton("<-");
        clearbtn=new JButton("C");
        signbtn=new JButton("+/-");
        cls.add(backbtn);
        cls.add(clearbtn);
        cls.add(signbtn);
        txtPanel.setSize(100, 110);
        txtPanel.add(upperTxt);
        txtPanel.add(lowerTxt);
        
        backbtn.setSize(20, 20);
        backbtn.addActionListener(cal_handle);
        clearbtn.addActionListener(cal_handle);
        signbtn.addActionListener(cal_handle);
        //txtPanel.add(backbtn);
        btnPanel.setBackground(new Color(230, 230, 230));
        txtPanel.setBackground(new Color(230, 230, 230));
        frame.setSize(250, 300);
        
        frame.add(txtPanel,BorderLayout.NORTH);
        frame.add(btnPanel,BorderLayout.CENTER);
        frame.add(cls,BorderLayout.LINE_END);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    
    
    
}
