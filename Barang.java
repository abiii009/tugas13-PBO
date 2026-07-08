public class Barang {

    private int id;
    private String nama;
    private int stok;
    private double harga;

    public Barang(){}

    public Barang(int id,String nama,int stok,double harga){

        this.id=id;
        this.nama=nama;
        this.stok=stok;
        this.harga=harga;

    }

    public int getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public int getStok(){
        return stok;
    }

    public double getHarga(){
        return harga;
    }

}