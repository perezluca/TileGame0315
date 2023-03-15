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
        BufferedImage primaryColorSheet = ImageLoader.loadImage("/primary color spritesheet.png");

        BufferedImage clear = primaryColorSheet.getSubimage(0, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile clearTile = new WorldTile(clear, 1);
        setWorldTile(clearTile);

        BufferedImage white = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*1, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile whiteTile = new WorldTile(white, 2);
        setWorldTile(whiteTile);

        BufferedImage red = primaryColorSheet.getSubimage(0, SPRITE_TILE_HEIGHT*2, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile redTile = new WorldTile(red, 3);
        setWorldTile(redTile);

        BufferedImage black = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2,0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blackTile = new WorldTile(black,4 );
        setWorldTile(blackTile);

        BufferedImage lightGreen = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*1, SPRITE_TILE_HEIGHT*5, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile lightGreenTile = new WorldTile(lightGreen, 5);
        setWorldTile(lightGreenTile);

        BufferedImage darkGreen = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2, SPRITE_TILE_HEIGHT*6, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile darkGreenTile = new WorldTile(darkGreen, 6);
        setWorldTile(darkGreenTile);

        BufferedImage lightBlue = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*1, SPRITE_TILE_HEIGHT*7, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile lightBlueTile = new WorldTile(lightBlue, 7);
        setWorldTile(lightBlueTile);

        BufferedImage blue = primaryColorSheet.getSubimage(0, SPRITE_TILE_HEIGHT*7, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blueTile = new WorldTile(blue, 8);
        setWorldTile(blueTile);

        BufferedImage tan = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT*3, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile tanTile = new WorldTile(tan, 9);
        setWorldTile(tanTile);
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
