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

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    
    public void printData(){
        System.out.println(getName());
    }
}