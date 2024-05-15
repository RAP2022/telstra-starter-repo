Feature: SIM Card activation test
	Simple scenario to test if a SIM card is activated successfully

Scenario: Test if a SIM card can be activated successfully
	Given the SIM card ID "<simCardId>"
	When I activate it
	Then The activate status should be "<status>"
	
	Examples:
		| simCardId           | status |
		| 1255789453849037777 | true   |
		| 8944500102198304826 | false  |
