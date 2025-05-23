package com.rafaeldsal.ws.minhaprata.dto.address;

import lombok.Builder;

@Builder
public record AddressViaCepDto(
    String cep,
    String logradouro,
    String estado,
    String bairro,
    String localidade,
    Boolean erro
) {
  public Boolean erro() {
    return erro != null ? erro : Boolean.FALSE;
  }
}
