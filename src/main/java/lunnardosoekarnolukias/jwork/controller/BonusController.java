package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.Bonus;
import lunnardosoekarnolukias.jwork.DatabaseBonusPostgre;
import lunnardosoekarnolukias.jwork.ReferralCodeAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class ini berfungsi untuk mengatur segala request atau end point
 * yang berkaitan dengan isi dari database bonus
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */

@RequestMapping("/bonus")
@RestController
public class BonusController {
    /**
     * Method ini berfungsi untuk menampilkan seluruh isi database bonus
     *
     * @return Semua isi dari database bonus
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus() {
    return DatabaseBonusPostgre.getBonusDatabase();
}

    /**
     * Method ini berfungsi untuk menampilkan bonus
     * berdasarkan referral code yang dimasukkan
     *
     * @return isi dari bonus berdasarkan referral code
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable(value = "referralCode") String referralCode) {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    /**
     * Method ini berfungsi untuk menambahkan bonus baru dengan memasukkan parameter berikut :
     * @param referralCode bernilai string berisikan kode referral code yang dapat dimasukkan
     * @param extraFee bernilai int berisikan biaya tambahan yang didapatkan ketika memasukkan referral code
     * @param minTotalFee bernilai string berisikan jumlah biaya minimal yang harus dibayarkan
     * @param active bernilai boolean menunjukkan apakah bonus tersebut ada
     *
     * @throws ReferralCodeAlreadyExistsException akan diberikan apabila referral code sudah ada di database
     * @return isi dari bonus yang dimasukkan sesuai parameter
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(
            @RequestParam(value = "referralCode") String referralCode,
            @RequestParam(value = "extraFee") int extraFee,
            @RequestParam(value = "minTotalFee") int minTotalFee,
            @RequestParam(value = "active") boolean active

    ) throws ReferralCodeAlreadyExistsException {
        Bonus bonus = new Bonus(DatabaseBonusPostgre.getLastBonusId() + 1,
                referralCode, extraFee, minTotalFee, active);
        DatabaseBonusPostgre.insertBonus(bonus);
        return bonus;
    }
}
