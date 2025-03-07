package com.example.atividade_lanche02.controllers;

import com.example.atividade_lanche02.applications.LancheApplication;
import com.example.atividade_lanche02.entities.Lanche;
import com.example.atividade_lanche02.facade.LancheFacade;
import com.example.atividade_lanche02.repositories.LancheRepository;
import com.example.atividade_lanche02.services.LancheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LancheController {
    public static LancheRepository lancheRepository;
    public static LancheService lancheService;
    public static LancheApplication lancheApplication;
    public static LancheFacade lancheFacade;

    private static void injectDependencies() {
        lancheRepository = new LancheRepository();
        lancheService = new LancheService();
        lancheApplication = new LancheApplication(lancheRepository, lancheService);
        lancheFacade = new LancheFacade(lancheApplication);
    }

    public LancheController() {
        injectDependencies();

        Lanche lanche1 = new Lanche("Lanche 1", "", 10.0, 1);
        Lanche lanche2 = new Lanche("Lanche 2", "", 10.0, 2);
        Lanche lanche3 = new Lanche("Lanche 3", "", 10.0, 3);

        this.lancheFacade.cadastrar(lanche1);
        this.lancheFacade.cadastrar(lanche2);
        this.lancheFacade.cadastrar(lanche3);
    }

    @GetMapping("")
    public List<Lanche> get() {
        return lancheFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Lanche getLanche(@PathVariable int codigo) {
        return lancheFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Lanche lanche) {
        lancheFacade.cadastrar(lanche);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Lanche lanche) {
        lancheFacade.atualizar(codigo, lanche);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        lancheFacade.remover(codigo);
    }
}