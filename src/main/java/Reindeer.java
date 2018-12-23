public class Reindeer extends Thread{
    final private String name;
    final private Santa santa;
    private boolean working;

    public Reindeer(String name, Santa santa){
        this.name = name;
        this.santa = santa;
        this.working = false;
    }

    @Override
    public void run() {
        while(!this.working){
            synchronized (this.santa){
                if(this.santa.getState() == 0){
                    System.out.println(this.name + " start to wait.");
                    santa.addReindeer();
                    this.working = true;
                }
            }
        }
        while(this.working){
            synchronized (this.santa){
                if(this.santa.getState() == 2){
                    this.santa.remReindeer();
                    this.working = false;
                    System.out.println(this.name + " finished working.");
                }
            }
        }
    }
}
