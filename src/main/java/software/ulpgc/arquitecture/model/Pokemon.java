package software.ulpgc.arquitecture.model;

public record Pokemon(int id, String name, int generation, int numAbilities) {
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", generation=" + generation +
                ", numAbilities=" + numAbilities +
                '}';
    }
}
