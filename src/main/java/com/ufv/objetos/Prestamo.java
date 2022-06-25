package com.ufv.objetos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "uId",
        "eId",
        "fIni",
        "fFin"
})
@Generated("jsonschema2pojo")
public class Prestamo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("eId")
    private Integer eId;
    @JsonProperty("fIni")
    private String fIni;
    @JsonProperty("fFin")
    private String fFin;

    public Prestamo() {
    }


    public Prestamo(Integer id, Integer uId, Integer eId, String fIni, String fFin) {
        super();
        this.id = id;
        this.uId = uId;
        this.eId = eId;
        this.fIni = fIni;
        this.fFin = fFin;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("uId")
    public Integer getuId() {
        return uId;
    }

    @JsonProperty("uId")
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @JsonProperty("eId")
    public Integer geteId() {
        return eId;
    }

    @JsonProperty("eId")
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    @JsonProperty("fIni")
    public String getfIni() {
        return fIni;
    }

    @JsonProperty("fIni")
    public void setfIni(String fIni) {
        this.fIni = fIni;
    }

    @JsonProperty("fFin")
    public String getfFin() {
        return fFin;
    }

    @JsonProperty("fFin")
    public void setfFin(String fFin) {
        this.fFin = fFin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Prestamo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("uId");
        sb.append('=');
        sb.append(((this.uId == null)?"<null>":this.uId));
        sb.append(',');
        sb.append("eId");
        sb.append('=');
        sb.append(((this.eId == null)?"<null>":this.eId));
        sb.append(',');
        sb.append("fIni");
        sb.append('=');
        sb.append(((this.fIni == null)?"<null>":this.fIni));
        sb.append(',');
        sb.append("fFin");
        sb.append('=');
        sb.append(((this.fFin == null)?"<null>":this.fFin));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
