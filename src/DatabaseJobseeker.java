import java.util.ArrayList;

/**
* Class DatabaseJobseeker berfungsi untuk menampilkan daftar listjobseeker yang ada
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210318
*/

public class DatabaseJobseeker {

    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE;
    private static int lastId = 0;

    public static ArrayList<Jobseeker> getDatabaseJobseeker() {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id) {
        Jobseeker temp = null;
        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (id == JOBSEEKER_DATABASE.get(i).getId()) {
                temp = JOBSEEKER_DATABASE.get(i);
            }
        }
        return temp;
    }

    public static boolean addJobseeker(Jobseeker jobseeker) {
        boolean result = false;
        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (jobseeker.getEmail() == JOBSEEKER_DATABASE.get(i).getEmail()) {
                System.out.println("Email has been registered");
                result = false;
            } else {
                JOBSEEKER_DATABASE.add(jobseeker);
                lastId = jobseeker.getId();
                result = true;
            }

        }
        return result;

    }

    public static boolean removeJobseeker(int id) {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == jobseeker.getId()) {
                JOBSEEKER_DATABASE.remove(jobseeker);
                return true;
            }
        }
        return false;
    }

}