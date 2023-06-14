
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.smartcardio.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.SinhVien;

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
        if (data.length > Constant.MAX_APDU_SIZE) {
            return false;
        }
        
        if (channel != null) {
            try {
                responseAPDU = 
                        channel.transmit(new CommandAPDU(0x00, ins, p1, p2, data));
                String check = Integer.toHexString(responseAPDU.getSW());
                if (resp != null) {
                    resp.setData(responseAPDU.getData());
                }
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
    
    private boolean sendCommandWithLongData(byte ins, byte p1, byte p2, byte[] data, ResponseDataWrapper resp) {
        if (channel != null) {
            try {
                int offset = 0;
                while (offset < data.length) {
                    int len = Math.min(Constant.MAX_APDU_SIZE, data.length - offset);
                    byte[] chunk = new byte[len];
                    System.arraycopy(data, offset, chunk, 0, len);
                    responseAPDU = 
                        channel.transmit(new CommandAPDU(0x00, ins, p1, p2, chunk));
                    
                    offset += len;
                }
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
    
    private boolean sendCommandReceiveLongData(byte ins, byte p1, byte p2, byte[] data, ResponseDataWrapper resp) {
        if (channel != null) {
            try {
                byte[] temp = new byte[100000];
                int offset = 0;
                while (true) {
                    responseAPDU = 
                        channel.transmit(new CommandAPDU(0x00, ins, p1, p2, data));
                    if (responseAPDU.getNr() < Constant.MAX_APDU_SIZE) {
                        System.arraycopy(responseAPDU.getData(), 0, temp, offset, responseAPDU.getData().length);
                        offset += responseAPDU.getNr();
                        break;
                    }
                    
                    System.arraycopy(responseAPDU.getData(), 0, temp, offset, responseAPDU.getData().length);
                    offset += Constant.MAX_APDU_SIZE;
                }
                
                String check = Integer.toHexString(responseAPDU.getSW());
                byte[] result = new byte[offset];
                System.out.println("Minh: " + result.length);
                System.arraycopy(temp, 0, result, 0, result.length);
                resp.setData(result);
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
    
    public boolean createPin(String pin) {
        byte[] data = new byte[pin.length()];
        for (int i = 0; i < pin.length(); i++) {
            data[i] = (byte)pin.charAt(i);
        }
        ResponseDataWrapper responseDataWrapper = new ResponseDataWrapper();
        boolean res = 
                sendCommand(Constant.INS_CREATE_PIN, Constant.NO_VALUE, Constant.NO_VALUE, data, responseDataWrapper);
        if (res) {
            if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CREATE_SUCCESS) {
                JOptionPane.showMessageDialog(null, "Tạo PIN thành công");
            } else if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_ALREADY_CREATED){
                JOptionPane.showMessageDialog(null, "Mã PIN đã được tạo, vui lòng thực "
                        + "hiện chúc năng khác hoặc liên hệ admin để reset");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tạo PIN thất bại");
        }
        
        return res;
    }
    
    public boolean checkPin(String pin) {
        byte[] data = new byte[pin.length()];
        for (int i = 0; i < pin.length(); i++) {
            data[i] = (byte)pin.charAt(i);
        }
        ResponseDataWrapper responseDataWrapper = new ResponseDataWrapper();
        boolean res = 
                sendCommand(Constant.INS_CHECK_PIN, Constant.NO_VALUE, Constant.NO_VALUE, data, responseDataWrapper);
        if (res) {
            if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CHECK_TRUE) {
                return true;
            } else if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CHECK_FALSE){
                JOptionPane.showMessageDialog(null, "Mật khẩu không đúng, vui lòng thử lại");
                return false;
            } else if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CHECK_REACH_LIMIT) {
                JOptionPane.showMessageDialog(null, "Nhập mật khẩu sai quá số lần quy định, vui lòng liên hệ admin để mở khóa");
                return false;
            }
        } 
        
        JOptionPane.showMessageDialog(null, "Mật khẩu pin không đúng");
        return false;
    }
    
    public void changePin(String pin) {
        byte[] data = new byte[pin.length()];
        for (int i = 0; i < pin.length(); i++) {
            data[i] = (byte)pin.charAt(i);
        }
        ResponseDataWrapper responseDataWrapper = new ResponseDataWrapper();
        boolean res = 
                sendCommand(Constant.INS_CHANGE_PIN, Constant.NO_VALUE, Constant.NO_VALUE, data, responseDataWrapper);
        if (res) {
            if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CREATE_SUCCESS) {
                JOptionPane.showMessageDialog(null, "Thay đổi pin thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Thay đổi pin thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thay đổi pin thất bại");
        }
    }
    
    public  void unlockCard(String password) {
        byte[] data = new byte[password.length()];
        for (int i = 0; i < password.length(); i++) {
            data[i] = (byte)password.charAt(i);
        }
        ResponseDataWrapper responseDataWrapper = new ResponseDataWrapper();
        boolean res = 
                sendCommand(Constant.INS_UNLOCK_CARD, Constant.NO_VALUE, Constant.NO_VALUE, data, responseDataWrapper);
        if (res) {
            if (responseDataWrapper.getDataAll().length== 4) {
                StringBuilder pin = new StringBuilder();
                for (int i = 0; i < responseDataWrapper.getDataAll().length; i++) {
                    pin.append((char)responseDataWrapper.getDataAll()[i]);
                }
                
                JOptionPane.showMessageDialog(null, "Mở khóa thẻ thành công, mật khẩu: " + pin);
            } else if (responseDataWrapper.getData() == Constant.RESPONSE_PIN_CHECK_FALSE) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không đúng, mở khóa thẻ thất bại");
            }
        } else {
             JOptionPane.showMessageDialog(null, "Có lỗi xảy ra thử lại sau");
        }
    }
    
    /**
     * Nap thong tin sinh vien cung ma pin xuong the
     * @return 
     */
    public boolean flushCardInfo(SinhVien sinhVien, byte ins) throws UnsupportedEncodingException {
        // Nap thong tin sinh vien
        byte id = (byte) sinhVien.getId();
        byte[] avatar = sinhVien.getAvatar().getBytes();
        byte[] name = sinhVien.getName().getBytes(StandardCharsets.UTF_8);
        byte gender = (byte) sinhVien.getGender();
        byte[] date = sinhVien.getDate().toString().getBytes();
        byte[] phone = sinhVien.getPhone().getBytes();
        byte[] studentId = sinhVien.getStudentId().getBytes();
        byte[] classSV = sinhVien.getClassSV().getBytes();
        
        ResponseDataWrapper wrapper = new ResponseDataWrapper();
        boolean status = sendCommand(ins, Constant.PARAM_ID, id, new byte[1], wrapper);
        byte response = wrapper.getData();
        if (response == Constant.RESPONSE_PIN_ALREADY_CREATED) {
            JOptionPane.showMessageDialog(null, "Thẻ đã cài đặt thông tin!");
            return false;
        }
        if (status) {
            status = sendCommandWithLongData(ins, Constant.PARAM_AVATAR, Constant.NO_VALUE, avatar, wrapper);
            if (status) {
                status = sendCommand(ins, Constant.PARAM_HO_TEN, Constant.NO_VALUE, name, wrapper);
                if (status) {
                    status = sendCommand(ins, Constant.PARAM_GIOI_TINH, gender, new byte[1], wrapper);
                    if (status) {
                        status = sendCommand(ins, Constant.PARAM_NGAY_SINH, Constant.NO_VALUE, date, wrapper);
                        if (status) {
                            status = sendCommand(ins, Constant.PARAM_DIEN_THOAI, Constant.NO_VALUE, phone, wrapper);
                            if (status) {
                                status = sendCommand(ins, Constant.PARAM_MSV, Constant.NO_VALUE, studentId, wrapper);
                                if (status) {
                                    status = sendCommand(ins, Constant.PARAM_LOP, Constant.NO_VALUE, classSV, wrapper);
                                }
                            }
                        }
                    }
                }
            }
        }
        //TODO cho nay co the check status de biet thanh cong hay that bai de gui 1 INS xuong 
        
        return status;
    }
    
    /**
     * Lay thong tin Sinh vien trong the len
     * @return 
     */
    
    
    
    public SinhVien getInfoCard() {
        if (connected) {
            ResponseDataWrapper data = new ResponseDataWrapper();
            boolean status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_ID, Constant.NO_VALUE, Constant.NO_DATA, data);
            if (status) {
                int id = data.getData();
                status = sendCommandReceiveLongData(Constant.INS_GET_DATA, Constant.PARAM_AVATAR, Constant.NO_VALUE, Constant.NO_DATA, data);
                if(status) {
                    String avatar = new String(data.getDataAll());
                    status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_HO_TEN, Constant.NO_VALUE, Constant.NO_DATA, data);
                    if (status) {
                        String name = new String(data.getDataAll(), StandardCharsets.UTF_8);
                        status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_GIOI_TINH, Constant.NO_VALUE, Constant.NO_DATA, data);
                        if (status) {
                            int gender = data.getData();
                            status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_NGAY_SINH, Constant.NO_VALUE, Constant.NO_DATA, data);
                            if (status) {
                                String date = new String(data.getDataAll());
                                status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_DIEN_THOAI, Constant.NO_VALUE, Constant.NO_DATA, data);
                                if (status) {
                                    String phone = new String(data.getDataAll());
                                    status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_MSV, Constant.NO_VALUE, Constant.NO_DATA, data);
                                    if (status) {
                                        String msv = new String(data.getDataAll());
                                        status = sendCommand(Constant.INS_GET_DATA, Constant.PARAM_LOP, Constant.NO_VALUE, Constant.NO_DATA, data);
                                        if (status) {
                                            String lop = new String(data.getDataAll());
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                            java.util.Date ns;
                                            try {
                                                ns = dateFormat.parse(date);
                                                Date ns0 = new Date(ns.getTime());
                                                SinhVien sv = new SinhVien(id, avatar, name, gender, ns0, phone, msv, lop);
                                                return sv;
                                            } catch (ParseException ex) {
                                                Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } 
        
        return null;
    }
    
    
    
    
    public boolean resetInfo(String pin, JPanel panel) {
        ResponseDataWrapper wrapper = new ResponseDataWrapper();
        boolean res = sendCommand(Constant.INS_RESET_DATA, Constant.NO_VALUE, Constant.NO_VALUE, pin.getBytes(), wrapper);
        
        if (res) {
            if (wrapper.getData() == Constant.RESPONSE_PIN_CHECK_FALSE) {
                JOptionPane.showMessageDialog(panel, "Mật khẩu không đúng!");
            } else if (wrapper.getData() == Constant.RESPONSE_RESET_INFO_SUCCESS) {
                JOptionPane.showMessageDialog(panel, "Reset thông tin thành công!");
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Có lỗi xảy ra, thử lại sau!");
        }
        
        return false;
    }
}
