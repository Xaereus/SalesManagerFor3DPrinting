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

    private Map<String, Order> orders;
    private Map<String, Customer> customers;
    private Map<String, Model> models;
    private Map<String, Piece> pieces;
    private Map<String, Filament> filaments;
    private Map<String, Material> materials;

    /*
     * Where the .json files will be saved/are saved. Will be implemented with
     * the save as system to change where files are to be saved.
     */
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

    //=================================ORDERS===================================
    public Collection<Order> getOrders(){
        return orders.values();
    }

    public Order getOrder(String key){
        return orders.get(key);
    }

    public void putOrder(Order order){
        orders.put(order.getName(), order);
    }

    //=================================CUSTOMERS================================
    public Collection<Customer> getCustomers(){
        return customers.values();
    }

    public Customer getCustomer(String key){
        return customers.get(key);
    }

    public void putCustomer(Customer customer){
        customers.put(customer.getName(), customer);
    }

    //=================================MODELS===================================
    public Collection<Model> getModels(){
        return models.values();
    }
    
    public Collection<String> getModelNames(){
        return models.keySet();
    }

    public Model getModel(String key){
        return models.get(key);
    }

    public void putModel(Model model){
        models.put(model.getName(), model);
    }

    //=================================PIECES===================================
    public Collection<Piece> getPieces(){
        return pieces.values();
    }

    public Piece getPiece(String key){
        return pieces.get(key);
    }

    public void putPiece(Piece piece){
        pieces.put(piece.getName(), piece);
    }

    //=================================FILAMENTS================================
    public Collection<Filament> getFilaments(){
        return filaments.values();
    }

    public Filament getFilament(String key){
        return filaments.get(key);
    }

    public void putFilament(Filament filament){
        filaments.put(filament.getName(), filament);
    }

    //=================================MATERIALS================================
    public Collection<Material> getMaterials(){
        return materials.values();
    }

    public Material getMaterial(String key){
        return materials.get(key);
    }

    public void putMaterial(Material material){
        materials.put(material.getName(), material);
    }

    //=================================I/O======================================
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
        saveModels();
        savePieces();
        saveFilaments();
        saveMaterials();
    }

    public void loadAll() throws IOException{
        loadCustomers();
        loadOrders();
        loadModels();
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
    public void saveModels() throws IOException{
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
    public void loadModels() throws IOException{
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
