Feature: Create Master Data

  Background: Login IRIS
    Given access website 'https://localhost:44337/'
    Then login

  #Master Entitas Pertamina
  Scenario: Create Master Entitas Pertamina
    Given access master entitas pertamina
    Then click button add entitas pertamina
      When i fill in the column hsh with'Holding'
      And choose hsh
      And i fill in the column kodeperusahaan with 'IniTesting'
      And i fill in the column namaperusahaan with 'TestingTes'
    Then i click submit
    Then check success submit

  #Master Fungsi
  Scenario: Create Master Fungsi
    Given access master fungsi
    Then click button add fungsi
      When i fill in the column entitas pertamina with'Badak'
      And choose ep
      And i fill in the column namafungsi with 'testinfungsi'
      And i fill in the column deskripsi with 'tesdeskripsi'
    Then i click submit
    Then check success submit

  #Master PIC Fungsi
  Scenario: Create Master PIC Fungsi
    Given access master pic fungsi
    Then click button add pic fungsi
      When i fill in the column dnamafungsi with'Marketing'
      And choose nf
      And i fill in the column namapic with 'testingpic'
      And i fill in the column notelp with '081274182412'
      And i fill in the column email with 'testing@tes.com'
    Then i click submit
    Then check success submit

  #Master Interest
  Scenario: Create Master Interest
    Given access master interest
    Then click button add interest
      When i fill in the column nama interest with 'TesInterest'
      And  i fill in the column order with '10'
    Then i click submit
    Then check success submit

  #Master Kementrian dan Lembaga
  Scenario: Create Master Kementrian dan Lembaga
    Given access master kementrianlembaga
    Then click button add kementrianlembaga
    Then i fill in the column nama kementrianlembaga with 'TesInterest'
    Then i click submit
    Then check success submit

  #Master Kesiapan Proyek
  Scenario: Create Master Kesiapan Proyek
    Given access master kesiapanproyek
    Then click button add kesiapanproyek
      When i fill in the column nama kesiapanproyek with 'TesKesiapanProyek'
      And  i fill in the column orderkp with '10'
    Then i click submit
    Then check success submit

  #Master Stream Business
  Scenario: Create Master Stream Business
    Given access master streambusiness
    Then click button add streambusiness
    When i fill in the column nama streambusiness with 'TesStreamBusiness'
    And  i fill in the column order with '10'
    Then i click submit
    Then check success submit

  #Master Target Mitra
  Scenario: Create Master Target Mitra
    Given access master targetmitra
    Then click button add targetmitra
    When i fill in the column nama targetmitra with 'TesTargetMitra'
    And  i fill in the column order with '10'
    Then i click submit
    Then check success submit
