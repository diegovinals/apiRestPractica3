package com.ufv.objetos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nombre",
        "departamento",
        "telefono",
        "correo",
        "ubicacion"
})
@Generated("jsonschema2pojo")
public class Usuario {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("departamento")
    private String departamento;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("ubicacion")
    private String ubicacion;


    public Usuario() {
    }


    public Usuario(Integer id, String nombre, String departamento, String telefono, String correo, String ubicacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.telefono = telefono;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("departamento")
    public String getDepartamento() {
        return departamento;
    }

    @JsonProperty("departamento")
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @JsonProperty("telefono")
    public String getTelefono() {
        return telefono;
    }

    @JsonProperty("telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonProperty("correo")
    public String getCorreo() {
        return correo;
    }

    @JsonProperty("correo")
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @JsonProperty("ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }

    @JsonProperty("ubicacion")
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Usuario.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nombre");
        sb.append('=');
        sb.append(((this.nombre == null)?"<null>":this.nombre));
        sb.append(',');
        sb.append("departamento");
        sb.append('=');
        sb.append(((this.departamento == null)?"<null>":this.departamento));
        sb.append(',');
        sb.append("telefono");
        sb.append('=');
        sb.append(((this.telefono == null)?"<null>":this.telefono));
        sb.append(',');
        sb.append("correo");
        sb.append('=');
        sb.append(((this.correo == null)?"<null>":this.correo));
        sb.append(',');
        sb.append("ubicacion");
        sb.append('=');
        sb.append(((this.ubicacion == null)?"<null>":this.ubicacion));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void modificarUsuario(Usuario usuarioModificado) {
        this.setNombre(usuarioModificado.getNombre());
        this.setDepartamento(usuarioModificado.getDepartamento());
        this.setTelefono(usuarioModificado.getTelefono());
        this.setUbicacion(usuarioModificado.getUbicacion());
        this.setCorreo(usuarioModificado.getCorreo());
    }
}