package com.ufv.objetos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "tipo",
        "nombreSO",
        "versionSO",
        "tipoDisc",
        "capacidadDisc",
        "sNombre"
})
@Generated("jsonschema2pojo")
public class Equipo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("nombreSO")
    private String nombreSO;
    @JsonProperty("versionSO")
    private String versionSO;
    @JsonProperty("tipoDisc")
    private String tipoDisc;
    @JsonProperty("capacidadDisc")
    private String capacidadDisc;
    @JsonProperty("sNombre")
    private String sNombre;


    public Equipo() {
    }

    public Equipo(Integer id, String tipo, String nombreSO, String versionSO, String tipoDisc, String capacidadDisc, String sNombre) {
        super();
        this.id = id;
        this.tipo = tipo;
        this.nombreSO = nombreSO;
        this.versionSO = versionSO;
        this.tipoDisc = tipoDisc;
        this.capacidadDisc = capacidadDisc;
        this.sNombre = sNombre;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("nombreSO")
    public String getNombreSO() {
        return nombreSO;
    }

    @JsonProperty("nombreSO")
    public void setNombreSO(String nombreSO) {
        this.nombreSO = nombreSO;
    }

    @JsonProperty("versionSO")
    public String getVersionSO() {
        return versionSO;
    }

    @JsonProperty("versionSO")
    public void setVersionSO(String versionSO) {
        this.versionSO = versionSO;
    }

    @JsonProperty("tipoDisc")
    public String getTipoDisc() {
        return tipoDisc;
    }

    @JsonProperty("tipoDisc")
    public void setTipoDisc(String tipoDisc) {
        this.tipoDisc = tipoDisc;
    }

    @JsonProperty("capacidadDisc")
    public String getCapacidadDisc() {
        return capacidadDisc;
    }

    @JsonProperty("capacidadDisc")
    public void setCapacidadDisc(String capacidadDisc) {
        this.capacidadDisc = capacidadDisc;
    }

    @JsonProperty("sNombre")
    public String getsNombre() {
        return sNombre;
    }

    @JsonProperty("sNombre")
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Equipo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("tipo");
        sb.append('=');
        sb.append(((this.tipo == null)?"<null>":this.tipo));
        sb.append(',');
        sb.append("nombreSO");
        sb.append('=');
        sb.append(((this.nombreSO == null)?"<null>":this.nombreSO));
        sb.append(',');
        sb.append("versionSO");
        sb.append('=');
        sb.append(((this.versionSO == null)?"<null>":this.versionSO));
        sb.append(',');
        sb.append("tipoDisc");
        sb.append('=');
        sb.append(((this.tipoDisc == null)?"<null>":this.tipoDisc));
        sb.append(',');
        sb.append("capacidadDisc");
        sb.append('=');
        sb.append(((this.capacidadDisc == null)?"<null>":this.capacidadDisc));
        sb.append(',');
        sb.append("sNombre");
        sb.append('=');
        sb.append(((this.sNombre == null)?"<null>":this.sNombre));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void modificarEquipo(Equipo equipoMod) {
        setTipo(equipoMod.getTipo());
        setNombreSO(equipoMod.getNombreSO());
        setVersionSO(equipoMod.getVersionSO());
        setTipoDisc(equipoMod.getTipoDisc());
        setCapacidadDisc(equipoMod.getCapacidadDisc());
        setsNombre(equipoMod.getsNombre());
    }

}