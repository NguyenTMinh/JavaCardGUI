/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Constant {
    // Danh sach cac instruction trong the ho tro
    // minh: ins tao ma pin cho the
    public static final byte INS_CREATE_PIN = (byte)0x00;
    // minh: ins thay doi ma pin the
    public static final byte INS_CHANGE_PIN = (byte)0x01;
    // minh: ins kiem tra ma pin
    public static final byte INS_CHECK_PIN = (byte)0x02;
    // minh: chuc nang unlock the
    public static final byte INS_UNLOCK_CARD = (byte)0x03;
    
    public static final byte RESPONSE_PIN_ALREADY_CREATED = (byte)0x2A;
    public static final byte RESPONSE_PIN_CREATE_SUCCESS = (byte)0x2B;
    public static final byte RESPONSE_PIN_CHECK_TRUE = (byte)0x2C; 
    public static final byte RESPONSE_PIN_CHECK_FALSE = (byte)0x2D;
    public static final byte RESPONSE_PIN_CHECK_REACH_LIMIT = (byte)0x2E;
    public static final byte NO_VALUE = (byte)0x00;
}
