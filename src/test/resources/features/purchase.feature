Feature: Comprar dos productos

  Background:
    Given que estoy en la página principal

  Scenario Outline: Agregar dos productos al carrito y completar la compra
    When agrego los productos "<producto1>" y "<producto2>" al carrito
    And  visualizo el carrito
    And  completo el formulario
    Then finalizo la compra exitosamente

    Examples:
      | producto1        | producto2     |
      | Nokia lumia 1520 | HTC One M9    |
      | Nexus 6          | Iphone 6 32gb |
