package com.video.juegos.model;
import java.util.List;


public class InventarioJson {
    private List<JuegoFisico> JuegoFisico;
    private List<JuegoDigital> JuegoDigital;

    public InventarioJson() {}

    public List<JuegoFisico> getJuegoFisicos() { return JuegoFisico; }
    public List<JuegoDigital> getJuegoDigital() { return JuegoDigital; }
}