
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class textpract {

  private Frame myframe;
  private Panel mypanel;
  private Panel my2panel;
  private TextField text;
  private Label label;
  private Label label2;
  private Label label3;
  private Button button;

  final int base = 97;
	int score = 0 ;
	int count = 0;

/**
  this is a constructor, when called creates the frame
**/
  public textpract()
  {
    create_frame();
  }



/**
  creates the frame and it components, then displays it.
**/
  public void create_frame()
  {
    myframe = new Frame();
    myframe.setSize(300,300);
    myframe.setLayout(new GridLayout(2, 1));
    myframe.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent windowEvent){
         System.exit(0);
      }
    });
    mypanel = new Panel(new GridLayout(3,1));
    my2panel = new Panel(new GridLayout(2,1));

    label = new Label("hi king");
    label2 = new Label("start");
    label3 = new Label("oh my");
    label3.setAlignment(label3.CENTER);
    label.setAlignment(label.CENTER);
    textgenerator();

    button = new Button("Reset");
    button.addActionListener(new CustomButtonListener());

    my2panel.add(label);
    my2panel.add(label2);

    myframe.add(my2panel);
    myframe.add(mypanel);

    myframe.setVisible(true);
  }





  public void TextListenerDemo()
  {
    text = new TextField(10);

    text.addTextListener(new CustomTextListener());
    mypanel.add(text);
    mypanel.add(button);
    mypanel.add(label3);
    myframe.setVisible(true);

  }


/**
  this method is responsible for generating a letter and set the text of the appropriate
  label .
**/
  public void textgenerator()
  {
    Random generator = new Random();

    int number = generator.nextInt(26);
    int ascii = base + number;

    char l = (char) ascii;
    String letter = Character.toString(l);
    label.setText(letter);

  }





  class CustomTextListener implements TextListener
  {
    public void textValueChanged(TextEvent e)
    {
      System.out.println("text was entered ====================");

      String letter = text.getText();
      String l_letter = label.getText();
      if (letter.equals("")) {
        label2.setBackground(new Color(129,0,252));

      }else if (letter.equals(l_letter)){

        label2.setBackground(new Color(0,252,0));
        label2.setText("correct");
        textgenerator();
        text.setText("");
        score++;
        count++;

      }else {
        label2.setBackground(new Color(252,0,0));
        label2.setText("wrong");
        text.setText("");
        count++;
      }


    }
  }






  class CustomButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) {

      String result = "your score: " + score + "/ " + count;
      label3.setText(result);
      score = 0;
      count = 0;

    }
  }





  public static void main(String[] args) {
    textpract mainFrame = new textpract();
    mainFrame.TextListenerDemo();
  }

}
