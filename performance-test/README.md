# Performance Testing

This module contains the performance tests for the `basic-webapp` module.

## Running the tests

To run the performance tests, use the following Maven command:

```bash
mvn -f pom.xml gatling:test -Dtps=<tps> -Dduration=<duration>
```

Replace `<tps>` with the desired transactions per second and `<duration>` with the desired duration in seconds.

For example, to run the test with 10 TPS for 60 seconds, use the following command:

```bash
mvn -f pom.xml gatling:test -Dtps=10 -Dduration=60
```

## Test Reports

The test reports will be generated in the `target/gatling-reports` directory.
