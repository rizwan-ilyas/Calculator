import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CalculatorHandler implements ActionListener{
    CalculatorGUI refg;
    double num1,num2,answer;
    String operation;
    boolean flage;
    public CalculatorHandler(CalculatorGUI calculator) {
        refg=calculator;    
    }
    
    boolean handleInfinity(boolean isEnable){
        if(isEnable){
            refg.lowerTxt.setText("");
            refg.upperTxt.setText("");
        }
    refg.btns[3].setEnabled(isEnable);
    refg.btns[7].setEnabled(isEnable);
    refg.btns[11].setEnabled(isEnable);
    refg.btns[15].setEnabled(isEnable);
    return isEnable;
    }
    double calculate(double num1,double num2,String operator){
         double ans = 0;
        switch (operator){
               case "+": 
                   ans=num1+num2;break;
               case "-":
                   ans=num1-num2;break;
               case "*":
                   ans=num1*num2;break;
               case "/":
                   if(num1!=0 && num2==0){
                       ans=num1/num2;
                       flage=handleInfinity(false);
                       //refg.backbtn.setEnabled(false);
                       break;
                   }else{
                       ans=num1/num2;break;
                   }       
           }
        return ans;
    }
    boolean isNumber(String st){
        try{
            if(Integer.parseInt(st)>=0 && Integer.parseInt(st)<=9){
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
     
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!flage){
            flage=handleInfinity(!flage);
        }
        
       String inputValue=ae.getActionCommand();
       String current_lowerTxt=refg.lowerTxt.getText();
       String current_upperTxt=refg.upperTxt.getText();
       String[] opr={"+","-","*","-"};
       if(current_lowerTxt.length()<15 || !isNumber(inputValue)){
        if((inputValue=="+" || inputValue=="-" || inputValue=="/" || inputValue=="*")){
           if(current_upperTxt.equals("") && current_lowerTxt.equals("")){
              //do nothings
           }
           else if((current_upperTxt.endsWith("+") || current_upperTxt.endsWith("-") ||current_upperTxt.endsWith("*") || current_upperTxt.endsWith("/"))){
                if(!current_lowerTxt.equals("")){
                    num2=Double.parseDouble(current_lowerTxt);
                    answer=calculate(num1, num2, operation);
                    num1=answer;
                    refg.upperTxt.setText(Double.toString(answer)+inputValue);
                    refg.lowerTxt.setText("");
                    operation=inputValue;
                } else{
                    System.out.println(num2);
                    operation=inputValue;
                    refg.upperTxt.setText(Double.toString(num1)+inputValue);
                       }
               }
           else{
            num1=Double.parseDouble(current_lowerTxt);
            operation=inputValue;
            refg.upperTxt.setText(current_lowerTxt+inputValue);
            refg.lowerTxt.setText("");
            }
        }
        else if(inputValue.equals("=")){
            if(current_upperTxt.equals("") || current_lowerTxt.equals("")){
              //do nothings
           }else{   
                if(current_upperTxt.endsWith("+") || current_upperTxt.endsWith("-") || current_upperTxt.endsWith("*") || current_upperTxt.endsWith("/")){
                   num2=Double.parseDouble(current_lowerTxt);
                   answer=calculate(num1, num2, operation);
                   refg.upperTxt.setText(current_upperTxt+current_lowerTxt);
                   refg.lowerTxt.setText(Double.toString(answer));
                }
                else if(current_lowerTxt.endsWith(".")){
                    System.out.println(". Exception");
                }
            }
        }
        else if(inputValue.equals("<-")){
            if(!current_lowerTxt.isEmpty()){
                if(current_lowerTxt.length()==2 && current_lowerTxt.startsWith("-")){
                    refg.lowerTxt.setText("");
                }
                else if(current_lowerTxt.equals(Double.toString(answer)) || current_lowerTxt.equals(Double.toString(-answer))){
                    refg.upperTxt.setText("");
                    //refg.lowerTxt.setText("");
                }
                else{
                    String temp=current_lowerTxt;
                    refg.lowerTxt.setText(temp.substring(0,temp.length()-1));

                }
                
                            }
        }
        else if(inputValue.equals("C")){
            refg.upperTxt.setText("");
            refg.lowerTxt.setText("");
            num1=0;
            num2=0;
            operation="";
            
        }
        else if(inputValue.equals("+/-")){
            if(current_lowerTxt.equals("")){
              //do nothings
           }else{
                if(current_lowerTxt.endsWith(".")){
                    refg.lowerTxt.setText(Double.toString(-1*Double.parseDouble(current_lowerTxt.substring(0, current_lowerTxt.length()-1))));
                }
                else if(current_lowerTxt.equals(Double.toString(answer)) || current_lowerTxt.equals(Double.toString(-answer))){
                    refg.upperTxt.setText("negate("+current_lowerTxt+")");
                    refg.lowerTxt.setText(Double.toString(-1*Double.parseDouble(current_lowerTxt)));
                }
                else{
                refg.lowerTxt.setText(Double.toString(-1*Double.parseDouble(current_lowerTxt)));
            }}
        }
        else if(inputValue.equals(".")){
            if(!current_lowerTxt.contains(".")){
                if(current_lowerTxt.equals("")){
                    refg.lowerTxt.setText("0"+inputValue);
                }else{
                    refg.lowerTxt.setText(current_lowerTxt+inputValue);
                }
            }
        }
        else if(inputValue.equals("0")){
            if(current_lowerTxt.contains(".")){
                refg.lowerTxt.setText(current_lowerTxt+inputValue);    
            }
            else if(!current_lowerTxt.equals("0")){
                refg.lowerTxt.setText(current_lowerTxt+inputValue);
            }
        }
        else{
            if(current_lowerTxt.equals(Double.toString(answer)) || current_lowerTxt.equals(Double.toString(-answer))){
                refg.lowerTxt.setText(inputValue);
                refg.upperTxt.setText("");
            }else{
                refg.lowerTxt.setText(current_lowerTxt+inputValue);
            }
            
            
            
        }
       }
       }
    
    
}
