package Presentation;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;

public class PClock extends JLabel implements Runnable {
    private static final long serialVersionUID = 1L;

    public PClock() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder("시계");
        this.setBorder(titledBorder);
        updateClock();
        Thread clockThread = new Thread(this);
        clockThread.start();


        setPreferredSize(new Dimension(150, 50)); 
    }

    private void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        setText(sdf.format(new Date()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateClock();
        }
    }
}
