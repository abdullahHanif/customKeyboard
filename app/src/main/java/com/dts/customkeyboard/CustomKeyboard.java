package com.dts.customkeyboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Admin on 11/16/2017.
 */

public class CustomKeyboard extends LinearLayout implements View.OnClickListener {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnbackspace,btnenter;
    private SparseArray<String> keyValues =  new SparseArray<>();
    private InputConnection inputConnection;

    public CustomKeyboard(Context context) {
        this(context,null,0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.keyboard,this,true);

        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btnbackspace = findViewById(R.id.btndel);
        btnbackspace.setOnClickListener(this);

        btnenter = findViewById(R.id.btnEnter);
        btnenter.setOnClickListener(this);

        keyValues.put(R.id.btn0,"0");
        keyValues.put(R.id.btn1,"1");
        keyValues.put(R.id.btn2,"2");
        keyValues.put(R.id.btn3,"3");
        keyValues.put(R.id.btn4,"4");
        keyValues.put(R.id.btn5,"5");
        keyValues.put(R.id.btn6,"6");
        keyValues.put(R.id.btn7,"7");
        keyValues.put(R.id.btn8,"8");
        keyValues.put(R.id.btn9,"9");
        keyValues.put(R.id.btnEnter,"\n");
    }

    @Override
    public void onClick(View view) {
        if(inputConnection == null) {return;}

        if(view.getId() == R.id.btndel){
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if(TextUtils.isEmpty(selectedText)){
                inputConnection.deleteSurroundingText(1,0);
            }
            else{
                inputConnection.commitText("",1);
            }
        }
        else{
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value,1);
        }
    }
    public void setInputConnection(InputConnection ic)
    {
        inputConnection = ic;
    }

}
