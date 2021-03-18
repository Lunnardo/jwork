public class Jwork
{
    public Jwork()
    {
        
        
    }
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Utara", "Kota Lahir");
        System.out.println(location1.getProvince());
        location1.setProvince("Jawa Barat");
        System.out.println(location1.getProvince());

        Recruiter recruite1 = new Recruiter(1, "Lunnardo", "lunnardo@gmail.com", "08121234567", location1);
        System.out.println(recruite1.getEmail());
        
        Job job1 = new Job(1,"Gagan", recruite1, 100, "Kebersihan" );
        System.out.println(job1.getName());
        
        Jobseeker jobseeke1 = new Jobseeker(1, "Asep", "asep@gmail.com", "password", "14-03-2021");
        System.out.println(jobseeke1.getName());
        
        Invoice invoice1 = new Invoice(1, 2, "12 Maret 2021", 2, jobseeke1);
        System.out.println(invoice1.getDate());
    }
}
