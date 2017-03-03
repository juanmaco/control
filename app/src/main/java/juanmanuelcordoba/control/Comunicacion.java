package juanmanuelcordoba.control;

import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {
    private InetAddress ipDestino;
    private  int puertoDestino;
    private int miPuerto;
    private DatagramSocket miBuzon;
    public String mensaje;

    public Comunicacion(){
        try{
            ipDestino= InetAddress.getByName("192.168.43.57");
            miPuerto= 6000;
            puertoDestino= 6000;
            miBuzon= new DatagramSocket();
        } catch (SocketException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        while(true){
            try{
                setChanged();
                notifyObservers();
                clearChanged();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void enviar(final String data){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    byte[] bytes = data.getBytes();
                    DatagramPacket enviarP= new DatagramPacket(bytes,bytes.length,ipDestino,puertoDestino);
                    miBuzon.send(enviarP);
                    System.out.println("envia");
                }catch (SocketException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
