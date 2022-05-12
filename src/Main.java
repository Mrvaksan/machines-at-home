import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WashingMachine washingMachine = new WashingMachine();
        boolean isStopped = false;

        while (!isStopped) {
            washingMachine.update();
            washingMachine.printStatus();
            System.out.println("�ama��r Makinesi");
            System.out.println("1. S�cakl�k ayar�");
            System.out.println("2. S�re ayar�");
            System.out.println("3. Devir ayar�");
            System.out.println("4. Ba�lat/Duraklat");
            System.out.println("5. Bitir");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("S�cakl�k se�in:");
                    System.out.println("1. 30�");
                    System.out.println("2. 40�");
                    System.out.println("3. 60�");
                    System.out.println("4. 90�");

                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            washingMachine.setTemperature(30);
                            break;
                        case 2:
                            washingMachine.setTemperature(40);
                            break;
                        case 3:
                            washingMachine.setTemperature(60);
                            break;
                        case 4:
                            washingMachine.setTemperature(90);
                            break;
                        default:
                            washingMachine.setTemperature(60); //e�er kullan�c� yanl�� girerse
                            break;
                    }

                    break;
                case 2:
                    System.out.println("S�re se�in:");
                    System.out.println("1. 30 dk");
                    System.out.println("2. 60 dk");
                    System.out.println("3. 180 dk");

                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            washingMachine.setTimer(30);
                            break;
                        case 2:
                            washingMachine.setTimer(60);
                            break;
                        case 3:
                            washingMachine.setTimer(180);
                            break;
                        default:
                            washingMachine.setTimer(60); //e�er kullan�c� yanl�� girerse
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Devir se�in:");
                    System.out.println("1. 600");
                    System.out.println("2. 800");
                    System.out.println("3. 1200");

                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            washingMachine.setRpm(600);
                            break;
                        case 2:
                            washingMachine.setRpm(800);
                            break;
                        case 3:
                            washingMachine.setRpm(1200);
                            break;
                        default:
                            washingMachine.setRpm(800); //e�er kullan�c� yanl�� girerse
                            break;
                    }
                    break;
                case 4:
                    washingMachine.update();
                    washingMachine.start();
                    break;
                case 5:
                    isStopped = true;
                    break;
                default:
                    break;
            }
        }
    }
}