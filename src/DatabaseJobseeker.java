import java.util.ArrayList;

/**
* Class DatabaseJobseeker berfungsi untuk menampilkan daftar listjobseeker yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJobseeker {
    private static String[] listJobseeker;
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE;
    private static int lastId = 0;
    private static int id;

    public static ArrayList<Jobseeker> getDatabaseJobseeker()
    {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id)
    {
        for (int i = 0; i < JOBSEEKER_DATABASE.size()-1; i++)
        {
            if(JOBSEEKER_DATABASE.get(i).getId() == id)
            {
                return JOBSEEKER_DATABASE.get(i);
            }
        }
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addJobseeker pada database Jobseeker.
    * @return true
    */
    public static boolean addJobseeker(Jobseeker jobseeker) {
        boolean result = false;
        if (JOBSEEKER_DATABASE.size() == 0){
            JOBSEEKER_DATABASE.add(jobseeker);
            lastId = jobseeker.getId();
            result = true;
            return result;
        }
        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (jobseeker.getEmail().equals(JOBSEEKER_DATABASE.get(i).getEmail())) {
                System.out.println("Email has been registered");
                result = false;
                return result;
            } else {
                JOBSEEKER_DATABASE.add(jobseeker);
                lastId = jobseeker.getId();
                result = true;
                return result;
            }

        }
        return result;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeJobseeker pada database rJobseeker.
    * @return true
    */
    public static boolean removeJobseeker(int id)
    {for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++)
    {
        if(JOBSEEKER_DATABASE.get(i).getId() == id)
        {
            JOBSEEKER_DATABASE.remove(i);
            return true;
        }
    }
        return false;
    }

    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai null untuk getJobseeker pada database Jobseeker.
    * @return null
    */
    public static Job getJobseeker(){
        return null;
    }
    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJobseeker pada database Jobseeker.
    * @return listJobseeker
    */
    public static String[] getListJobseeker(){
        return listJobseeker;
    }
}