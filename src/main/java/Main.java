import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название автомобиля " + i + ":");
            String name = scanner.nextLine();
            int speed = 0;
            while (speed <= 0 || speed > 250) {
                System.out.println("Введите скорость автомобиля " + i + " (в км/ч):");
                String speedInput = scanner.nextLine();
                try {
                    speed = Integer.parseInt(speedInput);
                    if (speed <= 0 || speed >250) {
                        System.out.println("Введена неправильная скорость. Введите число больше 0 и не более 250.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод. Пожалуйста, введите числовое значение.");
                }
            }
            Car car = new Car(name, speed);
            race.addCar(car);
        }
        race.findLeader();
        System.out.println("Самая быстрая машина: " + race.getLeader().getName());
        System.out.println("Машина проехала за 24 часа: " + race.getLeader().getDistance() + " км");
    }
}
    class Car {
        private String name;
        private int speed;

        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public int getDistance() {
            return speed * 24;
        }
    }

    class Race {
        private Car leader;
        private Car[] cars;

        public Race() {
            cars = new Car[3];
        }

        public void addCar(Car car) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    return;
                }
            }
        }

        public void findLeader() {
            leader = cars[0];
            for (int i = 1; i < cars.length; i++) {
                if (cars[i] != null && cars[i].getDistance() > leader.getDistance()) {
                    leader = cars[i];
                }
            }
        }

        public Car getLeader() {
            return leader;
        }
    }