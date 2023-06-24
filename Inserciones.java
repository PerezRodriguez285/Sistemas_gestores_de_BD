/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb1;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Antonio Alberto
 */
public class Inserciones {
    
    private final static String  HOST  = "localhost";
    MongoCredential credencial;
    MongoClient cliente;
    MongoDatabase db;
    MongoCollection coll;
    
    public boolean conexion(){
        try{
            credencial = MongoCredential.createCredential("root", "admin", "mongo21".toCharArray());
            cliente = new MongoClient(new ServerAddress(HOST), Arrays.asList(credencial));                
            db = cliente.getDatabase("ejemplo1" ); 
            System.out.println("Connected to MongoDB: Ejemplo1");   
            
            coll = db.getCollection("Propietario");
        }
        catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return true;
    }
    
    
    public void insertar1(){               
        Document doc = new Document()
                .append("Nombre", "Maria")
                .append("Estado", "CDMX")
                .append("Direccion", new Document()
                        .append("Calle", "Av. Juarez")
                        .append("Num Ext", 2450)
                        .append("CP", 06070)
                );
        
        coll.insertOne(doc);
    }
    
    public void insertar2(){
        List<Document> telefonos = new ArrayList<>();
        telefonos.add(new Document("Celular", "5567767876"));
        telefonos.add(new Document("Trabajo", "5567888888"));
         
        Document doc = new Document("Nombre", "Mike")
           .append("Estado", "SLP")           
           .append("Telefonos", telefonos);
        
         coll.insertOne(doc);
    }
    
        
    public void insertar3(){
        Document tel = new Document("Celular", "5558888800").append("Trabajo", "5567890000");
         
        Document doc = new Document("Nombre", "Alex")
           .append("Estado", "PUE")           
           .append("Telefonos", tel);
        
         coll.insertOne(doc);
    }
    

    public void consultar(){  
        System.out.println("\nConsultar : ");        
        FindIterable<Document> iterableFind = coll.find();
        MongoCursor<Document> cursor = iterableFind.iterator();               
        
        int i = 1;
			
        while (cursor.hasNext()) { 
            System.out.println("Documento: "+i); 
            System.out.println(cursor.next());
            i++;
        }        

        System.out.println("\n\nTotal documentos: " + coll.countDocuments());
        System.out.println("\nPrimer Documento: " + iterableFind.first() );
        
    }
    
    public static void main(String[] args) {
        Inserciones obj = new Inserciones();
        obj.conexion();
        obj.insertar1();
        obj.insertar2();
        obj.insertar3();
        obj.consultar();
    }
  
    
}
