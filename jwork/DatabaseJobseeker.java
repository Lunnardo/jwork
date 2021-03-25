/**
* Class DatabaseJobseeker berfungsi untuk menampilkan daftar listjobseeker yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJobseeker {
    private static String[] listJobseeker;
        
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addJobseeker pada database Jobseeker.
    * @return true
    */
    public static boolean addJobseeker(Recruiter recruiter){
    return true;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeJobseeker pada database rJobseeker.
    * @return true
    */
    public static boolean removeJobseeker(Recruiter recruiter){
    return true;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai null untuk getJobseeker pada database Jobseeker.
    * @return null
    */
    public static Job getJobseeker(){
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJobseeker pada database Jobseeker.
    * @return listJobseeker
    */
    public static String[] getListJobseeker(){
        return listJobseeker;
    }
}