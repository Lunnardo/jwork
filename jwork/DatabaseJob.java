/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJob {
    private String[] listJob;
    
    
    /**
    * Method ini digunakan untuk mendeklarasikan objek baru bernama listJob yang didalamnya dapat memuat string hingga 100.
    */
    public DatabaseJob(){
       listJob = new String[100];
    }
    
    /**
    * Method mutator ini digunakan untuk mendeklarasikan nilai String[] listJob akan dimasukkan ke dalam variabel listJob.
    */
    public DatabaseJob(String[] listJob){
        this.listJob = listJob;
    }
    
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
    public String[] getListJob(){
        return listJob;
    }
}