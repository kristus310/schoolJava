import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> randomArray = new ArrayList<>();
    static ArrayList<Integer> killed = new ArrayList<>();
    static ArrayList<Integer> playerPosition = new ArrayList<>(2);

    public static void main(String[] args) {

        System.out.println("----------VÍTEJTE VE HŘE!----------");
        System.out.println("Pravidla hry: Vy jste \"H\", jako hrdina, a musíte zabít 5x \"M\", jako monstra!");
        while (true) {
            System.out.println();
            System.out.println("Zadejte jak moc velkou chcete mapu!");
            System.out.println("(ve stylu x,y; např: 5,5):");
            String mapSize = input.nextLine();

            String[] sizes = mapSize.split(",");
            if (sizes.length != 2) {
                System.out.println("ERROR! Zadejte prosím platná čísla!");
                continue;
            }

            try {
                int x = Integer.parseInt(sizes[0].trim());
                int y = Integer.parseInt(sizes[1].trim());

                if(x < 3 || y < 3) {
                    System.out.println("ERROR! Mapa musí být minimálně 3x3!");
                    continue;
                }

                int[] player = new int[2];
                playerPosition.add(0);
                playerPosition.add(0);
                randomizer(x,y);
                drawBoard(x,y, player);
                while (killed.size() != 5) {
                    player = gameplay();
                    drawBoard(x,y, player);
                }
                System.out.println();
                System.out.println("Zabil jsi všechny monstra! Gratuluji!!!!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Zadejte prosím platná čísla!");
            }
        }

    }

    private static void drawBoard(int sizeX, int sizeY, int[] moves) {

        String[][] map = new String[sizeX][sizeY];

        playerPosition.set(0, playerPosition.get(0) + moves[0]);
        playerPosition.set(1, playerPosition.get(1) + moves[1]);

        if(playerPosition.get(0) >= sizeX) {
            playerPosition.set(0, 0);
        } else if(playerPosition.get(0) < 0) {
            playerPosition.set(0, sizeX - 1);
        }

        if(playerPosition.get(1) >= sizeY) {
            playerPosition.set(1, 0);
        } else if(playerPosition.get(1) < 0) {
            playerPosition.set(1, sizeY - 1);
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(i == randomArray.get(0) && j == randomArray.get(1)) {
                    map[i][j] = "M";
                } else {
                    map[i][j] = ".";
                }
                map[playerPosition.get(0)][playerPosition.get(1)] = "H";
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        checkMonster(map);

    }

    private static void randomizer(int sizeX, int sizeY) {

        Random random = new Random();
        int randomX = 0;
        int randomY = 0;
        while (randomX == playerPosition.get(0) && randomY == playerPosition.get(1)) {
            randomX = random.nextInt(sizeX);
            randomY = random.nextInt(sizeY);
        }

        randomArray.add(randomX);
        randomArray.add(randomY);

    }

    private static int[] gameplay() {


        System.out.println();
        System.out.println("Kam se chcete pohnout?");
        System.out.println("(W,A,S,D):");
        String movement = input.nextLine();
        int move[] = new int[2];

        if(movement.equalsIgnoreCase("w")) {
            move[0] = -1;
        } else if(movement.equalsIgnoreCase("a")) {
            move[1] = -1;
        } else if(movement.equalsIgnoreCase("s")) {
            move[0] = 1;
        } else if(movement.equalsIgnoreCase("d")) {
            move[1] = 1;
        } else {
            System.out.println("ERROR! Jen W,A,S,D!");
            gameplay();
        }
        return move;

    }

    private static void checkMonster(String[][] map) {
        if(map[playerPosition.get(0)][playerPosition.get(1)] == map[randomArray.get(0)][randomArray.get(1)]) {
            randomArray.clear();
            randomizer(map.length, map[0].length);
            killed.add(1);
            System.out.println("Gratuluji zabil jsi monstrum! Dohromady jsi zabil: " + killed.size() + "/5!");
        }

    }

}