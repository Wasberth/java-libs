/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.gui.validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Willy
 */
public abstract class WTextField extends JTextField implements Runnable {

    public static final int POSITIVE_NUMBER_TEXTFIELD = 0;

    private final WTextField textfield;
    private final PlainDocument documentValidator;
    private final KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
            calcule = true;
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            calcule = true;
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            calcule = true;
        }
    };

    private final Thread constantValidation = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                if (calcule) {
                    SwingUtilities.invokeAndWait(textfield);
                }
            } catch (InterruptedException | InvocationTargetException ex) {
                Logger.getLogger(WTextField.class.getName()).log(Level.SEVERE, null, ex);
            }
            SwingUtilities.invokeLater(this);
        }
    });

    private volatile boolean calcule = false;

    public WTextField(final int type){
        super();
        switch (type) {
            case POSITIVE_NUMBER_TEXTFIELD:
                this.documentValidator = new PlainDocument() {
                    @Override
                    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
                        final boolean previous0;
                        if (textfield.getText().length() != 0) {
                            previous0 = textfield.getText().charAt(0) == '0';
                        } else {
                            previous0 = false;
                        }
                        for (int i = 0; i < arg1.length(); i++) {
                            if (!Character.isDigit(arg1.charAt(i))) {
                                return;
                            }
                        }
                        if (previous0) {
                            super.replace(0, arg1.length(), arg1, arg2);
                        } else {
                            super.insertString(arg0, arg1, arg2);
                        }
                    }
                };
                break;
            default:
                this.documentValidator = new PlainDocument();
        }
        super.setDocument(documentValidator);
        super.addKeyListener(keyListener);
        this.textfield = this;
        this.constantValidation.start();
    }

    public WTextField(final String regex, final boolean strongInputValidation) {
        super();
        this.documentValidator = new PlainDocument() {
            @Override
            public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
                if (strongInputValidation) {
                    if (arg1.matches(regex)) {
                        super.insertString(arg0, arg1, arg2);
                    }
                } else {
                    super.insertString(arg0, arg1, arg2);
                }
            }
        };
        super.setDocument(documentValidator);
        super.addKeyListener(keyListener);
        this.textfield = this;
        this.constantValidation.start();
    }

}
