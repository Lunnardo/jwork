/**
* Class Invoice berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, idJob, totalFee, tanggal, dan mengambil data dari kelas jobseeker.
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Invoice {
    private int id;
    private int idJob;  
    protected  int totalFee;
    private Calendar date;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus invoiceStatus;
    private Job job;
    private Bonus bonus;
    
    public Invoice(int id,Job job, Jobseeker jobseeker,InvoiceStatus invoiceStatus){
        this.id = id;
        this.job = job;
        date = Calendar.getInstance();
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
    public Job getJob(){
        return job;
    }
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa tanggal invoice.
    * @return date
    */
    public Calendar getDate(){
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
    public abstract PaymentType getPaymentType();
    
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa status invoice.
    * @return status
    */
    public InvoiceStatus getInvoiceStatus(){
        return invoiceStatus;
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
    public void setJob(Job job){
        this.job = job;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setDate adalah nilai kembalian dari this.date yang didapat dari nilai date
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setDate(Calendar date){
        this.date = date;
    }
    public void setDate(int year, int month, int dayOfMonth){
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setTotalFee adalah nilai kembalian dari this.totalFee 
    * yang didapat dari nilai totalFee yang dimasukkan pada saat method ini dipanggil
    */
    public abstract void setTotalFee();
    
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
    
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    } */
    
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setJobseeker adalah nilai kembalian dari this.jobseeker 
    * yang didapat dari nilai jobseeker yang dimasukkan pada saat method ini dipanggil
    */
    public void setInvoiceStatus(InvoiceStatus status) {
        this.invoiceStatus = invoiceStatus;
    }

    public abstract void printData(); 
    
    
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getTotalFee pada class Invoice
    
    public void printData(){
     System.out.println("===================== INVOICE =====================");
        System.out.print("ID: " + id + "\n");
        System.out.print("ID Job: " + idJob+ "\n");
        System.out.print("Date: " + getDate() + "\n" );
        System.out.print("Seeker: " + jobseeker.getName() + "\n" );
        System.out.print("Fee: " + totalFee + "\n" );
        System.out.print("Status: " + invoiceStatus + "\n");
    }*/
    
    public String toString()
    {
        return ("Id = " + id + "\nID Job = " + idJob + "\nDate = " + getDate() + "\nSeeker = " + jobseeker.getName() + "\nFee = " + totalFee + "\nInvoice Sttaus = " +invoiceStatus);
    }
    
}