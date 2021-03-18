public class DatabaseJob {
    private String[] listJob;

    public DatabaseJob(){
       listJob = new String[100];
    }
    
    public DatabaseJob(String[] listJob){
        this.listJob = listJob;
    }
    
    public boolean addJob(Job job){
    return true;
    }
    
    public boolean removeJob(Job job){
    return true;
    }
    
    public Job getJob(){
        return null;
    }

    public String[] getListJob(){
        return listJob;
    }
}