package game.utils;

public class WorldGenerator {

    private static int worldRows, worldColumns;
    private final long TIME_STAMP = System.nanoTime() % 1000000;
    private final String WORLD_FILE_NAME = "thisIsMyFileName_" + TIME_STAMP + ".txt";
    private final String WORLD_DIRECTORY = "res\\worlds\\";
    private final String WORLD_FULL_DIRECTORY_NAME = WORLD_DIRECTORY + WORLD_FILE_NAME;
    private int[][] worldMap2DArr;

    public WorldGenerator(int worldRows, int worldColumns) {
        this.worldRows = worldRows;
        this.worldColumns = worldColumns;

        worldMap2DArr = new int[worldRows][worldColumns];
        setWater();
        blackBorder();
        dropSeed();
        buildIsland();
        setLand();
        FileGenerator.getFileGenerator().createFile(WORLD_FULL_DIRECTORY_NAME, FileGenerator.getFileGenerator().intArr2DToString(worldMap2DArr));

    }

    private void setWater() {
        for(int r= 0; r < worldMap2DArr.length;r++) {
            for(int c = 0; c < worldMap2DArr[r].length; c++){
                worldMap2DArr[r][c] = getWaterIndex();
            }
        }
    }

    private void blackBorder() {
        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                if (r == 0 || c == 0 || r == worldMap2DArr[r].length - 1 || c == worldMap2DArr[c].length - 1) {
                    worldMap2DArr[r][c] = 50;
                }
            }
        }
    }




    private void dropSeed() {
        /*int numOfIslands = (int)(Math.random()*3+1);
        for(int){

        }*/
        int rand = (int) (Math.random() * 100);
        int dropSeedR = (int) ((Math.random() * (50 - 14)) + 14);
        int dropSeedC = (int) ((Math.random() * (50 - 14)) + 14);
        worldMap2DArr[dropSeedR][dropSeedC] = 7;
        if (rand < 50) {
            int dropSeedR2 = (int) ((Math.random() * (50 - 14)) + 14);
            int dropSeedC2 = (int) ((Math.random() * (50 - 14)) + 14);

            worldMap2DArr[dropSeedR2][dropSeedC2] = 7;
        }
    }


    private void buildIsland() {

        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                if (worldMap2DArr[r][c] == 8) {
                    for (int i = -7; i <= 7; i++) {
                        for (int j = -7; j <= 7; j++) {
                            if (j > -4 && j < 4 && i > -4 && i < 4) {
                                if ((Math.random() < .99)) {
                                    worldMap2DArr[r + i][c + j] = 0;
                                }
                            }
                            else {
                                if ((Math.random() < .60)) {
                                    worldMap2DArr[r + i][c + j] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void setLand() {
        for(int r= 0; r < worldMap2DArr.length;r++) {
            for(int c = 0; c < worldMap2DArr[r].length; c++){
                if (worldMap2DArr[r][c] == 0)
                    worldMap2DArr[r][c] = getLandIndex();
            }
        }
    }
    private int getLandIndex() {
        return (int) ((Math.random() * (77 - 61)) + 60);
    }


    private int getWaterIndex(){
        return (int) ((Math.random() * (62 - 61)) + 61);
    }

    public String getWORLD_FULL_DIRECTORY_NAME() {
        return WORLD_FULL_DIRECTORY_NAME;
    }
}