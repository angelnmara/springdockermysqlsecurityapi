package mx.com.aea.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BeeperControl {
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        Integer horaEjecucion = 7;
        Integer minutoEjecucion = 5;
        Long periodo = 86400000L;
        //Date dateActual = new java.util.Date();
        //Date dateEjecucion = new java.util.Date();
        //dateEjecucion.setHours(horaEjecucion);
        //dateEjecucion.setMinutes(minutoEjecucion);
        //Long diff = (dateEjecucion.getTime() - dateActual.getTime())/1000;


        Calendar fechaActual = Calendar.getInstance();

        Calendar fechaEjecucion = Calendar.getInstance();
        String name = fechaEjecucion.getTimeZone().getDisplayName();
        System.out.println(fechaEjecucion + " " + name);

        fechaEjecucion.setTimeZone(TimeZone.getTimeZone("UTC"));
        fechaEjecucion.set(Calendar.HOUR_OF_DAY, horaEjecucion);
        fechaEjecucion.set(Calendar.MINUTE, minutoEjecucion);
        System.out.println(fechaEjecucion + " " + name);

        Long diff = (fechaEjecucion.getTimeInMillis() - fechaActual.getTimeInMillis())/1000;

        System.out.println(fechaEjecucion);

        //System.out.println(dateActual);
        //System.out.println(dateEjecucion);
        //System.out.println(diff);

        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, diff, 5, SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { beeperHandle.cancel(true); }
        }, 60 * 60, SECONDS);
    }
}
