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
    private PaymentType paymentType;
    private InvoiceStatus status;
    
    public Invoice(int id, int idJob,String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType,InvoiceStatus status){
        this.id = id;
        this.idJob = idJob; 
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
        
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa id invoice.
    * @return id
    */
   public int getId(){
        return id;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa idJob invoice.
    * @return idJob
    */
    public int getIdJob(){
        return idJob;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa tanggal invoice.
    * @return date
    */
    public String getDate(){
        return date;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa total fee invoice.
    * @return totalFee
    */
    public int getTotalFee(){
        return totalFee;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa jenis pembayaran.
    * @return paymentType
    */
    public PaymentType getPaymentType(){
        return paymentType;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa status invoice.
    * @return status
    */
    public InvoiceStatus getInvoiceStatus(){
        return status;
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setId adalah nilai kembalian dari this.id yang didapat dari nilai id
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setId(int id){
        this.id = id;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setIdJobs adalah nilai kembalian dari this.idJob yang didapat dari nilai idJobs
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setIdJobs(int idJobs){
        this.idJob = idJobs;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setDate adalah nilai kembalian dari this.date yang didapat dari nilai date
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setDate(String date){
        this.date = date;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setTotalFee adalah nilai kembalian dari this.totalFee 
    * yang didapat dari nilai totalFee yang dimasukkan pada saat method ini dipanggil
    */
    public void setTotalFee(int totalFee){
        this.totalFee = totalFee;
    }
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getJobseeker adalah nilai kembalian dari jobseeker
    */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJobseeker adalah nilai kembalian dari this.jobseeker 
    * yang didapat dari nilai jobseeker yang dimasukkan pada saat method ini dipanggil
    */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJobseeker adalah nilai kembalian dari this.jobseeker 
    * yang didapat dari nilai jobseeker yang dimasukkan pada saat method ini dipanggil
    */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJobseeker adalah nilai kembalian dari this.jobseeker 
    * yang didapat dari nilai jobseeker yang dimasukkan pada saat method ini dipanggil
    */
    public void setInvoiceStatus(InvoiceStatus status) {
        this.status = status;
    }
    
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getTotalFee pada class Invoice
    */
    public void printData(){
     System.out.println("===================== INVOICE =====================");
        System.out.print("ID: " + id + "\n");
        System.out.print("ID Job: " + idJob+ "\n");
        System.out.print("Date: " + getDate() + "\n" );
        System.out.print("Seeker: " + jobseeker.getName() + "\n" );
        System.out.print("Fee: " + totalFee + "\n" );
        System.out.print("Status: " + status + "\n");
    }

}