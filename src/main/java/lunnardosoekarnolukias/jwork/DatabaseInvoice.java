package lunnardosoekarnolukias.jwork;
import java.util.ArrayList;

public class DatabaseInvoice {

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
        Invoice dummy = null;
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getId() == id) {
                    dummy = INVOICE_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new InvoiceNotFoundException(id);
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        ArrayList<Invoice> dummy = new ArrayList<>();
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if (INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId) {
                dummy.add(INVOICE_DATABASE.get(i));
            }
        }
        return dummy;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if ((INVOICE_DATABASE.get(i).getId() == id) && (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing) {
                }
            }
        } catch (Exception error) {
            throw new OngoingInvoiceAlreadyExistsException(invoice);
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getId() == id) {
                    INVOICE_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new InvoiceNotFoundException(id);
        }
        throw new InvoiceNotFoundException(id);
    }
}
