import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection(){

        try{

            if(koneksi==null){

                String url="jdbc:mysql://localhost:3306/toko_retail";
                String user="root";
                String password="";

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

                koneksi=DriverManager.getConnection(url,user,password);

            }

        }catch(Exception e){

            System.out.println(e);

        }

        return koneksi;

    }

}