package lunnardosoekarnolukias.jwork;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Class ini berfungsi untuk membuat BankPayment
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
public class BankPayment extends Invoice{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Constructor ini berfungsi untuk membuat objek BankPayment dengan parameter:
     * @param id yang bernilai int
     * @param jobs yang bernilai ArrayList<Job>
     * @param jobseeker yang isinya kelas Jobseeker
     *
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    /**
     * Constructor ini berfungsi untuk membuat objek BankPayment dengan parameter:
     * @param id yang bernilai int
     * @param jobs yang bernilai ArrayList<Job>
     * @param jobseeker yang isinya kelas Jobseeker
     * @param adminFee yang bernilai int
     *
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee) {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }

    /**
     * Method accessor getPaymentType ini akan
     * @return nilai kembali berupa isi dari PAYMENT_TYPE
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    /**
     * Method accessor getAdminFee ini akan
     * @return nilai kembali berupa isi dari adminFee
     */
    public int getAdminFee() {
        return adminFee;
    }

    /**
     * Method mutator setAdminFee ini akan
     * Mengubah adminFee yang lama dengan nilai adminFee yang dimasukkan sebagai parameter
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }
    /**
     * Method mutator setAdminFee ini akan menetapkan nilai totalFee dimana jika adminFee tidak bernilai 0 maka totalFee adalah
     * Fee dari kelas Job yang dikurangi adminFee sementara jika adminFee bernilai 0 maka totalFee = Fee dari job sepenuhnya.
     */
    @Override
    public void setTotalFee() {
        for(int i = 0; i < getJobs().size(); i++) {
            if (adminFee != 0) {
                super.totalFee = getJobs().get(i).getFee() - adminFee;
            } else {
                super.totalFee = getJobs().get(i).getFee();
            }
        }
    }

    /**
     * Method toString ini ketika dipanggil akan menampilkan informasi dimana selama nilai adminFee tidak sama dengan 0
     * maka informasi yang ditampilkan mengenai id, nama job, tanggal, nama jobseeker, adminfee, totalFee,
     * status invoice, dan paymentType berupa bank payment
     *
     * Dan jika adminFee sama denagn 0 maka informasi yang ditampilkan mengenai id, nama job, tanggal, nama jobseeker, totalFee,
     * status invoice, dan paymentType berupa bank payment
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        String res = "";
        for (Job job : getJobs()) {
            if (adminFee != 0) {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nAdmin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            } else {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
        }
        return res;
    }
}