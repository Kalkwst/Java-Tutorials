# Java Streams and Lambda Expressions

You are given a list of service metrics. Each service metric has the following properties:

- `serviceName` (String): The name of the service.
- `serviceArea` (String): The area to which the service belongs.
- `weeklyLatency` (Map<String, Double>): A map containing days of the week as keys (e.g., "Monday", "Tuesday") and the corresponding average latency as values.

**Your task**: Find the highest average weekly latency in a specific service area.

**Parameters**
`List services`: A list of services

**Result**
`double`: The highest average weekly latency if a service in a specific service area.

**Constraints**
- The services array always contains at least one service
- If there is no value, it returns 0

**Example 1**:

Input:
```java
Arrays.asList(new Service("Authentication", "Security", Map.of("Monday", 32.9)));
```

Result: `32.9`

**Example 2**:
Input:
```java
Arrays.asList(
    new Service("Authentication", "Security", Map.of("Monday", 50.4, "Tuesday", 45.6, "Wednesday", 60.5, "Thursday", 55.7, "Friday", 70.4, "Saturday", 40.3, "Sunday", 30.5));
    new Service("Analytics", "Data Warehousing", Map.of("Monday", 60.4, "Tuesday", 55.6, "Wednesday", 70.5, "Thursday", 65.7, "Friday", 80.4, "Saturday", 50.3, "Sunday", 40.5));
    new Service("Monitoring", "Operations", Map.of("Monday", 40.4, "Tuesday", 35.6, "Wednesday", 50.5, "Thursday", 45.7, "Friday", 60.4, "Saturday", 30.3, "Sunday", 25.5));
    new Service("OrderProcessing", "Operations", Map.of("Monday", 70.4, "Tuesday", 65.6, "Wednesday", 80.5, "Thursday", 75.7, "Friday", 90.4, "Saturday", 60.3, "Sunday", 50.5));
    new Service("Telemetry", "Operations", Map.of("Monday", 55.4, "Tuesday", 40.6, "Wednesday", 65.5, "Thursday", 60.7, "Friday", 75.4, "Saturday", 45.3, "Sunday", 35.5));
    new Service("Firewall", "Security", Map.of("Monday", 45.4, "Tuesday", 40.6, "Wednesday", 55.5, "Thursday", 50.7, "Friday", 65.4, "Saturday", 35.3, "Sunday", 25.5));
);
```

Result: 90.4

