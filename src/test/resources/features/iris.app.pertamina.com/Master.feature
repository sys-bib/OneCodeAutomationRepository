Feature: Create Master Data

  Scenario: Create Master Entitas Pertamina
    Given access website 'https://localhost:44337/'
    Then login
    Then access master entitas pertamina
    Then click button add entitas pertamina
      When i fill in the column hsh with'Holding'
      And choose hsh
      And i fill in the column kodeperusahaan with 'KodeTes'
      And i fill in the column namaperusahaan with 'NamaTes'
    Then i click submit