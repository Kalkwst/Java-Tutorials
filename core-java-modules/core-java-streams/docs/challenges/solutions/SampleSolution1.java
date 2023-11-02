public class SampleSolution1 {
    static int findAnswer(List<Service> services, String area) {
        List<Service> servicesInArea = 
            services.stream()
                    .filter(s -> s.getServiceArea().equalsIgnoreCase(area))
                    .toList();

        int maximumLatency = 
            servicesInArea.stream()
                          .mapToInt(s -> s.getWeeklyLatency()
                                          .values()
                                          .stream()
                                          .mapToInt(Integer::intValue)
                                          .max()
                                          .orElse(0))
                          .max()
                          .orElse(0);
    }
}
