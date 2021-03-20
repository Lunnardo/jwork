/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseRecruiter {
    private String[] listRecruiter;
    private Recruiter recruiter;
    
    /**
    * Method ini digunakan untuk mendeklarasikan objek baru bernama listRecruiter yang didalamnya dapat memuat string hingga 100.
    */
    public DatabaseRecruiter(){
       listRecruiter = new String[100];
    }
    
    /**
    * Method mutator ini digunakan untuk mendeklarasikan nilai String[] listRecruiter akan dimasukkan ke dalam variabel listRecruiter.
    */
    public DatabaseRecruiter(String[] listRecruiter){
        this.listRecruiter = listRecruiter;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addRecruiter pada database recruiter.
    * @return true
    */
    public boolean addRecruiter(Recruiter recruiter){
    return true;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeRecruiter pada database recruiter.
    * @return true
    */
    public boolean removeRecruiter(Recruiter recruiter){
    return true;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai null untuk getRecruiter pada database recruiter.
    * @return null
    */
    public Job getRecruiter(){
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJob pada database job.
    * @return true
    */
    public String[] getListRecruiter(){
        return listRecruiter;
    }
}