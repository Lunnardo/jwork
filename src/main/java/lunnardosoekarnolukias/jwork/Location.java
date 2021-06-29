package lunnardosoekarnolukias.jwork;
/**
* Class Location berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, name, email, phonenumber, mengambil data dari kelas location, dan menampilkan output berupa nama recruiter
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Location {
    private int id = 0;
    private String province = "", city = "", description = "";
    
    /**
    * Field ini berfungsi untuk mendeklarasikan semua nilai yang akan dipakai pada method yang ada dibawahnya
    * Field ini bersifat mutator dimana semua nilai yang ditambahkan this dapat diubah secara manual per classnya
    * tanpa perlu menambahkannya dari class jwork
    */
    public Location(int id, String province, String city, String description) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.description = description;
    }
    

    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getProvince adalah nilai kembalian dari this.province
    */
    public String getProvince()
    {
        return this.province;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getCity adalah nilai kembalian dari this.city
    */
    public String getCity()
    {
        return this.city;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getDescription adalah nilai kembalian dari this.description
    */
    public String getDescription()
    {
        return this.description;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setProvince adalah nilai kembalian dari this.province yang didapat dari nilai province
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setCity adalah nilai kembalian dari this.city yang didapat dari nilai city
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setDescription adalah nilai kembalian dari this.description yang 
    * didapat dari nilai description yang dimasukkan pada saat method ini dipanggil
    */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getProvince pada class Location
    */
    public void printData()
    {
        System.out.println(getProvince());
    }
    
    public String toString()
    {
        return ("Provinsi = " + getProvince() + "\nKota = " + getCity() + "\nDeskripsi = " + getDescription());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}