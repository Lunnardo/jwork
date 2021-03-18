/**
* Class Location berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, name, email, phonenumber, mengambil data dari kelas location, dan menampilkan output berupa nama recruiter
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class Location {
    private String province, city, description;

     public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    public String getProvince()
    {
        return this.province;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void printData()
    {
        System.out.println(getProvince());
    }
}