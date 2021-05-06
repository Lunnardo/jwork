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
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
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

    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus temp = null;

        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                temp = bonus;
                return temp;
            }
        }
        throw new BonusNotFoundException(id);
    }


    public static Bonus getBonusByRefferalCode(String refferalCode) throws BonusNotFoundException {
        Bonus x = null;

        try{
            for (Bonus bonus : BONUS_DATABASE) {
                if (refferalCode.equals(bonus.getReferralCode())) {
                    x = bonus;
                }
            }
        }
        catch (Exception e){
            throw new BonusNotFoundException(id);
        }
        return x;
    }

    public static Bonus getBonus(){
        return null;
    }

    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        for (Bonus element : BONUS_DATABASE) {
            if (element.getReferralCode() == bonus.getReferralCode()) {
                throw new ReferralCodeAlreadyExistsException(bonus);
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

    public static boolean removeBonus(int id) throws BonusNotFoundException {
        try{
            for (Bonus bonus : BONUS_DATABASE) {
                if (bonus.getId() == id) {
                    BONUS_DATABASE.remove(bonus);
                    return true;
                }
            }
        }
        catch (Exception e){
            throw new BonusNotFoundException(id);
        }
        return false;
    }


    public static String[] getListBonus(){
        return listBonus;
    }
}