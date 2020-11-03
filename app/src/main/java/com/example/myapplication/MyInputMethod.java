package com.example.myapplication;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class MyInputMethod extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView= (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard,null);
        Keyboard keyboard=new Keyboard(this, R.xml.keys);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection =getCurrentInputConnection();
        if (inputConnection!=null){
            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    CharSequence selectedText = inputConnection.getSelectedText(0);
                    if (TextUtils.isEmpty(selectedText))
                        inputConnection.deleteSurroundingText(1, 0);
                    else
                        inputConnection.commitText("", 1);
                    break;
                default://it here for delete case
                    char code = (char) primaryCode;//what clicked
                    inputConnection.commitText(String.valueOf(code), 1);
            }
        }

    }


    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
