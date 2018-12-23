public class Elf extends Thread {
    final private String name;
    final private Santa santa;
    private boolean working;

    public Elf(String name, Santa santa){
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
                    this.santa.addElf();
                    this.working = true;
                }
            }
        }
        while(this.working){
            synchronized (this.santa){
                if(this.santa.getState() == 1){
                    this.santa.remElf();
                    this.working = false;
                    System.out.println(this.name + " finished working.");
                }
            }
        }
    }
}
