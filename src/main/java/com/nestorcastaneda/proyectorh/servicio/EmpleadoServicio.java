package com.nestorcastaneda.proyectorh.servicio;

import com.nestorcastaneda.proyectorh.entidad.Empleado;
import com.nestorcastaneda.proyectorh.repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private RepositorioEmpleado repoEmpleado;

    @Override
    public List<Empleado> listarEmpleados() {
        return repoEmpleado.findAll();
    }

    @Override
    public Empleado buscarEmpleadoporId(int id) {

        Empleado empleado = repoEmpleado.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repoEmpleado.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        repoEmpleado.delete(empleado);
    }
}
