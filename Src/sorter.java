///RUN THIS 
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 
  sorter extends JFrame implements ActionListener, Runnable, KeyListener,MouseListener, MouseMotionListener{ 
  MyDrawPanel drawpanel1;  
  JPanel panel,panel2;
  JTextField enter;
  JLabel go;
  JButton choose,sort,delay;
  Font f1 = new Font("Cambria", Font.BOLD,24);
  long start,end,fina,fina2,fina3,fina4;
  long start2,end2;
  long start3,end3;
  long start4,end4;
  line box1[];
  int xx=0;
  int comp1=0,comp2=0,comp3=0,comp4=0;
  int mx,my;
  line box2[];  
  line box3[];
  int checker=0;
  line box4[];
  int value=0;
  int b[],cc[];
  int swaps1=0,time1=0;
  int swaps2=0,time2=0;
  int swaps3=0,time3=0;
  int swaps4=0,time4=0;
  String nanon="";
  BufferedImage info=null;
  boolean showlines=false,starter=false;
  int a;
  int bb;
  int ccc;
  int gg;
  int zzz=1;

  
  
  Thread th = new Thread (this); 
  
  public static void main(String[ ] args)   
  {
    new sorter();
  }  
  
  public sorter(){
        try {info=ImageIO.read(new File("PICPIC.png"));    
        }catch(IOException e){}
    
    
    
    
    
    
    
    addKeyListener(this);    
    this.setLayout(new BorderLayout(10,10));
    panel=new JPanel();
    this.setBackground(Color.BLACK);
    
    panel.setLayout(new GridLayout(1,5));
    
    go=new JLabel("# OF LINES",JLabel.CENTER);
    go.setFont(f1);
    go.setBackground(Color.WHITE);
    go.setOpaque(true);
    go.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
    panel.add(go); 
    
    
    enter= new JTextField();
    enter.setBounds(0,0,10,20);
    enter.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
    panel.add(enter);
    
    choose= new JButton("GO");
    choose.setFont(f1);
    choose.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
    choose.addActionListener(this);
    choose.setBackground(Color.WHITE);
    panel.add(choose);
    
    sort= new JButton("SORT");
    sort.setFont(f1);
    sort.setEnabled(false);
    sort.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
    sort.addActionListener(this);
    sort.setBackground(Color.WHITE);   
    panel.add(sort);
    
        
    delay= new JButton("DELAY ON");
    delay.setFont(f1);
    delay.setEnabled(true);
    delay.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
    delay.addActionListener(this);
    delay.setBackground(Color.WHITE);   
    panel.add(delay);
    
    
    
    
    
    drawpanel1=new MyDrawPanel();    
    th.start();
    th2.start();
    th3.start();
    th4.start();
    addMouseMotionListener(this);
    addMouseListener(this);
    this.add(panel);
    this.setSize(2000,800);
    this.setVisible(true);  
    this.add (drawpanel1);
    
    this.add(panel,BorderLayout.NORTH);
    
    
    
    
    
  } 
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      Font f1= new Font("OCR A Extended", Font.BOLD,20);
      g2.setFont(f1);
      g2.setColor(Color.BLACK);
      g2.fillRect(0,0,2000,2000);
   
      if (showlines==true){
        
        for (int c=0;c<value;c++){
          g2.setColor(Color.WHITE);
          g2.fillRect(box1[c].posx,box1[c].posy,box1[c].width,box1[c].lenght);
          g2.fillRect(box2[c].posx,box2[c].posy,box2[c].width,box2[c].lenght);
          g2.fillRect(box3[c].posx,box3[c].posy,box3[c].width,box3[c].lenght);
          g2.fillRect(box4[c].posx,box4[c].posy,box4[c].width,box4[c].lenght);
          
          
        }
      }
      
      if (checker==1){
         g2.setColor(Color.WHITE);
        g2.fillRect(mx-5,my-45,450,110);
        g2.setColor(Color.yellow);
        g2.fillRect(mx,my-40,440,100);
        g2.setColor(Color.black);
        g2.drawString("SELECTION SORT:",mx+10,my-10);
        g2.drawString("Swaps "+swaps1,mx+10,my+30);
        g2.drawString("TIME: "+fina+" "+nanon+"seconds",mx+10,my+10);
        
      }
      if (checker==2){
        g2.setColor(Color.WHITE);
        g2.fillRect(mx-5,my-45,450,110); 
        g2.setColor(Color.CYAN);
        g2.fillRect(mx,my-40,440,100);
        g2.setColor(Color.black);
        g2.drawString("BUBBLE SORT:",mx+10,my-10); 
        g2.drawString("Swaps "+swaps2,mx+10,my+30);    
        g2.drawString("TIME: "+fina2+" "+nanon+"seconds",mx+10,my+10);
      } 
      if (checker==3){
         g2.setColor(Color.WHITE);
        g2.fillRect(mx-5,my-45,450,110);
        g2.setColor(Color.GREEN);
        g2.fillRect(mx,my-40,440,100);
        g2.setColor(Color.black);
        g2.drawString("INSERTION SORT:",mx+10,my-10);
        g2.drawString("Swaps "+swaps3,mx+10,my+30);    
        g2.drawString("TIME: "+fina3+" "+nanon+"seconds",mx+10,my+10);
      }
      if (checker==4){
         g2.setColor(Color.WHITE);
        g2.fillRect(mx-5,my-45,450,110);
        g2.setColor(Color.PINK);
        g2.fillRect(mx,my-40,440,100);
        g2.setColor(Color.black);
        g2.drawString("Q SORT:",mx+10,my-10);     
        g2.drawString("Swaps "+swaps4,mx+10,my+30);    
        g2.drawString("TIME: "+fina4+" "+nanon+"seconds",mx+10,my+10);
      }
      
       g2.drawImage(info,900,100,390,513,null);
    }
      
  }
  public void actionPerformed(ActionEvent e)
  {
        if(e.getSource()==delay)
    {
          if (zzz==1){
          zzz=0;
           delay.setText("DELAY OFF");
          
          
          }
          else if (zzz==0){
           zzz=1;
           delay.setText("DELAY ON");
          
          
          }
          
          
        }
    if(e.getSource()==choose)
    {
      value= Integer.parseInt(enter.getText());
      makeboxes(value);
      swaps1=0;time1=0;
      swaps2=0;time2=0;
      swaps3=0;time3=0;
      swaps4=0;time4=0;
      start=0;
      end=0;
      fina=0;
      fina2=0;
      fina3=0;
      fina4=0;
      start2=0;
      end2=0;
      start3=0;
      end3=0;
      start4=0;
      end4=0;
      starter=false;
      choose.setEnabled(false);
      sort.setEnabled(true);
      delay.setEnabled(false);
    } 
    if(e.getSource()==sort)
    {
      if (zzz==1){
        a=5;
        bb=0;
       ccc=0;
       gg=1000000000;
       nanon="";
      starter=true;
      }
      else if (zzz==0){
       a=0;
       bb=0;
       ccc=0;
      gg=1;
       nanon="nano";
      start1();
      start2();
      start3();
      start4();
      
      }
      }
      
  }
  public void start1(){
          start= System.nanoTime();
        int lowest,lowpos,temp;
        for (int n=0;n<value;n++){
          lowest=box1[n].lenght;
          lowpos=n;
          long ender= System.nanoTime();
          fina=(ender-start);
          repaint();
          for (int m=n+1;m<value;m++){
            if (box1[m].lenght<lowest){
              comp1+=1;
              lowest=box1[m].lenght;
              lowpos=m;
              
            }
          }
          temp=box1[n].lenght;
          box1[n].lenght=box1[lowpos].lenght;
          swaps1+=1;
          repaint();
          box1[lowpos].lenght=temp;
          
        }
        end= System.nanoTime();
        fina=(end-start);
  }
  public void start2(){
            start2= System.nanoTime();
          int flag,temp;
          for (int m=value-1;m>=1;m--){
            long ender= System.nanoTime();
            fina2=(ender-start2);
            repaint();
            flag=0;
            for (int n=0;n<m;n++){
              if (box2[n+1].lenght<box2[n].lenght){
                temp=box2[n+1].lenght;
                box2[n+1].lenght=box2[n].lenght;
                swaps2+=1;
                box2[n].lenght=temp;
                flag=1;
              }
            }
            
            if (flag==0){
              m=0;
            }
            end2= System.nanoTime();
            fina2=(end2-start2); 
          }
         
  }
  
  public void start3(){
          start3= System.nanoTime();
          int flag;
          b[0]=cc[0];
          for (int m=1;m<value;m++){
            long ender= System.nanoTime();
            fina3=(ender-start3);
            flag=0;          
            for (int n=0;n<m;n++){
              
              if (cc[m]<b[n]){
                swaps3+=1;
                flag=1;
                for (int o=m;o>n;o--){
                  b[o]=b[o-1];
                }
                b[n]=cc[m];
                n=m;
              }
            }
            if (flag==0){
              b[m]=cc[m];
              swaps3+=1;
            }
            for (int mm=0;mm<m;mm++){
              box3[mm].lenght=b[mm];
              repaint();
              
              
            }
            end3= System.nanoTime();
            fina3=(end3-start3); 
          }
          
          starter=false;
          choose.setEnabled(true);
          sort.setEnabled(false);
          delay.setEnabled(true);
  }
  public void start4(){
     start4= System.nanoTime();
     int start1=0;
     qsort(cc,0,value-1);  
  }
  
  
  
  public void run () 
  {  
    Thread.currentThread().setPriority(Thread.MIN_PRIORITY); 
    
    
    while (true) 
    { 
      if (starter==true){
        start= System.nanoTime();
        int lowest,lowpos,temp;
        for (int n=0;n<value;n++){
          lowest=box1[n].lenght;
          lowpos=n;
          long ender= System.nanoTime();
          fina=(ender-start)/1000000000;
          repaint();
          try        
          {
            Thread.sleep(a);
          } 
          catch(InterruptedException ex) 
          {
            Thread.currentThread().interrupt();
          }
          for (int m=n+1;m<value;m++){
            if (box1[m].lenght<lowest){
              comp1+=1;
              lowest=box1[m].lenght;
              lowpos=m;
              
            }
          }
          temp=box1[n].lenght;
          box1[n].lenght=box1[lowpos].lenght;
          swaps1+=1;
          repaint();
          box1[lowpos].lenght=temp;
          
        }
        end= System.nanoTime();
        fina=(end-start)/1000000000;
      }
      repaint();
      
      try 
      {  
        Thread.sleep (bb); 
      } 
      catch (InterruptedException ex) 
      {  
      } 
      
      Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
    }
  } 
  
  ////////////////////////////////////////////////////////////////////
  
  Thread th2= new Thread(){ 
    public void run()
    {
      while (true) 
      { 
        
        if (starter==true){
          start2= System.nanoTime();
          int flag,temp;
          for (int m=value-1;m>=1;m--){
            long ender= System.nanoTime();
            fina2=(ender-start2)/1000000000;
            repaint();
            try        
            {
              Thread.sleep(a);
            } 
            catch(InterruptedException ex) 
            {
              Thread.currentThread().interrupt();
            }
            
            flag=0;
            for (int n=0;n<m;n++){
              if (box2[n+1].lenght<box2[n].lenght){
                temp=box2[n+1].lenght;
                box2[n+1].lenght=box2[n].lenght;
                swaps2+=1;
                box2[n].lenght=temp;
                flag=1;
              }
            }
            
            if (flag==0){
              m=0;
            }
            end2= System.nanoTime();
            fina2=(end2-start2)/1000000000; 
          }
          
          
          
          
          
          
          
          
        }
        repaint();
        
        try 
        {  
          Thread.sleep (bb); 
        } 
        catch (InterruptedException ex) 
        {  
        } 
        
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
      }
    }
  };
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////
  Thread th3= new Thread(){ 
    public void run()
    {
      while (true) 
      { 
        
        if (starter==true){
          start3= System.nanoTime();
          int flag;
          b[0]=cc[0];
          for (int m=1;m<value;m++){
            long ender= System.nanoTime();
            fina3=(ender-start3)/1000000000;
            flag=0;
            try        
            {
              Thread.sleep(a);
            } 
            catch(InterruptedException ex) 
            {
              Thread.currentThread().interrupt();
            }
            
            for (int n=0;n<m;n++){
              
              if (cc[m]<b[n]){
                swaps3+=1;
                flag=1;
                for (int o=m;o>n;o--){
                  b[o]=b[o-1];
                }
                b[n]=cc[m];
                n=m;
              }
            }
            if (flag==0){
              b[m]=cc[m];
              swaps3+=1;
            }
            for (int mm=0;mm<m;mm++){
              box3[mm].lenght=b[mm];
              repaint();
              
              
            }
            end3= System.nanoTime();
            fina3=(end3-start3)/1000000000; 
          }
          
          starter=false;
          choose.setEnabled(true);
          sort.setEnabled(false);
          delay.setEnabled(true);
        }
        
        repaint();
        
        try 
        {  
          Thread.sleep (bb); 
        } 
        catch (InterruptedException ex) 
        {  
        } 
        
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
      }
    }
  };
  Thread th4= new Thread(){ 
    public void run()
    {
      while (true) 
      { 
        start4= System.nanoTime();
        if (starter==true){
          int start1=0;
          qsort(cc,0,value-1);  
          
          
          
          
        }
        
        repaint();
        
        try 
        {  
          Thread.sleep (20); 
        } 
        catch (InterruptedException ex) 
        {  
        } 
        
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
      }
    }
  };
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  public void makeboxes(int z){  
    box1= new line [z]; 
    box2= new line [z];
    box3= new line [z];
    box4= new line [z];
    b= new int [z];
    cc= new int [z];
    createlines(z);
  }
  public void createlines(int a){ 
    int posx1=0,posy1=200;
    int posx2=0,posy2=300;
    int posx3=0,posy3=400;
    int posx4=0,posy4=500;
    xx=0;
    for (int z=0;z<a;z++){
      box1[z]= new line();
      box2[z]= new line();
      box3[z]= new line();
      box4[z]= new line();
      int load=(int)(Math.random()*50)+1;
      cc[z]=load;
      box1[z].setupline(posx1+xx,posy1,load);
      box2[z].setupline(posx2+xx,posy2,load);
      box3[z].setupline(posx3+xx,posy3,load);
      box4[z].setupline(posx4+xx,posy4,load);
      xx+=1;
    } 
    showlines=true;
    
  }
  
  public void keyReleased (KeyEvent e){
    int code =e.getKeyCode();
    if (code == KeyEvent.VK_W)   
    { 
    }
  }
  public void keyTyped(KeyEvent e){}  
  public void keyPressed (KeyEvent e)
  {
    int code =e.getKeyCode(); 
    if (code == KeyEvent.VK_W)   
    { 
    }
  } 
  public void mouseClicked(MouseEvent me){}
  public void mouseEntered(MouseEvent me){}
  public void mouseExited(MouseEvent me){}
  public void mousePressed(MouseEvent me){ }
  public void mouseReleased(MouseEvent me){}
  public void mouseDragged(MouseEvent me){}
  public void mouseMoved(MouseEvent me){
    int ymouse=me.getY();
    int xmouse=me.getX();
    mx=me.getX();
    my=me.getY();
    if (xmouse>=0 && xmouse<=xx && ymouse>=290){
      if (ymouse>=290 && ymouse<=330){
        checker=1;
        
        mx=me.getX();
        my=me.getY();
        
      }
      if (ymouse>=390 && ymouse<=430){
        checker=2;
        
        
      }
      if (ymouse>=490 && ymouse<=530){
        checker=3;
        
        
      }
      if (ymouse>=590 && ymouse<=630){
        
        checker=4;
        
      }
      
      
      
      
      
    }
    else{
      
      checker=0;
      
    }
  } 
////////////////////////SORTS///////////////////////////////////

  
  public void qsort(int a[], int start, int finish) {
    int lo = start;
    int hi = finish+1;
    int flag=0;
    
    if (lo >= hi) {
      return;
    }
    int pivot = a[lo];
    while (lo < hi) {
      flag=0;
       try 
    {  
      Thread.sleep (1); 
    } 
    catch (InterruptedException ex) 
    {  
    } 
      
      while (lo<hi && flag==0) {
        

        
        
        hi--;
        if (a[hi]<pivot){
          flag=1;
          a[lo]=a[hi];
          swaps4+=1;
          box4[lo].lenght=a[hi];
          repaint();
        }
        
      }
      flag=0;
      while (lo<hi && flag==0) {
        
        
        
        long ender= System.nanoTime();
        fina4=(ender-start4)/gg;
        lo++;
        if (a[lo]>pivot){
          flag=1;
          a[hi]=a[lo];
          swaps4+=1;
          box4[hi].lenght=a[hi];
          repaint();
        }
      }
    }
    if (lo==hi)
    {
      a[hi]=pivot;
      swaps4+=1;
      box4[hi].lenght=a[hi];
    }
    repaint();

    qsort(a, start, lo-1);
    qsort(a, hi+1, finish);
    
    starter=false;
    end4= System.nanoTime();
    fina4=(end4-start4)/gg; 
  }
  
}




