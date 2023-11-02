public class SampleSolution2 {
    static int findAnswer(List<Service> services, String area) {
        return services.stream()
                        .filter(s -> area.equalsIgnoreCase(area.getServiceArea()))
                        .flatMap(s -> s.getWeeklyLatency().values.stream())
                        .max(Integer::compareTo).orElseGet(() -> 0);
    }
}
