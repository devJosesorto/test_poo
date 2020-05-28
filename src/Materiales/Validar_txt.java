/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materiales;



import Reg_usuarios.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author José Sorto
 */
public class Validar_txt extends PlainDocument{
    
    private JTextField editor;
    private int num;

    public Validar_txt() {
 
    }
    
    public Validar_txt(JTextField editor, int num){
        this.editor=editor;
        this.num=num;
        }
    
    @Override
    public void insertString(int offset,String str, AttributeSet atrr) throws BadLocationException{
        if((editor.getText().length()+str.length())>this.num){
        return;}
    super.insertString(offset, str.toUpperCase(), atrr);
    }
    
    public void Validartxt_texto(JTextField a){
    a.addKeyListener(new KeyAdapter(){
    public void keyTyped(KeyEvent e){
    char c=e.getKeyChar();
    if(Character.isDigit(c)){
        e.consume();
    }
    }
    });
}
    
        public void Validartxt_numerico(JTextField a){
    a.addKeyListener(new KeyAdapter(){
    public void keyTyped(KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isDigit(c)){
        e.consume();
    }
    }
    });
}
        
        
    
}

