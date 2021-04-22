import java.util.ArrayList;


/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Recruiter getRecruiterById(int id)
    {
        Recruiter tempVar = null;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()){
                tempVar = recruiter;
            }
            else{
                tempVar =  null;
            }
        }
        return tempVar;
    }

    public static boolean addRecruiter(Recruiter recruiter)
    {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    public static boolean removeRecruiter(int id)
    {
        boolean tempBool = true;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()){
                RECRUITER_DATABASE.remove(id);
                tempBool = true;
            }
            else{
                tempBool = false;
            }
        }
        return tempBool;
    }

}