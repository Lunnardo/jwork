package lunnardosoekarnolukias.jwork;
/**
 * Class BonusNotFoundException ini berfungsi menampilkan pesan error
 * ketika Bonus yang dimaksud tidak ada
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
public class BonusNotFoundException extends Exception {
    private int referral_error;

    public BonusNotFoundException(int referral_input){
        super("Bonus ID: ");
        referral_error = referral_input;
    }

    /**
     * Method getMessage ini ketika dipanggil akan menampilkan pesan bahwa Bonus tersebut tidak ditemukan
     */
    public String getMessage() {
        return super.getMessage() + referral_error + " not found";
    }

}