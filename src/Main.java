import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] fieldGame = new char[3][3];
    static char player = 'X';
    static int row = 0;
    static int col = 0;
    static boolean isWinner = false;

    public static void main(String[] args) {
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                fieldGame[i][j] = '.';
            }
        }
        while (isWinner != true){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            try {
                // сразу тут добавил - 1 чтобы в row и col постоянно - 1 не ставить
                System.out.println("Введите число: ");
                row = Integer.parseInt(reader.readLine()) -1;
                System.out.println("Введите число: ");
                col = Integer.parseInt(reader.readLine()) -1;


                if (checkPos(row, col)){
                    fieldGame[row][col] = player;
                    if (checkWinner()){
                        System.out.println("Победа - " + player);
                        isWinner = true;
                    }
                    swapPlayer();
                }else{
                    System.out.println("Эта ячейка занята!");
                }
                outputField();
            } catch (IOException e) {
                System.out.println("Введите корректное значение!");
            } catch (ArrayIndexOutOfBoundsException er){
                System.out.println("Введите корректное значение!");
            }
        }

        System.out.println("Игра окончена!");
        //
    }

    public static void outputField(){
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                System.out.print(fieldGame[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean checkPos(int row, int col){

        if (fieldGame[row][col] == '.'){
            return true;
        }else {
            return false;
        }
    }
    public static boolean checkWinner(){
        // проверка по горизонтали
        for (int i = 0; i < fieldGame.length; i++) {
            int count = 0;
            for (int j = 0; j < fieldGame.length; j++) {
                if (fieldGame[i][j] == player){
                    count += 1;
                }
            }
            if (count == 3){
                return true;
            }
        }
        // проверка диагонали
        int countD1 = 0;
        for (int i = 0; i < fieldGame.length; i++) {
            if(fieldGame[i][i] == player){
                countD1 += 1;
            }
        }
        if(countD1 == 3){
            return true;
        }

        // проверка диагонали
        int k = 2;
        int countD2 = 0;
        for (int i = 0; i < fieldGame.length; i++) {
            if(fieldGame[i][k] == player){
                countD2 += 1;
                k--;
            }
        }
        if(countD2 == 3){
            return true;
        }
        // проверка по вертикали
        for (int i = 0; i < fieldGame.length; i++) {
            int count2 = 0;
            for (int j = 0; j < fieldGame.length; j++) {
                if(fieldGame[j][i] == player){
                    count2 += 1;
                }
            }
            if(count2 == 3){
                return true;
            }
        }
        return false;
    }
    public static void swapPlayer(){

        if (player == 'X') {
            player = 'O';
        }else{
            player = 'X';
        }
    }

}