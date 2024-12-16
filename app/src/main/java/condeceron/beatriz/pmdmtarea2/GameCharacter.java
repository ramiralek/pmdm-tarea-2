package condeceron.beatriz.pmdmtarea2;

public class GameCharacter {

    String name;
    String description;
    String ability;
    int imageId;

    GameCharacter(String name, String description, String ability, int imageId) {
        this.name = name;
        this.description = description;
        this.ability = ability;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAbility() {
        return ability;
    }

    public int getImageId() {
        return imageId;
    }

}
