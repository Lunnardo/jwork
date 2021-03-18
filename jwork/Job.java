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
    private String name, category;
    private Recruiter recruiter;
    
    public Job(int id, String name, Recruiter recruiter, int Fee, String Category){
        this.id = id;
        this.name = name; 
        this.recruiter = recruiter;
        this.fee= fee;
        this.category = category;
    }

  public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getFee()
    {
        return fee;
    }
    public String getCategory()
    {
        return category;
    }
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    public void setId(int id)
    {
       this.id = id;
    }
    public void setName(String name)
    {
       this.name = name;
    }
    public void setRecruiter(Recruiter recruiter)
    {
       this.recruiter = recruiter;
    }
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public void printData()
    {
        
    }
    

}