/**
* Class Jwork berfungsi untuk mendeklarasikan suatu objek dimana isi dari objek tersebut berupa nilai variable untuk sebuah class yang dideklarasikan.
* Kemudian nilai dari class tersebut akan sesuai dengan objek tersebut dan salah satu nilai tersebut akan ditampilkan dengan fungsi println.
* Dimana fungsi ini akan memanggil method pada class tersebut sehingga nilai dari method tersebut akan ditampilkan sesuai dengan isi method
* dari kelas tersebut.
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jwork
{
    /**
    * Field ini tidak berisi nilai
    */
    public Jwork()
    {
        
        
    }
    
    /**
    * Method ini akan mendeklarasikan objek dimana nilai objek ini akan dimasukkan ke dalam class yang dideklarasikan lalu
    * nilai dari method pada class tersebut akan dipanggil dan ditampilkan dengan fungsi println
    */
    public static void main(String[] args)
    {
        System.out.println("Case Study Modul 5");
        //for (JobCategory jobCategory : JobCategory.values())
        //{
           // System.out.println(jobCategory);
        //}
        
        
        //for (PaymentType paymentType : PaymentType.values())
        //{
           // System.out.println(paymentType);
        //}
        
        Location location1 = new Location("DKI Jakarta", "Depok", "Kota Lahir");
        //System.out.println(location1.getProvince());
        
        location1.setProvince("Jawa Barat");
        //System.out.println(location1.getProvince());

        Recruiter recruite1 = new Recruiter(1, "Lunnardo", "lunnardo@gmail.com", "08121234567", location1);
        //System.out.println(recruite1.getEmail());
        
        Job job1 = new Job(2,"Web Developer", recruite1, 20000, JobCategory.WebDeveloper);
        //System.out.println(job1.getName());
        
        Calendar calendar = Calendar.getInstance();
        Jobseeker jobseeke1 = new Jobseeker(1, "Lunnardo", "gajar@gmail.com", "lunnardo",2000, 06, 15 );
        
        //System.out.println(jobseeke1.getName());
        
        Bonus bonus1 = new Bonus (10, "PROMO1", 20000, 20001, true);
        Bonus bonus2 = new Bonus (20, "PROMO2", 20000, 18000, true);

        EwalletPayment invoice1 = new EwalletPayment(1, job1, "13 Desember 2021",jobseeke1, InvoiceStatus.Finished);
        EwalletPayment invoice2 = new EwalletPayment(2, job1, "14 Desember 2021",jobseeke1, InvoiceStatus.Finished, bonus1);
        EwalletPayment  invoice3 = new EwalletPayment(3, job1, "15 Desember 2021",jobseeke1, InvoiceStatus.Finished, bonus2);
        
        
        //Invoice invoice1 = new Invoice(1, job1.getId(), "23-03-2021", 20000000, jobseeke1,PaymentType.BankPayment, InvoiceStatus.Finished );
        //System.out.println(invoice1.getDate());
        
        //System.out.println(recruite1.getName());
        //recruite1.setName("Hansaka Wijaya");
        //System.out.println(recruite1.getName());
        
        //job1.printData();
        //invoice1.printData();
        //System.out.println("\n");
        //invoice1.printData();
        //System.out.println("\n");
        //invoice2.printData();
        //System.out.println("\n");
        //invoice3.printData();
        BankPayment bank1 = new BankPayment(1, job1, "3 April 2021", jobseeke1, InvoiceStatus.Finished);

        BankPayment bank2 = new BankPayment(1, job1, "3 April 2021", jobseeke1, InvoiceStatus.Finished, 2000);

        //bank1.printData();
       //System.out.println("\n");
        //bank2.printData();
        //System.out.println("\n");
        //System.out.println(jobseeke1.toString());
        //System.out.println("\n");
        //System.out.println(job1.toString());
        //System.out.println("\n");
        //System.out.println(recruite1.toString());
        //System.out.println("\n");
        //System.out.println(location1.toString());
        //System.out.println("\n");
        //System.out.println(bonus1.toString());
        
        Jobseeker jobseeker1 = new Jobseeker(1, "Lunnardo", "lunnardo.soekarno", "lunnardo", new GregorianCalendar(2021, 01, 8));
        Jobseeker jobseeker2 = new Jobseeker(2, "Lunnardo", "lunnardo.soekarno@ui.ac.id", "Akagami2.-", 2021, 03, 8);
        Jobseeker jobseeker3 = new Jobseeker(3, "Lunnardo", "lunnardo.soekarno@ui.ac.id", "Akagami2-.");
        System.out.println(jobseeker1.toString());
        System.out.println(jobseeker2.toString());
        System.out.println(jobseeker3.toString());
    }
}
