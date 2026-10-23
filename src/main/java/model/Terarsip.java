/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Hype AMD
 */
public interface Terarsip {
    String nomorRak();
    String lokasiLantai();

    default String ringkasanArsip() {
        return nomorRak() + ", " + lokasiLantai();
    }
}