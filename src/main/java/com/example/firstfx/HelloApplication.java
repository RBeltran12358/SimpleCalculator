package com.example.firstfx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    Label topLabel;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button add;
    Button sub;
    Button div;
    Button mult;
    Button clear;
    Button equal;
    Button log10;

    Boolean onFirst;
    String firstNum;
    String secNum;
    String labelText;
    String operation;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Setting Initial title and label
        stage.setTitle("Calculator by Ricardo B");
        topLabel = new Label(" General Purpose Calculator");
        topLabel.setFont(new Font("Cambria", 20));

        createButtons();
        onFirst = true;
        labelText = "";
        firstNum = "";
        secNum = "";

        // Create: root and rowNodes
        VBox root = new VBox();
        HBox fRow= new HBox(one, two, three, add);
        HBox sRow= new HBox(four, five, six, sub);
        HBox tRow= new HBox(seven, eight, nine, mult);
        HBox fthRow= new HBox(clear, zero, equal, div);
        HBox sthRow= new HBox(log10);


        // Create Scene and set Scene
        Scene scene = new Scene(root, 350, 350);
        stage.setScene(scene);

        setButtonBehavior();

        root.getChildren().addAll(topLabel, fRow, sRow, tRow, fthRow, sthRow);
        stage.show();
    }

    public void handleButton(Button button){
        String id = button.getId();
        button.setOnAction(event -> {
            if(id.equals("clear")){
                labelText = "";
                firstNum = "";
                secNum = "";
                onFirst = true;
                operation = "";
            }else if(id.equals("log10")){
                //// logic for log10
                operation = "log10";
                String answer = String.valueOf(executeOperation());
                labelText = answer;
                firstNum = answer;
                secNum = "";
                onFirst = false;
                operation = "";
            }else if(id.equals("=")){
                String answer = String.valueOf(executeOperation());
                labelText = answer;
                firstNum = answer;
                secNum = "";
                onFirst = false;
                operation = "";
            }else if(id.equals("+")){
                //// logic for operands
                handleOperatorLogic("+");
            }else if(id.equals("-")){
                //// logic for operands
                handleOperatorLogic("-");
            }else if(id.equals("x")){
                //// logic for operands
                handleOperatorLogic("x");
            }else if(id.equals("/")){
                //// logic for operands
                handleOperatorLogic("/");
            }else{
                // For all numerical values
                if(onFirst){
                    firstNum += id;
                }else {
                    secNum += id;
                }
                labelText += id;
            }
            topLabel.setText(labelText);
        });
    }

    public void handleOperatorLogic(String op){
        labelText += (" " + op + " ");
        operation = op;
        onFirst = false;
    }

    public void setButtonBehavior(){
        handleButton(one);
        handleButton(two);
        handleButton(three);
        handleButton(four);
        handleButton(five);
        handleButton(six);
        handleButton(seven);
        handleButton(eight);
        handleButton(nine);
        handleButton(zero);
        handleButton(add);
        handleButton(sub);
        handleButton(mult);
        handleButton(div);
        handleButton(clear);
        handleButton(equal);
        handleButton(log10);
    }

    public void setButtonConstraints(Button button){
        button.setMaxWidth(100);
        button.setMaxHeight(100);
        button.setMinWidth(60);
        button.setMinHeight(60);
    }

    public void createButtons(){
        this.zero = new Button("0");
        setButtonConstraints(zero);
        zero.setId("0");

        this.one = new Button("1");
        setButtonConstraints(one);
        one.setId("1");

        this.two = new Button("2");
        setButtonConstraints(two);
        two.setId("2");

        this.three = new Button("3");
        setButtonConstraints(three);
        three.setId("3");

        this.four = new Button("4");
        setButtonConstraints(four);
        four.setId("4");

        this.five = new Button("5");
        setButtonConstraints(five);
        five.setId("5");

        this.six = new Button("6");
        setButtonConstraints(six);
        six.setId("6");

        this.seven = new Button("7");
        setButtonConstraints(seven);
        seven.setId("7");

        this.eight = new Button("8");
        setButtonConstraints(eight);
        eight.setId("8");

        this.nine = new Button("9");
        setButtonConstraints(nine);
        nine.setId("9");

        this.add = new Button("+");
        setButtonConstraints(add);
        add.setId("+");

        this.sub = new Button("-");
        setButtonConstraints(sub);
        sub.setId("-");

        this.mult = new Button("x");
        setButtonConstraints(mult);
        mult.setId("x");

        this.div = new Button("/");
        setButtonConstraints(div);
        div.setId("/");

        this.clear = new Button("C");
        setButtonConstraints(clear);
        clear.setId("clear");

        this.equal = new Button("=");
        setButtonConstraints(equal);
        equal.setId("=");

        this.log10 = new Button("log10");
        setButtonConstraints(log10);
        log10.setId("log10");
    }

    public float executeOperation(){

        if(operation.equals("+")){
            return Float.parseFloat(this.firstNum) + Float.parseFloat(this.secNum);
        }else if(operation.equals("-")){
            return Float.parseFloat(this.firstNum) - Float.parseFloat(this.secNum);
        }else if(operation.equals("/")){
            return Float.parseFloat(this.firstNum) / Float.parseFloat(this.secNum);
        }else if(operation.equals("log10")){



//            return Float.parseFloat(this.firstNum) - Float.parseFloat(this.secNum);
            if(this.firstNum.equals("")){
                return Float.MAX_VALUE;
            }
            double ret = Math.log10(Double.parseDouble(this.firstNum));
            return (float)ret;





        }else{
            return Float.parseFloat(this.firstNum) * Float.parseFloat(this.secNum);
        }
    }
}