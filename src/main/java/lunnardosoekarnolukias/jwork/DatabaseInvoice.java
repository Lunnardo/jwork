package lunnardosoekarnolukias.jwork;
import java.util.ArrayList;

public class DatabaseInvoice {
    // instance variable dari DatabaseInvoice
    private static  ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;
    private static int id;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        Invoice result = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                result = invoice;
            } else {
                result = null;
            }
        }
        if (result == null){
            throw new InvoiceNotFoundException(id);
        }

        return result;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId){
        try {
            ArrayList<Invoice> dummy = new ArrayList<Invoice>();
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId) {
                    dummy.add(INVOICE_DATABASE.get(i));
                    return dummy;
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("NullPointer detected!");
        }
        return null;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for(int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if ((INVOICE_DATABASE.get(i).getId() == id) && (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException{
        for (Invoice invoicee : INVOICE_DATABASE) {
            if (invoicee.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
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
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}
