Feature: Find Username - Delphine

Scenario: verify user able to find user with name Delphine.
	Given call ENDPOINT and Store all username.
	When extract all details with Get http request.
	Then validate user able to find specific username or not.

