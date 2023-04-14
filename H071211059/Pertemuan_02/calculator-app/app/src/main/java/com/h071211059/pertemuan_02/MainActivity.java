package com.h071211059.pertemuan_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText entry;
    private TextView result;
    private boolean isResultShown = false;
    private boolean onOperator = false;
    private Map<String, Integer> priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entry = findViewById(R.id.entry);
        result = findViewById(R.id.result);

        Button c = findViewById(R.id.resetBtn);
        c.setOnClickListener(v -> {
            entry.setText("0");
            result.setText("0");
        });

        Button equal = findViewById(R.id.equalBtn);
        equal.setOnClickListener(v -> {
            if (calculate()) updateResult(ResultState.SHOWN);
        });

        onOperator = false;

        priority = new HashMap<>();
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("x", 2);
        priority.put("/", 2);
        priority.put("^", 3);
    }


    /**
     * Number clicked.
     *
     * @param view the view
     */
    public void numberClicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String eq = entry.getText().toString();

        if (isResultShown) {
            entry.setText(buttonText);
            updateResult(ResultState.NOT_SHOWN);
        } else {
            if (!(eq.equals("")
                    && buttonText.matches("[+/x^]"))) {
                if (validateInput(buttonText, eq)) {
                    entry.append(buttonText);
                }
            }
        }
    }

    /**
     * Delete entry.
     *
     * @param view the view
     */
    public void deleteEntry(View view) {
        if (!isResultShown && entry.getText().length() > 0) {
            String temp = entry.getText().toString();
            temp = temp.substring(0, temp.length() - 1);

            if (temp.isEmpty()) {
                entry.setText("0");
            } else {
                entry.setText(temp);
            }
        }
    }

    /**
     * Calculate entry and set result.
     *
     * @return the boolean
     */
    public boolean calculate() {
        String eq = entry.getText().toString();
        String temp = eq.substring(eq.length() - 1);
        int multiplyParanthesis = 0;

        if (isOperator(temp)) {
            entry.setError("Invalid input");
            return false;
        }

        if (eq.length() == 0) return false;

        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?){1,}|[+/x^()\\-]", Pattern.CASE_INSENSITIVE);
        Matcher matches = pattern.matcher(eq);

        List<String> parsedEq = new LinkedList();
        while (matches.find()) {
            parsedEq.add(matches.group());
        }

        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        boolean isNegativeNumber = false;

//        parsing
        for (int i = 0; i < parsedEq.size(); i++) {
            String token = parsedEq.get(i);
            if (token.equals("-") && (isOperator(parsedEq.get(i - 1)) || parsedEq.get(i - 1).matches("[()]"))) {
                isNegativeNumber = true;
                continue;
            }

            if (isNegativeNumber) {
                token = "-" + token;
                isNegativeNumber = false;
            }

            System.out.println(token);
//            token is number
            if (isNumber(token)) {
                queue.add(token);
            }

//            token is operator
            if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                        (priority.get(token) <= priority.get(stack.peek()))) {
                    if (token.equals("^") && stack.peek().equals("^")) {
                        break;
                    } else {
                        queue.add(stack.pop());
                    }
                }
                stack.push(token);
            }
//            token is (
            if (token.equals("(")) {
                stack.push(token);

                if (isNumber(parsedEq.get(i - 1))) {
                    multiplyParanthesis += 1;
                }
            }
//            token is )
            if (token.equals(")")) {
                System.out.println(token);
                while (!stack.peek().equals("(") && !stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                stack.pop();

                while (multiplyParanthesis != 0) {
                    queue.offer("x");
                    multiplyParanthesis -= 1;
                }
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        System.out.println(queue);

        Stack<Double> resultStack = new Stack<>();
        for (String token : queue) {
            if (isNumber(token)) {
                resultStack.push(Double.parseDouble(token));
            } else {
                double a = resultStack.pop();
                double b = resultStack.pop();
                switch (token) {
                    case "+":
                        resultStack.push(b + a);
                        break;
                    case "-":
                        resultStack.push(b - a);
                        break;
                    case "x":
                        resultStack.push(b * a);
                        break;
                    case "/":
                        resultStack.push(b / a);
                        break;
                    case "^":
                        resultStack.push(Math.pow(b, a));
                        break;
                }
            }
        }

        result.setText(new DecimalFormat("#.#########").format(resultStack.pop()));
        return true;
    }


    /**
     * Check if token is operator.
     *
     * @param token the token
     * @return true if token is operator
     */
    private boolean isOperator(String token) {
        return priority.containsKey(token);
    }

    /**
     * Check if token is number.
     *
     * @param token the token
     * @return true if token is operator
     */
    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Update result.
     *
     * @param state the view
     */
    private void updateResult(ResultState state) {
        if (state == ResultState.SHOWN) {
            entry.setTextAppearance(R.style.unfocusedText);
            result.setTextAppearance(R.style.focusedText);
            isResultShown = true;
        } else {
            entry.setTextAppearance(R.style.focusedText);
            result.setTextAppearance(R.style.unfocusedText);
            isResultShown = false;
        }
    }

    /**
     * Validate input user to filter double operator, and remove 0 if user input number.
     *
     * @param input the input
     * @param entry the entry
     * @return true if input is valid
     */
    private boolean validateInput(String input, String entry) {
        String lastChar = entry.length() > 0 ? entry.substring(entry.length() - 1) : "";
        if (lastChar.matches("[x/+^]") && input.matches("[x/+^]")) return false;

        if (entry.equals("0") && input.matches("[0-9]")) {
            this.entry.setText("");
        }

        return !lastChar.equals("-") || !input.equals("-");
    }
}