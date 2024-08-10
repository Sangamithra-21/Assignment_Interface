package Assignment_14_Interface;

import java.util.Scanner;

public interface Playable {
    void play();
    void pause();
    void stop();
}
class MP3Player implements Playable{
    public void play()
    {
        System.out.println("Play MP3 Player");
    }

    @Override
    public void pause() {
        System.out.println("Pause MP3 Player");
    }

    @Override
    public void stop() {
        System.out.println("Stop MP3 Player");
    }
}

class CDPlayer implements Playable{
    public void play()
    {
        System.out.println("Play CD Player");
    }

    @Override
    public void pause() {
        System.out.println("Pause CD Player");
    }

    @Override
    public void stop() {
        System.out.println("Stop CD Player");
    }
}
class StreamingPlayer implements Playable{
    public void play()
    {
        System.out.println("Play Streaming");
    }

    @Override
    public void pause() {
        System.out.println("Pause Streaming");
    }

    @Override
    public void stop() {
        System.out.println("Stop Streaming");
    }
}
class Main1
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Playable player=null;
        System.out.println("1)MP3 Player 2)CD Player 3)Streaming");
        int option = sc.nextInt();
        switch(option)
        {
            case 1:
                player=new MP3Player();
                break;
            case 2:
                player=new CDPlayer();
                break;
            case 3:
                player=new StreamingPlayer();
                break;
        }

        boolean used=true;
        while(used)
        {
            System.out.println("1)Play 2)Pause 3)Stop 4)Exit");
            int op=sc.nextInt();

            switch(op)
            {
                case 1:
                    player.play();
                    break;
                case 2:
                    player.pause();
                    break;
                case 3:
                    player.stop();
                    break;
                case 4:
                    used=false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }

    }
}



