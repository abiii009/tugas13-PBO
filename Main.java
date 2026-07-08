import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner input=new Scanner(System.in);

    public static void main(String[] args){

        while(true){

            System.out.println("\n===== TOKO RETAIL =====");
            System.out.println("1. Tampilkan Barang");
            System.out.println("2. Tambah Barang");
            System.out.println("3. Ubah Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");

            System.out.print("Pilih : ");

            int pilih=input.nextInt();

            switch(pilih){

                case 1:
                    tampilBarang();
                    break;

                case 2:
                    tambahBarang();
                    break;

                case 3:
                    ubahBarang();
                    break;

                case 4:
                    hapusBarang();
                    break;

                case 5:
                    System.exit(0);

            }

        }

    }

    static void tampilBarang(){

        try{

            Statement st=Koneksi.getConnection().createStatement();

            ResultSet rs=st.executeQuery("SELECT * FROM barang");

            System.out.println("--------------------------------------------");
            System.out.println("ID\tNama\t\tStok\tHarga");

            while(rs.next()){

                System.out.println(
                rs.getInt(1)+"\t"+
                rs.getString(2)+"\t"+
                rs.getInt(3)+"\t"+
                rs.getDouble(4));

            }

        }catch(Exception e){

            System.out.println(e);

        }

    }

    static void tambahBarang(){

        input.nextLine();

        System.out.print("Nama Barang : ");
        String nama=input.nextLine();

        System.out.print("Stok : ");
        int stok=input.nextInt();

        System.out.print("Harga : ");
        double harga=input.nextDouble();

        try{

            String sql="INSERT INTO barang(nama_barang,stok,harga) VALUES(?,?,?)";

            PreparedStatement ps=Koneksi.getConnection().prepareStatement(sql);

            ps.setString(1,nama);
            ps.setInt(2,stok);
            ps.setDouble(3,harga);

            ps.executeUpdate();

            System.out.println("Data berhasil ditambah.");

        }catch(Exception e){

            System.out.println(e);

        }

    }

    static void ubahBarang(){

        System.out.print("ID Barang : ");

        int id=input.nextInt();

        input.nextLine();

        System.out.print("Nama Baru : ");

        String nama=input.nextLine();

        System.out.print("Stok Baru : ");

        int stok=input.nextInt();

        System.out.print("Harga Baru : ");

        double harga=input.nextDouble();

        try{

            String sql="UPDATE barang SET nama_barang=?,stok=?,harga=? WHERE id_barang=?";

            PreparedStatement ps=Koneksi.getConnection().prepareStatement(sql);

            ps.setString(1,nama);
            ps.setInt(2,stok);
            ps.setDouble(3,harga);
            ps.setInt(4,id);

            ps.executeUpdate();

            System.out.println("Data berhasil diubah.");

        }catch(Exception e){

            System.out.println(e);

        }

    }

    static void hapusBarang(){

        System.out.print("ID Barang : ");

        int id=input.nextInt();

        try{

            String sql="DELETE FROM barang WHERE id_barang=?";

            PreparedStatement ps=Koneksi.getConnection().prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println("Data berhasil dihapus.");

        }catch(Exception e){

            System.out.println(e);

        }

    }

}