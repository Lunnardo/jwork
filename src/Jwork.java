import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jwork{
    public static void main(String[] args) throws EmailAlreadyExistsException, ReferralCodeAlreadyExistsException, JobNotFoundException, JobSeekerNotFoundException, RecruiterNotFoundException, BonusNotFoundException {
        System.out.println("Case Study Modul 7");
        Location location1 = new Location("DKI Jakarta", "Depok", "Kota Lahir");

        ArrayList<Job> job1 = new ArrayList<Job>();
        ArrayList<Job> job2 = new ArrayList<Job>();

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo@ui.ac.id", "lunnardo123", 2021, 03, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo@ui.ac.id", "lunnardo123", 2021, 03, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo123@gmail.com", "lunnardo123", 2021, 04, 6));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardo123@ui.ac.id", "lunnardo123", 2021, 03, 6));
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
            DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Lonnardi", "lonnardi@ui.ac.id", "081212344321", location1));
            DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Hansaka", "Hansaka@ui.ac.id", "081212345678", location1));

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

        System.out.println("\n");
        try {
            job1.add(new Job(1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(1), 1000, JobCategory.BackEnd));
        }
        catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }
        try {
            job2.add(new Job(2, "Frontend Engineer", DatabaseRecruiter.getRecruiterById(2), 1000, JobCategory.FrontEnd));
        }
        catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(1, job1, DatabaseJobseeker.getJobseekerById(1)));
        }
        catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(2, job2, DatabaseJobseeker.getJobseekerById(1)));
        }
        catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(1, job1, DatabaseJobseeker.getJobseekerById(1)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(2, job1, DatabaseJobseeker.getJobseekerById(1)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(3, job2, DatabaseJobseeker.getJobseekerById(1)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        for (Invoice invoice: DatabaseInvoice.getInvoiceDatabase()){
            new Thread(new FeeCalculator(invoice)).start();
        }



    }
}