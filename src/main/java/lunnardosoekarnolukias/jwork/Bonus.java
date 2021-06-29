/**
* Class Bonus ini berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, referralcode, extrafee, mintotalfee, dan boolean active
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
*/
package lunnardosoekarnolukias.jwork;
public class Bonus {
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    /**
     * Constructor ini berfungsi untuk membuat objek Bonus dengan parameter:
     * @param id yang bernilai int
     * @param referralCode yang bernilai String
     * @param extraFee yang bernila int
     * @param minTotalFee yang bernila int
     * @param active yang yang bernila boolean
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active) {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * Method accessor getId ini akan
     * @return nilai kembali berupa isi dari id
     */
    public int getId() {
        return id;
    }

    /**
     * Method accessor getReferralCode ini akan
     * @return nilai kembali berupa isi dari referralCode
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * Method accessor getExtraFee ini akan
     * @return nilai kembali berupa isi dari extraFee
     */
    public int getExtraFee() {
        return extraFee;
    }

    /**
     * Method accessor getMinTotalFee ini akan
     * @return nilai kembali berupa isi dari minTotalFee
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }

    /**
     * Method accessor getActive ini akan
     * @return nilai kembali berupa isi dari active
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Method mutator setId ini akan
     * Mengubah id yang lama dengan nilai id yang dimasukkan sebagai parameter
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method mutator setReferralCode ini akan
     * Mengubah referralCode yang lama dengan nilai referralCode yang dimasukkan sebagai parameter
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    /**
     * Method mutator setExtraFee ini akan
     * Mengubah extraFee yang lama dengan nilai extraFee yang dimasukkan sebagai parameter
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    /**
     * Method mutator setMinTotalFee ini akan
     * Mengubah minTotalFee yang lama dengan nilai minTotalFee yang dimasukkan sebagai parameter
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    /**
     * Method mutator setActive ini akan
     * Mengubah active yang lama dengan nilai active yang dimasukkan sebagai parameter
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method printData ini ketika dipanggil akan menampilkan informasi yang berisi
     * id, referralCode, extraFee, minTotalFee, dan active dari kelas bonus
     */
    public void printData() {
        System.out.println("ID: " + id);
        System.out.println("Referral Code: " + referralCode);
        System.out.println("Extra Fee: " + extraFee);
        System.out.println("Min Total Fee: " + minTotalFee);
        System.out.println("Active: " + active);
    }

    /**
     * Method toString ini ketika dipanggil akan menampilkan informasi yang berisi
     * id, referralCode, extraFee, minTotalFee, dan active dari kelas bonus
     */
    public String toString()
    {
        return ("Id = " + id + "\nReferral Code = " + referralCode + "\nExtra Fee= " + getExtraFee() + "\nMin Total Fee = " + getMinTotalFee() + "\nActive Status = " + active);
    }
}