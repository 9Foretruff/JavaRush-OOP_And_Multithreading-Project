package islands.variationsOfIslands;

import exceptions.IncorrectIslandSizeException;
import islands.Island;
import islands.fieldTypes.Field;
import islands.fieldTypes.Ground;
import islands.fieldTypes.Mountains;
import islands.fieldTypes.Water;

import java.util.Random;
import java.util.Scanner;

public class IslandFromConsole extends Island {
    private final int formatPosition = 4;
    private final int groundChoice = 0;
    private final int waterChoice = 1;
    private final int mountainChoice = 2;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private String instruction = "𝙏𝙮𝙥𝙚 𝙣𝙪𝙢𝙗𝙚𝙧𝙨 𝙩𝙤 𝙘𝙝𝙤𝙞𝙘𝙚 𝙛𝙞𝙚𝙡𝙙\n" +
            "0-𝙂𝙧𝙤𝙪𝙣𝙙\n" +
            "1-𝙒𝙖𝙩𝙚𝙧\n" +
            "2-𝙈𝙤𝙪𝙣𝙩𝙖𝙞𝙣\n" +
            "𝙄𝙛 𝙮𝙤𝙪 𝙩𝙮𝙥𝙚 𝙬𝙧𝙤𝙣𝙜 , 𝙥𝙧𝙤𝙜𝙧𝙖𝙢 𝙨𝙚𝙩 𝙛𝙞𝙚𝙡𝙙 𝙗𝙮 𝙧𝙖𝙣𝙙𝙤𝙢";

    public IslandFromConsole(int width, int height, String nameOfIsland) throws IncorrectIslandSizeException {
        super(width, height, nameOfIsland);
    }

    @Override
    public void setMapFields() {
        System.out.println(instruction);
        String choice;
        int finalChoice;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                choice = scanner.nextLine();
                try {
                    finalChoice = Integer.parseInt(choice);
                } catch (Exception exception) {
                    finalChoice = random.nextInt(3);
                }
                switch (finalChoice) {
                    case groundChoice -> {
                        fields[i][j] = new Ground();
                        System.out.print(fields[i][j].getPictureOfField());
                    }
                    case waterChoice -> {
                        fields[i][j] = new Water();
                        System.out.print(fields[i][j].getPictureOfField());
                    }
                    case mountainChoice -> {
                        fields[i][j] = new Mountains();
                        System.out.print(fields[i][j].getPictureOfField());
                    }
                    default -> {
                        fields[i][j] = randomField();
                        System.out.print(fields[i][j].getPictureOfField());
                    }
                }
            }
            System.out.print("\n");
        }
    }

    private Field randomField() {
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case groundChoice -> {
                return new Ground();
            }
            case waterChoice -> {
                return new Water();
            }
            default -> {
                return new Mountains();
            }
        }
    }

    @Override
    public void getMapFields() {
        for (int i = 0; i < getWidth() / formatPosition; i++) {
            System.out.print("\t");
        }
        System.out.println(getNameOfIsland());
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(fields[i][j].getPictureOfField());
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }


}
