/**
* Class Jobseeker berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, nama, email, password, dan tanggal masuk dari jobseeker
* seluruh class menggunakan fungsi asesor, mutator, dan fungsi untuk mencetak nama jobseeker
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Jobseeker{
    private int id;
    private String name, email, password, joinDate;

    public Jobseeker(int id, String name, String email, String password, String joinDate){
        this.id = id;
        this.name = name; 
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa id jobseeker.
    * @return this.id
    */
    public int getId(){
        return this.id;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nama jobseeker.
    * @return this.name
    */
    public String getName(){
        return this.name;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa email jobseeker.
    * @return this.email
    */
    public String getEmail(){
        return this.email;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa password jobseeker.
    * @return this.password
    */
    public String getPassword(){
        return this.password;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa tanggal masuk jobseeker.
    * @return this.joinDate
    */
    public String getJoinDate(){
        return this.joinDate;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setId adalah nilai kembalian dari this.id 
    * yang didapat dari nilai id yang dimasukkan pada saat method ini dipanggil
    */
    public void setId(int id){
        this.id = id;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setName adalah nilai kembalian dari this.name 
    * yang didapat dari nilai name yang dimasukkan pada saat method ini dipanggil
    */
    public void setName(String name){
        this.name = name;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setEmail adalah nilai kembalian dari this.email 
    * yang didapat dari nilai email yang dimasukkan pada saat method ini dipanggil
    */
    public void setEmail(String email){
        this.email = email;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setPassword adalah nilai kembalian dari this.password 
    * yang didapat dari nilai password yang dimasukkan pada saat method ini dipanggil
    */
    public void setPassword(String password){
        this.password = password;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJoinDate adalah nilai kembalian dari this.joinDate 
    * yang didapat dari nilai joinDate yang dimasukkan pada saat method ini dipanggil
    */
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getName pada class Jobseeker
    */
    public void printData(){
        System.out.println(getName());
    }
}