public enum PaymentType
{
    BankPayment, EwalletPayment;
    
    public String toString()
    {
        switch(this)
        {
            case BankPayment:
            return "Bank Payment";
            case EwalletPayment:
            return "E-Wallet Payment";
            default:
            return null;
        }
    }
    
}



