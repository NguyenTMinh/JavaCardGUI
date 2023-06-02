/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ResponseDataWrapper {
    private byte[] data;
    
    public ResponseDataWrapper() {
        data = new byte[255];
    }
    
    public byte getData() {
        return data[0];
    }
    
    public byte[] getDataAll() {
        return data;
    }
    
    public void setData(byte[] b) {
        data = b;
    }
}
