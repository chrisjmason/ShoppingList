package utility;

public class Item {
    private String title;
    private String description;
    private int colour;
    private String date;

    public Item(String title, String description, int colour, String date){
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        if(description!=null) {
            return description;
        }else{
            return null;
        }
    }

    public int getColour() {
        return colour;
    }

    public String getDate(){return date;}

}
