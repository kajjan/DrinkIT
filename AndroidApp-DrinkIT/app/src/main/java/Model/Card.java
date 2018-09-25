package Model;

public class Card {
    private Category category;
    private int point;
    private String description;

    public Card(Category category, int point, String description) {
        this.category = category;
        this.point = point;
        this.description = description;
    }
}
