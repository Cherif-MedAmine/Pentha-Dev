/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Riadh Akkari
 */
public class Message {     
    private int idMessage;
    private int idDiscussionM;
    private int idUserS_M;
    private String message;
    private String dateMessage;

    public Message( int idMessage, int idDiscussionM, int idUserS_M,String message, String dateMessage) {
        this.idMessage = idMessage;
        this.idDiscussionM = idDiscussionM;
        this.idUserS_M = idUserS_M;
        this.message = message;
        this.dateMessage = dateMessage;
    }

    public Message(int aInt, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdUserS_M() {
        return idUserS_M;
    }

    public void setIdUserS_M(int idUserS_M) {
        this.idUserS_M = idUserS_M;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }
    

    public int getIdDiscussionM() {
        return idDiscussionM;
    }

    public void setIdDiscussionM(int idDiscussionM) {
        this.idDiscussionM = idDiscussionM;
    }
    

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "message=" + message + ", idMessage=" + idMessage + ", idDiscussionM=" + idDiscussionM + ", idUserS_M=" + idUserS_M + ", dateMessage=" + dateMessage + '}';
    }

   


   
    
    
}
