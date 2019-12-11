package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Armando on 28/07/18.
 */
@Entity
@Table(name = "trabajadores")
//@NamedStoredProcedureQueries({
//    @NamedStoredProcedureQuery(
//            name = "spProductoSearch", procedureName = "spproductosearch", resultClasses = Producto.class
//            , parameters = { @StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = String.class) }
//    )
//})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String nombre;

    @NotBlank
    //@Length(min = 8, max = 10)
    public String direccion;

    @NotBlank
    public String turno;

    // @Column(nullable = false, updatable = true)
    @Column(updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date createdAt;
/*
    public Producto(){

    }
    public Producto(long id, String nombre, String descripcion, Date fecha){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.createdAt = fecha;
    }
*/
    // @Column(nullable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    // @LastModifiedDate
    // private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}