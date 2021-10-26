package com.example.firstfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    Boolean onfirst;
    Boolean afterEquals;
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
        onfirst = true;
        afterEquals = false;
        labelText = "";
        firstNum = "";
        secNum = "";


        // Create: root and rowNodes
        VBox root = new VBox();
        HBox fRow= new HBox(one, two, three, add);
        HBox sRow= new HBox(four, five, six, sub);
        HBox tRow= new HBox(seven, eight, nine, mult);
        HBox fthRow= new HBox(clear, zero, equal, div);

        // Create Scene and set Scene
        Scene scene = new Scene(root, 240, 267);
        stage.setScene(scene);

        setButtonBehavior();

        root.getChildren().addAll(topLabel, fRow, sRow, tRow, fthRow);
        stage.show();
    }

    public void handleButton(Button button){
        String id = button.getId();
        button.setOnAction(event -> {
            if(id.equals("clear") || id.equals("=")){
                if(id.equals("=")){
                    labelText += " = " + executeOperation();
                    afterEquals = true;
                }else{
                    labelText = "";
                }
                operation = "";
                clearOperands();
                onfirst = true;
            }else if(id.equals("+")){
                //// logic for operands
                labelText += " + ";
                operation = "+";
                onfirst = false;
            }else if(id.equals("-")){
                //// logic for operands
                labelText += " - ";
                operation = "-";
                onfirst = false;
            }else if(id.equals("*")){
                //// logic for operands
                labelText += " * ";
                operation = "*";
                onfirst = false;
            }else if(id.equals("/")){
                //// logic for operands
                labelText += " / ";
                operation = "/";
                onfirst = false;
            }else{
                if(afterEquals){
                    labelText = "";
                    topLabel.setText(labelText);
                    afterEquals = false;
                }
                // For all numerical values
                if(onfirst){
                    firstNum += id;
                }else {
                    secNum += id;
                }
                labelText += id;
            }
            topLabel.setText(labelText);
        });
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
    }

    public void clearOperands(){
        this.firstNum = "";
        this.secNum = "";
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

        this.mult = new Button("*");
        setButtonConstraints(mult);
        mult.setId("*");

        this.div = new Button("/");
        setButtonConstraints(div);
        div.setId("/");

        this.clear = new Button("C");
        setButtonConstraints(clear);
        clear.setId("clear");

        this.equal = new Button("=");
        setButtonConstraints(equal);
        equal.setId("=");
    }

    public float executeOperation(){
        if(operation.equals("+")){
            return Integer.parseInt(this.firstNum) + Integer.parseInt(this.secNum);
        }else if(operation.equals("-")){
            return Integer.parseInt(this.firstNum) - Integer.parseInt(this.secNum);
        }else if(operation.equals("/")){
            return (float)Integer.parseInt(this.firstNum) / Integer.parseInt(this.secNum);
        }else{
            return Integer.parseInt(this.firstNum) * Integer.parseInt(this.secNum);
        }
    }
}