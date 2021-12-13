Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecución de una api
  Para aprender a interactuar con los servicios

  Scenario: Cosultar informacion  de usuario
    Given "Juan" establece la base URL "https://gorest.co.in/"
    When consulta en el endpoint "public-api/users/" por id "2"
    Then valida que el estatus code sea 200 y la respuesta contenga el nombre "Anasuya Abbott"
