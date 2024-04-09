package com.nttdata.exchangerate.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final String MESSAGE_RESPONSE_ONE = "Objeto guardado correctamente";
  public static final String MESSAGE_RESPONSE_EXAMPLE = "USD";
  public static final String POST_OBJETOS = "/objetos";
  public static final String GET_OBJETOS_LIST = "/list-objetos";
  public static final String GET_OBJETOS_API_EXTERN = "/api-extern";
  public static final String POST_EXCHANGE = "/exchange-rate";
  public static final String ERROR_MAPA="Error al deserializar el mapa: ";
  public static final String MESSAGE_MEMORIA="consulta ya existe, y se extraido de la memoria";
  public static final String MESSAGE_NUEVO= "consulta nueva exitosa";
  public static final String CONCAT_CLAVE= "/";




}
