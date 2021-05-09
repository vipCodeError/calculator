package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    double input1 = 0;
    int input2 = 0;
    EditText edt1;
    boolean Addition, Subtract, Multiplication, Division, mRemainder, decimal;
    AppCompatButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel, buttonDot, Remainder, power, bin, hex, oct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonAdd = findViewById(R.id.buttonadd);
        buttonSub = findViewById(R.id.buttonsub);
        buttonMul = findViewById(R.id.buttonmul);
        buttonDivision = findViewById(R.id.buttondiv);

        bin = findViewById(R.id.bin);
        oct = findViewById(R.id.oct);
        hex = findViewById(R.id.hex);

        //Remainder = findViewById(R.id.Remainder);
        // buttonDel = findViewById(R.id.buttonDel);
        buttonEqual = findViewById(R.id.buttoneql);
        power = findViewById(R.id.power);

        edt1 = findViewById(R.id.display);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    edt1.setText(edt1.getText() + "+");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    edt1.setText(edt1.getText() + "-");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    edt1.setText(edt1.getText() + "*");

                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    edt1.setText(edt1.getText() + "/");

                }
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDecimal = false;
                boolean isInteger = false;

                String singleExpression = edt1.getText().toString();
                if (singleExpression.contains(".")) {
                    input1 = Float.parseFloat(singleExpression);
                    input1 = input1 * input1;
                    isDecimal = true;
                } else {
                    input2 = Integer.parseInt(singleExpression);
                    input2 = input2 * input2;
                    isInteger = true;
                }

                if (isDecimal) {
                    edt1.setText(input1 + "");
                } else if (isInteger) {
                    edt1.setText(input2 + "");
                }

                input1 = 0.0;
                input2 = 0;
            }
        });

        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDecimal = false;
                boolean isInteger = false;
                String binaryInteger = "";
                String binFloat = "";

                String singleExpression = edt1.getText().toString();
                if (singleExpression.contains(".")) {
                    input1 = Float.parseFloat(singleExpression);
                    binFloat = printFloatBits((float) input1);
                    isDecimal = true;
                } else {
                    input2 = Integer.parseInt(singleExpression);
                    binaryInteger = Integer.toBinaryString(input2);
                    isInteger = true;
                }

                if (isDecimal) {
                    edt1.setText(binFloat + "");
                } else if (isInteger) {
                    edt1.setText(binaryInteger + "");
                }

                input1 = 0.0;
                input2 = 0;
            }
        });

        // Todo
        // 1. Number format exception
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDecimal = false;
                boolean isInteger = false;
                String octInteger = "";
                String octFloat = "";
                String singleExpression = edt1.getText().toString();
                if (singleExpression.contains(".")) {
                    input1 = Float.floatToIntBits(Float.parseFloat(singleExpression));
                    isDecimal = true;
                } else {
                    input2 = Integer.parseInt(singleExpression);
                    octInteger = Integer.toOctalString(input2);
                    isInteger = true;
                }

                if (isDecimal) {
                    edt1.setText(input1 + "");
                } else if (isInteger) {
                    edt1.setText(octInteger + "");
                }

                input1 = 0.0;
                input2 = 0;
            }
        });

        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDecimal = false;
                boolean isInteger = false;
                String hexInteger = "";
                String hexFloat = "";

                String singleExpression = edt1.getText().toString();
                if (singleExpression.contains(".")) {
                    input1 = Float.floatToIntBits(Float.parseFloat(singleExpression));
                    isDecimal = true;
                } else {
                    input2 = Integer.parseInt(singleExpression);
                    hexInteger = Integer.toHexString(input2);
                    isInteger = true;
                }

                if (isDecimal) {
                    edt1.setText(input1 + "");
                } else if (isInteger) {
                    edt1.setText(hexInteger + "");
                }

                input1 = 0.0;
                input2 = 0;
            }
        });

//        Remainder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (edt1.getText().length() != 0) {
//                    input1 = Float.parseFloat(edt1.getText() + "");
//                    mRemainder = true;
//                    decimal = false;
//                    edt1.setText(null);
//                }
//            }
//        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expresssionLine = edt1.getText().toString();

                int operatorCount = 0;

                boolean isAdditionOperatorPresent = expresssionLine.contains("+");
                boolean isSubtractionOperatorPresent = expresssionLine.contains("-");
                boolean isMultiplicationOperatorPresent = expresssionLine.contains("*");
                boolean isDivisitionOperatorPresent = expresssionLine.contains("/");
                boolean shouldGoForExpresssion = false;

                if (isAdditionOperatorPresent) {
                    operatorCount++;
                }
                if (isSubtractionOperatorPresent) {
                    operatorCount++;
                }
                if (isMultiplicationOperatorPresent) {
                    operatorCount++;
                }
                if (isDivisitionOperatorPresent) {
                    operatorCount++;
                }

                if (operatorCount > 1) {
                    shouldGoForExpresssion = true;
                }

                if (shouldGoForExpresssion) {
                    // subtraction
                    int resultExp = evaluate(expresssionLine);
                    edt1.setText(resultExp + "");
//                    if (isSubtractionOperatorPresent) {
//                        // (2-3+4+6/2*3)
//                        String[] tempSubExpression = expresssionLine.split("-");
//
//                        // {2, 3+4+6/2*3}
//                        for (int i = 0; i < tempSubExpression.length; i++) {
//                            //addition
//                            String[] tempAddExpression = tempSubExpression[i].split("\\+");
//                            // {3, 4, 6/2*3}
//                            for (int m = 0; m < tempAddExpression.length; m++) {
//                                if (tempAddExpression[m].contains("*")) {
//
//                                    String[] tempMultExpression = tempAddExpression[m].split("\\*");
//                                    // {6/2, 3}
//                                    // multiplication
//                                    for (int j = 0; j < tempMultExpression.length; j++) {
//                                        if (tempMultExpression[j].contains("/")) {
//                                            String[] tempDivExpression = tempMultExpression[j].split("/");
//                                            for (int k = 0; k < tempDivExpression.length; k++) {
//
//                                                // {6,2}
//                                                // division
//                                                if (result == 0) {
//                                                    result = Integer.parseInt(tempDivExpression[k]);
//                                                } else {
//                                                    result = result / Integer.parseInt(tempDivExpression[k]);
//                                                }
//
//                                            }
//                                        }
//
//
//                                        result = result * Integer.parseInt(tempMultExpression[j]);
//                                        //tempSubExpression[j] = String.valueOf(result);
//                                    }
////
////                                    result = result + Integer.parseInt(tempAddExpression[i]);
////                                    tempSubExpression[i] = String.valueOf(result);
//                                }
//                            }
//
//
//                        }
//
//                        for (int m = 0; m < tempSubExpression.length; m++) {
//                            result = result + Integer.parseInt(tempSubExpression[m]);
//                        }
//                        edt1.setText(result + "");
//
//                    } else if (isAdditionOperatorPresent) {
//
//                    } else if (isMultiplicationOperatorPresent) {
//
//                    } else if (isDivisitionOperatorPresent) {
//
//                    }
                } else {
                    try {
                        additionCheck(expresssionLine);
                        multiplicationCheck(expresssionLine);
                        divisionCheck(expresssionLine);
                        subtractionCheck(expresssionLine);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Operation cannot be performed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {
                    //do nothing or you can show the error
                } else {
                    edt1.setText(edt1.getText() + ".");
                    decimal = true;
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public String printFloatBits(float f) {
        int bits = Float.floatToIntBits(f);
        // Extract each bit from 'bits' and compare it by '0'
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; --i) {
            // int mask = 1 << i;
            // int oneBit = bits & mask;
            // oneBit == 0 or 1?
            stringBuilder.append((bits & (1 << i)) == 0 ? "0" : "1");
        }

        return stringBuilder.toString();
    }

    public void additionCheck(String expresssionLine) {
        if (expresssionLine.contains("+")) {
            String[] splitStr = expresssionLine.split("\\+");

            boolean isDecimal = false;
            boolean isInteger = false;


            if (splitStr[0].contains(".")) {
                input1 = Float.parseFloat(splitStr[0]) + Float.parseFloat(splitStr[1]);
                isDecimal = true;
            } else {
                input2 = Integer.parseInt(splitStr[0]) + Integer.parseInt(splitStr[1]);
                isInteger = true;
            }


            edt1.setText("");

            if (isDecimal && isInteger) {
                edt1.setText((input1 + input2) + "");
            } else if (isDecimal) {
                edt1.setText(input1 + "");
            } else if (isInteger) {
                edt1.setText(input2 + "");
            }

            input1 = 0.0;
            input2 = 0;

        }
    }

    public void multiplicationCheck(String expresssionLine) {
        if (expresssionLine.contains("*")) {
            String[] splitStr = expresssionLine.split("\\*");
            boolean isDecimal = false;
            boolean isInteger = false;


            if (splitStr[0].contains(".")) {
                input1 = Float.parseFloat(splitStr[0]) * Float.parseFloat(splitStr[1]);
                isDecimal = true;
            } else {
                input2 = Integer.parseInt(splitStr[0]) * Integer.parseInt(splitStr[1]);
                isInteger = true;
            }


            edt1.setText("");

            if (isDecimal && isInteger) {
                edt1.setText((input1 + input2) + "");
            } else if (isDecimal) {
                edt1.setText(input1 + "");
            } else if (isInteger) {
                edt1.setText(input2 + "");
            }

            input1 = 0.0;
            input2 = 0;

        }
    }

    public void subtractionCheck(String expresssionLine) {
        if (expresssionLine.contains("-")) {
            String[] splitStr = expresssionLine.split("-");

            boolean isDecimal = false;
            boolean isInteger = false;


            if (splitStr[0].contains(".")) {
                input1 = Float.parseFloat(splitStr[0]) - Float.parseFloat(splitStr[1]);
                isDecimal = true;
            } else {
                input2 = Integer.parseInt(splitStr[0]) - Integer.parseInt(splitStr[1]);
                isInteger = true;
            }


            edt1.setText("");

            if (isDecimal && isInteger) {
                edt1.setText((input1 + input2) + "");
            } else if (isDecimal) {
                edt1.setText(input1 + "");
            } else if (isInteger) {
                edt1.setText(input2 + "");
            }

            input1 = 0.0;
            input2 = 0;
        }

    }

    public void divisionCheck(String expresssionLine) {
        if (expresssionLine.contains("/")) {
            String[] splitStr = expresssionLine.split("/");

            boolean isDecimal = false;
            boolean isInteger = false;


            if (splitStr[0].contains(".") || splitStr[1].contains(".")) {
                input1 = Float.parseFloat(splitStr[0]) / Float.parseFloat(splitStr[1]);
                isDecimal = true;
            } else {
                input2 = Integer.parseInt(splitStr[0]) / Integer.parseInt(splitStr[1]);
                isInteger = true;
            }


            edt1.setText("");

            if (isDecimal && isInteger) {
                edt1.setText((input1 + input2) + "");
            } else if (isDecimal) {
                edt1.setText(input1 + "");
            } else if (isInteger) {
                edt1.setText(input2 + "");
            }

            input1 = 0.0;
            input2 = 0;

        }
    }

    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
                i--;
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}