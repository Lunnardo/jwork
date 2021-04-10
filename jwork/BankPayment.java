public class BankPayment extends Invoice{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    public BankPayment(int id, Job job, Jobseeker jobseeker,
        InvoiceStatus invoiceStatus){
        super(id, job, jobseeker, invoiceStatus);
    }
    public BankPayment(int id, Job job, Jobseeker jobseeker,
        InvoiceStatus invoiceStatus, int adminFee){
        super(id, job,jobseeker, invoiceStatus);
        this.adminFee = adminFee;
    }

    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    public int getAdminFee() {
        return adminFee;
    }
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }
    
        @Override
    public void setTotalFee() {
        if(adminFee > 0){
        totalFee = getJob().getFee() - adminFee;
        } 
        else {
            totalFee = getJob().getFee();
        }
    }
    
    @Override
    public void printData() {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        System.out.println("Admin Fee: " + adminFee);
        setTotalFee();
        System.out.println("Total Fee: " + getTotalFee());
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("Payment Type: " + PAYMENT_TYPE);
    }
    
    public String toString()
    {
        return ("ID= " + getId() + "Job = " + getJob().getName() + "Date = " + getDate() + "Job Seeker = " + getJobseeker().getName() + "Admin Fee = " + adminFee
        + "Total Fee = " + getTotalFee() +  "Status = " + getInvoiceStatus() + "Payment Type = " + PAYMENT_TYPE);
    }
}