package gfx.utils;

import game.assets.World;
import gfx.assets.WorldTile;
import java.awt.image.BufferedImage;

public class ImageHandler {
    //singleton field
    //public static ImageHandler imageHandler = null;

    // actual pixel size of sprite on sheet
    private static final int SPRITE_TILE_WIDTH = 64, SPRITE_TILE_HEIGHT = 64;

    private WorldTile[] worldTileList;

    public ImageHandler() {
        worldTileList = new WorldTile[100];
        createWorldTiles();
    }

    /*
    // singleton constructor and getter
    private ImageHandler() {
        worldTileList = new WorldTile[1024];
        createWorldTiles();
    }

    public static ImageHandler getImageHandler() {
        if(imageHandler == null) {
            return new ImageHandler();
        }
        return imageHandler;
    }

     */
    private void createWorldTiles() {
        BufferedImage primaryColorSheet = ImageLoader.loadImage("/primary color spritesheet2.png");

        BufferedImage clear = primaryColorSheet.getSubimage(0, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile clearTile = new WorldTile(clear, 1);
        setWorldTile(clearTile);

        BufferedImage white = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile whiteTile = new WorldTile(white, 0);
        setWorldTile(whiteTile);

        BufferedImage grey_0 = primaryColorSheet.getSubimage(0, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_0Tile = new WorldTile(grey_0, 35);
        setWorldTile(grey_0Tile);

        BufferedImage grey_1 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_1Tile = new WorldTile(grey_1, 11);
        setWorldTile(grey_1Tile);

        BufferedImage grey_2 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_2Tile = new WorldTile(grey_2, 22);
        setWorldTile(grey_2Tile);

        BufferedImage grey_3 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*3, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_3Tile = new WorldTile(grey_3, 33);
        setWorldTile(grey_3Tile);

        BufferedImage grey_4 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*4, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_4Tile = new WorldTile(grey_4, 4);
        setWorldTile(grey_4Tile);

        BufferedImage grey_5 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*5, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_5Tile = new WorldTile(grey_5, 5);
        setWorldTile(grey_5Tile);

        BufferedImage grey_6 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*6, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_6Tile = new WorldTile(grey_6, 6);
        setWorldTile(grey_6Tile);

        BufferedImage grey_7 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*7, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_7Tile = new WorldTile(grey_7, 7);
        setWorldTile(grey_7Tile);

        BufferedImage red = primaryColorSheet.getSubimage(0, SPRITE_TILE_HEIGHT*2, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile redTile = new WorldTile(red, 1000);
        setWorldTile(redTile);

        BufferedImage black = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2,0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blackTile = new WorldTile(black,50 );
        setWorldTile(blackTile);

        BufferedImage lightGreen = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT*6, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile lightGreenTile = new WorldTile(lightGreen, 77);
        setWorldTile(lightGreenTile);

        BufferedImage darkGreen = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2, SPRITE_TILE_HEIGHT*6, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile darkGreenTile = new WorldTile(darkGreen, 60);
        setWorldTile(darkGreenTile);

        BufferedImage turquoise = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT*6, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile turquoiseTile = new WorldTile(turquoise, 61);
        setWorldTile(turquoiseTile);

        BufferedImage blue = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT*7, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blueTile = new WorldTile(blue, 62);
        setWorldTile(blueTile);
    }

    private void setWorldTile(WorldTile tile) {
        worldTileList[tile.getID()] = tile;
    }
    public WorldTile getWorldTile(int id) {
        return worldTileList[id];
    }

    public static int getSPRITE_TILE_WIDTH() {
        return SPRITE_TILE_WIDTH;
    }

    public static int getSPRITE_TILE_HEIGHT() {
        return SPRITE_TILE_HEIGHT;
    }
}
