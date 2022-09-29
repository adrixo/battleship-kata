package battleship.model;

public enum SHIP_TYPE {
    GUNSHIP("gunship", "g", 1),
    CARRIER("carrier", "c", 3),
    DESTRUCTOR("destructor", "d", 4);

    private final String full;
    private final String abbr;
    private final int size;

    private SHIP_TYPE(String full, String abbr, int size) {
        this.full = full;
        this.abbr = abbr;
        this.size = size;
    }

    public String getName() {
        return full;
    }

    public String getAbbr() {
        return abbr;
    }

    public int getSize(){
        return size;
    }
}
