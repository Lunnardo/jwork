package lunnardosoekarnolukias.jwork;
/**
* Class Jobseeker berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, nama, email, password, dan tanggal masuk dari jobseeker
* seluruh class menggunakan fungsi asesor, mutator, dan fungsi untuk mencetak nama jobseeker
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Jobseeker{
    private int id;
    private String name, email, password; 
    private Calendar joinDate;
    private Pattern pattern;

    //public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    //{
    //    this.id = id;
    //    this.name = name;
     //   setEmail(email);
     //   setPassword(password);
     //   this.joinDate = joinDate;
    //}

    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
       this.name = name;
        this.email=email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

   public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email=email;
        setPassword(password);
        this.joinDate = joinDate;
    }

    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa id jobseeker.
    * @return this.id
    */
    public int getId(){
        return id;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nama jobseeker.
    * @return this.name
    */
    public String getName(){
        return name;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa email jobseeker.
    * @return this.email
    */
    public String getEmail(){
        return email;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa password jobseeker.
    * @return this.password
    */
    public String getPassword(){
        return password;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa tanggal masuk jobseeker.
    * @return this.joinDate
    */
    public Calendar getJoinDate(){
        return joinDate;
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
        String regex = "^[a-zA-Z0-9&*_~]+([\\.{1}]?[a-z]+)+@[a-z0-9]+([\\.]{1}[a-z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            this.email = email;
        }
        else{
            this.email = " ";
        }
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setPassword adalah nilai kembalian dari this.password 
    * yang didapat dari nilai password yang dimasukkan pada saat method ini dipanggil
    */
    public void setPassword(String password) {
        String regex = "^.*(?=.*[a-z])|(?=.*[A-Z])|(?=.*\\d)[a-zA-Z\\d]{6,}.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            this.password = password;
        }
        else{
            this.password = " ";
        }
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJoinDate adalah nilai kembalian dari this.joinDate 
    * yang didapat dari nilai joinDate yang dimasukkan pada saat method ini dipanggil
    */
    public void setJoinDate(Calendar joinDate){
        this.joinDate = joinDate;
    }

    //public void setJoinDate(int year, int month, int dayOfMonth){
     //   SimpleDateFormat joinDate = new SimpleDateFormat("${dayOfMonth}-${month}-${year}");
    //}
    
    public void setJoinDate(int year, int month, int dayOfMonth){
        this.joinDate.set(Calendar.YEAR, year);
        this.joinDate.set(Calendar.MONTH, month);
        this.joinDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }
    
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getName pada class Jobseeker
    */
    public void printData(){
        System.out.println(getName());
    }
    
     public String toString() {
        if (this.joinDate == null) {
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword();
        } else {
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yyyy");
            String date = formattedDate.format(getJoinDate().getTime());
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword() + "\nJoin Date = " + date;
        }

    }
}