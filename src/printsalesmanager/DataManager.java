/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Xaereus
 */
public final class DataManager{

    private Map<String, Customer> customers;
    private Map<String, Order> orders;
    private Map<String, Model> models;
    private Map<String, Piece> pieces;
    private Map<String, Filament> filaments;
    private Map<String, Material> materials;

    private Map<String, String> saveLocations;

    public DataManager(){
        customers = new HashMap<>();
        orders = new HashMap<>();
        models = new HashMap<>();
        pieces = new HashMap<>();
        filaments = new HashMap<>();
        materials = new HashMap<>();

        validateDirs();
        try{
            loadAll();
        } catch(IOException ex){
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void putCustomer(Customer customer){
        customers.put(customer.getName(), customer);
    }

    public Collection<Customer> getCustomers(){
        return customers.values();
    }

    public Collection<Order> getOrders(){
        return orders.values();
    }

    public Collection<Model> getFullModels(){
        return models.values();
    }

    public Collection<Piece> getPieces(){
        return pieces.values();
    }

    public Collection<Filament> getFilaments(){
        return filaments.values();
    }

    public Collection<Material> getMaterials(){
        return materials.values();
    }

    /**
     * Checks all the save directories to insure they exist, creating them if
     * they do not exist.
     */
    public static void validateDirs(){
        File dir = new File("saves\\");

        if(!dir.exists()){
            Boolean created = dir.mkdir();
        }
    }

    public void saveAll() throws IOException{
        saveCustomers();
        saveOrders();
        saveFullModels();
        savePieces();
        saveFilaments();
        saveMaterials();
    }

    public void loadAll() throws IOException{
        loadCustomers();
        loadOrders();
        loadFullModels();
        loadPieces();
        loadFilaments();
        loadMaterials();
    }

    /**
     * Saves the customers HashMap to JSON file called "customers.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void saveCustomers() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\customers.json"))){
            Gson gson = new Gson();
            gson.toJson(customers, new TypeToken<HashMap<String, Customer>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the customers HashMap.
     *
     * @throws IOException
     */
    public void loadCustomers() throws IOException{
        File dir = new File("saves\\customers.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                customers = gson.fromJson(reader, new TypeToken<HashMap<String, Customer>>(){
                }.getType());
            }
    }

    /**
     * Saves the orders HashMap to JSON file called "orders.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void saveOrders() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\orders.json"))){
            Gson gson = new Gson();
            gson.toJson(orders, new TypeToken<HashMap<String, Order>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the orders HashMap.
     *
     * @throws IOException
     */
    public void loadOrders() throws IOException{
        File dir = new File("saves\\orders.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                orders = gson.fromJson(reader, new TypeToken<HashMap<String, Order>>(){
                }.getType());
            }
    }

    /**
     * Saves the fullModels HashMap to JSON file called "models.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void saveFullModels() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\models.json"))){
            Gson gson = new Gson();
            gson.toJson(models, new TypeToken<HashMap<String, Model>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the models HashMap.
     *
     * @throws IOException
     */
    public void loadFullModels() throws IOException{
        File dir = new File("saves\\models.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                models = gson.fromJson(reader, new TypeToken<HashMap<String, Model>>(){
                }.getType());
            }
    }

    /**
     * Saves the pieces HashMap to JSON file called "pieces.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void savePieces() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\pieces.json"))){
            Gson gson = new Gson();
            gson.toJson(pieces, new TypeToken<HashMap<String, Piece>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the pieces HashMap.
     *
     * @throws IOException
     */
    public void loadPieces() throws IOException{
        File dir = new File("saves\\pieces.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                pieces = gson.fromJson(reader, new TypeToken<HashMap<String, Piece>>(){
                }.getType());
            }
    }

    /**
     * Saves the filaments HashMap to JSON file called "filaments.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void saveFilaments() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\filaments.json"))){
            Gson gson = new Gson();
            gson.toJson(filaments, new TypeToken<HashMap<String, Filament>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the filaments HashMap.
     *
     * @throws IOException
     */
    public void loadFilaments() throws IOException{
        File dir = new File("saves\\filaments.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                filaments = gson.fromJson(reader, new TypeToken<HashMap<String, Filament>>(){
                }.getType());
            }
    }

    /**
     * Saves the materials HashMap to JSON file called "materials.json" in the
     * current directory.
     *
     * @throws java.io.IOException
     */
    public void saveMaterials() throws IOException{
        try(JsonWriter writer = new JsonWriter(new FileWriter("saves\\materials.json"))){
            Gson gson = new Gson();
            gson.toJson(materials, new TypeToken<HashMap<String, Material>>(){
            }.getType(), writer);
        }
    }

    /**
     * Loads a JSON file to the materials HashMap.
     *
     * @throws IOException
     */
    public void loadMaterials() throws IOException{
        File dir = new File("saves\\materials.json");
        if(dir.exists())
            try(JsonReader reader = new JsonReader(new FileReader(dir))){
                Gson gson = new Gson();
                materials = gson.fromJson(reader, new TypeToken<HashMap<String, Material>>(){
                }.getType());
            }
    }

}
