/**
* Class Job berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, name, Fee, category, dan mengambil data dari kelas recruiter.
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Job {
    private int id, fee;
    private String name;
    private Recruiter recruiter;
    private JobCategory category;
    
    /**
    * Field ini berfungsi untuk mendeklarasikan semua nilai yang akan dipakai pada method yang ada dibawahnya
    * Field ini bersifat mutator dimana semua nilai yang ditambahkan this dapat diubah secara manual per classnya
    * tanpa perlu menambahkannya dari class jwork
    */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category){
        this.id = id;
        this.name = name; 
        this.recruiter = recruiter;
        this.fee= fee;
        this.category = category;
    }
    
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getId adalah nilai kembalian dari id
    */
  public int getId()
    {
        return id;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getName adalah nilai kembalian dari name
    */
    public String getName()
    {
        return name;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getFee adalah nilai kembalian dari fee
    */
    public int getFee()
    {
        return fee;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getCategory adalah nilai kembalian dari category
    */
    public JobCategory getCategory()
    {
        return category;
    }
    /**
    * Method accessor ini mendeklarasikan bahwa isi dari method getRecruiter adalah nilai kembalian dari recruiter
    */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setId adalah nilai kembalian dari this.id yang didapat dari nilai id
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setId(int id)
    {
       this.id = id;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setName adalah nilai kembalian dari this.name yang didapat dari nilai name
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setName(String name)
    {
       this.name = name;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setRecruiter adalah nilai kembalian dari this.recruiter yang didapat dari nilai recruiter
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setRecruiter(Recruiter recruiter)
    {
       this.recruiter = recruiter;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setFee adalah nilai kembalian dari this.fee yang didapat dari nilai fee
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    /**
    * Method mutator ini mendeklarasikan bahwa isi dari method setCategory adalah nilai kembalian dari this.category yang didapat dari nilai category
    * yang dimasukkan pada saat method ini dipanggil
    */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }
    /**
    * Method ini berfungsi untuk menampilkan isi dari method getName pada class Job
    */
    public void printData()
    {
        System.out.println("===================== JOB =====================");
        System.out.print("ID: " + id + "\n");
        System.out.print("Name: " + name + "\n");
        System.out.print("Recruiter: " + recruiter.getName() + "\n" );
        System.out.print("City: " + recruiter.getLocation().getCity() + "\n" );
        System.out.print("Fee: " + fee + "\n" );
        System.out.print("Category: " + category + "\n");
    }

}