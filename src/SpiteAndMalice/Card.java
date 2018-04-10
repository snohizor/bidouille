package SpiteAndMalice;

public class Card {
    private int value;
    private String name;
    private String[] names = {"As","J","Q","K"};

    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    //Functions






    //Getters Setters

    public int getvalue() {
        return value;
    }

    public void setvalue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}