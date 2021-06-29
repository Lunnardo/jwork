package lunnardosoekarnolukias.jwork;
public enum InvoiceStatus
{
    OnGoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private String status;

    private InvoiceStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }

    public static void main(String[] args) {
        InvoiceStatus ongoing = InvoiceStatus.OnGoing;
        InvoiceStatus finished = InvoiceStatus.Finished;
        InvoiceStatus cancel = InvoiceStatus.Cancelled;

        System.out.println(ongoing);
        System.out.println(finished);
        System.out.println(cancel);
    }
}