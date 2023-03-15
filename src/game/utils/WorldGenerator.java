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
        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                worldMap2DArr[r][c] = getWaterIndex();
            }
        }
    }

    private void blackBorder() {
        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                if (r == 0 || c == 0 || r == worldMap2DArr[r].length - 1 || c == worldMap2DArr[c].length - 1) {
                    worldMap2DArr[r][c] = 4;
                }
            }
        }
    }

    private void dropSeed() {
        for( int count = 0; count <= 20; count++);
        int dropSeedR = (int) ((Math.random() * (9 - 6)) + 6);
        int dropSeedC = (int) ((Math.random() * (9 - 6)) + 6);
        worldMap2DArr[dropSeedR][dropSeedC] = 3;
    }

    private void buildIsland() {
        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                if (worldMap2DArr[r][c] == 3) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                                if (worldMap2DArr[r + i][c + j] != 3) {
                                    worldMap2DArr[r + i][c + j] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

    private void setLand() {
        for (int r = 0; r < worldMap2DArr.length; r++) {
            for (int c = 0; c < worldMap2DArr[r].length; c++) {
                if (worldMap2DArr[r][c] == 0)
                    worldMap2DArr[r][c] = getLandIndex();
            }
        }
    }

    private int getLandIndex() {
        return (int) ((Math.random() * (10 - 6)) + 6);
    }

    private int getWaterIndex() {
        return (int) ((Math.random() * (9 - 7)) + 7);
    }

    public String getWORLD_FULL_DIRECTORY_NAME() {
        return WORLD_FULL_DIRECTORY_NAME;
    }
}
