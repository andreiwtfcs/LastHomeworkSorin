

public class MyThread extends Thread{

    private int id;
    MyThread(int valueofid){
        this.id = valueofid;
    }
    public void run(){
        while (Main.i<Main.ID_PREZENTA){
            Main.Sectiune_critica.acquireUninterruptibly(1);
            //BEGIN - Sectiune critica
            if(Main.i<Main.ID_PREZENTA) {
                Main.i++;
                System.out.println("Threadul " + id + " am incrementat i cu 1, i=" + Main.i);
            }
            //END - Sectiune critica
            Main.Sectiune_critica.release(1);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
