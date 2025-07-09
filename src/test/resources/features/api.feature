Feature: OrangeHRM Login

  @api
  Scenario: Test get list data normal
    Given Prepare URL for "GET_LIST_USERS"
    And Hit API get list users
    Then Validate status code is equals 200
    Then Validation response body get list users
    Then Validation response JSON with JSON Schema "get_list_users_normal.json"

  @api
  Scenario: Test create new user normal
    Given Prepare URL for "CREATED_NEW_USERS"
    And Hit API post created users
    Then Validate status code is equals 201
    Then Validation response body get created users
    Then Validation response JSON with JSON Schema "post_create_new_users_normal.json"

  @api
  Scenario: Test delete user normal
    Given Prepare URL for "CREATED_NEW_USERS"
    And Hit API post created users
    Then Validate status code is equals 201
    Then Validation response body get created users
    Given Prepare URL for "DELETE_LIST_USERS"
    And Hit API delete new
    Then Validate status code is equals 204

  @api
  Scenario: Test update user normal
    Given Prepare URL for "CREATED_NEW_USERS"
    And Hit API post created users
    Then Validate status code is equals 201
    Then Validation response body get created users
    Given Prepare URL for "UPDATE_LIST_USERS"
    And Hit API update user
    Then Validate status code is equals 200
    Then Validation response body update users