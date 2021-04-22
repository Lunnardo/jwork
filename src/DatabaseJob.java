import java.util.ArrayList;

/**
* Class DatabaseJob berfungsi untuk menampilkan daftar listjob yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/
public class DatabaseJob {
    private static String[] listJob;
    private static ArrayList<Job> JOB_DATABASE;
    private static int lastId = 0;
    private static int id, recruiterId;
    private JobCategory category;

    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    public int getLastId() {
        return lastId;
    }
    public static Job getJobById(int id)
    {
        for (int i = 0; i < JOB_DATABASE.size()-1; i++)
        {
            if(JOB_DATABASE.get(i).getId() == id)
            {
                return JOB_DATABASE.get(i);
            }
            else
            {
                return null;
            }
        }
        return null;
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        for (int i = 0; i < JOB_DATABASE.size();i++)
        {
            if(JOB_DATABASE.get(i).getRecruiter().getId() == recruiterId)
            {
                ArrayList<Job> dummy = new ArrayList<Job>();
                dummy.add(JOB_DATABASE.get(i));
                return dummy;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        for (int i = 0; i < JOB_DATABASE.size();i++)
        {
            if(JOB_DATABASE.get(i).getCategory() == category)
            {
                ArrayList<Job> dummy = new ArrayList<Job>();
                dummy.add(JOB_DATABASE.get(i));
                return dummy;
            }
        }
        return null;
    }


    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk addJob pada database job.
    * @return true
    */
    public static boolean addJob(Job job){
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }
        /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai true untuk removeJob pada database job.
    * @return true
    */
    public boolean removeJob(int id){
        for (int i = 0; i < JOB_DATABASE.size(); i++)
        {
            if(JOB_DATABASE.get(i).getId() == id)
            {
                JOB_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
    * Method asesor ini digunakan untuk mengembalikan nilai berupa nilai dari listJob untuk getListJob pada database job.
    * @return true
    */
    public static String[] getListJob(){
        return listJob;
    }
}