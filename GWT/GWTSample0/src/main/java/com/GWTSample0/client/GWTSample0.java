package com.GWTSample0.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTSample0 implements EntryPoint {

    private static final String PLACEHOLDER = "Please enter your name";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final TextBox textBox = new TextBox();
        String s = PLACEHOLDER.length() + "em";
        textBox.setWidth(s);
        textBox.getElement().setPropertyString("placeholder", PLACEHOLDER);
        textBox.setMaxLength(8);
        textBox.setStyleName("gwt-TextBox0");
//
//        SoundController soundController = new SoundController();
//        final Sound sound = soundController.createSound(Sound.MIME_TYPE_AUDIO_WAV_PCM,
//                "alarm1.wav");

//        textBox.addKeyUpHandler(new KeyUpHandler() {
//            @Override
//            public void onKeyUp(KeyUpEvent event) {
//                if(textBox.getText().length() == textBox.getMaxLength()) {
//                    mistakeAudio.play();
//                    sound.play();
//                }
//            }
//        });
        final Button buttonClick = new Button("Click me");
        final Label label = new Label();

        buttonClick.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                textBoxHandler(label, textBox);
            }
        });


        RootPanel.get().addDomHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    textBoxHandler(label, textBox);
                }
            }
        }, KeyDownEvent.getType());

        final Button buttonStyle = new Button("TextBox Style");
        buttonStyle.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                textBox.setStyleName("gwt-TextBox1");
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(textBox);
        RootPanel.get("slot1").add(buttonClick);
        RootPanel.get("slot3").add(buttonStyle);
        RootPanel.get("slot2").add(label);
        textBox.setFocus(true);
    }

    private void textBoxHandler(Label label, TextBox textBox) {
        if (label.getText().equals("")) {
            GWTSample0Service.App.getInstance().getMessage(textBox.getText(), new MyAsyncCallback(label));
        } else {
            label.setText("");
            textBox.setText("");
            textBox.getElement().setPropertyString("placeholder", "enter your first name");
            textBox.setFocus(true);
        }
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
//    private Audio mistakeAudio;
//
//    {
//        mistakeAudio = Audio.createIfSupported();
//        mistakeAudio.setSrc("sound/beep4.mp3");
//    }
}
