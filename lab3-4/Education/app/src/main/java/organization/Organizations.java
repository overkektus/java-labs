package organization;

/**
 * Created by Egor on 05.10.2017.
 */

import org.jetbrains.annotations.Contract;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Organizations {
    Itransition(1000),
    iTechArt(2000),
    Apalon(3000),
    Wargaming(4000),
    Exadel(4000),
    SoftClub(5000);

    @Contract(pure = true)
    public int getMoney() {
        return money;
    }

    private final int money;

    Organizations(int money)
    {
        this.money = money;
    }

    @Contract(pure = true)
    public static List<Organizations> getVALUES() {
        return VALUES;
    }

    @Contract(pure = true)
    public static Organizations castOrg(String org)
    {
        Organizations organization;
        switch (org)
        {
            case "Itransition" : organization = Organizations.Itransition; break;
            case "iTechArt" : organization = Organizations.iTechArt; break;
            case "Apalon" : organization = Organizations.Apalon; break;
            case "Exadel" : organization = Organizations.Exadel; break;
            case "Wargamin" : organization = Organizations.Wargaming; break;
            case "SoftClub" : organization = Organizations.SoftClub; break;
            default: organization = Organizations.Wargaming;
        }
        return organization;
    }

    private static final List<Organizations> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

}
