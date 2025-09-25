Feature: Perf test for simple REST API

  Background:
    * url 'http://localhost:8080'

  Scenario: transform
    Given path 'transform'
    And request { message: 'Hello, World!' }
    When method post
    Then status 200