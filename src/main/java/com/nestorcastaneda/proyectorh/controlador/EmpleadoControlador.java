package com.nestorcastaneda.proyectorh.controlador;


import com.nestorcastaneda.proyectorh.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rh-app") //sirve para modificar la url, quedaría http://localhost8080/rh-app
@CrossOrigin(value="http://localhost:3000") //para indicar que se recibirán peticiones del puerto 3000 (frontend)
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;
}
