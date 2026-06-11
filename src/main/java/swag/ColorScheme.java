package swag;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

//TODO: have this be stored in a json file instead
public final class ColorScheme {
    
    private ColorScheme() {}
    
    public static final Map<BlockType, Color> COLORS;

    static {
        COLORS = new HashMap<>();
        
        COLORS.put(BlockType.BLOCK   , new Color( 41, 47, 86));
        COLORS.put(BlockType.STAIR   , new Color(121, 71,119));
        COLORS.put(BlockType.SLAB    , new Color(196,100,124));
        COLORS.put(BlockType.SHELF   , new Color(244,152,111));
        COLORS.put(BlockType.TRAPDOOR, new Color(250,222,112));
        COLORS.put(BlockType.ERROR   , new Color(000,255,000));
        COLORS.put(BlockType.AIR     , new Color(0,0,0,0));
    }

}
