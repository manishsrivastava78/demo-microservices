-------GENERATED BY TESTBUDDY-------
----Replace UPDATE-ME placeholder with required value----
----Also, update test steps with required inputs----

# findEmployee

* request setup


## TEST_200 Perform 200 OK Scenario
* use path "/employees/123"
* send "GET" http request
* Then response status code is "200"
* The response content-type should be "application/json"


## TEST_404 Perform 404 Resource Not Found Scenario
* use path "/employees/43234"
* send "GET" http request
* Then response status code is "404"
