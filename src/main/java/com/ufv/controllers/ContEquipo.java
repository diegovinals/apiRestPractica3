package com.ufv.controllers;

import com.ufv.objetos.Equipo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ContEquipo {
    public final String urlEquipos = "/equipos";
    private final AtomicInteger nextId = new AtomicInteger();


    private ArrayList<Equipo> equipolst() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader file = null;
        try {
            file = new FileReader("Equipos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Equipo> list;
        Type tipolist = new TypeToken<ArrayList<Equipo>>() {
        }.getType();

        list = gson.fromJson(file, tipolist);

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

    //FUNCIONES USUARIOS
    @GetMapping(urlEquipos)
    public ArrayList<Equipo> getAllEquipos() throws IOException {
        ArrayList<Equipo> list = equipolst();
        return list;
    }

    @PostMapping(urlEquipos)
    public ResponseEntity addEquipo(@RequestBody Equipo u) throws IOException {

        ArrayList<Equipo> list = equipolst();

        if (list.size() != 0) {
            int temp = 0;
            for (Equipo user : list) {
                if (user.getId() > temp) {
                    temp = user.getId();
                }
            }
            nextId.set(temp + 1);
        } else {
            nextId.set(0);
        }

        u.setId(nextId.getAndIncrement());

        list.add(u);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Equipos.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/modificarEquipo")
    public ResponseEntity modificarEquipo(@RequestBody ArrayList<Equipo> u) throws IOException {
        ArrayList<Equipo> list = equipolst();
        list.removeIf(equipos -> equipos.getId().equals(u.get(0).getId()));
        list.add(u.get(1));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Equipos.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/eliminarEquipo")
    public ResponseEntity eliminarEquipo(@RequestBody Equipo u) throws IOException {
        ArrayList<Equipo> list = equipolst();
        list.removeIf(equipos -> equipos.getId().equals(u.getId()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Equipos.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
