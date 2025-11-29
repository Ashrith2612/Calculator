import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardWidth = 360;
    int boardHeight = 540;

    Color customLightgrey = new Color(212 , 212 , 210);
    Color customDarkgrey = new Color(80 , 80 , 80);
    Color customBlack = new Color(28 , 28 , 28);
    Color customOrnage = new Color(255 , 149 , 0);

    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("CALCULATOR");

    JLabel displaylable = new JLabel();
    JPanel displaypanel = new JPanel();

    JPanel buttonspanel = new JPanel();

    String a = "0";
    String operator = null;
    String b = null;

    Calculator() {
        
        frame.setSize(boardWidth , boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displaylable.setBackground(customBlack);
        displaylable.setForeground(Color.white);
        displaylable.setFont(new Font("Arial" , Font.PLAIN , 80));
        displaylable.setHorizontalAlignment(JLabel.RIGHT);
        displaylable.setText("0");
        displaylable.setOpaque(true);

        displaypanel.setLayout(new BorderLayout());
        displaypanel.add(displaylable);
        frame.add(displaypanel , BorderLayout.NORTH);

        buttonspanel.setLayout(new GridLayout(5 , 4));
        buttonspanel.setBackground(customBlack);
        frame.add(buttonspanel);

        for(int i=0;i<buttonValues.length;i++){
            JButton button = new JButton();
            String buttonvalue = buttonValues[i];
            button.setFont(new Font("Arial" , Font.PLAIN , 30));
            button.setText(buttonvalue);
            button.setFocusable(false);

            button.setBorder(new LineBorder(customBlack));

            if(Arrays.asList(topSymbols).contains(buttonvalue)){
                button.setBackground(customLightgrey);
                button.setForeground(customBlack);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonvalue)){
                button.setBackground(customOrnage);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(customDarkgrey);
                button.setForeground(Color.white);
            }

            buttonspanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonvalue = button.getText();

                    if(Arrays.asList(rightSymbols).contains(buttonvalue)){
                        if(buttonvalue == "="){
                            if(a != null){

                                double numa = Double.parseDouble(a);

                                b = displaylable.getText();
                                double numb = Double.parseDouble(b);

                                if(operator == "+"){
                                    displaylable.setText(removeZeroDecimal(numa + numb));
                                }
                                else if(operator == "-"){
                                    displaylable.setText(removeZeroDecimal(numa - numb));
                                }
                                else if(operator == "×"){
                                    displaylable.setText(removeZeroDecimal(numa * numb));
                                }
                                else if(operator == "÷"){
                                    displaylable.setText(removeZeroDecimal(numa / numb));
                                }
                                clearAll();
                            }
                        }
                        else if("+-×÷".contains(buttonvalue)){
                            if(operator == null){
                                a = displaylable.getText();
                                displaylable.setText("0");
                                b = "0";
                            }
                            operator = buttonvalue;
                        }
                    }
                    else if(Arrays.asList(topSymbols).contains(buttonvalue)){
                        if(buttonvalue == "AC"){
                            clearAll();
                            displaylable.setText("0");
                        }
                        else if(buttonvalue == "+/-"){
                            double numdisplay = Double.parseDouble(displaylable.getText());
                            numdisplay *= -1;
                            displaylable.setText(removeZeroDecimal(numdisplay));
                        }
                        else if(buttonvalue == "%"){
                            double numdisplay = Double.parseDouble(displaylable.getText());
                            numdisplay /= 100;
                            displaylable.setText(removeZeroDecimal(numdisplay));
                        }
                    }
                    else if(buttonvalue == "√"){
                        double numdisplay = Double.parseDouble(displaylable.getText());
                        if(numdisplay > 0){
                            numdisplay = Math.sqrt(numdisplay);
                            displaylable.setText(removeZeroDecimal(numdisplay));
                        }
                        else{
                            displaylable.setText("ERR");
                        }
                    }
                    else{ // digits or decimals -- "."
                        if(buttonvalue == "."){
                            if(!displaylable.getText().contains(buttonvalue)){
                                displaylable.setText(displaylable.getText() + buttonvalue);
                            }
                        }
                        else if("0123456789".contains(buttonvalue)){
                            if(displaylable.getText() == "0"){
                                displaylable.setText(buttonvalue);
                            }
                            else{
                                displaylable.setText(displaylable.getText() + buttonvalue);
                            }
                        }
                    }
                }
            });

            frame.setVisible(true);
        }
    }

    void clearAll(){
        a = "0";
        operator = null;
        b = null;
    }

    String removeZeroDecimal(double numdisplay){
        if(numdisplay % 1 == 0){
            return Integer.toString((int) numdisplay);
        }
        return Double.toString(numdisplay);
    }
}



class Nagabhushanam {
    Scanner sc = new Scanner(System.in);
    int age = 80;
    String initial = "Poloju";

    
}