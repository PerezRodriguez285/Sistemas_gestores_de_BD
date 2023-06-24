/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb1;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import org.bson.Document;

//https://search.maven.org/search?q=a:mongo-java-driver
//https://mongodb.github.io/mongo-java-driver/3.6/javadoc/?com/mongodb/client/MongoCollection.html

public class MongoDB2 {

    private final static String  HOST  = "localhost";
    private final static int PORT = 27020;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try{
                
                MongoCredential credential = MongoCredential.createCredential("root", "admin", "mongo21".toCharArray());
                //MongoClient mongoCliente = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
                MongoClient mongoCliente = new MongoClient(new ServerAddress(HOST,PORT), Arrays.asList(credential));
                //Si el contenedor fue mapeado a otro puerto 27020... al crearse  docker run -d -p 27020:27017 --name
                
                  MongoDatabase db = mongoCliente.getDatabase("ejemplo2" ); 

                MongoCollection coll = db.getCollection("persona");
            
                Document doc = new Document("name","owen4")
                .append("age", 40)
                .append("email", "owen@mail.com")
                .append("phone", "111-222-333");
                coll.insertOne(doc);
                            
                System.out.println("Successfully connected to MongoDB");
           }
           catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           }
    }
    
 
}
