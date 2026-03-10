package com.nestorcastaneda.proyectorh.controlador;


import com.nestorcastaneda.proyectorh.entidad.Empleado;
import com.nestorcastaneda.proyectorh.excepcion.RecursoNoEncontradoExcepcion;
import com.nestorcastaneda.proyectorh.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rh-app") //sirve para modificar la url, quedaría http://localhost8080/rh-app
@CrossOrigin(value="http://localhost:3000") //para indicar que se recibirán peticiones del puerto 3000 (frontend)
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    //http:localhost:8080/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        return empleados;
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoxId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(id);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el empleado con el id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadorecibido){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(id);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe " + id);
        }
        empleado.setNombre(empleadorecibido.getNombre());
        empleado.setDepartamento(empleadorecibido.getDepartamento());
        empleado.setSueldo(empleadorecibido.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

}
