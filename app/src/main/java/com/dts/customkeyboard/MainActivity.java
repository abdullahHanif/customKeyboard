package com.dts.customkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    boolean toggle = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.showKeybBoard);

        final CustomKeyboard customKeyboard = (CustomKeyboard) findViewById(R.id.keyboard);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        customKeyboard.setInputConnection(ic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = !toggle;
                button.setText(toggle ? "Hide Keyboard":"Show Keyboard");
                customKeyboard.setVisibility(toggle ? View.VISIBLE : View.GONE);
            }
        });
    }
}
