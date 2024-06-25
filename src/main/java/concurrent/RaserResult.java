package concurrent;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class RaserResult {
    private String name;
    private List<LocalTime> laps;

    public RaserResult(String name, List<LocalTime> laps) {
        this.name = name;
        this.laps = laps;
    }

    public List<LocalTime> getLaps() {
        return laps;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaserResult that = (RaserResult) o;
        return Objects.equals(name, that.name) && Objects.equals(laps, that.laps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, laps);
    }

    @Override
    public String toString() {
        return "RaserResult{" +
                "name='" + name + '\'' +
                ", laps=" + laps +
                '}';
    }
}
