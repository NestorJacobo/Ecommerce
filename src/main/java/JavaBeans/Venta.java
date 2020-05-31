package JavaBeans;

public class Venta {

    private int idventa;
    private int idproducto;
    private String nombreproducto;
    private int cantidad;
    private double preciounitario;
    private double preciototal;
    private String usuario;
    private String fecha;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Venta() {
    }

    /**
     * @return the idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    /**
     * @return the idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * @return the nombreproducto
     */
    public String getNombreproducto() {
        return nombreproducto;
    }

    /**
     * @param nombreproducto the nombreproducto to set
     */
    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad; 
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the preciounitario
     */
    public double getPreciounitario() {
        return preciounitario;
    }

    /**
     * @param preciounitario the preciounitario to set
     */
    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    /**
     * @return the preciototal
     */
    public double getPreciototal() {
        return preciototal;
    }

    /**
     * @param preciototal the preciototal to set
     */
    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
