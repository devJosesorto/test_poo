/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos_Usuarios;

import java.sql.Date;

/**
 *
 * @author José Sorto
 */
public class Prestamo {
    
    private String cod_prestamo;
    private String cod_ejemplar;
    private String carnet;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private double mora;

    
    public Prestamo(String cod_prestamo, String cod_ejemplar, String carnet, Date fecha_prestamo, Date fecha_devolucion, double mora) {
        this.cod_prestamo = cod_prestamo;
        this.cod_ejemplar = cod_ejemplar;
        this.carnet = carnet;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.mora = mora;
    }

    public Prestamo() {
    }
    
    

    public String getCod_prestamo() {
        return cod_prestamo;
    }

    public void setCod_prestamo(String cod_prestamo) {
        this.cod_prestamo = cod_prestamo;
    }

    public String getCod_ejemplar() {
        return cod_ejemplar;
    }

    public void setCod_ejemplar(String cod_ejemplar) {
        this.cod_ejemplar = cod_ejemplar;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }
    
    
}
