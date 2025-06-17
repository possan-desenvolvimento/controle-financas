package br.com.controlefinanceiro.service;

import br.com.controlefinanceiro.model.ContaMes;
import br.com.controlefinanceiro.repository.ContaMesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaMesService {
    @Autowired
    private ContaMesRepository repository;

    public List<ContaMes> listarTodas() {
        return repository.findAll();
    }

    public ContaMes salvar(ContaMes conta){
        return repository.save(conta);
    }

    public Optional<ContaMes> buscarPorId(int id){
        return repository.findById(id);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }
}