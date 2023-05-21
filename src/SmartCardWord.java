
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class SmartCardWord {
    public static final byte[] AID_APPLET = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55};
    public static final String CARD_NAME = "T=0";
    public static final String RESPONSE_SUCCESS = "9000";
    public static final String RESPONSE_DISABLED = "6400";
    
    private boolean connected;
    private Card card;
    private TerminalFactory factory;
    private CardChannel channel;
    private CardTerminal terminal;
    private List<CardTerminal> terminals;
    private ResponseAPDU responseAPDU;
    
    public SmartCardWord() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
        } catch (CardException e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean connectAndSelectDefaultApplet() {
        try {
           card = terminal.connect(CARD_NAME);
           channel = card.getBasicChannel();
           if (channel == null) {
               return false;
           }
           responseAPDU = channel.transmit(new CommandAPDU(0x00, (byte)0xA4, 0x04, 0x00, AID_APPLET));
           String check = Integer.toHexString(responseAPDU.getSW());
           if (check.equals(RESPONSE_SUCCESS)) {
               connected = true;
               return true;
           } else if (check.equals(RESPONSE_DISABLED)) {
               connected = true;
               JOptionPane.showMessageDialog(null, "Thẻ đã bị vô hiệu hóa");
               return true;
           } else {
               return false;
           }
        } catch (CardException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean disconnect() {
        try {
            card.disconnect(false);
            connected = false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isConnected() {
        return connected;
    }
    
    private boolean sendCommand(byte ins, byte p1, byte p2, byte[] data, ResponseDataWrapper resp) {
        if (channel != null) {
            try {
                responseAPDU = 
                        channel.transmit(new CommandAPDU(0x00, ins, p1, p2, data));
                String check = Integer.toHexString(responseAPDU.getSW());
                resp.setData(responseAPDU.getData());
                if (check.equals(RESPONSE_SUCCESS)) {
                    connected = true;
                    return true;
                } else {
                    return false;
                }
            } catch (CardException ex) {
                Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public void createPin(String pin) {
        byte[] data = new byte[pin.length()];
        for (int i = 0; i < pin.length(); i++) {
            data[i] = (byte)pin.charAt(i);
        }
        ResponseDataWrapper responseDataWrapper = new ResponseDataWrapper();
        boolean res = 
                sendCommand(Constant.INS_CREATE_PIN, Constant.NO_VALUE, Constant.NO_VALUE, data, responseDataWrapper);
        if (res) {
            System.out.println(responseDataWrapper.getData());
            if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CREATE_SUCCESS) {
                JOptionPane.showMessageDialog(null, "Tạo PIN thành công");
            } else if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_ALREADY_CREATED){
                JOptionPane.showMessageDialog(null, "Mã PIN đã được tạo, vui lòng thực "
                        + "hiện chúc năng khác hoặc liên hệ admin để reset");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Tạo PIN thất bại");
        }
    }
}
