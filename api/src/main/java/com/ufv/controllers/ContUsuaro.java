package com.ufv.controllers;

import com.ufv.objetos.Usuario;
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
public class ContUsuaro {
    public final String urlUsuarios = "/usuarios";
    private final AtomicInteger nextId = new AtomicInteger();

    private ArrayList<Usuario> userlst() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader file = null;
        try {
            file = new FileReader("Usuarios.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Usuario> list;
        Type tipolist = new TypeToken<ArrayList<Usuario>>() {
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
    @GetMapping(urlUsuarios)
    public ArrayList<Usuario> getAllUsuarios() throws IOException {
        ArrayList<Usuario> list = userlst();
        return list;
    }


    @PostMapping(urlUsuarios)
    public ResponseEntity addUsuario(@RequestBody Usuario u) throws IOException {

        ArrayList<Usuario> list = userlst();

        if(list.size()!=0){
            int temp=0;
            for (Usuario user : list) {
                if(user.getId()>temp){
                    temp = user.getId();
                }
            }
            nextId.set(temp+1);
        }
        else{
            nextId.set(0);
        }

        u.setId(nextId.getAndIncrement());

        list.add(u);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Usuarios.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/modificarUsuario")
    public ResponseEntity modificarUsuario(@RequestBody ArrayList<Usuario> u) throws IOException {
        ArrayList<Usuario> list = userlst();
        list.removeIf( usuarios -> usuarios.getId().equals(u.get(0).getId()));
        list.add(u.get(1));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Usuarios.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    /*
    @PutMapping("/modificarUsuario")
    public ResponseEntity modificarUsuario (@RequestBody Usuario usuarioModificado) throws IOException {

        ArrayList<Usuario> list = userlst();
        int id = usuarioModificado.getId();
        for (Usuario user : list) {
            if(user.getId()==id){
                user.modificarUsuario(usuarioModificado);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Usuarios.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
     */


    @PostMapping("/eliminarUsuario")
    public ResponseEntity eliminarUsuario(@RequestBody Usuario u) throws IOException {
        ArrayList<Usuario> list = userlst();
        list.removeIf( usuarios -> usuarios.getId().equals(u.getId()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter file = new FileWriter("Usuarios.json");
            gson.toJson(list, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
