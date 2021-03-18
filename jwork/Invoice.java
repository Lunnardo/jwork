/**
* Class Invoice berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, idJob, totalFee, tanggal, dan mengambil data dari kelas jobseeker.
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Invoice {
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;
    
    public Invoice(int id, int idJob,String date, int totalFee, Jobseeker jobseeker){
        this.id = id;
        this.idJob = idJob; 
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }

   public int getId(){
        return id;
    }
    
    public int getIdJob(){
        return idJob;
    }
    
    public String getDate(){
        return date;
    }
    
    public int getTotalFee(){
        return totalFee;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setIdJobs(int idJobs){
        this.idJob = idJobs;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setTotalFee(int totalFee){
        this.totalFee = totalFee;
    }
    
    public Jobseeker getJobseeker() {
        return jobseeker;
    }
    
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    
    public void printData(){
    
    }

}