/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class SmartCard {
    private int id;
    private String mathe;
    private int sv;
    private BigInteger publicKeyModulus;
    private BigInteger publicKeyExponent;

    public SmartCard(int id, String mathe, int sv, BigInteger publicKeyModulus, BigInteger publicKeyExponent) {
        this.id = id;
        this.mathe = mathe;
        this.sv = sv;
        this.publicKeyModulus = publicKeyModulus;
        this.publicKeyExponent = publicKeyExponent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMathe() {
        return mathe;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public BigInteger getPublicKeyModulus() {
        return publicKeyModulus;
    }

    public void setPublicKeyModulus(BigInteger publicKeyModulus) {
        this.publicKeyModulus = publicKeyModulus;
    }

    public BigInteger getPublicKeyExponent() {
        return publicKeyExponent;
    }

    public void setPublicKeyExponent(BigInteger publicKeyExponent) {
        this.publicKeyExponent = publicKeyExponent;
    }

    
}
