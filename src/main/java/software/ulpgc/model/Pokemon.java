package software.ulpgc.model;

public record Pokemon(int id, String name, int generation) {
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", generation=" + generation +
                '}';
    }
}
