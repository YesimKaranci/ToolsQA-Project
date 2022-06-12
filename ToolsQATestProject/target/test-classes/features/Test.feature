Feature:DemoQA Test

  @Register
  Scenario Outline: Register
    Then Web sitesinin açıldığı kontrol edilir
    And Book Store Application kategorisine tıklanır
    When Login butonuna tıklanır
    Then Login sayfasına gidildiği kontrol edilir
    When Yeni üyelik için New User butonuna tıklanır
    Then Register ekranına gidildiği kontrol edilir
    Given <firstname> <lastname> <username> <password> alanları girilir
    And I'm a not robot checboxına tıklanır
    When Register butonuna tıklanır
    Then Üye olunduğu kontrol edilir

    Examples:
      | firstname | lastname | username | password |
      | test1     | test1  | testqa | Test@2834 |


  @Login @Search
  Scenario Outline: Login and Search Test
    Then Web sitesinin açıldığı kontrol edilir
    And Book Store Application kategorisine tıklanır
    When Login butonuna tıklanır
    Then Login sayfasına gidildiği kontrol edilir
    Given Kullanıcı adı alanına <username> parola alanına <password> girilir
    And Giriş ekranında Login butonuna tıklanır
    Then Başarılı giriş yapıldığı kontrol edilir
    And Search alanından bir <product> aranır ve aranan kitabın listelendiği görülür
    And Uygulamadan çıkış yapılır

    Examples:
      | username | password | product |
      | yesimkaranci| Sebin@2834| Speaking JavaScript |