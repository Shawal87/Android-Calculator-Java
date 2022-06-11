package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle; // for saving state information
import android.preference.PreferenceScreen;
import android.view.View;  //  for view
import android.widget.Button;  //   button
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private Button AC,Power,Back,Div,Mul,Add,Sub, One,Two,Three, Four,Five,Six,Seven,Eight,Nine,Zero,Ans,Point,Equal ;
    private String input,Answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Add = findViewById(R.id.plus);
        Sub = findViewById(R.id.min);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
        Point = findViewById(R.id.point);
        Ans = findViewById(R.id.ans);
        Equal = findViewById(R.id.equal);
    }
   // function click button and view 
   @Override
    public void ButtonClick(View view){
         Button button = (Button) view;
         String data = button.getText().toString();
         switch (data){
             case"AC":
                   input=" ";
                   break;
             case"Ans":
                  input+=Answer;
                  break;
             case "x":
                 input+="*";
                 break;
             case "^":
               input+="^";
               break;
             case "=":
                Solve();
                Answer = input;
                break;
             case "arrow back":
                 String newText=input.substring(0,input.length()-1);
                 input = newText;
                 break;
             default:
               if( input == null) {
                   input ="";
               }
              if(data.equals("+") || data.equals("-") ||  data.equals("/")){
                  Solve();
              }
              input== data;





         }
       screen.setText(input);

   }
     private void Solve(){
      if(input.split("\\*").length==2){
          String number[] = input.split("\\*");
          try{
          double mul=Double.parseDouble(number[])*Double.parseDouble(number[1]);
          input=mul+;

      }catch(Exception e){
              // Toggler error
          }
     }
      else if(input.split("/").length==2){
          String number[] = input.split("/");
          try{
              double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
              input= div+"";

          }catch(Exception e){
              // Toggler error
          }
      }
      else if(input.split("\\^").length==2){
          String number[] = input.split("\\^");
          try{
              double pow=Math.pow(Double.parseDouble(number[0])/Double.parseDouble(number[1]));
              input= pow+;

          }catch(Exception e){
              // Toggler error
          }

      }     else if(input.split("\\+").length==2){
          String number[] = input.split("\\+");
          try{
              double sum=Double.parseDouble(number[0])+ Double.parseDouble(number[1]);
              input= sum+;

          }catch(Exception e){
              // Toggler error
          }
      }

     }     else if(input.split("-").length>1){   // this is subtraction that may have more than two split in case of like -4-6
        String number[] = input.split("\\+");
        // to substract from negative number like  -5-8
        if(number[0] == "" && number.length==2){
            number[0]=0+"";
        }

        try{
         double sub=0;
         if(number.length==2){
             sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
         }
        else if (number.length ==3){
            sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
         }
          input = sub + "";

        }
        catch(Exception e){
            // Toggler error
        }

        // to remove the last digit  .0 from integer result like 9 instead of 9.0
        String n [] = input.split("\\.");
        if (n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
    }
}