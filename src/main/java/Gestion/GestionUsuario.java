package Gestion;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Modelo.Cliente;

import java.util.HashMap;
import java.util.HashSet;

public class GestionUsuario {

    private HashMap<String, HashSet<Cliente>> clientes;
    private HashMap<String, String> loginData;

    public GestionUsuario() {
        clientes = new HashMap<>();
    }


}
