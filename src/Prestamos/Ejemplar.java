package Prestamos;

/**
 *
 * @author José Sorto
 */
public class Ejemplar {
    
    
    private String cod_ejemplar;
    private String cod_libro;
    private String ubicacion;
    private double mora;
    private String status;

    public Ejemplar(String cod_ejemplar, String cod_libro, String ubicacion, double mora, String status) {
        this.cod_ejemplar = cod_ejemplar;
        this.cod_libro = cod_libro;
        this.ubicacion = ubicacion;
        this.mora = mora;
        this.status = status;
    }

    public Ejemplar() {
    }

    public String getCod_ejemplar() {
        return cod_ejemplar;
    }

    public void setCod_ejemplar(String cod_ejemplar) {
        this.cod_ejemplar = cod_ejemplar;
    }

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
    
}
