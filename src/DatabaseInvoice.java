import java.util.ArrayList;

public class DatabaseInvoice {
    // instance variable dari DatabaseInvoice
    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;
    private static int id;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id){
        Invoice x = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                x = invoice;
            }
        }
        return x;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId){
        ArrayList<Invoice> temp = new ArrayList<Invoice>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (jobseekerId == invoice.getJobseeker().getId()) {
                temp.add(invoice);
            } else {
                return null;
            }
        }
        return temp;
    }

    public static boolean changeInvoiceStatus(InvoiceStatus invoiceStatus){
        for(int i = 0; i < INVOICE_DATABASE.size();i++)
        {
        if (id == INVOICE_DATABASE.get(i).getId())
        {
            INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
        }
        }
        return true;
    }

    public static boolean addInvoice(Invoice invoice){
        for (int i = 0; i < INVOICE_DATABASE.size(); i++)
        {
            if(INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }
    /**
     * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeInvoice pada database invoice.
     * @return true
     */
    public boolean removeInvoice(Invoice invoice, int id){
        for (Invoice invoice_1 : INVOICE_DATABASE) {
            if (invoice.getId() == invoice_1.getId()) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }
}
