import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

class panel extends JPanel implements ActionListener {
    JPanel panelnumber = new JPanel();
    JPanel paneldisplay = new JPanel();
    JTextField display;
    JLabel logdisplay;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[10];
    JButton addButton,subButton,mulButton,divButton,modulaButton;
    JButton decButton,equButton,delButton,clrButton,negativeButton;

    Font BTfont = new Font("",Font.BOLD,20);
    Font DPfont = new Font("",Font.BOLD,70);
    Font logDPfont = new Font("",Font.BOLD,20);

    double num1 = 0, num2 = 0, result = 0;
    String strnum1 , strnum2;
    String sum[] = null;
    char operator;

    ImageIcon delete = new ImageIcon(System.getProperty("user.dir")+ File.separator + "delete1.png");

    TextBubbleBorder border = new TextBubbleBorder(new Color(32,32,32),0,20,0);
    TextBubbleBorder DPborder = new TextBubbleBorder(new Color(32,32,32),0,0,0);


    panel(){
        setLayout(new BorderLayout());
        setBackground(new Color(32,32,32));
        display = new JTextField();
        display.setFont(DPfont);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(32,32,32));
        display.setForeground(Color.WHITE);
        display.setBorder(DPborder);
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                keynumpad(e);


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        logdisplay = new JLabel(" ",SwingConstants.RIGHT);
        logdisplay.setFont(logDPfont);
        logdisplay.setForeground(new Color(150,150,150));
        logdisplay.setBorder(DPborder);

        panelnumber.setLayout(new GridLayout(5,4,2,2));
        panelnumber.setBackground(new Color(32,32,32));

        paneldisplay.setLayout(new BorderLayout());
        paneldisplay.setBackground(new Color(32,32,32));
        paneldisplay.add(logdisplay,BorderLayout.NORTH);
        paneldisplay.add(display,BorderLayout.CENTER);

        setButton();
        BTaddpanel();
        setcolor();

        add(paneldisplay,BorderLayout.NORTH);
        add(panelnumber,BorderLayout.CENTER);




    }

    private void setcolor() {
        for (int i = 0; i < 10; i++) {
            numberButton[i].setForeground(Color.WHITE);
            numberButton[i].setBackground(new Color(59,59,59));
            if (i!=6){
                functionButton[i].setForeground(Color.WHITE);
            }
            if (i!=5 || i!=6 || i!=9){
                functionButton[i].setBackground(new Color(50,50,50));
            }

        }
        functionButton[5].setBackground(new Color(59,59,59));
        functionButton[9].setBackground(new Color(59,59,59));
        functionButton[6].setBackground(new Color(118,180,240));

    }

    private void BTaddpanel() {
        panelnumber.add(functionButton[8]);
        panelnumber.add(functionButton[4]);
        panelnumber.add(functionButton[3]);
        panelnumber.add(functionButton[7]);

        panelnumber.add(numberButton[7]);
        panelnumber.add(numberButton[8]);
        panelnumber.add(numberButton[9]);
        panelnumber.add(functionButton[2]);

        panelnumber.add(numberButton[4]);
        panelnumber.add(numberButton[5]);
        panelnumber.add(numberButton[6]);
        panelnumber.add(functionButton[1]);

        panelnumber.add(numberButton[1]);
        panelnumber.add(numberButton[2]);
        panelnumber.add(numberButton[3]);
        panelnumber.add(functionButton[0]);

        panelnumber.add(functionButton[9]);
        panelnumber.add(numberButton[0]);
        panelnumber.add(functionButton[5]);
        panelnumber.add(functionButton[6]);
    }

    private void setButton() {

        addButton = new JButton("+");           //0
        subButton = new JButton("-");           //1
        mulButton = new JButton("x");           //2
        divButton = new JButton("/");           //3
        modulaButton = new JButton("%");        //4
        decButton = new JButton(".");           //5
        equButton = new JButton("=");           //6
        delButton = new JButton();                   //7
        delButton.setIcon(delete);
        clrButton = new JButton("C");           //8
        negativeButton = new JButton("+/-");    //9

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = modulaButton;
        functionButton[5] = decButton;
        functionButton[6] = equButton;
        functionButton[7] = delButton;
        functionButton[8] = clrButton;
        functionButton[9] = negativeButton;

        for (int i = 0; i < 10; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(BTfont);
            functionButton[i].setFocusable(false);
            functionButton[i].setBorder(border);
//<<------------------------------------------------------------------------------>>\\
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(BTfont);
            numberButton[i].setFocusable(false);
            numberButton[i].setBorder(border);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]){
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == addButton){
        	operator = '+';
            logdisplay.setText(display.getText() + operator);
            if (num1 == 0) {
                num1 = Double.parseDouble(display.getText());
            } else {
                num1 += Double.parseDouble(display.getText());
            }
            display.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (e.getSource() == mulButton){
        	operator = 'x';
            logdisplay.setText(display.getText() + operator);
            if (num1 == 0) {
                num1 = Double.parseDouble(display.getText());
            } else {
                num1 *= Double.parseDouble(display.getText());
            }
            display.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (e.getSource() == modulaButton){
            num1 = Double.parseDouble(display.getText());
            operator = '%';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(display.getText());
            logdisplay.setText(logdisplay.getText().concat(display.getText()+"="));
            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case 'x':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                case '%':
                    result = num1%num2;
                    break;

            }

            display.setText(String.valueOf(result));
            if (display.getText().length() > 9 && display.getText().length() < 20){
                display.setFont(new Font("",Font.BOLD,30));
            }else {
                display.setFont(DPfont);
            }
            num1 = result;
        }
        if (e.getSource() == clrButton){
            display.setText("");
            logdisplay.setText(" ");
            display.setFont(DPfont);
            num1 = 0;
        }
        if (e.getSource() == delButton){
            String str = display.getText();
            display.setText("");
            for (int i = 0; i < str.length()-1; i++) {
                display.setText(display.getText()+str.charAt(i));
            }
        }
        if (e.getSource() == negativeButton){
            double temp = Double.parseDouble(display.getText());
            temp *= -1;
            display.setText(String.valueOf(temp));
        }
    }

    private void keynumpad(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyPressed = e.getKeyChar();
        if (keyCode >= KeyEvent.VK_NUMPAD0 && keyCode <= KeyEvent.VK_NUMPAD9) {
            display.setText(display.getText().concat(String.valueOf(e.getKeyChar())));
        }
        if (keyPressed == '+'){
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (keyPressed == '-'){
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (keyPressed == '*'){
            num1 = Double.parseDouble(display.getText());
            operator = 'x';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (keyPressed == '/'){
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (keyPressed == '%'){
            num1 = Double.parseDouble(display.getText());
            operator = '%';
            logdisplay.setText(display.getText()+operator);
            display.setText("");
        }
        if (keyCode == 10){
            num2 = Double.parseDouble(display.getText());
            logdisplay.setText(logdisplay.getText().concat(display.getText()+"="));
            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case 'x':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                case '%':
                    result = num1%num2;
                    break;

            }

            display.setText(String.valueOf(result));
            if (display.getText().length() > 9 && display.getText().length() < 20){
                display.setFont(new Font("",Font.BOLD,30));
            }else {
                display.setFont(DPfont);
            }
        }
        if (keyCode == 27){
            display.setText("");
            logdisplay.setText(" ");
            display.setFont(DPfont);
        }
        if (keyCode == 8){
            String str = display.getText();
            display.setText("");
            for (int i = 0; i < str.length()-1; i++) {
                display.setText(display.getText()+str.charAt(i));
            }
        }
    }
}
