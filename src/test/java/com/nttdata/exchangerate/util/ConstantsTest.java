package com.nttdata.exchangerate.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstantsTest {

  @Test
  public void constantValuesTest() {
    assertEquals("Objeto guardado correctamente", Constants.MESSAGE_RESPONSE_ONE);
    assertEquals("USD", Constants.MESSAGE_RESPONSE_EXAMPLE);
    assertEquals("/objetos", Constants.POST_OBJETOS);
    assertEquals("/list-objetos", Constants.GET_OBJETOS_LIST);
    assertEquals("/api-extern", Constants.GET_OBJETOS_API_EXTERN);
    assertEquals("/exchange-rate", Constants.POST_EXCHANGE);
    assertEquals("Error al deserializar el mapa: ", Constants.ERROR_MAPA);
    assertEquals("consulta ya existe, y se extraido de la memoria", Constants.MESSAGE_MEMORIA);
    assertEquals("consulta nueva exitosa", Constants.MESSAGE_NUEVO);
    assertEquals("/", Constants.CONCAT_CLAVE);
  }
}