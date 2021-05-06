import java.util.GregorianCalendar;

public class Jwork{
    public static void main(String[] args) throws EmailAlreadyExistsException, ReferralCodeAlreadyExistsException, JobNotFoundException, JobSeekerNotFoundException, RecruiterNotFoundException, BonusNotFoundException {
        System.out.println("Case Study Modul 7");
        Location location1 = new Location("DKI Jakarta", "Depok", "Kota Lahir");

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo@ui.ac.id", "lunnardo123", 2021, 03, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo@ui.ac.id", "lunnardo123", 2021, 03, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo123@gmail.com", "lunnardo123", 2021, 04, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo123@ui.ac.id", "lunnardo123", 2021, 03, 6));
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
            DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Lonnardi", "lonnardi@ui.ac.id", "081212344321", location1));


        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "PROMO1", 10000, 5000,true));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "PROMO1", 20000, 5000,true));
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.getJobById(1);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJobseeker.getJobseekerById(5);
        }catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseRecruiter.getRecruiterById(3);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseBonus.getBonusById(3);
        } catch (BonusNotFoundException bonusNotFound) {
            System.out.println(bonusNotFound.getMessage());
        }
        System.out.println("\n=========Database JobSeeker============");
        System.out.println(DatabaseJobseeker.getDatabaseJobseeker());

        System.out.println("\n=========Database Bonus===============");
        System.out.println(DatabaseBonus.getBonusDatabase());
    }
}