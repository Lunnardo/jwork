package lunnardosoekarnolukias.jwork;
/**
* Class Recruiter berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, name, email, phonenumber, mengambil data dari kelas location, dan menampilkan output berupa nama recruiter
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Recruiter {
    
    private int id;
    private String name, email, phoneNumber;
    private Location location;
    
    /**
    * Field ini berfungsi untuk mendeklarasikan semua nilai yang akan dipakai pada method yang ada dibawahnya
    * Field ini bersifat mutator dimana semua nilai yang ditambahkan this dapat diubah secara manual per classnya
    * tanpa perlu menambahkannya dari class jwork
    */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location){
        this.id = id;
        this.name = name; 
        this.email = email;
        this.phoneNumber= phoneNumber;
        this.location = location;
    }
    
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getId adalah nilai kembalian dari this.id
    */
       public int getId()
    {
        return this.id;
    }
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getName adalah nilai kembalian dari this.name
    */
        public String getName()
    {
        return this.name;
    } 
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getEmail adalah nilai kembalian dari this.email
    */
    public String getEmail()
    {
        return this.email;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getPhoneNumber adalah nilai kembalian dari this.phoneNumber
    */
     public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getLocation adalah nilai kembalian dari this.location
    */
    public Location getLocation()
    {
        return this.location; 
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setId adalah nilai kembalian dari this.id yang didapat dari nilai id
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setId adalah nilai kembalian dari this.id yang didapat dari nilai id
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setName adalah nilai kembalian dari this.name yang didapat dari nilai name
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setPhoneNumber adalah nilai kembalian dari this.phoneNumber yang didapat dari nilai
    * phoneNumber yang dimasukkan pada saat method ini dipanggil
    */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setLocation adalah nilai kembalian dari this.location yang didapat dari nilai
    * location yang dimasukkan pada saat method ini dipanggil
    */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getName pada class recruiter
    */
    public void printData() {
        System.out.println(getName());
    }
    
    public String toString()
    {
        return ("Id = " + id + "\nNama = " + name + "\nNomor Telfon = " + getPhoneNumber() + "\nLocation = " + location.getCity());
    }

}