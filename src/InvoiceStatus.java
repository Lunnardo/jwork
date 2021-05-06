public enum InvoiceStatus
{
    OnGoing, Finished, Cancelled;
    
    public String toString()
    {
        switch(this)
        {
            case OnGoing:
            return "Ongoing";
            case Finished:
            return "Finished";
            case Cancelled:
            return "Cancelled";
            default:
            return null;
        }
    }

}