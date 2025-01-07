import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JTextField signField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[11];
    JButton[] additionalButtons = new JButton[4];
    JButton bAdd,bSub,bMul,bDiv,bSqr, bRoot;
    JButton bDot, bEql,bDel,bClr, bSign;

    JButton bRadDeg,bDegRad,bDecBin,bBinDec;
    JPanel panel;

    Font f = new Font("Calibri", Font.BOLD, 25);
    Font f2 = new Font("Calibri", Font.BOLD, 15);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.setForeground(Color.BLACK);

        textField = new JTextField();
        signField = new JTextField();
        textField.setBounds(100,10,250,80);
        textField.setFont(f);
        textField.setEditable(false);
        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.WHITE);

        signField.setBounds(20,10,80,80);
        signField.setFont(f2);
        signField.setEditable(false);
        signField.setBackground(Color.LIGHT_GRAY);
        signField.setForeground(Color.WHITE);

        bAdd = new JButton("+");
        bSub = new JButton("-");
        bMul = new JButton("*");
        bDiv = new JButton("/");
        bSqr = new JButton("x^y");
        bRoot = new JButton("sqrt(x)");
        bDel = new JButton("Del");
        bClr = new JButton("C");
        bDot = new JButton(".");
        bSign = new JButton("+/-");
        bEql = new JButton("=");

        bRadDeg = new JButton("Deg");
        bDegRad = new JButton("Rad");
        bDecBin = new JButton("Bin");
        bBinDec = new JButton("Dec");

        functionButtons[0]=bAdd;
        functionButtons[1]=bSub;
        functionButtons[2]=bMul;
        functionButtons[3]=bDiv;
        functionButtons[4]=bSqr;
        functionButtons[5]=bRoot;
        functionButtons[6]=bDel;
        functionButtons[7]=bClr;
        functionButtons[8]=bDot;
        functionButtons[9]=bSign;
        functionButtons[10]=bEql;

        additionalButtons[0]=bRadDeg;
        additionalButtons[1]=bDegRad;
        additionalButtons[2]=bDecBin;
        additionalButtons[3]=bBinDec;

        panel = new JPanel();
        panel.setBounds(2,100,430,410);
        panel.setLayout(new GridLayout(6,4,1,1));
        panel.setBackground(Color.BLACK);

        for(int i =0 ;i<4;i++){
            additionalButtons[i].addActionListener(this);
            additionalButtons[i].setFont(f);
            additionalButtons[i].setBackground(Color.GRAY);
            additionalButtons[i].setFocusable(false);
            panel.add(additionalButtons[i]);
        }

        for(int i=0;i<11;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(f);
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(f);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setFocusable(false);
        }


        bEql.setBackground(Color.RED);
        bDel.setBounds(350,10,80,80);
        bDel.setBackground(Color.LIGHT_GRAY);

       panel.add(bClr);
       panel.add(bSqr);
       panel.add(bRoot);
       panel.add(bDiv);
       panel.add(numberButtons[7]);
       panel.add(numberButtons[8]);
       panel.add(numberButtons[9]);
       panel.add(bMul);
       panel.add(numberButtons[4]);
       panel.add(numberButtons[5]);
       panel.add(numberButtons[6]);
       panel.add(bSub);
       panel.add(numberButtons[1]);
       panel.add(numberButtons[2]);
       panel.add(numberButtons[3]);
       panel.add(bAdd);
       panel.add(bSign);
       panel.add(numberButtons[0]);
       panel.add(bDot);
       panel.add(bEql);





        frame.add(panel);
        frame.add(textField);
        frame.add(signField);
        frame.add(bDel);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==bDot&&!textField.getText().contains(".")){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==bAdd){
            num1= Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
            signField.setText(String.valueOf(num1).concat("+"));
        }
        if(e.getSource()==bSub){
            num1= Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
            signField.setText(String.valueOf(num1).concat("-"));
        }
        if(e.getSource()==bMul){
            num1= Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
            signField.setText(String.valueOf(num1).concat("*"));
        }
        if(e.getSource()==bDiv){
            num1= Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
            signField.setText(String.valueOf(num1).concat("/"));
        }
        if(e.getSource()==bSqr){
            num1= Double.parseDouble(textField.getText());
            operator='^';
            textField.setText("");
            signField.setText(String.valueOf(num1).concat("^"));
        }
        if(e.getSource()==bRoot){
            num1= Double.parseDouble(textField.getText());
            operator='s';
            textField.setText("");
            if(num1>=0){
                result=Math.sqrt(num1);
                textField.setText(String.valueOf(result));
                signField.setText("sqrt("+String.valueOf(num1)+")");
            }
            else {
                textField.setText("Negative SqRt");
            }
        }
        if(e.getSource()==bSign){
            if(textField.getText().charAt(0) != '-') {
                String signed = "-"+textField.getText();
                textField.setText(signed);
            }else {
                textField.setText(textField.getText().substring(1));
            }
        }
        if(e.getSource() == bClr){
            textField.setText("");
            signField.setText("");
            num1=0;
            num2=0;
            result=0;
        }

        if(e.getSource()==bEql){

            num2=Double.parseDouble(textField.getText());
            System.out.print(num2);
            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;

                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if(num2==0.0){
                        textField.setText("Division by 0");
                        result=0.0;
                        break;
                    }else {
                        result = num1 / num2;
                        break;
                    }
                case '^':
                    result=Math.pow(num1,num2);
                    break;
                case 's':

                    result=Math.sqrt(num1);
                    break;

            }
            textField.setText(String.valueOf(result));
            signField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==bDel){
            String string=textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if(e.getSource()==bDecBin){
            String res;
            if(!textField.getText().contains(".")){
                int num = Integer.parseInt(textField.getText());
                res = Integer.toBinaryString(num);
                textField.setText(res);
            }else {
                textField.setText("Not Int");
            }

        }
        if(e.getSource()==bBinDec){
            String bin=textField.getText();
            if(bin.contains("2")||bin.contains("3")||bin.contains("4")||bin.contains("5")||bin.contains("6")||bin.contains("7")||bin.contains("8")||bin.contains("9")){
                textField.setText("Not Binary");
            }else {
                int res = Integer.parseInt(bin,2);
                textField.setText(String.valueOf(res));
            }
        }
        if(e.getSource()==bRadDeg){
            num1=Double.parseDouble(textField.getText());
            result=(num1*180)/Math.PI;
            textField.setText(String.valueOf(result));
        }
        if(e.getSource()==bDegRad){
            num1=Double.parseDouble(textField.getText());
            result=num1/180*Math.PI;
            textField.setText(String.valueOf(result));
        }
    }

}

