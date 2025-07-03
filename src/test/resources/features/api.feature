Feature: OrangeHRM Login

  @api
  Scenario: Test get list data normal
    Given Prepare URL for "GET_LIST_USERS"
    And Hit API get list users
    Then Validate status code is equals 200
    Then Validation response body get list users
    Then Validation response JSON with JSON Schema "get_list_users_normal.json"
