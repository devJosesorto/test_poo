
package Prestamos;

import java.sql.Date;

/**
 *
 * @author Bolaines
 */
public class Funciones_prestamos {
       
    private int recibo_E;
    private String carnet;
    private String cod_libro;
    private int cantidad;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
  
    
    
    public Funciones_prestamos() {
    
}

    public Funciones_prestamos(int recibo_E, String carnet, String cod_libro, int cantidad, Date fecha_prestamo, Date fecha_devolucion) {
        
        this.recibo_E = recibo_E;
        this.carnet = carnet;
        this.cod_libro = cod_libro;
        this.cantidad = cantidad;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        
    }
    

    
    public int getRecibo_E() {
        return recibo_E;
    }

    public void setRecibo_E(int recibo_E) {
        this.recibo_E = recibo_E;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    
    
    
    
}
