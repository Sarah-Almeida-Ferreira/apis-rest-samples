package org.serratec.lojasAmazonas.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasAmazonas.models.ClienteModel;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	private List<ClienteModel> clientes = new ArrayList<ClienteModel>();
	
	public ClienteModel getCliente(String id) {
		
		for(ClienteModel cliente : clientes) {
			if((cliente.getId()).equals(id)) {
				return cliente;	
			}
		}
		
		return null;		
	}
	
	public List<ClienteModel> listarClientes(){
		return clientes;
	}
	
	public ClienteModel cadastrarCliente(String id, String cpf, String senha) {
		
		ClienteModel cliente = new ClienteModel(id,cpf,senha);
		
		clientes.add(cliente);
		
		return cliente;		
	}

}
