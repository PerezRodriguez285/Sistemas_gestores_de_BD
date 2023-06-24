/*
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO 
UA: Sistemas gestores de bases de datos
TEMA:
Alumno:  Antonio Alberto de la Luz Perez Rodriguez
Profesor: Mtra. Edith Cristina Herrena Luna
Descripción: 
 */
package mongodb1;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;


//https://search.maven.org/search?q=a:mongo-java-driver

/**
 *

 */
public class MongoDB1 {

    //private final static String  HOST  = "localhost";
    //private final static int PORT = 27020;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try{
                // Connect to mongodb server on localhost
                //MongoClient cliente = new MongoClient(HOST, PORT);
                //MongoDatabase db = cliente.getDatabase("test" );   //DB db = cliente.getDB("ejempo1");
                
                MongoCredential credential = MongoCredential.createCredential("root", "admin", "mongo21".toCharArray());
                MongoClient mongoCliente = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
                //MongoClient mongoCliente = new MongoClient(new ServerAddress("localhost",27020), Arrays.asList(credential));
                //Si el contenedor fue mapeado a otro puerto 27020... al crearse  docker run -d -p 27020:27017 --name
                
                
                //DB db = mongoCliente.getDB("test" ); 
                
                            
                DB db = mongoCliente.getDB( "ejemplo1" );
                DBCollection coll = db.getCollection("persona");
            
                DBObject doc = new BasicDBObject("name","owen")
                .append("age", 30)
                .append("email", "owen@mail.com")
                .append("phone", "111-222-333");
                coll.insert(doc);
    
                System.out.println("Successfully connected to MongoDB");
           }
           catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           }
    }
    
    /*
    
    public static void main( String args[] ){
        try{
            MongoClient mongoClient = new MongoClient(HOST,PORT );
            //MongoDatabase db = mongoClient.getDatabase( "ejemplo1" );
            //MongoCollection coll = db.getCollection("persona");
            
            DB db = mongoClient.getDB( "ejemplo1" );
            DBCollection coll = db.getCollection("persona");
            
            DBObject doc = new BasicDBObject("name","owen")
            .append("age", 47)
            .append("email", "owen@mail.com")
            .append("phone", "111-222-333");
            coll.insert(doc);
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " +e.getMessage() );
        } 
    }*/
}
