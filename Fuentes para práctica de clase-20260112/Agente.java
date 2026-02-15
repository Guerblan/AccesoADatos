package com.ejemxml.model;

/**
 * POJO del dominio: un agente de BugHunters.
 * Se usará para crear el XML con JDOM2.
 */
public class Agente {
    private int id;
    private String alias;
    private short equipo;
    private double recompensa;

    public Agente(int id, String alias, short equipo, double recompensa) {
        this.id = id;
        this.alias = alias;
        this.equipo = equipo;
        this.recompensa = recompensa;
    }

    public int getId() { return id; }
    public String getAlias() { return alias; }
    public short getEquipo() { return equipo; }
    public double getRecompensa() { return recompensa; }

    @Override
    public String toString() {
        return "Agente{id=" + id + ", alias='" + alias + "', equipo=" + equipo + ", recompensa=" + recompensa + "}";
    }
}