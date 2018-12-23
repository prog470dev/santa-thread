public class Main {
    public static void main(String... args){
        Santa santa = new Santa();

        for(int i = 0; i < Conf.elfSize; i++){
            new Elf("elf-" + i, santa).start();
        }

        for(int i = 0; i < Conf.reindeerSize; i++){
            new Reindeer("reindeer-" + i, santa).start();
        }
    }
}
