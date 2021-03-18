/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJob {
    private String[] listJob;

    public DatabaseJob(){
       listJob = new String[100];
    }
    
    public DatabaseJob(String[] listJob){
        this.listJob = listJob;
    }
    
    public boolean addJob(Job job){
    return true;
    }
    
    public boolean removeJob(Job job){
    return true;
    }
    
    public Job getJob(){
        return null;
    }

    public String[] getListJob(){
        return listJob;
    }
}