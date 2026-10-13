package cl9;

public class Example14 {
    public static void main(String[] args) throws Exception{
        Runtime rt=Runtime.getRuntime();
        Process process= rt.exec("notepad.exe");
        Thread.sleep(63);
        process.destroy();

    }
}
