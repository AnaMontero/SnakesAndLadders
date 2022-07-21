package net.voxelgroup.utilities;

import java.util.Random;

public final class RandomCreator {
    private final static Random random = new Random();
    private final static String[] colorsList = {"aliceblue", "antiquewhite", "aqua", "aquamarine", "azure", "beige",
            "bisque", "black", "blanchedalmond", "blue", "blueviolet", "brown", "burlywood", "cadetblue", "chartreuse",
            "chocolate", "coral", "cornflowerblue", "cornsilk", "cyan", "darkblue", "darkcyan", "darkgoldenrod",
            "darkgray", "darkgreen", "darkkhaki", "darkmagenta", "darkolivegreen", "darkorange", "darkorchid",
            "darkseagreen", "darkslateblue", "darkslategray", "darkturquoise", "darkviolet", "deepskyblue", "dimgray",
            "dodgerblue", "floralwhite", "forestgreen", "fuchsia", "gainsboro", "ghostwhite", "gold", "goldenrod",
            "gray", "green", "greenyellow", "honeydew", "indigo", "ivory", "khaki", "lavender", "lavenderblush",
            "lawngreen", "lemonchiffon", "lightblue", "lightcyan", "lightgoldenrodyellow", "lightgray", "lightgreen",
            "lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightsteelblue", "lightyellow", "lime",
            "limegreen", "linen", "magenta", "maroon", "mediumaquamarine", "mediumblue", "mediumorchid",
            "mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise",
            "midnightblue", "mintcream", "mistyrose", "moccasin", "navajowhite", "navy", "oldlace", "olive",
            "olivedrab", "orange", "orangered", "orchid", "palegoldenrod", "palegreen", "paleturquoise", "papayawhip",
            "peachpuff", "peru", "plum", "powderblue", "purple", "rebeccapurple", "rosybrown", "royalblue",
            "saddlebrown", "sandybrown", "seagreen", "seashell", "sienna", "silver", "skyblue", "slateblue",
            "slategray", "snow", "springgreen", "steelblue", "tan", "teal", "thistle", "tomato", "turquoise",
            "violet", "wheat", "white", "whitesmoke", "yellow", "yellowgreen"};

    public static int rollDice() {
        return random.nextInt(6) + 1;
    }

    public static String generateRandomColor() {
        String tokenColor;
        int colorNumber = random.nextInt(colorsList.length);
        tokenColor = colorsList[colorNumber];

        return tokenColor;
    }
}
