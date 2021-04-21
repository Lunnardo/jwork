/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseRecruiter {
    private static String[] listRecruiter;
    private Recruiter recruiter;
        
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addRecruiter pada database recruiter.
    * @return true
    */
    public static boolean addRecruiter(Recruiter recruiter){
    return true;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeRecruiter pada database recruiter.
    * @return true
    */
    public static boolean removeRecruiter(Recruiter recruiter){
    return true;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai null untuk getRecruiter pada database recruiter.
    * @return null
    */
    public static Job getRecruiter(){
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJob pada database job.
    * @return true
    */
    public static String[] getListRecruiter(){
        return listRecruiter;
    }
}