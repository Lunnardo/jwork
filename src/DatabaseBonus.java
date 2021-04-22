import java.util.ArrayList;

/**
* Class DatabaseBonus ini berfungsi untuk mengambil nilai dan menampilkan output berupa
* addbonus, removebonus, getbonus, dan getlistbonus
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210401
*/
public class DatabaseBonus {
    private static String[] listBonus;
    private static ArrayList<Bonus> BONUS_DATABASE;
    private static int lastId;
    private static int id;
    private static String referralCode;

    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

    public static Bonus getBonusByid(int id)
    {
        for (int i = 0; i < BONUS_DATABASE.size()-1; i++)
        {
            if(BONUS_DATABASE.get(i).getId() == id)
            {
                return BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    public static Bonus getBonusByReferralCode(String referralCode)
    {
        for (int i = 0; i < BONUS_DATABASE.size(); i++)
        {
            if(BONUS_DATABASE.get(i).getReferralCode() == referralCode)
            {
                return BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    public static Bonus getBonus(){
        return null;
    }

    public static boolean addBonus(Bonus bonus){
        for (int i = 0; i < BONUS_DATABASE.size(); i++)
        {
            if(BONUS_DATABASE.get(i).getReferralCode() == bonus.getReferralCode())
            {
                return false;
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activateBonus(int id){
        boolean i = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(true);
                i = true;
            }
        }
        return i;
    }

    public static boolean deactivateBonus(int id){
        boolean i = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(false);
                i = true;
            }
        }
        return i;
    }

    public static boolean removeBonus(int id){
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                BONUS_DATABASE.remove(bonus);
                return true;
            }
        }
        return false;
    }


    public static String[] getListBonus(){
        return listBonus;
    }
}