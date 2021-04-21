/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJob {
    private static String[] listJob;
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addJob pada database job.
    * @return true
    */
    public boolean addJob(Job job){
    return true;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeJob pada database job.
    * @return true
    */
    public boolean removeJob(Job job){
    return true;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai null untuk getJob pada database job.
    * @return null
    */
    public Job getJob(){
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJob pada database job.
    * @return true
    */
    public static String[] getListJob(){
        return listJob;
    }
}