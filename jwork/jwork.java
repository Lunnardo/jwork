/**
* Class Jwork berfungsi untuk mendeklarasikan suatu objek dimana isi dari objek tersebut berupa nilai variable untuk sebuah class yang dideklarasikan.
* Kemudian nilai dari class tersebut akan sesuai dengan objek tersebut dan salah satu nilai tersebut akan ditampilkan dengan fungsi println.
* Dimana fungsi ini akan memanggil method pada class tersebut sehingga nilai dari method tersebut akan ditampilkan sesuai dengan isi method
* dari kelas tersebut.
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
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
        Location location1 = new Location("DKI Jakarta", "Jakarta Utara", "Kota Lahir");
        System.out.println(location1.getProvince());
        
        location1.setProvince("Jawa Barat");
        System.out.println(location1.getProvince());

        Recruiter recruite1 = new Recruiter(1, "Lunnardo", "lunnardo@gmail.com", "08121234567", location1);
        System.out.println(recruite1.getEmail());
        
        Job job1 = new Job(1,"Office Boy", recruite1, 100, "Kebersihan" );
        System.out.println(job1.getName());
        
        Jobseeker jobseeke1 = new Jobseeker(1, "Asep", "asep@gmail.com", "password", "14-03-2021");
        System.out.println(jobseeke1.getName());
        
        Invoice invoice1 = new Invoice(1, 2, "12 Maret 2021", 2, jobseeke1);
        System.out.println(invoice1.getDate());
        
        System.out.println(recruite1.getName());
        recruite1.setName("Hansaka Wijaya");
        System.out.println(recruite1.getName());
        
        job1.printData();
    }
}
