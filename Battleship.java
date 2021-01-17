
/**
 * play battleship by guessing the locations of the program's ships.
 *
 * @author (Sienna)
 * @version (1.2)
 */

import java.util.Scanner;

public class Battleship
{
    static void clear()
    {
        System.out.println('\u000C');
    }
    static String[][] buildBoard(String[] letters, String[][] board)
    {
        for (int i = 0; i < 9; i++) //rows
        {
            for (int j = 0; j < 9; j++) //columns
            {
                board[i][j] = "-";
            }
        }
        
        int counter = 0;
        board[0][0] = " ";
        for (int j = 1; j < 9; j++)
        {
            counter++;
            String count = String.valueOf(counter);
            board[0][j] = count;
        }
        counter = 0;
        int lettersCount = 0;
        
        for (int i = 1; i < 9; i++)
        {
            counter++;
            String count = String.valueOf(counter);
            board[i][0] = letters[lettersCount];
            lettersCount++;
        }
        
        return board;
    }
    static void printBoard(String[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print("     " + board[i][j] + "    ");
            }
            System.out.println();
            System.out.println(" ");
        }
    }
    //////////////////////////////////////////////////////////
    static String[][] ships(String[][] shipCoords, String[] letters)
    {
        String lettersString;
        int letterCoords;
        String numbersString;
        int numberCoords;
        int shipNumber = 0;
        int[] noNoLetters = {0,0,0};
        int v = 0;
        
        while (shipNumber < 3)
        {
            do
            {
                letterCoords = (int)(Math.random()*((6-1)+1))+1;
                lettersString = letters[letterCoords];
            } while (letterCoords == noNoLetters[0] || letterCoords == noNoLetters[1]);
            
            numberCoords = (int)(Math.random() * ((6-1)+1)) +1;
            numbersString = String.valueOf(numberCoords);
            
            nextSpace(shipCoords, shipNumber, numberCoords, lettersString);
            shipCoords[shipNumber][0] = lettersString + numbersString;
            
            
            
            ////////////////
            noNoLetters[v] = letterCoords;
            v++;
            
            shipNumber++;
        }
        
        return shipCoords;
    }
    static void nextSpace(String[][] shipCoords, int shipNumber, int numberCoords, String lettersString)
    {
        shipCoords[shipNumber][1] = lettersString + (numberCoords + 1);
        shipCoords[shipNumber][2] = lettersString + (numberCoords + 2);
    }
    static void guess(String vertical, int horizontal, String[][] shipCoords, String[][] board, String[] numbers, String[] letters, String[] sunkShips, int m, int a)
    {
        int b;
        
        String userGuess;
        userGuess = vertical + horizontal;
        
        if (vertical.equals("A"))
        {
            a = 1;
        }
        else if (vertical.equals("B"))
        {
            a = 2;
        }
        else if (vertical.equals("C"))
        {
            a = 3;
        }
        else if (vertical.equals("D"))
        {
            a = 4;
        }
        else if (vertical.equals("E"))
        {
            a = 5;
        }
        else if (vertical.equals("F"))
        {
            a = 6;
        }
        else if (vertical.equals("G"))
        {
            a = 7;
        }
        else if (vertical.equals("H"))
        {
            a = 8;
        }
        clear();
        if (userGuess.equals(shipCoords[0][0]) || userGuess.equals(shipCoords[0][1]) || userGuess.equals(shipCoords[0][2]) || userGuess.equals(shipCoords[1][0]) || userGuess.equals(shipCoords[1][1]) || userGuess.equals(shipCoords[1][2]) || userGuess.equals(shipCoords[2][0]) || userGuess.equals(shipCoords[2][1]) || userGuess.equals(shipCoords[2][2]))
        {
            System.out.println("Hit!");
            board[a][horizontal] = "O";
            if (userGuess.equals(shipCoords[0][0]) || userGuess.equals(shipCoords[0][1]) || userGuess.equals(shipCoords[0][2]))
            {
                if (userGuess.equals(shipCoords[0][0]))
                {
                    shipCoords[0][0] = "O";
                }
                else if (userGuess.equals(shipCoords[0][1]))
                {
                    shipCoords[0][1] = "O";
                }
                else if (userGuess.equals(shipCoords[0][2]))
                {
                    shipCoords[0][2] = "O";
                }
            }
            else if (userGuess.equals(shipCoords[1][0]) || userGuess.equals(shipCoords[1][1]) || userGuess.equals(shipCoords[1][2]))
            {
                if (userGuess.equals(shipCoords[1][0]))
                {
                    shipCoords[1][0] = "O";
                }
                else if (userGuess.equals(shipCoords[1][1]))
                {
                    shipCoords[1][1] = "O";
                }
                else if (userGuess.equals(shipCoords[1][2]))
                {
                    shipCoords[1][2] = "O";
                }
            }
            else if (userGuess.equals(shipCoords[2][0]) || userGuess.equals(shipCoords[2][1]) || userGuess.equals(shipCoords[2][2]))
            {
                if (userGuess.equals(shipCoords[2][0]))
                {
                    shipCoords[2][0] = "O";
                }
                else if (userGuess.equals(shipCoords[2][1]))
                {
                    shipCoords[2][1] = "O";
                }
                else if (userGuess.equals(shipCoords[2][2]))
                {
                    shipCoords[2][2] = "O";
                }
            }
        }
        else
        {
            System.out.println("Miss!");
            board[a][horizontal] = "X";
        }
    }
    static String[] sink(String[][] shipCoords, String[] sunkShips, int m, int a, int horizontal, String userGuess)
    {
        if (shipCoords[0][0].equals("O") && shipCoords[0][1].equals("O") && shipCoords[0][2].equals("O") || shipCoords[1][0].equals("O") && shipCoords[1][1].equals("O") && shipCoords[1][2].equals("O") || shipCoords[2][0].equals("O") && shipCoords[2][1].equals("O") && shipCoords[2][2].equals("O"))
        {
            System.out.println("You sank a ship!!!");
            
            sunkShips[m] = "sunk";
        
            if (shipCoords[0][0].equals("O") && shipCoords[0][1].equals("O") && shipCoords[0][2].equals("O"))
                {
                    shipCoords[0][1] = "sunk";
                }
                else if (shipCoords[1][0].equals("O") && shipCoords[1][1].equals("O") && shipCoords[1][2].equals("O"))
                {
                    shipCoords[1][1] = "sunk";
                }
                else if (shipCoords[2][0].equals("O") && shipCoords[2][1].equals("O") && shipCoords[2][2].equals("O"))
                {
                    shipCoords[2][1] = "sunk";
                }
            }
        return sunkShips;
    }
    
        
    public static void main(String[] args)
    {
        String[][] board = { {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",} };
        
        String[] sunkShips = {"0", "0", "0"};
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        
        int a = 0;
        String userGuess = "" ;
        String yesOrNo;
        boolean play = true;
        boolean fillAnElement = true;
        boolean trueOrFalse = true;
        int x, y;
        String vertical;
        int horizontal;
        boolean win = false;
        int m = 0;
        
        int number = 9;
        String[][] grid = { {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",}, {"0", "0", "0", "0", "0", "0", "0", "0", "0",} };
        
        String[][] shipCoords = { {"0", "1", "2"}, {"0", "1", "2"}, {"0", "1", "2"} };
        
        int elementNumber;
        
        Scanner scanner = new Scanner(System.in);
        
        
        do {
            clear();
            
            System.out.println("Welcome to Battleship!");
            System.out.println(" ");
            System.out.println("Would you like a quick run down of how to play? (Type \"yes\" or \"no\")");
            yesOrNo = scanner.next();
            
            
            if (yesOrNo.equals("yes") || yesOrNo.equals("Yes") || yesOrNo.equals("YES") || yesOrNo.equals("Y") || yesOrNo.equals("y"))
            {
                trueOrFalse = true;
            }
            else if (yesOrNo.equals("no") || yesOrNo.equals("No") || yesOrNo.equals("NO") || yesOrNo.equals("N") || yesOrNo.equals("n"))
            {
                trueOrFalse = false;
            }
            else
            {
                System.out.println("input not recognized; playing tutorial");
                System.out.println(" ");
            }
            
            clear();
            
            if (trueOrFalse)
            {
                System.out.println("Tutorial.");
                System.out.println(" ");
                System.out.println("The goal of this game is to sink you opponent(the computer)'s ships!");
                System.out.println("The program is assigned three ships, each of which covers three spaces on an 8x8 grid.");
                System.out.println("To sink a ship, you must guess what spaces you think your opponent's ship lies on.");
                System.out.println("If you guess the space correctly, you weaken their ship. You must guess every space");
                System.out.println("the ship lies on in order to sink it.");
                System.out.println(" ");
                System.out.println("Try to sink all of your opponents' ships! Good luck!");
                System.out.println(" ");
            }
            
            
            System.out.println("Type anything when you are ready to play.");
            yesOrNo = scanner.next();
            
            grid = buildBoard(letters, board);
            ships(shipCoords, letters);
            
            clear();
            while (!win)
            {
                System.out.println(" ");
                System.out.println("(The symbol \"O\" indicates a hit. \"X\" indicates a miss.)");
                System.out.println(" ");
                
                printBoard(grid);
                
                System.out.print("Guess the location of your opponents ships!");
                System.out.println("(Be careful not to reuse coordinates!)");
                System.out.println(" ");
                System.out.print("What vertical coordinate will you guess? (CAPITAL letter A-H): ");
                vertical = scanner.next();
                System.out.print("What horizontal coordinate will you guess? (number): ");
                horizontal = scanner.nextInt();
                
                clear();
                guess(vertical, horizontal, shipCoords, board, numbers, letters, sunkShips, m, a);
                sink(shipCoords, sunkShips, m, a, horizontal, userGuess);
                
                if (sunkShips[m].equals("sunk"))
                {
                    m++;
                }
                
                if (sunkShips[0].equals("sunk") && sunkShips[1].equals("sunk") && sunkShips[2].equals("sunk"))
                {
                    win = true;
                }
            }
            printBoard(grid);
            clear();
            System.out.println("Congrats! You sank all of your opponents ships!");
            
            System.out.print("Would you like to play again? (Type \"yes\" or \"no\")");
            yesOrNo = scanner.next();
            if (yesOrNo.equals("yes") || yesOrNo.equals("Yes") || yesOrNo.equals("YES") || yesOrNo.equals("Y") || yesOrNo.equals("y"))
            {
                play = true;
            }
            else if (yesOrNo.equals("no") || yesOrNo.equals("No") || yesOrNo.equals("NO") || yesOrNo.equals("N") || yesOrNo.equals("n"))
            {
                play = false;
            }
        } while (play);
    }
}
