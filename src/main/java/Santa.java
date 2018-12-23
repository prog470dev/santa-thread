public class Santa {
    private int state;
    private int elfCount;
    private int reindeerCount;

    private static final int elfMax = 3;
    private static final int reindeerMax = 9;

    public Santa(){
        this.state = 0; // 0:睡眠, 1:開発, 2:出荷
        this.elfCount = 0;
        this.reindeerCount = 0;
    }

    public void addElf(){
        synchronized (this){
            if(this.state == 0 && this.elfCount < elfMax) this.elfCount++;
            if(this.elfCount == elfMax) develop();
        }
    }

    public void remElf(){
            if(this.state == 1 && this.elfCount > 0) this.elfCount--;
            if(this.elfCount == 0) sleep();
    }

    public void addReindeer(){
            if(this.state == 0 && this.reindeerCount < reindeerMax) this.reindeerCount++;
            if(this.reindeerCount == reindeerMax) ship();
    }

    public void remReindeer(){
            if(this.state == 2 && this.reindeerCount > 0) this.reindeerCount--;
            if(this.reindeerCount == 0) sleep();
    }

    private void develop(){
        this.state = 1;
        System.out.println("Santa starts to develop.");
    }

    private void ship(){
        this.state = 2;
        System.out.println("Santa starts to ship.");
    }

    private void sleep(){
        this.state = 0;
        System.out.println("Santa starts to sleep.");
    }


    public int getState(){
        return this.state;
    }
}
