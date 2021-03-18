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

        recruite1.setEmail("lunnardo@gmail.com");

        System.out.println(recruite1.getEmail());
        
        Job job1 = new Job(1,"Gagan", recruite1, 100, "Kebersihan" );
        System.out.println(job1.getName());
        
        Jobseeker jobseeke1 = new Jobseeker(1, "Asep", "asep@gmail.com", "password", "14-09-2020");
        System.out.println(jobseeke1.getName());
        
    }
    
    
}
