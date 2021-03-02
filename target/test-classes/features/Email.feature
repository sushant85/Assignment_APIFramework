Feature: Fetch users posts and Validate email are in proper format

Scenario: verify user able to fetch posts and emails are in the proper format.
	
	Given call Endpoint
	When I Perform Get for the PostId
	Then I Should see all posts
	And Validate Emails are in proper formats or not.