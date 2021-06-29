package lunnardosoekarnolukias.jwork;
/**
* Class Invoice berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, idJob, totalFee, tanggal, dan mengambil data dari kelas jobseeker.
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Invoice {
    protected int totalFee;
    private int id;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    private ArrayList<Job> jobs;
    private Calendar date;

    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
    }

    /**
     * getId untuk mendapatkan nilai dari property id
     *
     * @return nilai dari property id
     */
    public int getId() {
        return id;
    }

    /**
     * getId untuk mendapatkan nilai dari property date
     *
     * @return nilai dari property date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * getTotalFee untuk mendapatkan nilai dari property totalFee
     *
     * @return nilai dari property totalFee
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * getJobseeker untuk mendapatkan nilai dari objek jobseeker
     *
     * @return nilai dari objek jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    /**
     * getPaymentType untuk mendapatkan nilai dari objek paymentType
     *
     * @return nilai dari objek paymentType
     */
    public abstract PaymentType getPaymentType();

    /**
     * getJobs untuk mendapatkan nilai dari objek jobs
     *
     * @return nilai dari objek jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * getInvoiceStatus untuk mendapatkan nilai dari objek invoiceStatus
     *
     * @return nilai dari objek status
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * setId untuk menggantikan nilai dari property id
     *
     * @param id, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * setJob untuk menggantikan nilai dari property pada objek Jobs
     *
     * @param jobs, property yang nilainya akan digantikan, dengan tipe jobs
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }


    /**
     * setDate untuk menggantikan nilai dari property date
     *
     * @param date, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setDate(Calendar date){
        this.date = date;
    }

    /**
     * setDate untuk menggantikan nilai year, month, dan dayOfMonth
     *
     * @param year, month, dan dayOfMonth
     */
    public void setDate(int year, int month, int dayOfMonth){
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    /**
     * setTotalFee untuk menggantikan nilai dari property totalFee
     *
     * @param , property yang nilainya akan digantikan, dengan tipe int
     */
    public abstract void setTotalFee();

    /**
     * setJobseeker untuk menggantikan nilai dari property pada objek jobseeker
     *
     * @param jobseeker, property yang nilainya akan digantikan, dengan tipe Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * setInvoiceStatus untuk menggantikan nilai dari property pada objek invoiceStatus
     *
     * @param , property yang nilainya akan digantikan, dengan tipe status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * toString digunakan untuk menampilkan berbagai parameter
     */
    public abstract String toString();
}