/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolucionSoap;

/**
 *
 * @author IvoSpruth
 */
public class Usuario {

private int id;
private String cuit;
private String nro_registro;
private String estado;
private double monto;

public Usuario(){}


    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNro_registro() {
        return nro_registro;
    }

    public void setNro_registro(String nro_registro) {
        this.nro_registro = nro_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }





}
