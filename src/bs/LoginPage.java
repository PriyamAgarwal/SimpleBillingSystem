package bs;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;














public class LoginPage
{
  private String user;
  private String pass;
  protected JFrame frame;
  private JTextField username;
  private JPasswordField password;
  private JLabel lblClock;
  private JLabel lblClock_1;
  public Connection con = null;
  public Connection scon = null;
  
  private JLabel imgLabel;
  
  private JPasswordField passwordField;
  
  private JTextField textField;
  
  JButton create;
  
  JPanel panel_1;
  
  private JPasswordField passwordField_1;
  
  DatabaseMetaData dmd;
  private JLabel lblGstBillingSystem;
  private JLabel label_5;
  private JLabel lblJayPrakashNagar;
  private JLabel lblInternetEticketingOnline;
  private JTabbedPane tabbedPane;
  
  private void tableCheck()
  {
    try
    {
      dmd = con.getMetaData();
      ResultSet rs = dmd.getTables(null, null, "admintable", null);
      
      if (!rs.next())
      {





        String sql = "create table admintable (username varchar(50), password varchar(50))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        
        ps.close();
      }
    }
    catch (Exception localException) {}
    





    try
    {
      ResultSet rs = dmd.getTables(null, null, "cyber_customers", null);
      if (!rs.next())
      {





        String sql = "create table  cyber_CUSTOMERS  (INVOICE_NO INTEGER(10) PRIMARY KEY auto_increment, cust_name varchar(50), cust_phone varchar(30), address varchar(50),grand_total DECIMAL(10), TOTAL_ITEMS DECIMAL(7), date date, time time)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException2) {}













    

    
    try
    {
      ResultSet rs = dmd.getTables(null, null, "cyber_invoicetable", null);
      if (!rs.next())
      {





        String sql = "create table  cyber_INVOICETABLE (p_name varchar(50), p_price DECIMAL(10), P_QTY DECIMAL(5), p_DISC DECIMAL(10), p_AMT DECIMAL(10), I_NO INTEGER(10))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException3) {}

    





        
    
    
    

        




  







     




     }
  















  public void newAccount()
  {
    try
    {
      String sql = "select * from admintable";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      if (rs.next())
      {
        create.setVisible(false);
      }
      else
      {
        create.setVisible(true);
      }
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  










  public Connection sharedb()
  {
    return scon;
  }
  
  public Connection dbcon()
  {
    try
    {
      Class.forName("org.h2.Driver");
      
      con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
      

      scon = con;


    }
    catch (ClassNotFoundException e)
    {


      JOptionPane.showMessageDialog(null, "Driver Not Loaded");
      System.exit(3);

    }
    catch (SQLException c)
    {

      JOptionPane.showMessageDialog(null, "connection not  established  wrong user name or password");
      System.exit(3);
    }
    
    return con;
  }
  
  public Connection dbconcheck()
  {
    try
    {
      Class.forName("org.h2.Driver");
      
    Connection  concheck = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
      

      JOptionPane.showMessageDialog(null, "yes you can!");


    }
    catch (ClassNotFoundException e)
    {


      JOptionPane.showMessageDialog(null, "Driver Not Loaded");
      System.exit(3);

    }
    catch (SQLException c)
    {

      JOptionPane.showMessageDialog(null, "connection not  established  wrong user name or password");
      System.exit(3);
    }
    
    return con;
  }


  public void Clock()
  {
    Thread Clock = new Thread()
    {

      public void run()
      {
        try
        {
          for (;;)
          {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            lblClock_1.setText(s.format(d));
            


            SimpleDateFormat s1 = new SimpleDateFormat("hh:mm:ss a");
            lblClock.setText(s1.format(d));
            

            sleep(1000L);
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        
      }
      
    };
    Clock.start();
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoginPage window = new LoginPage();
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  



  public LoginPage()
  {
    dbcon();
    
    tableCheck();
    initialize();
    newAccount();
  }
  








  private void initialize()
  {
    frame = new JFrame();
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/archive/invoice-icon.png")));
    frame.setResizable(false);
    frame.getContentPane().setBackground(new Color(70,130,150));
    frame.setBounds(200, 100, 1000, 600);
    frame.setDefaultCloseOperation(3);
    frame.getContentPane().setLayout(null);
    
    
    JLabel lblBillilngSystem = new JLabel("CYBER  VALLEY");
    lblBillilngSystem.setHorizontalAlignment(SwingConstants.CENTER);
    lblBillilngSystem.setVerticalAlignment(SwingConstants.TOP);
    lblBillilngSystem.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(255, 255, 255), new Color(255, 255, 255)));
    lblBillilngSystem.setForeground(Color.WHITE);
    lblBillilngSystem.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
    lblBillilngSystem.setBounds(56, 162, 557, 376);
    frame.getContentPane().add(lblBillilngSystem);
    

    imgLabel = new JLabel("");
    Image img = new ImageIcon(getClass().getResource("/bs1.png")).getImage();
    imgLabel.setIcon(new ImageIcon(img));
    imgLabel.setBounds(58, 252, 552, 308);
    frame.getContentPane().add(imgLabel);
    
    lblClock = new JLabel("Clock");
    lblClock.setForeground(Color.WHITE);
    lblClock.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
    lblClock.setBounds(56, 75, 218, 45);
    frame.getContentPane().add(lblClock);
    
    lblClock_1 = new JLabel("Clock");
    lblClock_1.setForeground(Color.WHITE);
    lblClock_1.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
    lblClock_1.setBounds(56, 29, 218, 35);
    frame.getContentPane().add(lblClock_1);
    
    JPanel panel = new JPanel();
    panel.setBounds(633, 162, 295, 205);
    panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel.setBackground(new Color(70, 130, 150));
    frame.getContentPane().add(panel);
    panel.setLayout(null);
    
    passwordField_1 = new JPasswordField();
    passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    passwordField_1.setVisible(false);
    passwordField_1.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
          if (passwordField_1.getText().equals("iwant2bamsp"))
          {

            try
            {
              String query = "delete from  admintable ";
              
              PreparedStatement pst = con.prepareStatement(query);
              

              pst.execute();
              pst.close();
            }
            catch (Exception e1) {
              JOptionPane.showMessageDialog(null, e1);
            }
            



            create.setVisible(true);
          }
          
        }
        
      }
    });
    passwordField_1.setBounds(143, 180, 135, 18);
    panel.add(passwordField_1);
    
    JLabel lblAdminLogIn = new JLabel(" Log In");
    lblAdminLogIn.setHorizontalAlignment(SwingConstants.CENTER);
    lblAdminLogIn.setBounds(110, 11, 145, 40);
    panel.add(lblAdminLogIn);
    lblAdminLogIn.setForeground(Color.WHITE);
    lblAdminLogIn.setFont(new Font("Segoe Print", Font.BOLD, 30));
    

    username = new JTextField();
    username.setHorizontalAlignment(SwingConstants.LEFT);
    username.setFont(new Font("Tahoma", Font.PLAIN, 15));
    username.setBounds(106, 62, 174, 22);
    panel.add(username);
    username.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent evt)
      {

        if (evt.getKeyCode() == 10)
        {

          password.requestFocus();
        }
        
      }
    });
    username.setColumns(10);
    

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBounds(22, 64, 83, 14);
    panel.add(lblUsername);
    lblUsername.setForeground(Color.WHITE);
    lblUsername.setFont(new Font("Segoe Print", Font.BOLD, 15));
    
    password = new JPasswordField();
    password.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    		{
    			
    			
    			try
                {
                  String query = "select * from admintable where USERNAME=? and PASSWORD=?";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  pst.setString(1, username.getText());
                  pst.setString(2, password.getText());
                  ResultSet rs = pst.executeQuery();
                  if (rs.next())
                  {

                    pst.close();
                    rs.close();
                    
                   TasksRaw t = new TasksRaw();
                    
                    frame.dispose();
                    t.setVisible(true);
                  }
                  else
                  {  pst.close();
                     rs.close();
                  
                    JOptionPane.showMessageDialog(null, "wrong username or passoword");
                  }
                }
                catch (Exception e) {
                  e.printStackTrace();
                }

    			
    			
    		}
    	}
    });
    password.setFont(new Font("Tahoma", Font.PLAIN, 15));
    password.setBounds(106, 94, 174, 22);
    panel.add(password);
    password.setBackground(new Color(255,255,102));
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(24, 100, 83, 14);
    panel.add(lblPassword);
    lblPassword.setForeground(Color.WHITE);
    lblPassword.setFont(new Font("Segoe Print", Font.BOLD, 15));
    
    final JLabel forgotPassword = new JLabel("Forgot password?");
    forgotPassword.setBounds(170, 160, 110, 17);
    panel.add(forgotPassword);
    forgotPassword.setForeground(Color.WHITE);
    forgotPassword.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent arg0)
      {
        forgotPassword.setForeground(Color.YELLOW);
      }
      

      public void mouseExited(MouseEvent e)
      {
        forgotPassword.setForeground(Color.WHITE);
      }
      

      public void mouseClicked(MouseEvent e)
      {
        passwordField_1.setVisible(true);
        passwordField_1.requestFocus();
      }
      
    });
    forgotPassword.setBackground(Color.DARK_GRAY);
    forgotPassword.setFont(new Font("Segoe Print", Font.PLAIN, 12));
    
    JButton btnNewButton = new JButton("Admin");
    btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		try
            {
              String query = "select * from admintable where USERNAME=? and PASSWORD=?";
              
              PreparedStatement pst = con.prepareStatement(query);
              pst.setString(1, username.getText());
              pst.setString(2, password.getText());
              ResultSet rs = pst.executeQuery();
              if (rs.next())
              {

                pst.close();
                rs.close();
                
               TasksRaw t = new TasksRaw();
                
                frame.dispose();
                t.setVisible(true);
              }
              else
              {  pst.close();
                 rs.close();
              
                JOptionPane.showMessageDialog(null, "wrong username or passoword");
              }
            }
            catch (Exception e) {
              e.printStackTrace();
            }

    	}
    });
    btnNewButton.setBackground(new Color(70,130,150));
    btnNewButton.setForeground(Color.WHITE);
    btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 11));
    btnNewButton.setBounds(210, 127, 70, 23);
    panel.add(btnNewButton);
    
    
    
    
    
    create = new JButton("Create New Account");
    create.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    create.setBackground(new Color(70,130,150));
    create.setForeground(Color.WHITE);
    create.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
        panel_1.setVisible(true);
        textField.requestFocus();
      }
      
    });
    create.setFont(new Font("Segoe Print", Font.BOLD, 14));
    create.setBounds(715, 411, 165, 23);
    create.setVisible(false);
    frame.getContentPane().add(create);
    
    panel_1 = new JPanel();
    panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_1.setBackground(new Color(70, 130, 150));
    panel_1.setBounds(633, 445, 299, 100);
    frame.getContentPane().add(panel_1);
    panel_1.setLayout(null);
    panel_1.setVisible(false);
    
    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    passwordField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10)
        {
          try
          {
            String query = "INSERT INTO  admintable (username, password) values (?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, textField.getText());
            pst.setString(2, passwordField.getText());
            
            pst.execute();
            pst.close();
            

            JOptionPane.showMessageDialog(null, "USER CREATED!");
            panel_1.setVisible(false);
            create.setVisible(false);
            passwordField_1.setVisible(false);
            passwordField_1.setText("");
            textField.setText("");
            passwordField.setText("");
          }
          catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);

          }
          
        }
        
      }
      

    });
    passwordField.setBounds(129, 57, 136, 22);
    panel_1.add(passwordField);
    
    textField = new JTextField();
    textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    textField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {

          passwordField.requestFocus();
        }
        
      }
      
    });
    textField.setColumns(10);
    textField.setBounds(129, 26, 136, 22);
    panel_1.add(textField);
    
    JLabel label = new JLabel("Username");
    label.setForeground(Color.WHITE);
    label.setFont(new Font("Segoe Print", Font.BOLD, 15));
    label.setBounds(24, 27, 83, 14);
    panel_1.add(label);
    
    JLabel label_1 = new JLabel("Password");
    label_1.setForeground(Color.WHITE);
    label_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    label_1.setBounds(24, 63, 83, 14);
    panel_1.add(label_1);
    
    lblGstBillingSystem = new JLabel("      Billing System");
    lblGstBillingSystem.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
    lblGstBillingSystem.setForeground(Color.WHITE);
    lblGstBillingSystem.setFont(new Font("Segoe Print", Font.BOLD, 55));
    lblGstBillingSystem.setBounds(405, 6, 547, 88);
    frame.getContentPane().add(lblGstBillingSystem);
    
    label_5 = new JLabel("Created by: MD ZEYAUR RAHMAN");
    label_5.setForeground(Color.WHITE);
    label_5.setFont(new Font("Segoe Print", Font.BOLD, 16));
    label_5.setBorder(null);
    label_5.setBounds(643, 91, 289, 23);
    frame.getContentPane().add(label_5);
    
    lblJayPrakashNagar = new JLabel("Jay Prakash Nagar, Nala Road, Khagaria.");
    lblJayPrakashNagar.setHorizontalAlignment(SwingConstants.RIGHT);
    lblJayPrakashNagar.setForeground(Color.WHITE);
    lblJayPrakashNagar.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblJayPrakashNagar.setBounds(156, 220, 360, 29);
    frame.getContentPane().add(lblJayPrakashNagar);
    
    lblInternetEticketingOnline = new JLabel("INTERNET, e-Ticketing, Online Form Filling ,etc.");
    lblInternetEticketingOnline.setHorizontalAlignment(SwingConstants.RIGHT);
    lblInternetEticketingOnline.setForeground(Color.WHITE);
    lblInternetEticketingOnline.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
    lblInternetEticketingOnline.setBounds(92, 203, 461, 29);
    frame.getContentPane().add(lblInternetEticketingOnline);
    
    JButton btnNewButton_1 = new JButton("New button");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		String[] nam= new String[10];
    		nam[0]="hi there";
    		nam[1]="pagle";
    		JOptionPane x=new JOptionPane();
    		JList jl;
    		x.setMessage(jl=new JList(nam));
    	//	x.setMessage(Arrays.toString(nam));
    		
    		x.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    		JDialog dl=x.createDialog(null, "Associated Names!");
    		dl.setVisible(true); 
    		//JOptionPane.showMessageDialog(null, );
    		 String myString =   (String) jl.getSelectedValue();
    		 JOptionPane.showMessageDialog(null, myString);
    	}
    });
    btnNewButton_1.setBounds(338, 128, 89, 23);
    frame.getContentPane().add(btnNewButton_1);
    
    
    
    Clock();
  }
}
