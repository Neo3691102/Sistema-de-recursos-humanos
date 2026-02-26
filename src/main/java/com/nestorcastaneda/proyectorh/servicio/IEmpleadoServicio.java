package com.nestorcastaneda.proyectorh.servicio;

import com.nestorcastaneda.proyectorh.entidad.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadoporId(int id);
    public Empleado guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
}
