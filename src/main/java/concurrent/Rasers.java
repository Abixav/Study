package concurrent;

import java.time.LocalTime;
import java.util.*;

public class Rasers {
    private final static int AMOUNT = 5;
    private final static int LAPS = 4;

    public static void main(String[] args) {
        List<RaserResult> raserResults = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<LocalTime> time = new ArrayList<>();
            for (int j = 0; j < 4; j++) {

                time.add(LocalTime.now().minusMinutes(j));
            }
            raserResults.add(new RaserResult("v" + i, time));
        }
        System.out.println(getBestLop(raserResults));


    }

    public static LocalTime getBestLop(List<RaserResult> raserResults) {
       return raserResults.stream().flatMap(a->a.getLaps().stream()).min(LocalTime :: compareTo).get();

    }

   /* public static Map<String, Optional<LocalTime>> getBestLopOtherRasers(List<RaserResult> raserResults) {
            raserResults.stream().min(a->a.getLaps().stream();
    }*/
}
