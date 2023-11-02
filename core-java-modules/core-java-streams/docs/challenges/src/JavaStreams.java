public class JavaStreams {
    
    List<Service> services = Arrays.asList(
        new Service("Authentication", "Security", Map.of("Monday", 50.4, "Tuesday", 45.6, "Wednesday", 60.5, "Thursday", 55.7, "Friday", 70.4, "Saturday", 40.3, "Sunday", 30.5)),
        new Service("Analytics", "Data Warehousing", Map.of("Monday", 60.4, "Tuesday", 55.6, "Wednesday", 70.5, "Thursday", 65.7, "Friday", 80.4, "Saturday", 50.3, "Sunday", 40.5)),
        new Service("Monitoring", "Operations", Map.of("Monday", 40.4, "Tuesday", 35.6, "Wednesday", 50.5, "Thursday", 45.7, "Friday", 60.4, "Saturday", 30.3, "Sunday", 25.5)),
        new Service("OrderProcessing", "Operations", Map.of("Monday", 70.4, "Tuesday", 65.6, "Wednesday", 80.5, "Thursday", 75.7, "Friday", 90.4, "Saturday", 60.3, "Sunday", 50.5)),
        new Service("Telemetry", "Operations", Map.of("Monday", 55.4, "Tuesday", 40.6, "Wednesday", 65.5, "Thursday", 60.7, "Friday", 75.4, "Saturday", 45.3, "Sunday", 35.5)),
        new Service("Firewall", "Security", Map.of("Monday", 45.4, "Tuesday", 40.6, "Wednesday", 55.5, "Thursday", 50.7, "Friday", 65.4, "Saturday", 35.3, "Sunday", 25.5))
    );

    String area = "Operations";
    int result = findAnswer(services, area);

    // Return the highest grade for the students with a specific major
    static int findAnswer(List<Service> services, String area){
        // Your answer goes here
        return 0;
    }
}

class Service {
    private String serviceName;
    private String serviceArea;
    private Map<String, Double> weeklyLatency;
    
    public Service(String serviceName, String serviceArea, Map<String, Double> weeklyLatency) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.weeklyLatency = weeklyLatency;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public Map<String, Double> getWeeklyLatency() {
        return weeklyLatency;
    }
}
