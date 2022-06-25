package com.ufv.controllers;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.ufv.objetos.*;
import com.google.gson.Gson;
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
public class ContPrestamo {

    public final String urlPrestamos = "/prestamos";
    private final AtomicInteger nextId = new AtomicInteger();

    private Gson gson = new Gson();


    private ArrayList<Prestamo> prestamolst() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader file = null;
        try {
            file = new FileReader("Prestamos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Prestamo> list;
        Type tipolist = new TypeToken<ArrayList<Prestamo>>() {
        }.getType();

        list = gson.fromJson(file, tipolist);

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

    @GetMapping(urlPrestamos)
    public ArrayList<Prestamo> getAllPrestamos() throws IOException {
        ArrayList<Prestamo> list = prestamolst();
        return list;
    }

    @PutMapping("/modificarPrestamo")
    public ResponseEntity modificarEquipo(@RequestBody ArrayList<Prestamo> u) throws IOException {
        ArrayList<Prestamo> list = prestamolst();
        list.removeIf(prestamos -> prestamos.getId().equals(u.get(0).getId()));
        list.add(u.get(1));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Prestamos.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
