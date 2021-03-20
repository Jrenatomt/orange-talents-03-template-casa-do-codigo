package br.com.zup.casaDoCodigo.form;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casaDoCodigo.entities.Cliente;
import br.com.zup.casaDoCodigo.entities.Estado;
import br.com.zup.casaDoCodigo.entities.Pais;
import br.com.zup.casaDoCodigo.repositories.EstadoRepository;
import br.com.zup.casaDoCodigo.repositories.PaisRepository;
import br.com.zup.casaDoCodigo.validation.CpfOuCnpj;
import br.com.zup.casaDoCodigo.validation.UniqueValue;

public class ClienteForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@CpfOuCnpj(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotNull
	@UniqueValue(domainClass = Cliente.class, fieldName = "id")
	private Long paisId;
	private Long estadoId;

	@Deprecated
	public ClienteForm() {
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.findById(paisId)
				.orElseThrow(() -> new EntityNotFoundException("País não Encontrado."));
		Estado estado = null;
		if (estadoId != null)
			estado = estadoRepository.getOne(estadoId);

		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, 
				cidade, telefone, cep, pais, estado);
	}
}