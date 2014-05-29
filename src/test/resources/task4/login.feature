Feature: Verify that draft folder contain saved and closed draft letter

@draft-folder-feature
Scenario: Check draft folder after saving and closed letter
  Given Login to gmail page "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail" with credentials login - "testt3820@gmail.com" and password - "CreateAPassword"
  When press compose button
  And fill email message "This is the test message for draft link"
  And click 'Save & Close'
  And click 'Draft' link
  Then Draft folder should contains letter with "This is the test message for draft link"

