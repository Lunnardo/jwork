/**
* Class Bonus ini berfungsi untuk mengambil nilai dan menampilkan output berupa
* id, referralcode, extrafee, mintotalfee, dan boolean active
* seluruh class menggunakan fungsi asesor dan mutator untuk mengambil dan mengembalikan nilai
*
* @author Lunnardo Soekarno Lukias
* @version 20210401
*/
package lunnardosoekarnolukias.jwork;
public class Bonus {
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active) {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public int getExtraFee() {
        return extraFee;
    }

    public int getMinTotalFee() {
        return minTotalFee;
    }

    public boolean getActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void printData() {
        System.out.println("ID: " + id);
        System.out.println("Referral Code: " + referralCode);
        System.out.println("Extra Fee: " + extraFee);
        System.out.println("Min Total Fee: " + minTotalFee);
        System.out.println("Active: " + active);
    }
    
    public String toString()
    {
        return ("Id = " + id + "\nReferral Code = " + referralCode + "\nExtra Fee= " + getExtraFee() + "\nMin Total Fee = " + getMinTotalFee() + "\nActive Status = " + active);
    }
}